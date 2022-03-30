
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HotelSort {
    private ArrayList<Hotel> hotels;
    private ArrayList<Room> rooms;

    public HotelSort(ArrayList<Hotel> hotels, ArrayList<Room> rooms) {
        this.hotels = hotels;
        this.rooms = rooms;
    }

    public Comparator<Hotel> sortName = new Comparator<Hotel>() {
        public int compare(Hotel h1, Hotel h2){
            String hotel1 = h1.getName().toString().toUpperCase();
            String hotel2 = h2.getName().toString().toUpperCase();
            return hotel1.compareTo(hotel2);
        }
    }; 

    public Comparator<Room> sortPrice = new Comparator<Room>() {
        public int compare(Room s1, Room s2){
            int room1 = (int)s1.getPrice();
            int room2 = (int)s2.getPrice();
            return room1 - room2;
        }
    };

    public ArrayList<Hotel> sortNames(){
        Collections.sort(hotels, sortName);
        return hotels;
    }

    public ArrayList<Room> sortPrices(){
        Collections.sort(rooms, sortPrice);
        return rooms;
    }
}
