public class Hotel {
    private HotelName name;
    private int rating;
    private boolean petFriendly;
    private boolean hasBreakfast;
    private boolean hasPool;
    private String location;
    private int numFloors;
    private int numRoomsPerFloor;
    private Room[][] rooms;

    public Hotel(HotelName name, int rating, boolean petFriendly, boolean hasBreakfast, boolean hasPool,
                String location, int numFloors, int numRoomsPerFloor, Room[][] rooms) {
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

    public Room[][] getRooms() {
        return rooms;
    }

    public void setRooms(Room[][] rooms) {
        this.rooms = rooms;
    }
}
