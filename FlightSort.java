import java.util.ArrayList;

public class FlightSort implements Sort<Flight> {
    private ArrayList<Flight> flights;

    public FlightSort(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public ArrayList<Flight> sortName() {
        return flights;
    }

    public ArrayList<Flight> sortPrice() {
        return flights;
    }
}
