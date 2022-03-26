public class Room {

    private String roomtype;
    private Boolean Smoker_Friendly;
    private int bedCount;
    private String bedType;

    public void setRoomType(String roomtype)
    {
        this.roomtype = roomtype;
    }
    public Boolean isSmoker_Friendly()
    {
        return Smoker_Friendly;
    }
    public void setSmoker(Boolean Smoker_Friendly)
    {
        this.Smoker_Friendly = Smoker_Friendly;
    }
    public void setbedType(String bedType)
    {
        this.bedType = bedType;
    }
    public String getRoomType()
    {
        return roomtype;
    }
    public int getbedCount()
    {
        return bedCount;
    }
    public String getbedType()
    {
        return bedType;
    }
    
}
