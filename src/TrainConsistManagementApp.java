import java.util.regex.*;

public class TrainConsistManagement {

    private static final String TRAIN_REGEX = "TRN-\\d{4}";
    private static final String CARGO_REGEX = "PET-[A-Z]{2}";

    public static boolean isValidTrainId(String trainId) {
        Pattern pattern = Pattern.compile(TRAIN_REGEX);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile(CARGO_REGEX);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        System.out.println("Train ID Valid: " + isValidTrainId(trainId));
        System.out.println("Cargo Code Valid: " + isValidCargoCode(cargoCode));
    }
}