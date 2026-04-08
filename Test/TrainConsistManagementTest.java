import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

    private List<PassengerBogie> getSampleData() {
        List<PassengerBogie> list = new ArrayList<>();
        list.add(new PassengerBogie("Sleeper", 72));
        list.add(new PassengerBogie("AC Chair", 50));
        list.add(new PassengerBogie("First Class", 80));
        list.add(new PassengerBogie("General", 40));
        return list;
    }

    @Test
    void testLoopFilteringLogic() {
        List<PassengerBogie> result =
                TrainConsistManagement.filterUsingLoop(getSampleData());

        assertEquals(2, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<PassengerBogie> result =
                TrainConsistManagement.filterUsingStream(getSampleData());

        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<PassengerBogie> loop =
                TrainConsistManagement.filterUsingLoop(getSampleData());

        List<PassengerBogie> stream =
                TrainConsistManagement.filterUsingStream(getSampleData());

        assertEquals(loop.size(), stream.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<PassengerBogie> data = getSampleData();

        long start = System.nanoTime();
        TrainConsistManagement.filterUsingLoop(data);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<PassengerBogie> largeList = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            largeList.add(new PassengerBogie("Sleeper", i % 100));
        }

        List<PassengerBogie> result =
                TrainConsistManagement.filterUsingStream(largeList);

        assertNotNull(result);
    }
}