import java.util.ArrayList;

public class FlightParser implements Parser {
    private static FlightParser flightParser;
    private ArrayList<Flight> flights;

    private FlightParser() {

    }

    public static FlightParser getInstance() {
        if (flightParser == null) {
            return new FlightParser();
        }
        return flightParser;
    }

    public ArrayList<Flight> load() {
        return flights;
    }

    public void save() {

    }

    public void add(Flight flight) {

    }

    public void edit(Flight flight) {

    }

    public void delete(Flight flight) {

    }
}