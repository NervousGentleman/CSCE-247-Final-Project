import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FlightSort {
    private ArrayList<Flight> flights;
    private ArrayList<Seat> seats;

    public FlightSort(ArrayList<Flight> flights, ArrayList<Seat> seats){
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

    public Comparator<Seat> sortPrice = new Comparator<Seat>() {
        public int compare(Seat s1, Seat s2){
            int seat1 = (int)s1.getCost();
            int seat2 = (int)s2.getCost();
            return seat1 - seat2;
        }
    };

    public ArrayList<Flight> sortNames(ArrayList<Flight> flights){
        Collections.sort(flights, sortName);
        return flights;
    }

    public ArrayList<Seat> sortPrices(ArrayList<Seat> seats){
        Collections.sort(seats, sortPrice);
        return seats;
    }
}