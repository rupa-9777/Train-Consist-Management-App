import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("======================================");
        System.out.println("   Train Consist Management App 🚆");
        System.out.println("======================================");

        // Initialize empty train consist
        List<String> trainConsist = new ArrayList<>();

        // Display initial state
        System.out.println("\nInitializing train consist...");
        System.out.println("No bogies attached yet.");

        // Display bogie count
        System.out.println("Current Bogie Count: " + trainConsist.size());

        // Program continues
        System.out.println("\nSystem ready for further operations...");
    }
}