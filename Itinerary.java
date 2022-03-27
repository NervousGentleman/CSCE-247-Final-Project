import java.util.ArrayList;

public class Itinerary {
    private static ArrayList<Flight> plannedFlights;
    private static ArrayList<Hotel> plannedHotels;

    public Itinerary(Account user) {
        Itinerary.plannedFlights = user.getBookedFlights();
        Itinerary.plannedHotels = user.getBookedHotels();
    }

    public static void print() {
        
    }
}
