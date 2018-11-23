
import java.util.Map;

public class Minimal {
    public static void main(String[] args) {
        System.out.println("This is MINIMAL (in Java)");

        System.out.println("Arguments (count: " +  args.length + "):");
        for(String arg : args) {
            System.out.println("- '" + arg + "'");
        }

        System.out.println("");
        System.out.println("Environment:");
        for(Map.Entry<String,String> entry : System.getenv().entrySet()) {
            System.out.println("- " + entry.getKey() + "='" + entry.getValue() + "'");
        }
    }
}