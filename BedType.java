public enum BedType {
    SINGLE("Single"),
    DOUBLE("Double"),
    QUEEN("Queen"),
    KING("King");

    private final String name;

    private BedType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
