import java.util.ArrayList;

public interface Parser<T> {
    public ArrayList<T> load();
    public void save();
    public void add(T obj);
    public void delete(T obj);
}