public enum BedType {
    SINGLE("Single"),
    DOUBLE("Double"),
    QUEEN("Queen"),
    KING("King");

    private final String name;

    /**
     * Constructor for the bed type
     * @param String
     */
    private BedType(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the bedtype
     * @return
     */
    public String getName() {
        return name;
    }
}
