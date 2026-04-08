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
    }

    @Test
    }

    @Test
    }

    @Test
    }

    @Test
    }

    @Test
    }

    @Test
        List<Bogie> original = getSampleBogies();
        List<Bogie> copy = new ArrayList<>(original);


        assertTrue(original.size() == copy.size());
    }
}