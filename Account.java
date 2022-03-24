import java.util.ArrayList;
public class Account {


    private String email;
    private String userPassword;
    private ArrayList<Flight> flightHistory;
    private ArrayList<Hotel> hotelHistory;
    private Boolean frequentFlyer;
    private ArrayList<Flight> bookedFlights;
    private Boolean smoker;
    private ArrayList<Passenger> guests;
    private Flight flight;


    public String getUserPassword()
    {
        return userPassword;
    }
    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }
    public Boolean isSmoker()
    {
        return smoker;
    }
    public void setSomoker(Boolean smoker)
    {
        this.smoker = smoker;
    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public ArrayList<Flight> getFlightHistory()
    {
        return flightHistory;
    }
    public void addFlightHistory(ArrayList<Flight> flightHistory)
    {
        this.flightHistory = flightHistory;
    }
    public Flight getFlight()
    {
        return flight;
    }
    public void setFlight(Flight flight)
    {
        this.flight = flight;
    }
    public ArrayList<Hotel> getHotelHistory()
    {
        return hotelHistory;
    }
    public void addHotelHistory(ArrayList<Hotel> hotelHistory)
    {
        this.hotelHistory = hotelHistory;
    }
    public Boolean getFrequentFlyer()
    {
        return frequentFlyer;
    }
    public void setFrequentFlyer(boolean frequentFlyer)
    {
        this.frequentFlyer = frequentFlyer;
    }
    public ArrayList<Flight> getBookedFlights()
    {
        return bookedFlights;
    }
    public void addBookedFlight(ArrayList<Flight> bookedFlights)
    {
        this.bookedFlights = bookedFlights;
    }
    public ArrayList<Passenger> getGuests()
    {
        return guests;
    }
    public void addGuests(ArrayList<Passenger> guests)
    {
        this.guests = guests;
    }
    
}
