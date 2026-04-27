import java.util.ArrayList;
public class Room implements Interactable{
    private String name;
    private String description;
    private ArrayList<Item> items;
    private ArrayList<Monster> monsters;
    private boolean visited;
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<Item>();
        this.monsters = new ArrayList<Monster>();
        this.visited = false;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean setVisited(boolean visited) {
        this.visited = visited;
        return visited;
    }

    @Override
    public String toString() {
        String itemList = "";
        String monsterList = "";
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if(i < items.size() - 1) {
                itemList += item.getName() + ", ";
            } else {
                itemList += item.getName();
            }
        }
        for (int i = 0; i < monsters.size(); i++) {
            Monster monster = monsters.get(i);
            if(i < monsters.size() - 1) {
                monsterList += monster.getName() + ", ";
            } else {
                monsterList += monster.getName();
            }
        }
        return """
            #============================================#
            # ROOM: """ + name + "\n" +
           "# " + description + "\n" +
           "#--------------------------------------------#\n" +
           "# ITEMS : " + itemList + "\n" +
           "# MONSTERS: " + monsterList + "\n" +
           "# VISITED : " + visited + "\n" +
           "#============================================#";
    }  
    public void interact(Hero hero){
        this.visited = true;
        System.out.println(this);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) instanceof Interactable) {
                ((Interactable) items.get(i)).interact(hero);
            }
        }   
        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).attack(hero);
        }
    }
}
