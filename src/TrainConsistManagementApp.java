import java.util.*;
import java.util.stream.Collectors;

class PassengerBogie {
    String type;
    int capacity;

    PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        return type + " : " + capacity;
    }
}

public class TrainConsistManagement {

    // 🔹 LOOP FILTERING
    public static List<PassengerBogie> filterUsingLoop(List<PassengerBogie> list) {
        List<PassengerBogie> result = new ArrayList<>();

        for (PassengerBogie b : list) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // 🔹 STREAM FILTERING
    public static List<PassengerBogie> filterUsingStream(List<PassengerBogie> list) {
        return list.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<PassengerBogie> bogies = new ArrayList<>();

        bogies.add(new PassengerBogie("Sleeper", 72));
        bogies.add(new PassengerBogie("AC Chair", 50));
        bogies.add(new PassengerBogie("First Class", 80));
        bogies.add(new PassengerBogie("General", 40));

        // 🔹 LOOP PERFORMANCE
        long startLoop = System.nanoTime();
        List<PassengerBogie> loopResult = filterUsingLoop(bogies);
        long endLoop = System.nanoTime();

        // 🔹 STREAM PERFORMANCE
        long startStream = System.nanoTime();
        List<PassengerBogie> streamResult = filterUsingStream(bogies);
        long endStream = System.nanoTime();

        System.out.println("Loop Result: " + loopResult);
        System.out.println("Stream Result: " + streamResult);

        System.out.println("Loop Time: " + (endLoop - startLoop) + " ns");
        System.out.println("Stream Time: " + (endStream - startStream) + " ns");
    }
}