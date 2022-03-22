import java.util.ArrayList;

public interface Parser {
    public ArrayList<T> load();
    public void save();
    public void add(T obj);
    public void edit(T obj);
    public void delete(T obj);
}