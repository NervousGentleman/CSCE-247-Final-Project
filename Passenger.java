import java.util.Date;

public class Passenger {
    private String name;
    private Date dateOfBirth;
    private int passportNumber;

    public Passenger(String name, Date dateOfBirth, int passportNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.passportNumber = passportNumber;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPassportNumber()
    {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber)
    {
        this.passportNumber = passportNumber;
    }
}
