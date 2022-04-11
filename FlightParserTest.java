import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FlightParserTest {
    private ArrayList<Flight> flights; // expected size of 8
    private String firstFlightID = "f65c02df-22a1-4eb3-b5f6-a712aa82cc17"; // expected ID of first flight in JSON file

    @BeforeEach
    public void testSetup() {
        flights = FlightParser.getInstance().load();
    }

    @Test
    public void normalFlightJSONObject() {
        // ascertains the parser normally loads flights into the list
        // by checking the flight ID of the first flight in the list
        Assertions.assertEquals(firstFlightID, flights.get(0).getFlightID().toString());
    }

    @Test
    public void nullFlightJSONObject() {
        // an object with null attributes in JSON shouldn't be
        // created and loaded into the flight list
        // Therefore the size should be 8, the number of valid flights in the JSON
        Assertions.assertTrue(flights.size() == 8);
    }

    @Test
    public void emptyFlightJSONObject() {
        // an empty object shouldn't be created and loaded
        // into the flight list
        // Therefore the size should be 8, the number of valid flights in the JSON
        Assertions.assertTrue(flights.size() == 8);
    }
}
