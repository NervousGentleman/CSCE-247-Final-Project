import java.util.ArrayList;

public class Facade {
    private ArrayList<Flight> availableFlights;
    private ArrayList<Flight> preferenceFlights; // flight list after being sorted or narrowed
    private ArrayList<Hotel> availableHotels;
    private ArrayList<Account> loadedAccounts;
    private Hotel chosenHotel;
    private Flight chosenFlight;
    private Account userAccount;

    
    public Facade() {
        this.availableFlights = new ArrayList<Flight>();
        this.preferenceFlights = new ArrayList<Flight>();
        this.availableHotels = new ArrayList<Hotel>();
        this.loadedAccounts = new ArrayList<Account>();
        this.chosenFlight = new Flight(); // need to add default values in default constructor.
        this.chosenHotel = new Hotel(); // need to add default values in default constructor.
        this.userAccount = new Account();
    //  this.userAccount = new Account(); need default constructor

    }

    public boolean createAccount(String email, String password){
        boolean rv = false; // this will be set true if creation of the account is successful.
                            // Meaning account obj was created and successfully written to json.
                            // findAccount will return false if email isn't found.
        return rv;
    } 

    public boolean loginValidation(String email, String password){
        boolean rv = false; // set to true if email and password combo match.
        // use find account method to get corresponding account. 
        // use if statement to set return value (rv) to true if the Strings match.
        return rv;
    }
    
    private boolean findAccount(String email){
        boolean rv = false;
        // loop through accounts in list, and if you find an email that matches,
        // set "userAccount" to that account object, and change rv to true.
        return rv;
    }

    public boolean chooseFlight(int flightChoice){ 
        boolean rv = false;
        int flightIndex = flightChoice - 1;  // we subtract 1 because list will start at 0, but options will start at 1
        // user will enter number of chosen flight, and we add the corresponding flight from the list
        if(flightIndex >= 0 && flightIndex < this.availableFlights.size()){
            this.chosenFlight = this.availableFlights.get(flightIndex);
            rv = true;
        }
        return rv;
    } // ending bracket of method chooseFlight

    public void displayFlights(ArrayList<Flight> flightList){
        // display flightList by looping through and calling toString method of each flight
        // print i+1 + ". " before flight info
    }
    
    public void displayHotels(ArrayList<Hotel> hotelList){
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

    public boolean chooseSeat(String seatCode){
        boolean rv = true;
        // if seatCode equals an untaken seat, put user into Seat on chosenFlight
        return rv;

    }

    public void searchFlights(String startingCode, String endingCode){
        // loop through available flights and if the starting and ending codes are the same then add
        // flight to sublist "preferenceFlights"
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

}
