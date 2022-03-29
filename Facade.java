import java.util.ArrayList;

public class Facade {
    private ArrayList<Flight> availableFlights;
    private ArrayList<Account> loadedAccounts;
    private Flight chosenFlight;
    private Account userAccount;

    
    public Facade() {
        this.availableFlights = new ArrayList<Flight>();
        this.loadedAccounts = UserParser.getInstance().load();
        this.chosenFlight = new Flight(); // need to add default values in default constructor.
    //  this.userAccount = new Account(); need default constructor

    }

    public boolean createAccount(String email, String password){
        if (findAccount(email) == null) {
            userAccount = new Account();
            userAccount.setEmail(email);
            userAccount.setPassword(password);
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
        if(flightIndex >= 0 && flightIndex < this.availableFlights.size()){
            this.chosenFlight = this.availableFlights.get(flightIndex);
            rv = true;
        }
        return rv;
    } // ending bracket of method chooseFlight

    public void displayFlights(ArrayList<Flight> flightList){
        // display flightList by looping through and calling toString method of each flight
        // print i+1 + ". " before flight info
        for(int i = 0; i < flightList.size(); i++)
        {
            System.out.println(flightList.get(i).toString());
        }
    }
    
    public void displayHotels(ArrayList<Hotel> hotelList){
        // display hotelList by looping through and calling toString method of each hotel
        // print i+1 + ". " before hotel info
        for(int i = 0; i < hotelList.size(); i++)
        {
            System.out.println(hotelList.get(i).toString());
        }
    }

    public void displaySeats(Flight flight){
        // loop through each seat in chosenFlight and print seat code to console if seatTaken == false
        for(int i = 0; i < flight.getSeats().length; i++)
        {
            
        }
        
    }

    public boolean chooseSeat(String seatCode){
        boolean rv = true;
        if()
        {

        }
        // if seatCode equals an untaken seat, put user into Seat on chosenFlight
        // may need some type of "fillSeat" method in Flight
        return rv;

    }
}
