public class TrainConsistManagementApp {

    // 🔹 Search with Validation (Fail-Fast)
    public static boolean searchBogie(String[] bogies, String key) {

        // ✅ State Validation (Fail-Fast)
        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException("No bogies available in the train to search.");
        }

        // 🔍 Linear Search (after validation)
        for (String bogie : bogies) {
            if (bogie.equals(key)) {
                return true; // found
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309"};

        String searchKey = "BG205";

        try {
            boolean found = searchBogie(bogieIds, searchKey);

            if (found) {
                System.out.println("Bogie Found: " + searchKey);
            } else {
                System.out.println("Bogie Not Found: " + searchKey);
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}