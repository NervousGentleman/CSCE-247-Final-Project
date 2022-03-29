public class Seat {

    private Passenger passenger;
    private double cost;
    private SeatClass seatClass;
    private int seatRow;
    private String seatLetter;
    private boolean seatTaken;
    private String seatCode;

    public Seat(Passenger passenger, double cost, SeatClass seatClass, int seatRow, String seatLettrer,
                boolean seatTaken) {
                    this.passenger = passenger;
                    this.cost = cost;
                    this.seatClass = seatClass;
                    this.seatRow = seatRow;
                    this.seatLetter = seatLettrer;
                    this.seatTaken = seatTaken;
                    seatCode = seatRow + seatLetter;
                }

    public Passenger getPassenger()
    {
        return passenger;
    }

    public void setPassenger(Passenger passenger)
    {
        this.passenger = passenger;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public SeatClass getSeatClass()
    {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass)
    {
        this.seatClass = seatClass;
    }

    public int getseatRow()
    {
        return seatRow;
    }

    public void setseatRow(int seatRow)
    {
        this.seatRow = seatRow;
    }

    public String getSeatLetter()
    {
        return seatLetter;
    }

    public void setSeatLetter(String seatLetter)
    {
        this.seatLetter = seatLetter;
    }

    public boolean isSeatTaken()
    {
        return seatTaken;
    }

    public void setSeatTaken(boolean seatTaken)
    {
        this.seatTaken = seatTaken;
    }

    public String getSeatCode() {
        return seatCode;
    }
}
