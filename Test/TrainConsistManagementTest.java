import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

    private List<Bogie> getSampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 60));
        list.add(new Bogie("Sleeper", 80));
        list.add(new Bogie("First Class", 50));
        return list;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> result = TrainConsistManagement.groupBogiesByType(getSampleBogies());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> result = TrainConsistManagement.groupBogiesByType(getSampleBogies());
        assertTrue(result.get("Sleeper").size() > 1);
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> result = TrainConsistManagement.groupBogiesByType(getSampleBogies());
        assertTrue(result.keySet().size() > 1);
    }

    @Test
    void testGrouping_EmptyBogieList() {
        Map<String, List<Bogie>> result = TrainConsistManagement.groupBogiesByType(new ArrayList<>());
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 70));
        list.add(new Bogie("Sleeper", 80));

        Map<String, List<Bogie>> result = TrainConsistManagement.groupBogiesByType(list);

        assertTrue(result.size() == 1);
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> result = TrainConsistManagement.groupBogiesByType(getSampleBogies());

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> result = TrainConsistManagement.groupBogiesByType(getSampleBogies());

        assertTrue(result.get("Sleeper").size() == 2);
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        List<Bogie> copy = new ArrayList<>(original);

        TrainConsistManagement.groupBogiesByType(original);

        assertTrue(original.size() == copy.size());
    }
}