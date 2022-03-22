import java.util.Scanner;
public class Airline {

    private int carryOnLimit;
    private int checkedBagLimit;
    private String name;
    private int rating;
    private String airlineName;

    Scanner input = new Scanner(System.in);

    public int getCarryOnlimit()
    {
        return carryOnLimit;
    }
    public void setCarryOnLimit(int carryOnLimit)
    {
        this.carryOnLimit = carryOnLimit;
    }
    public int getCheckedBagLimit()
    {
        return checkedBagLimit;
    }
    public void setCheckedBagLimit(int checkedBagLimit)
    {
        this.checkedBagLimit = checkedBagLimit;
    }
    public String getAirlineName()
    {
        return airlineName;
    }
    public void setAirlineName(String airlineName)
    {
        this.airlineName = airlineName;
    }
    public int getRating()
    {
        return rating;
    }
    public void setRaiting(int rating)
    {
        this.rating = rating;
    }
}
