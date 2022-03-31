import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FlightParser implements Parser<Flight> {
    private static FlightParser flightParser;
    private ArrayList<Flight> flights;
    private FlightJSONConstants c;

    private FlightParser() {

    }

    /**
     * Gets an instant of flight parser
     * @return
     */
    public static FlightParser getInstance() {
        if (flightParser == null) {
            flightParser = new FlightParser();
        }
        return flightParser;
    }

    /**
     * Loads the flights from the JSON file
     */
    public ArrayList<Flight> load() {
        flights = new ArrayList<Flight>();

        try {
            FileReader reader = new FileReader(c.FILE_NAME.getName());
            JSONArray flightsArray = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < flightsArray.size(); i++) {
                JSONObject flightObj = (JSONObject) flightsArray.get(i);

                String tempUUID = (String) flightObj.get(c.FLIGHT_ID.getName());
                UUID flightID = UUID.fromString(tempUUID);

                String s = (String) flightObj.get(c.AIRLINE.getName());
                Airline airline = null;
                for (Airline a : Airline.values()) {
                    if (s.equals(a.getName())) {
                        airline = a;
                        break;
                    }
                }

                String departureLocation = (String) flightObj.get(c.DEPARTURE_LOCATION.getName());

                String destinationLocation =
                        (String) flightObj.get(c.DESTINATION_LOCATION.getName());

                boolean isConnecting = (boolean) flightObj.get(c.IS_CONNECTING.getName());

                long tDepartureTime = (long) flightObj.get(c.DEPARTURE_TIME.getName());
                Date departureTime = new Date(tDepartureTime * 1000);

                long tArrivalTime = (long) flightObj.get(c.ARRIVAL_TIME.getName());
                Date arrivalTime = new Date(tArrivalTime * 1000);

                double flightDuration = (double) flightObj.get(c.FLIGHT_DURATION.getName());

                int numRows = ((Long) flightObj.get(c.NUM_ROWS.getName())).intValue();

                int numSeatsPerRow =
                        ((Long) flightObj.get(c.NUM_SEATS_PER_ROW.getName())).intValue();

                ArrayList<ArrayList<Seat>> seats = new ArrayList<ArrayList<Seat>>();
                JSONArray seatsArray = (JSONArray) flightObj.get(c.SEATS.getName());
                for (int j = 0; j < seatsArray.size(); j++) {
                    JSONArray rowsArray = (JSONArray) seatsArray.get(j);
                    ArrayList<Seat> row = new ArrayList<Seat>();
                    for (int k = 0; k < rowsArray.size(); k++) {
                        JSONObject seatObj = (JSONObject) rowsArray.get(k);
                        JSONObject passengerObj = (JSONObject) seatObj.get(c.PASSENGER.getName());
                        String name = (String) passengerObj.get(c.NAME.getName());
                        long tDateOfBirth = (long) passengerObj.get(c.DATE_OF_BIRTH.getName());
                        Date dateOfBirth = new Date(tDateOfBirth * 1000);
                        int passportNumber =
                                ((Long) passengerObj.get(c.PASSPORT_NUMBER.getName())).intValue();
                        double cost = (double) seatObj.get(c.COST.getName());
                        String temp = (String) seatObj.get(c.CLASS.getName());
                        SeatClass seatClass = null;
                        for (SeatClass sc : SeatClass.values()) {
                            if (temp.equals(sc.getName())) {
                                seatClass = sc;
                                break;
                            }
                        }
                        int seatRow = ((Long) seatObj.get(c.SEAT_ROW.getName())).intValue();
                        String seatLetter = (String) seatObj.get(c.SEAT_LETTER.getName());
                        boolean seatTaken = (boolean) seatObj.get(c.SEAT_TAKEN.getName());
                        row.add(new Seat(new Passenger(name, dateOfBirth, passportNumber), cost,
                                seatClass, seatRow, seatLetter, seatTaken));
                    }
                    seats.add(row);
                }
                flights.add(new Flight(flightID, airline, departureLocation, destinationLocation,
                        isConnecting, null, null, departureTime, arrivalTime,
                        flightDuration, numRows, numSeatsPerRow, seats));
            }
            for (int i = 0; i < flightsArray.size(); i++) {
                JSONObject flightObj = (JSONObject) flightsArray.get(i);

                Flight previousFlight = null;
                if (flightObj.get(c.PREVIOUS_FLIGHT.getName()) != null) {
                    String tempUUID = (String) flightObj.get(c.PREVIOUS_FLIGHT.getName());
                    UUID flightUUID = UUID.fromString(tempUUID);
                    for (Flight f : flights) {
                        if (f.getFlightID().equals(flightUUID)) {
                            previousFlight = f;
                            break;
                        }
                    }
                }

                Flight nextFlight = null;
                if (flightObj.get(c.NEXT_FLIGHT.getName()) != null) {
                    String tempUUID = (String) flightObj.get(c.NEXT_FLIGHT.getName());
                    UUID flightUUID = UUID.fromString(tempUUID);
                    for (Flight f : flights) {
                        if (f.getFlightID().equals(flightUUID)) {
                            nextFlight = f;
                            break;
                        }
                    }
                }
                flights.get(i).setPreviousFlight(previousFlight);
                flights.get(i).setNextFlight(nextFlight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flights;
    }

    /**
     * Saves new flights to the JSON file
     */
    public void save() {
        JSONArray flightArray = new JSONArray();
        for (int i = 0; i < flights.size(); i++) {
            Flight f = flights.get(i);
            JSONObject flightObj = new JSONObject();
            flightObj.put(c.FLIGHT_ID.getName(), f.getFlightID().toString());
            flightObj.put(c.AIRLINE.getName(), f.getAirline().getName());
            flightObj.put(c.DEPARTURE_LOCATION.getName(), f.getDepartureLocation());
            flightObj.put(c.DESTINATION_LOCATION.getName(), f.getDestinationLocation());
            flightObj.put(c.IS_CONNECTING.getName(), f.getIsConnecting());
            if (f.getPreviousFlight() != null) {
                flightObj.put(c.PREVIOUS_FLIGHT.getName(),
                        f.getPreviousFlight().getFlightID().toString());
            } else {
                flightObj.put(c.PREVIOUS_FLIGHT.getName(), null);
            }
            if (f.getNextFlight() != null) {
                flightObj.put(c.NEXT_FLIGHT.getName(), f.getNextFlight().getFlightID().toString());
            } else {
                flightObj.put(c.NEXT_FLIGHT.getName(), null);
            }
            flightObj.put(c.DEPARTURE_TIME.getName(), f.getDepartureTime().getTime() / 1000);
            flightObj.put(c.ARRIVAL_TIME.getName(), f.getArrivalTime().getTime() / 1000);
            flightObj.put(c.FLIGHT_DURATION.getName(), f.getFlightDuration());
            flightObj.put(c.NUM_ROWS.getName(), ((Integer) f.getNumRows()).longValue());
            flightObj.put(c.NUM_SEATS_PER_ROW.getName(),
                    ((Integer) f.getNumSeatsPerRow()).longValue());
            ArrayList<ArrayList<Seat>> seats = f.getSeats();
            JSONArray seatsArray = new JSONArray();
            for (int j = 0; j < seats.size(); j++) {
                ArrayList<Seat> rows = seats.get(j);
                JSONArray rowArray = new JSONArray();
                for (int k = 0; k < seats.get(j).size(); k++) {
                    JSONObject seatObj = new JSONObject();
                    JSONObject passengerObj = new JSONObject();
                    passengerObj.put(c.NAME.getName(), rows.get(k).getPassenger().getName());
                    passengerObj.put(c.DATE_OF_BIRTH.getName(),
                            rows.get(k).getPassenger().getDateOfBirth().getTime() / 1000);
                    passengerObj.put(c.PASSPORT_NUMBER.getName(),
                            ((Integer) rows.get(k).getPassenger().getPassportNumber()).longValue());
                    seatObj.put(c.PASSENGER.getName(), passengerObj);
                    seatObj.put(c.COST.getName(), rows.get(k).getCost());
                    seatObj.put(c.CLASS.getName(), rows.get(k).getSeatClass().getName());
                    seatObj.put(c.SEAT_ROW.getName(),
                            ((Integer) rows.get(k).getseatRow()).longValue());
                    seatObj.put(c.SEAT_LETTER.getName(), rows.get(k).getSeatLetter());
                    seatObj.put(c.SEAT_TAKEN.getName(), rows.get(k).isSeatTaken());
                    rowArray.add(seatObj);
                }
                seatsArray.add(rowArray);
            }
            flightObj.put(c.SEATS.getName(), seatsArray);
            flightArray.add(flightObj);
        }

        try {
            FileWriter file = new FileWriter(c.FILE_NAME.getName());
            file.write(flightArray.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a flight to the JSON file
     */
    public void add(Flight flight) {
        flights.add(flight);
    }

    /**
     * Deletes a flight from the JSON file
     */
    public void delete(Flight flight) {
        flights.remove(flight);
    }

    /**
     * Gets the list of flights
     * @return
     */
    public ArrayList<Flight> getList() {
        return flights;
    }
}
