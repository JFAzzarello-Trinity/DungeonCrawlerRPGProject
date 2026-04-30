import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
public class Inventory<T extends Item> {
    // HashSet prevents duplicates and gives fast add/remove
    private HashSet<T> items = new HashSet<>();

    public void addItem(T item){
        items.add(item);
    }

    public void removeItem(T item){
        items.remove(item);
    }

    public boolean hasItem(T item){
        if(items.contains(item)){
            return true;
        }
        return false;
    }

    public String displaySorted() {
        List<T> list = new ArrayList<>(items);
        Collections.sort(list);

        String result = "";
        for (T item : list) {
            result += "\n" + item;
        }
        return result;
    }

    public int getSize(){
        return items.size();
    }
}
