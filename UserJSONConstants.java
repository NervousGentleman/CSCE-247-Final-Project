public enum UserJSONConstants {
    FILE_NAME("JSON/Users.json"),
    UUID("uuid"),
    EMAIL("email"),
    PASSWORD("password"),
    NAME("name"),
    DATE_OF_BIRTH("dateOfBirth"),
    PASSPORT_NUMBER("passportNumber"),
    FLIGHT_HISTORY("flightHistory"),
    HOTEL_HISTORY("hotelHistory"),
    BOOKED_FLIGHTS("bookedFlights"),
    BOOKED_HOTELS("bookedHotels"),
    FREQUENT_FLYER("frequentFlyer"),
    SMOKER("smoker"),
    GUESTS("guests");

    private final String name;

    private UserJSONConstants(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
