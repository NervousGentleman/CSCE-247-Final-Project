import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FlightSort {
    private ArrayList<Flight> flights;
    private ArrayList<Seat> seats;

    /**
     * Initializes FlightSort
     * @param flights
     * @param seats
     */
    public FlightSort(ArrayList<Flight> flights, ArrayList<Seat> seats){
        this.flights = flights;
        this.seats = seats;
    }
    
    /**
     * Helper method to sort the flight by name
     * https://www.geeksforgeeks.org/java-program-to-sort-an-arraylist/
     */
    public Comparator<Flight> sortName = new Comparator<Flight>() {
        public int compare(Flight f1, Flight f2){
            String flight1 = f1.getAirline().toString().toUpperCase();
            String flight2 = f2.getAirline().toString().toUpperCase();
            return flight1.compareTo(flight2);
        }
    }; 

    /**
     * Helper method to sort the seats on the flight by price
     * https://www.geeksforgeeks.org/java-program-to-sort-an-arraylist/
     */
    public Comparator<Seat> sortPrice = new Comparator<Seat>() {
        public int compare(Seat s1, Seat s2){
            int seat1 = (int)s1.getCost();
            int seat2 = (int)s2.getCost();
            return seat1 - seat2;
        }
    };
    /**
     * Sorts the flights by the airline name
     * @return ArrayList
     */
    public ArrayList<Flight> sortNames(){
        Collections.sort(flights, sortName);
        return flights;
    }

    /**
     * Sorts the flights by the seat price
     * @return ArrayList
     */
    public ArrayList<Seat> sortPrices(){
        Collections.sort(seats, sortPrice);
        return seats;
    }
}