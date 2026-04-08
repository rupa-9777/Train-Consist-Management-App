import java.util.Arrays;

public class TrainConsistManagementApp {

    // 🔹 Binary Search Method
    public static boolean binarySearchBogie(String[] bogies, String key) {

        // Handle empty array
        if (bogies == null || bogies.length == 0) {
            return false;
        }

        // 🔹 Ensure array is sorted (important precondition)
        Arrays.sort(bogies);

        int low = 0;
        int high = bogies.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = bogies[mid].compareTo(key);

            if (cmp == 0) {
                return true; // found
            } else if (cmp < 0) {
                low = mid + 1; // search right
            } else {
                high = mid - 1; // search left
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        String searchKey = "BG309";

        boolean found = binarySearchBogie(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie Found: " + searchKey);
        } else {
            System.out.println("Bogie Not Found: " + searchKey);
        }
    }
}