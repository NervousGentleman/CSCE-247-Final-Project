public enum HotelJSONConstants {
   HOTEL_FILE_NAME("JSON/Hotel.json"),
   HOTEL_NAME("name"),
   HOTEL_PRICE("price"),
   HOTEL_RATING("rating"),
   HOTEL_PET_FRIENDLY("petFriendly"),
   HOTEL_BREAKFAST("hasBreakfast"),
   HOTEL_ADDRESS("location"),
   HOTEL_UUID("uuid"),
   HOTEL_POOL("hasPool"),
   HOTEL_NUM_FLOORS("numFloors"),
   HOTEL_NUM_ROOMS_PER_FLOOR("numRoomsPerFloor"),
   HOTEL_ROOMS("rooms"),
   HOTEL_ROOM_NUMBER("roomNumber"),
   HOTEL_ROOM_TYPE("roomType"),
   HOTEL_ROOM_PRICE("price"),
   HOTEL_ROOM_SMOKER_FRIENDLY("smokerFriendly"),
   HOTEL_ROOM_BED_COUNT("bedCount"),
   HOTEL_ROOM_BED_TYPE("bedType"),
   HOTEL_ROOM_OCCUPANTS("occupants"),
   OCCUPANT_NAME("name"),
   OCCUPANT_DATE_OF_BIRTH("dateOfBirth"),
   OCCUPANT_PASSPORT_NUMBER("passportNumber"),
   HOTEL_ROOM_DATES_OCCUPIED("datesOccupied");
   
   private final String name;

   /**
    * Constant for the JSON names
    * @param name
    */
   private HotelJSONConstants(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}
