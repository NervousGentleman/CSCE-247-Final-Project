public enum FlightJSONConstants {
    TEST("test");
    
    private final String name;

    private FlightJSONConstants(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
