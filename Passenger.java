public class Passenger {

    private String name;
    private String dateOfBirth;
    private String passportNumber;
    private Seat seat;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getDateOfBirth()
    {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
    public String getPassportNumber()
    {
        return passportNumber;
    }
    public void setPassportNumber(String passportNumber)
    {
        this.passportNumber = passportNumber;
    }
    public Seat getSeat()
    {
        return seat;
    }
    public void setSeat(Seat seat)
    {
        this.seat = seat;
    }
    
}
