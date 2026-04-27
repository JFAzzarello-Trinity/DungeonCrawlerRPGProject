import java.util.ArrayList;
import java.util.Collections;
public class App {
    public static void main(String[] args) throws Exception {
        Hero hero = new Hero(15, "Warrior", 1, "Jorge", 85, 100, 20, 10);
        Monster monster = new Monster(10, "Goblin", "Greeb", 50, 50, 5, 10);
        Monster monster2 = new Monster(20, "Orc", "Grob", 80, 80, 15, 15);
        Weapon item = new Weapon("Spear", 100, "A sharp blade for far-ranged combat.");
        Potion item2 = new Potion("Health Potion", 50, "Restores 50 health points when consumed.");
        Armor item3 = new Armor("Helmet", 150, "Provides extra defense against attacks.");
        Armor item4 = new Armor("Gauntlets", 50, "Armor to protect your hands.");
        Room room = new Room("Dining Hall", "A candle-lit room with a long dining table and several chairs. The walls are adorned with faded tapestries depicting ancient battles.");
        room.addMonster(monster);
        room.addMonster(monster2);
        room.addItem(item);
        room.addItem(item2);
        room.addItem(item3);
        room.addItem(item4);
        System.out.println(hero);
        System.out.println(monster);
        System.out.println(monster2);
        System.out.println(item);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(item4);
        System.out.println(room);

        System.out.println("=== PART 2 OF ASSIGNMENT ===");

        ArrayList<Item> itemList = new ArrayList<Item>();
        itemList.add(item);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        Collections.sort(itemList);
        // Items are sorted in ascending order by their value field.
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i));
        }

        room.interact(hero);
        System.out.println(hero);

        System.out.println("=== SETTER VERIFICATIONS ===");
        hero.setHealth(-50);
        hero.setAttackPower(0);
    }
}
