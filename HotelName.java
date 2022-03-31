public enum HotelName {

    DEFAULT_NAME(""),
    WORST_EASTERN("Worst Eastern"),
    NIGHTS_INN("Nights Inn"),
    LOUSY_7("Lousy 7"),
    UNCOMFORTABLE_INN("Uncomfortable Inn"),
    WORK_INN("Work Inn");

    private final String name;

    /**
     * Name for the hotel
     * @param name
     */
    private HotelName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the hotel
     * @return
     */
    public String getName() {
        return name;
    }
}
