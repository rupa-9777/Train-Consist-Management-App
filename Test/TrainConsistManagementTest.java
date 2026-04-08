import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
        assertNotNull(bogie);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Sleeper", -10);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC Chair", 0);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("First Class", 0);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);

        assertEquals("Sleeper", bogie.getType());
        assertEquals(72, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
        PassengerBogie b2 = new PassengerBogie("AC Chair", 65);
        PassengerBogie b3 = new PassengerBogie("First Class", 80);

        assertNotNull(b1);
        assertNotNull(b2);
        assertNotNull(b3);
    }
}