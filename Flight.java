import java.util.ArrayList;
public class Flight {


    private Airline airline;
    private Double cost;
    private ArrayList<String> airports;
    private String date;
    private int Flight_ID;
    private int seatCount;
    private int flightDuration;
    private boolean flightFull;
    private ArrayList<Seat> seatList;

    public Flight(){

    } // ending bracket of default constructor


    public Airline getAirline()
    {
        return airline;
    }
    public void setAirline(Airline airline)
    {
        this.airline = airline;
    }
    public Double getCost()
    {
        return cost;
    }
    public void setCost(Double cost)
    {
        this.cost = cost;
    }
    public ArrayList<String> getAirports()
    {
        return airports;
    }
    public void setAirports(ArrayList<String> airports)
    {
        this.airports = airports;
    }
    public String getDate()
    {
        return date;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public int getFlightID()
    {
        return Flight_ID;
    }
    public void setFlightID(int Flight_ID)
    {
        this.Flight_ID = Flight_ID;
    }
    public int getSeatCount()
    {
        return seatCount;
    }
    public void setSeatCount(int seatCount)
    {
        this.seatCount = seatCount;
    }
    public int getFlightDuration()
    {
        return flightDuration;
    }
    public void setFlightDuration(int flightDuration)
    {
        this.flightDuration = flightDuration;
    }
    public Boolean isFlightFull()
    {
        return flightFull;
    }
    public void setFlightFull(Boolean flightFull)
    {
        this.flightFull = flightFull;
    }
    public void setSeatList(ArrayList<Seat> seatList)
    {
        this.seatList = seatList;
    }
    public ArrayList<Seat> getSeatList()
    {
        return seatList;
    }
   
    
}
