public enum HotelJSONConstants {
   HOTEL_FILE_NAME("JSON/Hotel.json"),
   HOTEL_UUID("uuid"),
   HOTEL_NAME("name"),
   HOTEL_RATING("rating"),
   HOTEL_PET_FRIENDLY("petFriendly"),
   HOTEL_BREAKFAST("hasBreakfast"),
   HOTEL_POOL("hasPool"),
   HOTEL_LOCATION("location"),
   HOTEL_FLOORS_NUMBER("numFloors"),
   HOTEL_ROOMS_PER_FLOOR("numRoomsPerFloor"),
   HOTEL_ADDRESS("hotelAddress");
   
   private final String name;

   private HotelJSONConstants(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}
