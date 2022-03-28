import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserParser implements Parser<Account> {
    private static UserParser userParser;
    private ArrayList<Account> users;
    private UserJSONConstants c;

    private UserParser() {
        // this.users = new ArrayList<Account>();
        // users = load();
    }

    public static UserParser getInstance() {
        if (userParser == null) {
            userParser = new UserParser();
        }
        return userParser;
    }

    public ArrayList<Account> load() {
        users = new ArrayList<Account>();
        ArrayList<Flight> flights = FlightParser.getInstance().load();
        ArrayList<Hotel> hotels = HotelParser.getInstance().load();

        try {
            FileReader reader = new FileReader(c.FILE_NAME.getName());
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < usersJSON.size(); i++) {
                System.out.println(i);
                JSONObject userObj = (JSONObject) usersJSON.get(i);

                String stringUUID = (String) userObj.get(c.UUID.getName());
                UUID uuid = UUID.fromString(stringUUID);

                String email = (String) userObj.get(c.EMAIL.getName());

                String password = (String) userObj.get(c.PASSWORD.getName());

                String name = (String) userObj.get(c.NAME.getName());

                long longDateOfBirth = (long) userObj.get(c.DATE_OF_BIRTH.getName());
                Date dateOfBirth = new Date(longDateOfBirth * 1000);

                Long longPassportNumber = (long) userObj.get(c.PASSPORT_NUMBER.getName());
                int passportNumber = longPassportNumber.intValue();

                JSONArray flightHistoryArray = (JSONArray) userObj.get(c.FLIGHT_HISTORY.getName());
                ArrayList<Flight> flightHistory = new ArrayList<Flight>();
                for (int j = 0; j < flightHistoryArray.size(); j++) {
                    JSONObject temp = (JSONObject) flightHistoryArray.get(j);
                    String s = (String) temp.get(String.valueOf(j+1));
                    UUID tempUUID = UUID.fromString(s);
                    for (Flight f : flights) {
                        if (f.getFlightID().equals(tempUUID)) {
                            flightHistory.add(f);
                            break;
                        }
                    }
                }

                JSONArray hotelHistoryArray = (JSONArray) userObj.get(c.HOTEL_HISTORY.getName());
                ArrayList<Hotel> hotelHistory = new ArrayList<Hotel>();
                for (int j = 0; j < hotelHistoryArray.size(); j++) {
                    JSONObject temp = (JSONObject) hotelHistoryArray.get(j);
                    String s = (String) temp.get(String.valueOf(j+1));
                    UUID tempUUID = UUID.fromString(s);
                    for (Hotel h : hotels) {
                        if (h.getUUID().equals(tempUUID)) {
                            hotelHistory.add(h);
                            break;
                        }
                    }
                }

                JSONArray bookedFlightsArray = (JSONArray) userObj.get(c.BOOKED_FLIGHTS.getName());
                ArrayList<Flight> bookedFlights = new ArrayList<Flight>();
                for (int j = 0; j < bookedFlightsArray.size(); j++) {
                    JSONObject temp = (JSONObject) bookedFlightsArray.get(j);
                    String s = (String) temp.get(String.valueOf(j+1));
                    UUID tempUUID = UUID.fromString(s);
                    for (Flight f : flights) {
                        if (f.getFlightID().equals(tempUUID)) {
                            bookedFlights.add(f);
                            break;
                        }
                    }
                }

                JSONArray bookedHotelsArray = (JSONArray) userObj.get(c.BOOKED_HOTELS.getName());
                ArrayList<Hotel> bookedHotels = new ArrayList<Hotel>();
                for (int j = 0; j < bookedHotelsArray.size(); j++) {
                    JSONObject temp = (JSONObject) bookedHotelsArray.get(j);
                    String s = (String) temp.get(String.valueOf(j+1));
                    UUID tempUUID = UUID.fromString(s);
                    for (Hotel h : hotels) {
                        if (h.getUUID().equals(tempUUID)) {
                            bookedHotels.add(h);
                            break;
                        }
                    }
                }

                boolean frequentFlyer = (boolean) userObj.get(c.FREQUENT_FLYER.getName());

                boolean smoker = (boolean) userObj.get(c.SMOKER.getName());

                JSONArray guestsArray = (JSONArray) userObj.get(c.GUESTS.getName());
                ArrayList<Passenger> guests = new ArrayList<Passenger>();
                for (int j = 0; j < guestsArray.size(); j++) {
                    JSONObject temp = (JSONObject) guestsArray.get(j);
                    String tName = (String) temp.get(c.NAME.getName());
                    Long lDateOfBirth = (long) temp.get(c.DATE_OF_BIRTH.getName());
                    Date tDateOfBirth = new Date(lDateOfBirth * 1000);
                    int tPassportNumber = ((Long) temp.get(c.PASSPORT_NUMBER.getName())).intValue();
                    guests.add(new Passenger(tName, tDateOfBirth, tPassportNumber));
                }

                users.add(new Account(uuid, email, password, name, dateOfBirth, passportNumber, 
                        flightHistory, hotelHistory, bookedFlights, bookedHotels, frequentFlyer, 
                        smoker, guests, new Passenger(name, dateOfBirth, passportNumber)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public void save() {
        JSONArray usersArray = new JSONArray();
        for (int i = 0; i < users.size(); i++) {
            Account a = users.get(i);
            JSONObject user = new JSONObject();
            user.put(c.UUID.getName(), a.getUUID().toString());
            user.put(c.EMAIL.getName(), a.getEmail());
            user.put(c.PASSWORD.getName(), a.getPassword());
            user.put(c.NAME.getName(), a.getName());
            user.put(c.DATE_OF_BIRTH.getName(), ((Long) a.getDateOfBirth().getTime() / 1000));
            user.put(c.PASSPORT_NUMBER.getName(), ((Integer) a.getPassportNumber()).longValue());
            ArrayList<Flight> flightHistory = a.getFlightHistory();
            JSONArray flightHistoryArray = new JSONArray();
            for (int j = 0; j < flightHistory.size(); j++) {
                JSONObject temp = new JSONObject();
                temp.put(String.valueOf(j+1), flightHistory.get(j).getFlightID().toString());
                flightHistoryArray.add(temp);
            }
            user.put(c.FLIGHT_HISTORY.getName(), flightHistoryArray);
            ArrayList<Hotel> hotelHistory = a.getHotelHistory();
            JSONArray hotelHistoryArray = new JSONArray();
            for (int j = 0; j < hotelHistory.size(); j++) {
                JSONObject temp = new JSONObject();
                temp.put(String.valueOf(j+1), hotelHistory.get(j).getUUID().toString());
                hotelHistoryArray.add(temp);
            }
            user.put(c.HOTEL_HISTORY.getName(), hotelHistoryArray);
            ArrayList<Flight> bookedFlights = a.getBookedFlights();
            JSONArray bookedFlightsArray = new JSONArray();
            for (int j = 0; j < bookedFlights.size(); j++) {
                JSONObject temp = new JSONObject();
                temp.put(String.valueOf(j+1), bookedFlights.get(j).getFlightID().toString());
                bookedFlightsArray.add(temp);
            }
            user.put(c.BOOKED_FLIGHTS.getName(), bookedFlightsArray);
            ArrayList<Hotel> bookedHotels = a.getBookedHotels();
            JSONArray bookedHotelsArray = new JSONArray();
            for (int j = 0; j < bookedHotels.size(); j++) {
                JSONObject temp = new JSONObject();
                temp.put(String.valueOf(j+1), bookedHotels.get(j).getUUID().toString());
                bookedHotelsArray.add(temp);
            }
            user.put(c.BOOKED_HOTELS.getName(), bookedHotelsArray);
            user.put(c.FREQUENT_FLYER.getName(), a.getFrequentFlyer());
            user.put(c.SMOKER.getName(), a.isSmoker());
            ArrayList<Passenger> guests = a.getGuests();
            JSONArray guestsArray = new JSONArray();
            for (int j = 0; j < guests.size(); j++) {
                JSONObject temp = new JSONObject();
                temp.put(c.NAME.getName(), guests.get(j).getName());
                temp.put(c.DATE_OF_BIRTH.getName(), ((Long) guests.get(j).getDateOfBirth().getTime() / 1000));
                temp.put(c.PASSPORT_NUMBER.getName(), ((Integer) guests.get(j).getPassportNumber()).longValue());
                guestsArray.add(temp);
            }
            user.put(c.GUESTS.getName(), guestsArray);
            usersArray.add(user);
        }

        try {
            FileWriter file = new FileWriter(c.FILE_NAME.getName());
            file.write(usersArray.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Account user) {
        users.add(user);
    }

    public void delete(Account user) {
        users.remove(user);
    }

    public ArrayList<Account> getList() {
        return users;
    }
}
