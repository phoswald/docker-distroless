
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Minimal {
    public static void main(String[] args) {
        System.out.println("This is MINIMAL (in Java)");

        System.out.println("Arguments (count: " +  args.length + "):");
        for(String arg : args) {
            System.out.println("- '" + arg + "'");
        }

        System.out.println("");
        System.out.println("Environment:");
        printMap(System.getenv());

        System.out.println("");
        System.out.println("System Properties:");
        printMap(System.getProperties());

        System.out.println("");
        System.out.println("Now:         " + ZonedDateTime.now());
        System.out.println("Now (Local): " + LocalDateTime.now());
        System.out.println("Locale:      " + Locale.getDefault());
        System.out.println("TimeZone:    " + TimeZone.getDefault().getID());
        System.out.println("Charset:     " + Charset.defaultCharset().name());
    }

    private static void printMap(Map<?, ?> map) {
        map.entrySet().stream()
                .sorted(Comparator.comparing(e -> (String) e.getKey()))
                .map(e -> "- " + e.getKey() + "='" + e.getValue().toString().replace('\n', '|') + "'")
                .forEach(System.out::println);
    }
}