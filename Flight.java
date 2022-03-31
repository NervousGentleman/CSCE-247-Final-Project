import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Flight {
    private UUID flightID;
    private Airline airline;
    private String departureLocation;
    private String destinationLocation;
    private boolean isConnecting;
    private Flight previousFlight;
    private Flight nextFlight;
    private Date departureTime;
    private Date arrivalTime;
    private double flightDuration;
    private int numRows;
    private int numSeatsPerRow;
    private ArrayList<ArrayList<Seat>> seats;

    /**
     * Constructor for flights
     * @param flightID
     * @param airline
     * @param departureLocation
     * @param destinationLocation
     * @param isConnecting
     * @param previousFlight
     * @param nextFlight
     * @param departureTime
     * @param arrivalTime
     * @param flightDuration
     * @param numRows
     * @param numSeatsPerRow
     * @param seats
     */
    public Flight(UUID flightID, Airline airline, String departureLocation, String destinationLocation,
                    boolean isConnecting, Flight previousFlight, Flight nextFlight, Date departureTime,
                    Date arrivalTime, double flightDuration, int numRows, int numSeatsPerRow, ArrayList<ArrayList<Seat>> seats) {
                        this.flightID = flightID;
                        this.airline = airline;
                        this.departureLocation = departureLocation;
                        this.destinationLocation = destinationLocation;
                        this.isConnecting = isConnecting;
                        this.previousFlight = previousFlight;
                        this.nextFlight = nextFlight;
                        this.departureTime = departureTime;
                        this.arrivalTime = arrivalTime;
                        this.flightDuration = flightDuration;
                        this.numRows = numRows;
                        this.numSeatsPerRow = numSeatsPerRow;
                        this.seats = seats;
                    }

    /**
     * Getters and setters
     * @return
     */
    public UUID getFlightID()
    {
        return flightID;
    }

    public void setFlightID(UUID flightID)
    {
        this.flightID = flightID;
    }

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

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public boolean getIsConnecting() {
        return isConnecting;
    }

    public void setIsConnecting(boolean isConnecting) {
        this.isConnecting = isConnecting;
    }

    public Flight getPreviousFlight() {
        return previousFlight;
    }

    public void setPreviousFlight(Flight previousFlight) {
        this.previousFlight = previousFlight;
    }

    public Flight getNextFlight() {
        return nextFlight;
    }

    public void setNextFlight(Flight nextFlight) {
        this.nextFlight = nextFlight;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTimer(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getFlightDuration()
    {
        if (isConnecting && previousFlight != null) {
            return flightDuration + previousFlight.getFlightDuration();
        }
        return flightDuration;
    }

    public void setFlightDuration(double flightDuration)
    {
        this.flightDuration = flightDuration;
    }
    
    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumSeatsPerRow() {
        return numSeatsPerRow;
    }

    public void setNumSeatsPerRow(int numSeatsPerRow) {
        this.numSeatsPerRow = numSeatsPerRow;
    }

    public ArrayList<ArrayList<Seat>> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<ArrayList<Seat>> seats) {
        this.seats = seats;
    }

    /**
     * returns a string of the flight details
     */
    public String toString() {
        String ret = "Flight " + airline.getName() + " departing from " + departureLocation + " at " + departureTime + " arriving at " 
        + destinationLocation + " at " + arrivalTime + ". Flight duration " + flightDuration + " hours.";
        return ret;
    }
}
