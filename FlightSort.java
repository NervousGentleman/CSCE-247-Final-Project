import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.MissingResourceException;

public class FlightSort {
    private ArrayList<Flight> flights;
    private ArrayList<Seat> seats;

    /**
     * Initializes FlightSort
     * @param flights
     * @param seats
     */
    public FlightSort(ArrayList<Flight> flights){
        this.flights = flights;
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
    public Comparator<Flight> sortPrice = new Comparator<Flight>() {
        public int compare(Flight f1, Flight f2) {
            double minPriceF1 = Double.MAX_VALUE;
            double minPriceF2 = Double.MAX_VALUE;
            for (ArrayList<Seat> a : f1.getSeats()) {
                for (Seat s : a) {
                    if (s.getCost() < minPriceF1) {
                        minPriceF1 = s.getCost();
                    }
                }
            }
            for (ArrayList<Seat> a : f2.getSeats()) {
                for (Seat s : a) {
                    if (s.getCost() < minPriceF2) {
                        minPriceF2 = s.getCost();
                    }
                }
            }
            if (minPriceF1 < minPriceF2) {
                return -1;
            } else if (minPriceF1 > minPriceF2) {
                return 1;
            }
            return 0;
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
        Collections.sort(flights, sortPrice);
        return seats;
    }
}