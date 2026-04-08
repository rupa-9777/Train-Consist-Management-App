import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

    private List<Bogie> getSampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 60));
        list.add(new Bogie("First Class", 50));
        list.add(new Bogie("General", 90));
        return list;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = TrainConsistManagement.filterBogies(getSampleBogies(), 70);
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = TrainConsistManagement.filterBogies(getSampleBogies(), 60);
        assertFalse(result.stream().anyMatch(b -> b.getCapacity() == 60));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = TrainConsistManagement.filterBogies(getSampleBogies(), 60);
        assertFalse(result.stream().anyMatch(b -> b.getCapacity() < 60));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = TrainConsistManagement.filterBogies(getSampleBogies(), 50);
        assertTrue(result.size() > 1);
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = TrainConsistManagement.filterBogies(getSampleBogies(), 100);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = TrainConsistManagement.filterBogies(getSampleBogies(), 40);
        assertTrue(result.size() == getSampleBogies().size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result = TrainConsistManagement.filterBogies(new ArrayList<>(), 50);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        List<Bogie> copy = new ArrayList<>(original);

        TrainConsistManagement.filterBogies(original, 60);

        assertTrue(original.size() == copy.size());
    }
}