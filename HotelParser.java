import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
                String sUUID = (String)hotelJSON.get(HotelJSONConstants.HOTEL_UUID.getName());
                UUID uuid = UUID.fromString(sUUID);
				HotelName hotelName = null;
                String name = (String)hotelJSON.get(HotelJSONConstants.HOTEL_NAME.getName());
                for (HotelName n : HotelName.values()) {
                    if (n.getName().equals(name)) {
                        hotelName = n;
                        break;
                    }
                }
				int rating = ((Long) hotelJSON.get(HotelJSONConstants.HOTEL_RATING.getName())).intValue();
                boolean petFriendly = (boolean)hotelJSON.get(HotelJSONConstants.HOTEL_PET_FRIENDLY.getName());
                boolean breakfast = (boolean)hotelJSON.get(HotelJSONConstants.HOTEL_BREAKFAST.getName());
                String location = (String)hotelJSON.get(HotelJSONConstants.HOTEL_ADDRESS.getName());
				boolean hasPool = (boolean) hotelJSON.get(HotelJSONConstants.HOTEL_POOL.getName());
                int numFloors = ((Long) hotelJSON.get(HotelJSONConstants.HOTEL_NUM_FLOORS.getName())).intValue();
                int numRoomsPerFloor = ((Long) hotelJSON.get(HotelJSONConstants.HOTEL_NUM_ROOMS_PER_FLOOR.getName())).intValue();
                ArrayList<ArrayList<Room>> rooms = new ArrayList<ArrayList<Room>>();
                JSONArray roomsArray = (JSONArray) hotelJSON.get(HotelJSONConstants.HOTEL_ROOMS.getName());
                for (int j = 0; j < roomsArray.size(); j++) {
                    ArrayList<Room> subRooms = new ArrayList<Room>();
                    JSONArray roomsArray2 = (JSONArray) roomsArray.get(j);
                    for (int k = 0; k < roomsArray2.size(); k++) {
                        JSONObject roomObj = (JSONObject) roomsArray2.get(k);
                        RoomType roomType = null;
                        String s = (String) roomObj.get(HotelJSONConstants.HOTEL_ROOM_TYPE.getName());
                        for (RoomType rt: RoomType.values()) {
                            if (s.equals(rt.getName())) {
                                roomType = rt;
                                break;
                            }
                        }
                        double price = (double) roomObj.get(HotelJSONConstants.HOTEL_ROOM_PRICE.getName());
                        boolean smokerFriendly = (boolean) roomObj.get(HotelJSONConstants.HOTEL_ROOM_SMOKER_FRIENDLY.getName());
                        int bedCount = ((Long) roomObj.get(HotelJSONConstants.HOTEL_ROOM_BED_COUNT.getName())).intValue();
                        s = (String) roomObj.get(HotelJSONConstants.HOTEL_ROOM_BED_TYPE.getName());
                        BedType bedType = null;
                        for (BedType bt : BedType.values()) {
                            if (bt.getName().equals(s)) {
                                bedType = bt;
                                break;
                            }
                        }
                        int roomNumber = ((Long) roomObj.get(HotelJSONConstants.HOTEL_ROOM_NUMBER.getName())).intValue();
                        ArrayList<Passenger> occupants = new ArrayList<Passenger>();
                        JSONArray occupantsArray = (JSONArray) roomObj.get(HotelJSONConstants.HOTEL_ROOM_OCCUPANTS.getName());
                        for (int m = 0; m < occupantsArray.size(); m++) {
                            JSONObject occupantObj = (JSONObject) occupantsArray.get(m);
                            String occupantName = (String) occupantObj.get(HotelJSONConstants.OCCUPANT_NAME.getName());
                            long lDateOfBirth = (Long) occupantObj.get(HotelJSONConstants.OCCUPANT_DATE_OF_BIRTH.getName());
                            Date dateOfBirth = new Date(lDateOfBirth * 1000);
                            int passportNumber = ((Long) occupantObj.get(HotelJSONConstants.OCCUPANT_PASSPORT_NUMBER.getName())).intValue();
                            occupants.add(new Passenger(occupantName, dateOfBirth, passportNumber));
                        }
                        ArrayList<Date[]> datesOccupied = new ArrayList<Date[]>();
                        JSONArray datesArray = (JSONArray) roomObj.get(HotelJSONConstants.HOTEL_ROOM_DATES_OCCUPIED.getName());
                        for (int m = 0; m < datesArray.size(); m++) {
                            JSONArray dates2 = (JSONArray) datesArray.get(m);
                            Date[] dates = new Date[2];
                            long lDate1 = (Long) dates2.get(0);
                            Date date1 = new Date(lDate1 * 1000);
                            long lDate2 = (Long) dates2.get(1);
                            Date date2 = new Date(lDate2 * 1000);
                            dates[0] = date1;
                            dates[1] = date2;
                            datesOccupied.add(dates);
                        }
                        subRooms.add(new Room(occupants, datesOccupied, price, roomNumber, roomType, smokerFriendly, bedCount, bedType));
                    }
                    rooms.add(subRooms);
                }

				hotels.add(new Hotel(uuid, hotelName, rating, petFriendly, breakfast, hasPool, location, numFloors, numRoomsPerFloor, rooms));
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
        hotelDetails.put(HotelJSONConstants.HOTEL_NAME.getName(), hotel.getName().getName());
        hotelDetails.put(HotelJSONConstants.HOTEL_RATING.getName(), hotel.getRating());
        hotelDetails.put(HotelJSONConstants.HOTEL_PET_FRIENDLY.getName(), hotel.isPetFriendly());
        hotelDetails.put(HotelJSONConstants.HOTEL_BREAKFAST.getName(), hotel.getHasBreakfast());
        hotelDetails.put(HotelJSONConstants.HOTEL_ADDRESS.getName(), hotel.getLocation());
        hotelDetails.put(HotelJSONConstants.HOTEL_UUID.getName(), hotel.getUUID().toString());
        hotelDetails.put(HotelJSONConstants.HOTEL_POOL.getName(), hotel.getHasPool());
        hotelDetails.put(HotelJSONConstants.HOTEL_NUM_FLOORS.getName(), ((Integer) hotel.getNumFloors()).longValue());
        hotelDetails.put(HotelJSONConstants.HOTEL_NUM_ROOMS_PER_FLOOR.getName(), ((Integer) hotel.getNumRoomsPerFloor()).longValue());
        JSONArray rooms = new JSONArray();
        for (int i = 0; i < hotel.getRooms().size(); i++) {
            ArrayList<Room> floor = hotel.getRooms().get(i);
            JSONArray floors = new JSONArray();
            for (int j = 0; j < floor.size(); j++) {
                Room room = floor.get(j);
                JSONObject roomObj = new JSONObject();
                roomObj.put(HotelJSONConstants.HOTEL_ROOM_TYPE.getName(), room.getRoomType().getName());
                roomObj.put(HotelJSONConstants.HOTEL_ROOM_PRICE.getName(), room.getPrice());
                roomObj.put(HotelJSONConstants.HOTEL_ROOM_SMOKER_FRIENDLY.getName(), room.getSmokerFriendly());
                roomObj.put(HotelJSONConstants.HOTEL_ROOM_BED_COUNT.getName(), ((Integer) room.getNumberBeds()).longValue());
                roomObj.put(HotelJSONConstants.HOTEL_ROOM_BED_TYPE.getName(), room.getBedType().getName());
                roomObj.put(HotelJSONConstants.HOTEL_ROOM_NUMBER.getName(), ((Integer) room.getRoomNumber()).longValue());
                JSONArray occupantsArr = new JSONArray();
                for (int k = 0; k < room.getOccupants().size(); k++) {
                    Passenger occupant = room.getOccupants().get(k);
                    JSONObject occupantObj = new JSONObject();
                    occupantObj.put(HotelJSONConstants.OCCUPANT_NAME.getName(), occupant.getName());
                    occupantObj.put(HotelJSONConstants.OCCUPANT_DATE_OF_BIRTH.getName(), occupant.getDateOfBirth().getTime() / 1000);
                    occupantObj.put(HotelJSONConstants.OCCUPANT_PASSPORT_NUMBER.getName(), ((Integer) occupant.getPassportNumber()).longValue());
                    occupantsArr.add(occupantObj);
                }
                roomObj.put(HotelJSONConstants.HOTEL_ROOM_OCCUPANTS.getName(), occupantsArr);
                JSONArray datesOccupiedArr = new JSONArray();
                for (int k = 0; k < room.getDatesOccupied().size(); k++) {
                    JSONArray dates = new JSONArray();
                    long date1 = room.getDatesOccupied().get(k)[0].getTime() / 1000;
                    long date2 = room.getDatesOccupied().get(k)[1].getTime() / 1000;
                    dates.add(date1);
                    dates.add(date2);
                    datesOccupiedArr.add(dates);
                }
                roomObj.put(HotelJSONConstants.HOTEL_ROOM_DATES_OCCUPIED.getName(), datesOccupiedArr);
                floors.add(roomObj);
            }
            rooms.add(floors);
        }
        hotelDetails.put(HotelJSONConstants.HOTEL_ROOMS.getName(), rooms);
        
        return hotelDetails;

    } // ending bracket of method getHotelJson

}
