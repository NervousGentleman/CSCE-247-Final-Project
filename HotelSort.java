<<<<<<< HEAD
public class HotelSort implements Sort {
    
}
=======
import java.util.ArrayList;

public class HotelSort implements Sort<Hotel> {
    private ArrayList<Hotel> hotels;

    public HotelSort(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    public ArrayList<Hotel> sortName() {
        ArrayList<Hotel> ret = hotels;
        return ret;
    }

    public ArrayList<Hotel> sortPrice() {
        ArrayList<Hotel> ret = hotels;
        return ret;
    }
}
>>>>>>> origin/main
