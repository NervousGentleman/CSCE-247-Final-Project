public enum Airline {
    NORTHEAST("NorthEast", 1, 1, 1),
    AMTRACK("Amtrack", 1, 1, 1),
    EPSELON_AIRLINES("Epselon Airlines", 1, 1, 1),
    DISUNITED_AIRLINES("DisUnited Airlines", 1, 1, 1),
    UNAMERICAN_AIRLINES("Unamerican Airlines", 1, 1, 1);
    
    private final String name;
    private final int rating;
    private final int carryOnLimit;
    private final int checkedBagLimit;

    private Airline(String name, int rating, int carryOnLimit, int checkedBagLimit) {
        this.name = name;
        this.rating = rating;
        this.carryOnLimit = carryOnLimit;
        this.checkedBagLimit = checkedBagLimit;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getCarryOnLimit() {
        return carryOnLimit;
    }

    public int getCheckedBagLimit() {
        return checkedBagLimit;
    }
}
