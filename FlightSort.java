import java.util.ArrayList;
import java.util.Comparator;

public class FlightSort {
    private ArrayList<Flight> flights;
    private ArrayList<Seat> seats;

    public FlightSort(ArrayList<Flight> flights, ArrayList<Seat> seats) {
        this.flights = flights;
        this.seats = seats;
    }

    public Comparator<Flight> sortName = new Comparator<Flight>() {
        public int compare(Flight f1, Flight f2){
            String flight1 = f1.getAirline().toString().toUpperCase();
            String flight2 = f2.getAirline().toString().toUpperCase();
            return flight1.compareTo(flight2);
        }
    }; 

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