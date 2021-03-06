import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Facade {
    private ArrayList<Flight> availableFlights;
    private ArrayList<Flight> preferenceFlights; // flight list after being sorted or narrowed
    private ArrayList<Hotel> preferenceHotels;
    private ArrayList<Hotel> availableHotels;
    private ArrayList<Account> loadedAccounts;
    private Hotel chosenHotel;
    private Flight chosenFlight;
    private Account userAccount;
    private ArrayList<Passenger> guests;
    private Itinerary itinerary;
    private FlightSort fs;
    private HotelSort hs;
    
    /**
     * Constructor for facade
     */
    public Facade() {
        this.availableFlights = FlightParser.getInstance().load();
        this.availableHotels = HotelParser.getInstance().load();
        this.loadedAccounts = UserParser.getInstance().load();
        this.preferenceFlights = new ArrayList<Flight>();
        this.preferenceHotels = new ArrayList<Hotel>();
        this.guests = new ArrayList<Passenger>(); // at some point we set userAccount guests to this
        this.chosenFlight = new Flight(); // need to add default values in default constructor.
        this.chosenHotel = new Hotel(); // need to add default values in default constructor.
        this.userAccount = new Account();
    }

    /**
     * Creates the account for user
     * @param email
     * @param password
     * @param name
     * @param dateOfBirth
     * @param passportNumber
     * @return
     */
    public boolean createAccount(String email, String password, String name, Date dateOfBirth, int passportNumber){
        if (findAccount(email) == null) {
            userAccount = new Account();
            userAccount.setEmail(email);
            userAccount.setPassword(password);
            userAccount.setName(name);
            userAccount.setDateOfBirth(dateOfBirth);
            userAccount.setPassportNumber(passportNumber);
            loadedAccounts.add(userAccount);
            return true;
        }
        return false;
    } 

    /**
     * Validates the user login
     * @param email
     * @param password
     * @return
     */
    public boolean loginValidation(String email, String password){
        Account a = findAccount(email);
        if (a == null) {
            return false;
        } else if (!a.getPassword().equals(password)) {
            return false;
        }
        userAccount = a;
        return true;
    }
    
    /**
     * Finds the account of the user
     * @param email
     * @return
     */
    private Account findAccount(String email){
        for (Account a : loadedAccounts) {
            if(a.getEmail().equals(email)) {
                return a;
            }
        }
        return null;
        // loop through accounts in list, and if you find an email that matches,
        // set "userAccount" to that account object, and change rv to true.
    }

    /**
     * Allows the user to choose a flight
     * @param flightChoice
     * @return
     */
    public boolean chooseFlight(int flightChoice){ 
        boolean rv = false;
        int flightIndex = flightChoice - 1;  // we subtract 1 because list will start at 0, but options will start at 1
        // user will enter number of chosen flight, and we add the corresponding flight from the list
        if(flightIndex >= 0 && flightIndex < this.preferenceFlights.size()){
            this.chosenFlight = this.preferenceFlights.get(flightIndex);
            userAccount.addBookedFlight(chosenFlight);
            Flight temp = chosenFlight.getNextFlight();
            while (temp != null) {
                userAccount.addBookedFlight(temp);
                temp = temp.getNextFlight();
            }
            rv = true;
        }
        return rv;
    } // ending bracket of method chooseFlight

    /**
     * Allows the user to choose a hotel
     * @param hotelChoice
     * @return
     */
    public boolean chooseHotel(int hotelChoice){
        boolean rv = false;
        int hotelIndex = hotelChoice - 1;
        if(hotelIndex >= 0 && hotelIndex < this.preferenceHotels.size()){
            this.chosenHotel = this.preferenceHotels.get(hotelIndex);
            userAccount.getBookedHotels().add(chosenHotel);
            rv = true;
        }
        return rv;
    }

    /**
     * Displayss the list of flights to the user
     * @param flightList
     */
    public void displayFlights(ArrayList<Flight> flightList){
        int actual = 0;
        for(int i = 0; i < flightList.size(); i++) {
            Flight f = flightList.get(i);
            if (f.getIsConnecting() && f.getPreviousFlight() == null) {
                actual++;
                System.out.println(actual + ": ");
                while (f.getNextFlight() != null) {
                    System.out.println(f);
                    f = f.getNextFlight();
                }
                System.out.println(f);
            } else if (f.getIsConnecting() && f.getPreviousFlight() != null) {
                continue;
            } else {
                actual++;
                System.out.println(actual + ": " + f.toString());
            }
        }
    }
    
    /**
     * Displays the list of hotels to the user
     * @param hotelList
     */
    public void displayHotels(ArrayList<Hotel> hotelList){
        for(int i = 0; i < hotelList.size(); i++) {
            System.out.println((i+1) + ": " + hotelList.get(i).toString());
        }
        // display hotelList by looping through and calling toString method of each hotel
        // print i+1 + ". " before hotel info
    }

    /**
     * Displays the seats available to the flight
     * @param flight
     */
    public void displaySeats(Flight flight){
        // loop through each seat in chosenFlight and print seat code to console if seatTaken == false
    }

    /**
     * Displays the flights the user booked
     */
    public void displayBookedFlights(){
        displayFlights(this.userAccount.getBookedFlights());
    } // ending bracket of method display booked flights

    /**
     * Displays the flight history of the user
     */
    public void displayFlightHistory(){
        displayFlights(this.userAccount.getFlightHistory());
    }

    /**
     * Displays the booked hotels that the user choose
     */
    public void displayBookedHotels(){
        displayHotels(this.userAccount.getBookedHotels());
    }

    /**
     * Displays the hotel history for the user
     */
    public void displayHotelHistory(){
        displayHotels(this.userAccount.getHotelHistory());
    }

    /**
     * Displays the flights the user searched for
     */
    public void displaySearchedFlights(){
        displayFlights(this.preferenceFlights);
    }

    /**
     * Displays the hotels the user searched for
     */
    public void displaySearchedHotels(){
        displayHotels(this.preferenceHotels);
    }

    /**
     * Allows the user to choose seat for guests
     * @param seatCodes
     * @param guests
     */
    public void chooseSeatForGuest(ArrayList<String> seatCodes, ArrayList<Passenger> guests){
        for(int i = 0; i < guests.size(); i++){
            
        }
    }

    /**
     * Allows the user to choose a room
     */
    public void chooseRoom(){
        ArrayList<ArrayList<Room>> rooms = chosenHotel.getRooms();
    }

    /**
     * Displays the seats available on a flight
     */
    public void displaySeats() {
        ArrayList<ArrayList<Seat>> seats = chosenFlight.getSeats();
        ArrayList<ArrayList<Seat>> freeSeats = new ArrayList<ArrayList<Seat>>();
        System.out.println("Available Seats:\n");
        for (ArrayList<Seat> a : seats) {
            for (Seat s : a) {
                if (!s.isSeatTaken()) {
                    System.out.print(s.getSeatCode() + ", ");
                }
            } // ending of inner for loop
            System.out.println();
        } // ending of for loop

    }

    /**
     * Displays the room available at a certain hotel
     * @param start
     * @param end
     */
    public void displayRooms(Date start, Date end){
        ArrayList<ArrayList<Room>> rooms = chosenHotel.getRooms();
        for(ArrayList<Room> a : rooms ){
            for(Room r : a) {
                if (r.getDatesOccupied().isEmpty()) {
                    System.out.print(r.getRoomNumber() + " ");
                }
                for(Date[] d : r.getDatesOccupied()){
                    if(!roomTakenDuringTime(start, end, d)){
                        System.out.print(r.getRoomNumber() + " ");
                    } 
                }// ending of innermost for loop
            } // ending of inner for loop
            System.out.println();
        } // ending of outer for loop
    }

    public boolean roomTakenDuringTime(Date start, Date end, Date[] times){
        boolean rv = false;
        
        if((start.after(times[0]) && start.before(times[1])) || (end.after(times[0]) && end.before(times[1])) ){
            rv = true;
        }
        // if the start is between date[0] and date[1] or the end is between date[0] and date[1]
        // User wants to check in at 4/01 and leave at 4/07
        // Room is booked 3/30-4/02
        return rv;
    }

    /**
     * Search the flights
     * @param startingCode
     * @param endingCode
     */
    public void searchFlights(String startingCode, String endingCode){
        for (int i = 0; i < availableFlights.size(); i++) {
            if (preferenceFlights.contains(availableFlights.get(i))) {
                continue;
            }
            Flight f = availableFlights.get(i);
            if (f.getDepartureLocation().equals(startingCode)) {
                if (!f.getIsConnecting() && f.getDestinationLocation().equals(endingCode)) {
                    preferenceFlights.add(f);
                } else if (f.getIsConnecting()) {
                Flight temp = f.getNextFlight();
                while (temp != null) {
                    if (temp.getDestinationLocation().equals(endingCode)) {
                        while (!temp.equals(f)) {
                            preferenceFlights.add(f);
                            f = f.getNextFlight();
                        }
                        preferenceFlights.add(f);
                        break;
                    }
                    temp = temp.getNextFlight();
                }
            } 
            }
        }
    }

    /**
     * Searchs the hotel in a certain city
     * @param location
     */
    public void searchHotels(String location) {
        for(Hotel tempHotel : this.availableHotels){
            if(location.equalsIgnoreCase(tempHotel.getLocation())){
                preferenceHotels.add(tempHotel);
            }
        }
    }

    /**
     * Deletes the flight that the user previously selected
     * @param hotelChoice
     * @return
     */
    public boolean deleteUserFlight(int flightChoice){
        boolean rv = false;
        int flightIndex = flightChoice - 1;  // we subtract 1 because list will start at 0, but options will start at 1
        // user will enter number of chosen flight, and we add the corresponding flight from the list
        if(flightIndex >= 0 && flightIndex < this.userAccount.getBookedFlights().size()){
            this.userAccount.getBookedFlights().remove(flightIndex);
            rv = true;
        }
        return rv;
    }
    
    /**
     * Deletes the hotel that the user previously selected
     * @param hotelChoice
     * @return
     */
    public boolean deleteUserHotel(int hotelChoice){
        boolean rv = false;
        int hotelIndex = hotelChoice - 1;  
        if(hotelIndex >= 0 && hotelIndex < this.userAccount.getBookedHotels().size()){
            this.userAccount.getBookedHotels().remove(hotelIndex);
            rv = true;
        }
        return rv;
    }

    /**
     * Converts the data
     * @param date
     * @return
     */
    public Date dateConverter(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date tempBirthDate = new Date();
        try {
            tempBirthDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        } // ending of try catch block

        return tempBirthDate;
    }
    
    /**
     * Converts the time to SimpleDateFormat
     * @param date
     * @return
     */
    public Date dateAndTimeConverter(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        Date tempDate = new Date();
        try {
            tempDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        } // ending of try catch block

        return tempDate;
    }

    /**
     * Allows the user to add a guest
     * @param name
     * @param dateOfBirth
     * @param passportNumber
     */
    public void addGuest(String name, Date dateOfBirth, int passportNumber){
        Passenger tempPassenger = new Passenger(name, dateOfBirth, passportNumber);
        this.guests.add(tempPassenger);
    }

    /**
     * Prints the itinerary for the flight
     */
    public void printItinerary(){
        this.itinerary = new Itinerary(this.userAccount);
        this.itinerary.print();
    }
    
    /**
     * Allows the user to choose a seat
     * @param seatCode
     * @return
     */
    public boolean chooseSeat(String seatCode) {
        ArrayList<ArrayList<Seat>> seats = this.chosenFlight.getSeats();

        for (int i = 0; i < seats.size(); i++) {
            ArrayList<Seat> row = seats.get(i);
            for (int j = 0; j < row.size(); j++) {
                Seat seat = row.get(j);
                if (seat.getSeatCode().equals(seatCode) && !seat.isSeatTaken()) {
                    seat.setPassenger(this.userAccount.getPassengerSelf());
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Allows the user to choose a seat for the guest
     * @param seatCode
     * @param guest
     * @return
     */
    public boolean chooseSeatForGuest(String seatCode, Passenger guest) {
        ArrayList<ArrayList<Seat>> seats = this.chosenFlight.getSeats();
        
        for (int i = 0; i < seats.size(); i++) {
            ArrayList<Seat> row = seats.get(i);
            for (int j = 0; j < row.size(); j++) {
                Seat seat = row.get(j);
                if (seat.isSeatTaken()) {
                    return false;
                } else if (seat.getSeatCode().equals(seatCode)) {
                    seat.setPassenger(guest);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sorts the flights by price
     * @return
     */
    public ArrayList<Flight> sortFlightByPrice(){
        this.fs = new FlightSort(this.preferenceFlights);
        this.preferenceFlights = fs.sortPrices();
        return fs.sortPrices();
    }

    public ArrayList<Flight> sortFlightByName(){
        this.fs = new FlightSort(this.preferenceFlights);
        this.preferenceFlights = fs.sortNames();
        return fs.sortNames();
    }

    public ArrayList<Hotel> sortHotelByPrice(){
        this.hs = new HotelSort(this.preferenceHotels);
        this.preferenceHotels = hs.sortPrices();
        return hs.sortPrices();
    }

    public ArrayList<Hotel> sortHotelByName(){
        this.hs = new HotelSort(this.preferenceHotels);
        this.preferenceHotels = hs.sortNames();
        return hs.sortNames();
    }

    public ArrayList<Passenger> getGuests(){
        return this.guests;
    }
}