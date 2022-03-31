public enum SeatClass{
    ECONOMY("Economy"),
    BUSINESS("Business"),
    FIRST_CLASS("First Class");

    private final String name;

    /**
     * enum
     * @param name
     */
    private SeatClass(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the Seat class
     * @return
     */
    public String getName() {
        return name;
    }
}
