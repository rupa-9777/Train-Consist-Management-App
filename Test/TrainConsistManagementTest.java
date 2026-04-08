import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

    private List<Bogie> getSampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 60));
        list.add(new Bogie("First Class", 50));
        return list;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int total = TrainConsistManagement.totalCapacity(getSampleBogies());
        assertTrue(total == (72 + 60 + 50));
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int total = TrainConsistManagement.totalCapacity(getSampleBogies());
        assertTrue(total > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 80));

        int total = TrainConsistManagement.totalCapacity(list);
        assertTrue(total == 80);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int total = TrainConsistManagement.totalCapacity(new ArrayList<>());
        assertTrue(total == 0);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        int total = TrainConsistManagement.totalCapacity(getSampleBogies());
        assertTrue(total == 182);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        int total = TrainConsistManagement.totalCapacity(getSampleBogies());
        assertTrue(total == 182);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        List<Bogie> copy = new ArrayList<>(original);

        TrainConsistManagement.totalCapacity(original);

        assertTrue(original.size() == copy.size());
    }
}