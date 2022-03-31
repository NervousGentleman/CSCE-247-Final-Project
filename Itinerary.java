import java.io.File;
import java.io.FileWriter;
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

    /**
     * Prints out the itinerary to a text file
     */
    public static void print() {
        try {
            FileWriter file = new FileWriter("itinerary.txt");
            for (Flight f : plannedFlights) {
                file.write(f.toString());
                file.write("\n");
            }
            for (Hotel h : plannedHotels) {
                file.write(h.toString());
            }
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}