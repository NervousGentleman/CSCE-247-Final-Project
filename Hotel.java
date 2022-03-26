public class Hotel {

    private String name;
    private Double price;
    private Room room_type;
    private int rating;
    private Boolean pet_friendly;
    private Boolean breakfast;
    private String hotel_address;

    public Hotel(String name, Double price, int rating, boolean petFriendly, boolean breakfast, String hotelAddress){

        this.setName(name);
        this.setPrice(price);
        this.setRating(rating);
        this.setPet_Friendly(petFriendly);
        this.setBreakfast(breakfast);
        this.setHotelAddress(hotelAddress);

    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Double getPrice()
    {
        return price;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }
    public Room getRoom_Type()
    {
        return room_type;
    }
    public void setRoom_TYpe(Room room_type)
    {
        this.room_type = room_type;
    }
    public int getRating()
    {
        return rating;
    }
    public void setRating(int rating)
    {
        this.rating = rating;
    }
    public Boolean isPet_Friendly()
    {
        return pet_friendly;
    }
    public void setPet_Friendly(Boolean pet_friendly)
    {
        this.pet_friendly = pet_friendly;
    }
    public Boolean hasBreakfast()
    {
        return breakfast;
    }
    public void setBreakfast(Boolean breakfast)
    {
        this.breakfast = breakfast;
    }
    public String getHotelAddress()
    {
        return hotel_address;
    }
    public void setHotelAddress(String hotel_address)
    {
        this.hotel_address = hotel_address;
    }

    
}
