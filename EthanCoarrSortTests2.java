import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class EthanCoarrSortTests2 {

    public ArrayList<Hotel> hotels = new ArrayList<Hotel>();
    static Hotel H1;
    static Hotel H2;
    static Hotel H3;

    @Test
    public void testSortHotelName()
    {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        UUID uuid = UUID.randomUUID();
        HotelName name = HotelName.LOUSY_7;
        int rating = 3;
        boolean petFriendly = false;
        boolean hasBreakfast = true;
        boolean hasPool = true;
        String location = "Hell";
        int numFloors = 3;
        int numRoomsPerFloor = 12;
        ArrayList<ArrayList<Room>> rooms = new ArrayList<ArrayList<Room>>();
        for(int i = 0; i < numRoomsPerFloor; i++)
        {
            ArrayList<Room> floor = new ArrayList<Room>();
            for(int j = 0; j < numRoomsPerFloor; j++)
            {
                double price = 25;
                int roomNumber = i+1;
                RoomType roomType = RoomType.REGULAR;
                boolean smokerFriendly = false;
                int numberBeds = 2;
                BedType bedType = BedType.QUEEN;
                ArrayList<Passenger> occupants = new ArrayList<Passenger>();
                ArrayList<Date[]> datesOccupied = new ArrayList<Date[]>();
                for(int k = 0; k < numRoomsPerFloor;k++)
                {
                    occupants.add(new Passenger("null", new Date(0), -1));
                    datesOccupied.add(new Date[0]);
                    floor.add(new Room(occupants, datesOccupied, price, roomNumber, roomType, smokerFriendly, numberBeds, bedType));
                }
            }
        }
        H1 = new Hotel(uuid, name, rating, petFriendly, hasBreakfast, hasPool, location, numFloors, numRoomsPerFloor, rooms);
        hotels.add(H1);

         
        hotels = new ArrayList<Hotel>();
        uuid = UUID.randomUUID();
        name = HotelName.NIGHTS_INN;
        rating = 3;
        petFriendly = false;
        hasBreakfast = true;
        hasPool = true;
        location = "Hell";
        numFloors = 3;
        numRoomsPerFloor = 12;
        rooms = new ArrayList<ArrayList<Room>>();
        for(int i = 0; i < numRoomsPerFloor; i++)
        {
            ArrayList<Room> floor = new ArrayList<Room>();
            for(int j = 0; j < numRoomsPerFloor; j++)
            {
                double price = 50;
                int roomNumber = i+1;
                RoomType roomType = RoomType.REGULAR;
                boolean smokerFriendly = false;
                int numberBeds = 2;
                BedType bedType = BedType.QUEEN;
                ArrayList<Passenger> occupants = new ArrayList<Passenger>();
                ArrayList<Date[]> datesOccupied = new ArrayList<Date[]>();
                for(int k = 0; k < numRoomsPerFloor;k++)
                {
                    occupants.add(new Passenger("null", new Date(0), -1));
                    datesOccupied.add(new Date[0]);
                    floor.add(new Room(occupants, datesOccupied, price, roomNumber, roomType, smokerFriendly, numberBeds, bedType));
                }
            
            }
        }
        H2 = new Hotel(uuid, name, rating, petFriendly, hasBreakfast, hasPool, location, numFloors, numRoomsPerFloor, rooms);
        hotels.add(H2);
    
        
        hotels = new ArrayList<Hotel>();
        uuid = UUID.randomUUID();
        name = HotelName.UNCOMFORTABLE_INN;
        rating = 3;
        petFriendly = false;
        hasBreakfast = true;
        hasPool = true;
        location = "Hell";
        numFloors = 3;
        numRoomsPerFloor = 12;
        rooms = new ArrayList<ArrayList<Room>>();
        for(int i = 0; i < numRoomsPerFloor; i++)
        {
            ArrayList<Room> floor = new ArrayList<Room>();
            for(int j = 0; j < numRoomsPerFloor; j++)
            {
                double price = 75;
                int roomNumber = i+1;
                RoomType roomType = RoomType.REGULAR;
                boolean smokerFriendly = false;
                int numberBeds = 2;
                BedType bedType = BedType.QUEEN;
                ArrayList<Passenger> occupants = new ArrayList<Passenger>();
                ArrayList<Date[]> datesOccupied = new ArrayList<Date[]>();
                for(int k = 0; k < numRoomsPerFloor;k++)
                {
                    occupants.add(new Passenger("null", new Date(0), -1));
                    datesOccupied.add(new Date[0]);
                    floor.add(new Room(occupants, datesOccupied, price, roomNumber, roomType, smokerFriendly, numberBeds, bedType));
                }
            
            }
        }
        H3 = new Hotel(uuid, name, rating, petFriendly, hasBreakfast, hasPool, location, numFloors, numRoomsPerFloor, rooms);
        hotels.add(H3);
    
        HotelSort hs = new HotelSort(hotels);
        ArrayList<Hotel> SH = hs.sortNames();
        assertEquals(H1.getUUID(), SH.get(0).getUUID());
    }

    @Test
    public void testSortRoomPrice()
    {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        UUID uuid = UUID.randomUUID();
        HotelName name = HotelName.LOUSY_7;
        int rating = 3;
        boolean petFriendly = false;
        boolean hasBreakfast = true;
        boolean hasPool = true;
        String location = "Hell";
        int numFloors = 3;
        int numRoomsPerFloor = 12;
        ArrayList<ArrayList<Room>> rooms = new ArrayList<ArrayList<Room>>();
        for(int i = 0; i < numRoomsPerFloor; i++)
        {
            ArrayList<Room> floor = new ArrayList<Room>();
            for(int j = 0; j < numRoomsPerFloor; j++)
            {
                double price = 25;
                int roomNumber = i+1;
                RoomType roomType = RoomType.REGULAR;
                boolean smokerFriendly = false;
                int numberBeds = 2;
                BedType bedType = BedType.QUEEN;
                ArrayList<Passenger> occupants = new ArrayList<Passenger>();
                ArrayList<Date[]> datesOccupied = new ArrayList<Date[]>();
                for(int k = 0; k < numRoomsPerFloor;k++)
                {
                    occupants.add(new Passenger("null", new Date(0), -1));
                    datesOccupied.add(new Date[0]);
                    floor.add(new Room(occupants, datesOccupied, price, roomNumber, roomType, smokerFriendly, numberBeds, bedType));
                }
            }
        }
        H1 = new Hotel(uuid, name, rating, petFriendly, hasBreakfast, hasPool, location, numFloors, numRoomsPerFloor, rooms);
        hotels.add(H1);

        hotels = new ArrayList<Hotel>();
        uuid = UUID.randomUUID();
        name = HotelName.NIGHTS_INN;
        rating = 3;
        petFriendly = false;
        hasBreakfast = true;
        hasPool = true;
        location = "Hell";
        numFloors = 3;
        numRoomsPerFloor = 12;
        rooms = new ArrayList<ArrayList<Room>>();
        for(int i = 0; i < numRoomsPerFloor; i++)
        {
            ArrayList<Room> floor = new ArrayList<Room>();
            for(int j = 0; j < numRoomsPerFloor; j++)
            {
                double price = 50;
                int roomNumber = i+1;
                RoomType roomType = RoomType.REGULAR;
                boolean smokerFriendly = false;
                int numberBeds = 2;
                BedType bedType = BedType.QUEEN;
                ArrayList<Passenger> occupants = new ArrayList<Passenger>();
                ArrayList<Date[]> datesOccupied = new ArrayList<Date[]>();
                for(int k = 0; k < numRoomsPerFloor;k++)
                {
                    occupants.add(new Passenger("null", new Date(0), -1));
                    datesOccupied.add(new Date[0]);
                    floor.add(new Room(occupants, datesOccupied, price, roomNumber, roomType, smokerFriendly, numberBeds, bedType));
                }
            
            }
        }
        H2 = new Hotel(uuid, name, rating, petFriendly, hasBreakfast, hasPool, location, numFloors, numRoomsPerFloor, rooms);
        hotels.add(H2);
    
        
        hotels = new ArrayList<Hotel>();
        uuid = UUID.randomUUID();
        name = HotelName.UNCOMFORTABLE_INN;
        rating = 3;
        petFriendly = false;
        hasBreakfast = true;
        hasPool = true;
        location = "Hell";
        numFloors = 3;
        numRoomsPerFloor = 12;
        rooms = new ArrayList<ArrayList<Room>>();
        for(int i = 0; i < numRoomsPerFloor; i++)
        {
            ArrayList<Room> floor = new ArrayList<Room>();
            for(int j = 0; j < numRoomsPerFloor; j++)
            {
                double price = 75;
                int roomNumber = i+1;
                RoomType roomType = RoomType.REGULAR;
                boolean smokerFriendly = false;
                int numberBeds = 2;
                BedType bedType = BedType.QUEEN;
                ArrayList<Passenger> occupants = new ArrayList<Passenger>();
                ArrayList<Date[]> datesOccupied = new ArrayList<Date[]>();
                for(int k = 0; k < numRoomsPerFloor;k++)
                {
                    occupants.add(new Passenger("null", new Date(0), -1));
                    datesOccupied.add(new Date[0]);
                    floor.add(new Room(occupants, datesOccupied, price, roomNumber, roomType, smokerFriendly, numberBeds, bedType));
                }
            
            }
        }
        H3 = new Hotel(uuid, name, rating, petFriendly, hasBreakfast, hasPool, location, numFloors, numRoomsPerFloor, rooms);
        hotels.add(H3);
    
        HotelSort hs = new HotelSort(hotels);
        ArrayList<Hotel> SH = hs.sortPrices();
        assertEquals(H1.getUUID(), SH.get(0).getUUID());
    }
}
