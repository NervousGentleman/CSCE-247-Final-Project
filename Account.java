import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Account {
    private UUID uuid;
    private String email;
    private String password;
    private String name;
    private Date dateOfBirth;
    private int passportNumber;
    private ArrayList<Flight> flightHistory;
    private ArrayList<Hotel> hotelHistory;
    private ArrayList<Flight> bookedFlights;
    private ArrayList<Hotel> bookedHotels;
    private boolean frequentFlyer;
    private boolean smoker;
    private ArrayList<Passenger> guests;
    private Passenger passengerSelf;

<<<<<<< HEAD
    public Account(){

    } // ending bracket of default constructor
=======
    public Account() {
        uuid = UUID.randomUUID();
        email = "";
        password = "";
        name = "";
        dateOfBirth = null;
        passportNumber = 0;
        flightHistory = new ArrayList<Flight>();
        hotelHistory = new ArrayList<Hotel>();
        bookedFlights = new ArrayList<Flight>();
        bookedHotels = new ArrayList<Hotel>();
        frequentFlyer = false;
        smoker = false;
        guests = new ArrayList<Passenger>();
        passengerSelf = null;
    }
>>>>>>> main

    public Account(UUID uuid, String email, String password, String name, Date dateOfBirth, int passportNumber,
                    ArrayList<Flight> flightHistory, ArrayList<Hotel> hotelHistory, ArrayList<Flight> bookedFlights,
                    ArrayList<Hotel> bookedHotels, boolean frequentFlyer, boolean smoker, ArrayList<Passenger> guests,
                    Passenger passengerSelf) {
                        this.uuid = uuid;
                        this.email = email;
                        this.password = password;
                        this.dateOfBirth = dateOfBirth;
                        this.passportNumber = passportNumber;
                        this.flightHistory = flightHistory;
                        this.hotelHistory = hotelHistory;
                        this.bookedFlights = bookedFlights;
                        this.bookedHotels = bookedHotels;
                        this.frequentFlyer = frequentFlyer;
                        this.smoker = smoker;
                        this.guests = guests;
                        this.passengerSelf = passengerSelf;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public ArrayList<Flight> getFlightHistory()
    {
        return flightHistory;
    }

    public void setFlightHistory(ArrayList<Flight> flightHistory) {
        this.flightHistory = flightHistory;
    }

    public ArrayList<Hotel> getHotelHistory()
    {
        return hotelHistory;
    }

    public void setHotelHistory(ArrayList<Hotel> hotelHistory) {
        this.hotelHistory = hotelHistory;
    }
    
    public ArrayList<Flight> getBookedFlights()
    {
        return bookedFlights;
    }
    public void addBookedFlight(Flight bookedFlight)
    {
        this.bookedFlights.add(bookedFlight);
    }

    public ArrayList<Hotel> getBookedHotels() {
        return bookedHotels;
    }

    public void setBookedHotels(ArrayList<Hotel> bookedHotels) {
        this.bookedHotels = bookedHotels;
    }
    
    public Boolean getFrequentFlyer()
    {
        return frequentFlyer;
    }

    public void setFrequentFlyer(boolean frequentFlyer)
    {
        this.frequentFlyer = frequentFlyer;
    } 

    public Boolean isSmoker()
    {
        return smoker;
    }

    public void setSomoker(Boolean smoker)
    {
        this.smoker = smoker;
    }

    public ArrayList<Passenger> getGuests()
    {
        return guests;
    }
    public void setGuests(ArrayList<Passenger> guests)
    {
        this.guests = guests;
    }

    public Passenger getPassengerSelf() {
        return passengerSelf;
    }

    public void setPassengerSelf(Passenger passengerSelf) {
        this.passengerSelf = passengerSelf;
    }
}
