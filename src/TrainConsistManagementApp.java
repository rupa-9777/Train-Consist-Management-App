public class TrainConsistManagementApp {

    // 🔹 Linear Search Method
    public static boolean searchBogie(String[] bogies, String key) {

        for (String bogie : bogies) {
            if (bogie.equals(key)) {
                return true; // found
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        String searchKey = "BG309";

        boolean found = searchBogie(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie Found: " + searchKey);
        } else {
            System.out.println("Bogie Not Found: " + searchKey);
        }
    }
}