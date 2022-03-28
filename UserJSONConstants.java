public enum UserJSONConstants {
    TEST("test");

    private final String name;

    private UserJSONConstants(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
