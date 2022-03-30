public enum HotelName {

    DEFAULT_NAME(""),
    WORST_EASTERN("Worst Eastern"),
    NIGHTS_INN("Nights Inn"),
    LOUSY_7("Lousy 7"),
    UNCOMFORTABLE_INN("Uncomfortable Inn"),
    WORK_INN("Work Inn");

    private final String name;

    private HotelName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
