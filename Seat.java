public class Seat {

    private Passenger passeneger;
    private String seatClass;
    private int seatRow;
    private String seatColumn;
    private Boolean seatTaken;

    public Passenger getPassenger()
    {
        return passeneger;
    }
    public void setPassenger(Passenger passenger)
    {
        this.passeneger = passenger;
    }
    public void setSeatClass(String seatClass)
    {
        this.seatClass = seatClass;
    }
    public String getseatClass()
    {
        return seatClass;
    }
    public void setseatRow(int seatRow)
    {
        this.seatRow = seatRow;
    }
    public int getseatRow()
    {
        return seatRow;
    }
    public void setSeatColumn(String seatColumn)
    {
        this.seatColumn = seatColumn;
    }
    public String getSeatColumn()
    {
        return seatColumn;
    }
    public Boolean isSeatTaken()
    {
        return seatTaken;
    }
    public void setSeatTaken(Boolean seatTaken)
    {
        this.seatTaken = seatTaken;
    }
    
}
