import java.util.ArrayList;
import java.util.Date;

public class Room {
    private ArrayList<Passenger> occupants;
    private ArrayList<Date[]> datesOccupied;
    private double price;
    private int roomNumber;
    private RoomType roomType;
    private boolean smokerFriendly;
    private int numberBeds;
    private BedType bedType;

    public Room(ArrayList<Passenger> occupants, ArrayList<Date[]> datesOccupied, double price,
                int roomNumber, RoomType roomType, boolean smokerFriendly, int numberBeds, BedType bedType) {
                    this.occupants = occupants;
                    this.datesOccupied = datesOccupied;
                    this.price = price;
                    this.roomNumber = roomNumber;
                    this.roomType = roomType;
                    this.smokerFriendly = smokerFriendly;
                    this.numberBeds = numberBeds;
                    this.bedType = bedType;
                }

    public ArrayList<Passenger> getOccupants() {
        return occupants;
    }

    public void setOccupants(ArrayList<Passenger> occupants) {
        this.occupants = occupants;
    }

    public ArrayList<Date[]> getDatesOccupied() {
        return datesOccupied;
    }

    public void setDatesOccupied(ArrayList<Date[]> datesOccupied) {
        this.datesOccupied = datesOccupied;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType()
    {
        return roomType;
    }

    public void setRoomType(RoomType roomType)
    {
        this.roomType = roomType;
    }

    public boolean getSmokerFriendly()
    {
        return smokerFriendly;
    }

    public void setSmokerFriendly(boolean smokerFriendly)
    {
        this.smokerFriendly = smokerFriendly;
    }

    public int getNumberBeds() {
        return numberBeds;
    }

    public void setNumberBeds(int numberBeds) {
        this.numberBeds = numberBeds;
    }
    
    public BedType getBedType()
    {
        return bedType;
    }

    public void setBedType(BedType bedType)
    {
        this.bedType = bedType;
    }
}
