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

    public boolean chooseFlight(int flightChoice){ 
        boolean rv = false;
        int flightIndex = flightChoice - 1;  // we subtract 1 because list will start at 0, but options will start at 1
        // user will enter number of chosen flight, and we add the corresponding flight from the list
        if(flightIndex >= 0 && flightIndex < this.preferenceFlights.size()){
            this.chosenFlight = this.preferenceFlights.get(flightIndex);
            rv = true;
        }
        return rv;
    } // ending bracket of method chooseFlight

    public boolean chooseHotel(int hotelChoice){
        boolean rv = false;
        int hotelIndex = hotelChoice - 1;
        if(hotelIndex >= 0 && hotelIndex < this.preferenceHotels.size()){
            this.chosenHotel = this.preferenceHotels.get(hotelIndex);
            rv = true;
        }
        return rv;
    }

    public void displayFlights(ArrayList<Flight> flightList){
        for(int i = 0; i < flightList.size(); i++) {
            System.out.println(flightList.get(i).toString());
        }
    }
    
    public void displayHotels(ArrayList<Hotel> hotelList){
        for(int i = 0; i < hotelList.size(); i++) {
            System.out.println(hotelList.get(i).toString());
        }
        // display hotelList by looping through and calling toString method of each hotel
        // print i+1 + ". " before hotel info
    }

    public void displaySeats(Flight flight){
        // loop through each seat in chosenFlight and print seat code to console if seatTaken == false
        
    }

    public void displayBookedFlights(){
        displayFlights(this.userAccount.getBookedFlights());
    } // ending bracket of method display booked flights

    public void displayFlightHistory(){
        displayFlights(this.userAccount.getFlightHistory());
    }

    public void displayBookedHotels(){
        displayHotels(this.userAccount.getBookedHotels());
    }

    public void displayHotelHistory(){
        displayHotels(this.userAccount.getHotelHistory());
    }

    public void displaySearchedFlights(){
        displayFlights(this.preferenceFlights);
    }

    public void displaySearchedHotels(){
        displayHotels(this.preferenceHotels);
    }

    public boolean chooseSeat(String seatCode){
        // if seatCode equals an untaken seat, put user into Seat on chosenFlight
        // may need some type of "fillSeat" method in Flight
        ArrayList<ArrayList<Seat>> seats = chosenFlight.getSeats();
        for (ArrayList<Seat> a : seats) {
            for (Seat s : a) {
                if (s.getSeatCode().equals(seatCode)) {
                    if (s.isSeatTaken()) {
                        return false;
                    }
                    s.setPassenger(userAccount.getPassengerSelf());
                    return true;
                }
            }
        }
        return false;
    }

    public void displaySeats(){
        ArrayList<ArrayList<Seat>> seats = chosenFlight.getSeats();
        System.out.println("Available Seats:\n");
        for (ArrayList<Seat> a : seats) {
            for (Seat s : a) {
                if (!s.isSeatTaken()) {
                    System.out.println(s.getSeatCode() + ", ");
                }
            } // ending of inner for loop
        } // ending of for loop

    }

    public void searchFlights(String startingCode, String endingCode){
        for(Flight tempFlight : this.availableFlights){

            if(startingCode.equalsIgnoreCase(tempFlight.getDepartureLocation()) && endingCode.equalsIgnoreCase(tempFlight.getDestinationLocation())){
                preferenceFlights.add(tempFlight);
            }
        }
    }

    public void searchHotels(String location){
        for(Hotel tempHotel : this.availableHotels){
            if(location.equalsIgnoreCase(tempHotel.getLocation())){
                preferenceHotels.add(tempHotel);
            }
        }
    }

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
    
    public boolean deleteUserHotel(int hotelChoice){
        boolean rv = false;
        int hotelIndex = hotelChoice - 1;  
        if(hotelIndex >= 0 && hotelIndex < this.userAccount.getBookedHotels().size()){
            this.userAccount.getBookedHotels().remove(hotelIndex);
            rv = true;
        }
        return rv;
    }

    public Date dateConverter(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date tempBirthDate = new Date();
        try {
            tempBirthDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        } // ending of try catch block

        return tempBirthDate;
    }

    public void addGuest(String name, Date dateOfBirth, int passportNumber){
        Passenger tempPassenger = new Passenger(name, dateOfBirth, passportNumber);
        this.guests.add(tempPassenger);
    }

    public void viewItinerary(){
        this.itinerary = new Itinerary(this.userAccount);
        this.itinerary.print();
    }
}