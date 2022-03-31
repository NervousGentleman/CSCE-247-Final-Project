import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Itinerary {
    private static ArrayList<Flight> plannedFlights;
    private static ArrayList<Hotel> plannedHotels;
    private static ArrayList<Seat> plannedSeats;
    private static ArrayList<Room> plannedRooms;

    public Itinerary(Account user) {
        Itinerary.plannedFlights = user.getBookedFlights();
        Itinerary.plannedHotels = user.getBookedHotels();
    }

    public static void print() {
        try {
            File itinerary = new File("itinerary.txt");
            if (itinerary.createNewFile()) {
                System.out.println("Flight: " + Itinerary.plannedFlights.get(0));
                System.out.println("Seat: " + Itinerary.plannedSeats.get(0));
                System.out.println("Hotel: " + Itinerary.plannedHotels.get(0));
                System.out.println("Room: " + Itinerary.plannedRooms.get(0));
            }
        } catch (IOException e) {
            System.out.println("An error occured");
        }
    }
}