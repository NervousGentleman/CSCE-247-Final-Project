import java.util.ArrayList;

public class UserParser implements Parser<Account> {
    private static UserParser userParser;
    private ArrayList<Account> users;

    private UserParser() {
        this.users = new ArrayList<Account>();
    }

    public static UserParser getInstance() {
        if (userParser == null) {
            userParser = new UserParser();
        }
        return userParser;
    }

    public ArrayList<Account> load() {
        return users;
    }

    public void save() {
        
    }

    public void add(Account user) {
        users.add(user);
    }

    public void delete(Account user) {
        users.remove(user);
    }
}
