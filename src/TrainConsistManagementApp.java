import java.util.*;
import java.util.stream.*;

class Bogie {
    String type;
    int capacity;

    Bogie(String type, int capacity) {
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

public class TrainConsistManagementApp {

    public static int totalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 50));

        int total = totalCapacity(bogies);

        System.out.println("Total Seating Capacity: " + total);
    }
}