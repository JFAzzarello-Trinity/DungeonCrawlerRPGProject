import java.util.HashMap;
public class Dungeon {
    // HashMap allows fast lookup of rooms by name
    private HashMap<String, Room> rooms = new HashMap<>();

    public Dungeon() {
    }

    public void addRoom(Room r){
        rooms.put(r.getName(), r);
    }

    public Room getRoom(String name) {
        return rooms.get(name);
    }

    public void listRooms() {
        for (Room r : rooms.values()) {
            System.out.println(r.getName() + " | Visited: " + r.isVisited());
        }
    }

    @Override
    public String toString() {
        String result = "#================================#\n";
        result += "#  DUNGEON MAP                   #\n";
        result += "#================================#\n";

        for (Room r : rooms.values()) {
            String mark = "[ ]";
            if (r.isVisited()) {
                mark = "[X]";
            }
            result += "#  " + mark + " " + r.getName() + "\n";
        }

        result += "#  [X] = visited                 #\n";
        result += "#================================#";
        return result;
    }
}
