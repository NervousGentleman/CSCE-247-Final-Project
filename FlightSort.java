import java.util.ArrayList;

public class FlightSort implements Sort<Flight> {
    private ArrayList<Flight> flights;

    public FlightSort(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public ArrayList<Flight> sortName() {
        ArrayList<Flight> ret = flights;
        return ret;
    }

    public ArrayList<Flight> sortPrice() {
        ArrayList<Flight> ret = flights;
        return ret;
    }

    public ArrayList<Flight> sortArrivalTime() {
        ArrayList<Flight> ret = flights;
        return ret;
    }

    public ArrayList<Flight> sortDepartureTime() {
        ArrayList<Flight> ret = flights;
        return ret;
    }
}
