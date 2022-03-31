public enum RoomType {
    
    REGULAR("Regular"),
    SUITE("Suite"),
    PRESIDENTIAL_SUITE("Presidential Suite"),
    PENTHOUSE("Penthouse");

    private final String name;

    /**
     * enum
     * @param name
     */
    private RoomType(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the Room type
     * @return
     */
    public String getName() {
        return name;
    }

}
