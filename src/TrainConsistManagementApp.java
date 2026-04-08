import java.util.Arrays;

public class TrainConsistManagementApp {

    // 🔹 Method to sort bogie names
    public static void sortBogieNames(String[] bogies) {
        Arrays.sort(bogies);
    }

    public static void main(String[] args) {

        String[] bogieNames = {
                "Sleeper", "AC Chair", "First Class", "General", "Luxury"
        };

        sortBogieNames(bogieNames);

        System.out.println("Sorted Bogie Names: " + Arrays.toString(bogieNames));
    }
}