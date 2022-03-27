public enum SeatClass{
    ECONOMY("Economy"),
    BUSINESS("Business"),
    FIRST_CLASS("First Class");

    private final String name;
    
    private SeatClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
