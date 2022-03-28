import java.util.ArrayList;

public class Facade {
    private ArrayList<Flight> availableFlights;
    private ArrayList<Account> loadedAccounts;
    private Flight chosenFlight;
    private Account userAccount;

    
    public Facade() {
        this.availableFlights = new ArrayList<Flight>();
        this.loadedAccounts = new ArrayList<Account>();
        this.chosenFlight = new Flight(); // need to add default values in default constructor.
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
        for(int i = 0; i < flightList.size(); i++);
        {
            System.out.println(flightList.toString());
        }
    }
    
    public void displayHotels(ArrayList<Hotel> hotelList){
        // display hotelList by looping through and calling toString method of each hotel
        // print i+1 + ". " before hotel info
        for(int i = 0; i < hotelList.size(); i++)
        {
            System.out.println(hotelList.toString());
        }
    }

    public void displaySeats(Flight flight){
        // loop through each seat in chosenFlight and print seat code to console if seatTaken == false
        
    }

    public boolean chooseSeat(String seatCode){
        boolean rv = true;
        // if seatCode equals an untaken seat, put user into Seat on chosenFlight
        // may need some type of "fillSeat" method in Flight
        return rv;

    }
}
