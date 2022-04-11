import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HotelParserTest {
    private ArrayList<Hotel> hotels; // expected size of 4
    private String firstHotelID = "d9ef832d-3884-4f6c-a7b5-d74906d509c0"; // expected ID of first hotel in JSON file

    @BeforeEach
    public void testSetup() {
        hotels = HotelParser.getInstance().load();
    }

    @Test
    public void normalFlightJSONObject() {
        // ascertains the parser normally loads hotels into the list
        // by checking the hotel ID of the first hotel in the list
        Assertions.assertEquals(firstHotelID, hotels.get(0).getUUID().toString());
    }

    @Test
    public void nullFlightJSONObject() {
        // an object with null attributes in JSON shouldn't be
        // created and loaded into the flight list
        // Therefore, the size should be 4, the number of valid hotels in the JSON
        Assertions.assertTrue(hotels.size() == 4);
    }

    @Test
    public void emptyFlightJSONObject() {
        // an empty object shouldn't be created and loaded
        // into the hotel list
        // Therefore the size should be 4, the number of valid hotels in the JSON
        Assertions.assertTrue(hotels.size() == 4);
    }
}
