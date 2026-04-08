import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistManagement.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistManagement.isValidTrainId("TRAIN12"));
        assertFalse(TrainConsistManagement.isValidTrainId("TRN12A"));
        assertFalse(TrainConsistManagement.isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistManagement.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistManagement.isValidCargoCode("PET-ab"));
        assertFalse(TrainConsistManagement.isValidCargoCode("PET123"));
        assertFalse(TrainConsistManagement.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistManagement.isValidTrainId("TRN-123"));
        assertFalse(TrainConsistManagement.isValidTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistManagement.isValidCargoCode("PET-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistManagement.isValidTrainId(""));
        assertFalse(TrainConsistManagement.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistManagement.isValidTrainId("TRN-1234X"));
        assertFalse(TrainConsistManagement.isValidCargoCode("PET-ABC"));
    }
}