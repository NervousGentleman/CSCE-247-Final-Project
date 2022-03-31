import java.util.ArrayList;
import java.util.UUID;

public class Hotel {
    private UUID uuid;
    private HotelName name;
    private int rating;
    private boolean petFriendly;
    private boolean hasBreakfast;
    private boolean hasPool;
    private String location;
    private int numFloors;
    private int numRoomsPerFloor;
    private ArrayList<ArrayList<Room>> rooms;

    public Hotel(){
        this.uuid = UUID.randomUUID();
        this.setName(HotelName.DEFAULT_NAME);
        this.setRating(0);
        this.setPetFriendly(false);
        this.setHasBreakfast(false);
        this.setHasPool(false);
        this.setLocation("");
        this.setNumFloors(0);
        this.setNumRoomsPerFloor(0);
        this.setRooms(new ArrayList<ArrayList<Room>>());
    } // ending bracket of default constructor for Hotel

    public Hotel(UUID uuid, HotelName name, int rating, boolean petFriendly, boolean hasBreakfast, boolean hasPool,
                String location, int numFloors, int numRoomsPerFloor, ArrayList<ArrayList<Room>> rooms) {
                    this.uuid = uuid;
                    this.name = name;
                    this.rating = rating;
                    this.petFriendly = petFriendly;
                    this.hasBreakfast = hasBreakfast;
                    this.hasPool = hasPool;
                    this.location = location;
                    this.numFloors = numFloors;
                    this.numRoomsPerFloor = numRoomsPerFloor;
                    this.rooms = rooms;
    }

    /**
     * Getters and Setters
     * @return
     */
    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }
    
    public HotelName getName()
    {
        return name;
    }

    public void setName(HotelName name)
    {
        this.name = name;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public boolean isPetFriendly()
    {
        return petFriendly;
    }

    public void setPetFriendly(boolean petFriendly)
    {
        this.petFriendly = petFriendly;
    }

    public boolean getHasBreakfast()
    {
        return hasBreakfast;
    }

    public void setHasBreakfast(boolean hasBreakfast)
    {
        this.hasBreakfast = hasBreakfast;
    }

    public boolean getHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    public int getNumRoomsPerFloor() {
        return numRoomsPerFloor;
    }

    public void setNumRoomsPerFloor(int numRoomsPerFloor) {
        this.numRoomsPerFloor = numRoomsPerFloor;
    }

    public ArrayList<ArrayList<Room>> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<ArrayList<Room>> rooms) {
        this.rooms = rooms;
    }

    /**
     * Converts the hotel informtation to a String
     */
    public String toString(){
        return "Hotel Name: " + name.getName() + " Location: " + this.getLocation() +" Rating: " + this.getRating() + " Pet Friendly: " + this.isPetFriendly() + " Breakfast: "
        + this.getHasBreakfast() + " Pool: " + this.getHasPool();

    }
}
