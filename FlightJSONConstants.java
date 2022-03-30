public enum FlightJSONConstants {
    FILE_NAME("JSON/Flights.json"),
    FLIGHT_ID("flightID"),
    AIRLINE("airline"),
    DEPARTURE_LOCATION("departureLocation"),
    DESTINATION_LOCATION("destinationLocation"),
    IS_CONNECTING("isConnecting"),
    PREVIOUS_FLIGHT("previousFlight"),
    NEXT_FLIGHT("nextFlight"),
    DEPARTURE_TIME("departureTime"),
    ARRIVAL_TIME("arrivalTime"),
    FLIGHT_DURATION("flightDuration"),
    NUM_ROWS("numRows"),
    NUM_SEATS_PER_ROW("numSeatsPerRow"),
    SEATS("seats"),
    PASSENGER("passenger"),
    NAME("name"),
    DATE_OF_BIRTH("dateOfBirth"),
    PASSPORT_NUMBER("passportNumber"),
    COST("cost"),
    CLASS("class"),
    SEAT_ROW("seatRow"),
    SEAT_LETTER("seatLetter"),
    SEAT_TAKEN("seatTaken");
    
    private final String name;

    private FlightJSONConstants(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
