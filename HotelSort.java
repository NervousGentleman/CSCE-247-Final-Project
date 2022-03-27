import java.util.ArrayList;

public class HotelSort implements Sort<Hotel> {
    private ArrayList<Hotel> hotels;

    public HotelSort(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    public ArrayList<Hotel> sortName() {
        return hotels;
    }

    public ArrayList<Hotel> sortPrice() {
        return hotels;
    }
}
