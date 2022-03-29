import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HotelParser implements Parser<Hotel> {
    
    private static HotelParser hotelParser;
    private ArrayList<Hotel> hotels;

    public HotelParser() {
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
				UUID uuid = (UUID)hotelJSON.get(HotelJSONConstants.HOTEL_UUID.getName());
                HotelName name = (HotelName)hotelJSON.get(HotelJSONConstants.HOTEL_NAME.getName()); // maybe implemented wrong
				int rating = (int)hotelJSON.get(HotelJSONConstants.HOTEL_RATING.getName());
                boolean petFriendly = (boolean)hotelJSON.get(HotelJSONConstants.HOTEL_PET_FRIENDLY.getName());
                boolean hasBreakfast = (boolean)hotelJSON.get(HotelJSONConstants.HOTEL_BREAKFAST.getName());
                boolean hasPool = (boolean)hotelJSON.get(HotelJSONConstants.HOTEL_POOL.getName());
                String location = (String)hotelJSON.get(HotelJSONConstants.HOTEL_LOCATION.getName());
                int numFloors = (int)hotelJSON.get(HotelJSONConstants.HOTEL_FLOORS_NUMBER.getName());
                int numRoomsPerFloor = (int)hotelJSON.get(HotelJSONConstants.HOTEL_ROOMS_PER_FLOOR.getName());
                String address = (String)hotelJSON.get(HotelJSONConstants.HOTEL_ADDRESS.getName()); // will prob delete address 
				Room[][] rooms; // need to figure out how to take in and out of json
				hotels.add(new Hotel(uuid, name, rating, petFriendly, hasBreakfast, hasPool, location, numFloors, numRoomsPerFloor, rooms)); // need to add rooms
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

    public void delete(Hotel hotel) {
        this.hotels.remove(hotel);
    } // ending bracket of method delete
    
    public static JSONObject getHotelJson(Hotel hotel){

        JSONObject hotelDetails = new JSONObject();
        hotelDetails.put(HotelJSONConstants.HOTEL_UUID.getName(), hotel.getUUID());
        hotelDetails.put(HotelJSONConstants.HOTEL_NAME.getName(), hotel.getName());
        hotelDetails.put(HotelJSONConstants.HOTEL_RATING.getName(), hotel.getRating());
        hotelDetails.put(HotelJSONConstants.HOTEL_PET_FRIENDLY.getName(), hotel.isPetFriendly());
        hotelDetails.put(HotelJSONConstants.HOTEL_BREAKFAST.getName(), hotel.getHasBreakfast());
        hotelDetails.put(HotelJSONConstants.HOTEL_POOL.getName(), hotel.getHasPool());
        hotelDetails.put(HotelJSONConstants.HOTEL_LOCATION.getName(), hotel.getLocation());
        hotelDetails.put(HotelJSONConstants.HOTEL_FLOORS_NUMBER.getName(), hotel.getNumFloors());
        hotelDetails.put(HotelJSONConstants.HOTEL_ROOMS_PER_FLOOR.getName(), hotel.getNumRoomsPerFloor());
        
        
        return hotelDetails;

    } // ending bracket of method getHotelJson

}
