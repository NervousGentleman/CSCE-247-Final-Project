public enum RoomType {
    
    REGULAR("Regular"),
    SUITE("Suite"),
    PRESIDENTIAL_SUITE("Presidential Suite"),
    PENTHOUSE("Penthouse");

    private final String name;

    private RoomType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
