public enum HotelJSONConstants {
   HOTEL_FILE_NAME("Hotel.json"),
   HOTEL_NAME("name"),
   HOTEL_PRICE("price"),
   HOTEL_RATING("rating"),
   HOTEL_PET_FRIENDLY("petFriendly"),
   HOTEL_BREAKFAST("breakfast"),
   HOTEL_ADDRESS("hotelAddress");
   
   private final String name;

   private HotelJSONConstants(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}
