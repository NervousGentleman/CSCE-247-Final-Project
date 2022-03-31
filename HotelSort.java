
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HotelSort {
    private ArrayList<Hotel> hotels;

    /**
     * Initializes HotelSort
     * @param hotels
     * @param rooms
     */
    public HotelSort(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    /**
     * helper method for sorting the names of the hotels
     * https://www.geeksforgeeks.org/java-program-to-sort-an-arraylist/
     */
    public Comparator<Hotel> sortName = new Comparator<Hotel>() {
        public int compare(Hotel h1, Hotel h2){
            String hotel1 = h1.getName().toString().toUpperCase();
            String hotel2 = h2.getName().toString().toUpperCase();
            return hotel1.compareTo(hotel2);
        }
    }; 

    /**
     * helper method for sorting the price of the rooms
     * https://www.geeksforgeeks.org/java-program-to-sort-an-arraylist/
     */
    public Comparator<Hotel> sortPrice = new Comparator<Hotel>() {
        public int compare(Hotel h1, Hotel h2) {
        double minPriceF1 = Double.MAX_VALUE;
        double minPriceF2 = Double.MAX_VALUE;
            for (ArrayList<Room> a : h1.getRooms()) {
                for (Room s : a) {
                    if (s.getPrice() < minPriceF1) {
                        minPriceF1 = s.getPrice();
                    }
                }
            }
            for (ArrayList<Room> a : h2.getRooms()) {
                for (Room s : a) {
                    if (s.getPrice() < minPriceF2) {
                        minPriceF2 = s.getPrice();
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
     * Sorts the hotels by name
     * @return ArrayList
     */
    public ArrayList<Hotel> sortNames(){
        Collections.sort(hotels, sortName);
        return hotels;
    }

    /**
     * Sorts the rooms by price
     * @return
     */
    public ArrayList<Hotel> sortPrices(){
        Collections.sort(hotels, sortPrice);
        return hotels;
    }
}
