import java.util.LinkedHashSet;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC5 - Preserve Insertion Order ");
        System.out.println("======================================");

        LinkedHashSet<String> train = new LinkedHashSet<>();

        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add("Guard");
        train.add("Sleeper");

        System.out.println("\nTrain Formation:");
        System.out.println(train);
    }
}