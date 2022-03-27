import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HotelParser implements Parser<Hotel> {
    
    private static HotelParser hotelParser;
    private ArrayList<Hotel> hotels;

    private HotelParser() {
        this.hotels = new ArrayList<Hotel>();
    } // ending bracket of constructor

    public static HotelParser getInstance() {
        if (hotelParser == null) {
            hotelParser = new HotelParser();
        }
        return hotelParser;
    } // ending bracket of method getInstance

    public ArrayList<Hotel> load() {
       
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		
		try {
			FileReader reader = new FileReader(HotelJSONConstants.HOTEL_FILE_NAME.getName());
			JSONArray hotelsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < hotelsJSON.size(); i++) {
				JSONObject hotelJSON = (JSONObject)hotelsJSON.get(i);
				String name = (String)hotelJSON.get(HotelJSONConstants.HOTEL_NAME.getName());
				Double price = (Double)hotelJSON.get(HotelJSONConstants.HOTEL_PRICE.getName());
				int rating = (int)hotelJSON.get(HotelJSONConstants.HOTEL_RATING.getName());
                boolean petFriendly = (boolean)hotelJSON.get(HotelJSONConstants.HOTEL_PET_FRIENDLY.getName());
                boolean breakfast = (boolean)hotelJSON.get(HotelJSONConstants.HOTEL_BREAKFAST.getName());
                String address = (String)hotelJSON.get(HotelJSONConstants.HOTEL_ADDRESS.getName());
				
				hotels.add(new Hotel(name, price, rating, petFriendly, breakfast, address)); // need to add rooms
			}
			
			return hotels;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
       
        return null;
    } // ending bracket of method load

    public void save() {
        ArrayList<Hotel> hotels = this.hotels;
        JSONArray jsonHotels = new JSONArray();
       
        for(int i = 0; i < this.hotels.size(); i++){
            jsonHotels.add(getHotelJson(hotels.get(i)));
        }

        try(FileWriter file = new FileWriter(HotelJSONConstants.HOTEL_FILE_NAME.getName())){
            file.write(jsonHotels.toJSONString());
            file.flush();

        } catch(IOException e){
            e.printStackTrace();
        }

    } // ending bracket of method save

    public void add(Hotel hotel) {
        this.hotels.add(hotel);
    } // ending bracket of method add

    public void edit(Hotel hotel) {

    } // eniding bracket of method edit

    public void delete(Hotel hotel) {
        this.hotels.remove(hotel);
    } // ending bracket of method delete
    
    public static JSONObject getHotelJson(Hotel hotel){

        JSONObject hotelDetails = new JSONObject();
        hotelDetails.put(HotelJSONConstants.HOTEL_NAME.getName(), hotel.getName());
        hotelDetails.put(HotelJSONConstants.HOTEL_PRICE.getName(), hotel.getPrice());
        hotelDetails.put(HotelJSONConstants.HOTEL_RATING.getName(), hotel.getRating());
        hotelDetails.put(HotelJSONConstants.HOTEL_PET_FRIENDLY.getName(), hotel.isPet_Friendly());
        hotelDetails.put(HotelJSONConstants.HOTEL_BREAKFAST.getName(), hotel.hasBreakfast());
        hotelDetails.put(HotelJSONConstants.HOTEL_ADDRESS.getName(), hotel.getHotelAddress());
        
        return hotelDetails;

    } // ending bracket of method getHotelJson

}
