import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
public class App {
    public static void main1(String[] args) throws Exception {

        // ==================== SETUP ====================
        Hero hero = new Hero(15, "Warrior", 1, "Jorge", 85, 100, 60, 10);

        Monster monster = new Monster(10, "Goblin", "Greeb", 50, 50, 5, 10);
        Monster monster2 = new Monster(20, "Orc", "Grob", 80, 80, 15, 15);
        Monster monster3 = new Monster(30, "Mimic", "!#&!@%*#^", 200, 250, 2, 30);

        Weapon item = new Weapon("Spear", 10, "A sharp blade for far-ranged combat.");
        Potion item2 = new Potion("Health Potion", 15, "Restores 15 health points when consumed.");
        Armor item3 = new Armor("Helmet", 12, "Provides extra defense against attacks.");
        Armor item4 = new Armor("Gauntlets", 8, "Armor to protect your hands.");

        Room room = new Room("Dining Hall", "A candle-lit room with a long dining table.");
        Room room2 = new Room("Corridor", "A long hallway lined with portraits of kings.");
        Room room3 = new Room("Bedroom", "A large bedroom with a massive bed for 1.");

        room.addMonster(monster);
        room.addMonster(monster2);
        room.addItem(item);
        room.addItem(item2);
        room.addItem(item3);
        room.addItem(item4);

        // ==================== PHASE 1 — Print all objects ====================
        System.out.println("=== PHASE 1: OBJECT DISPLAY ===");
        System.out.println(hero);
        System.out.println(monster);
        System.out.println(monster2);
        System.out.println(item);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(item4);
        System.out.println(room);

        // ==================== PHASE 2 — Behavior & Rules ====================
        System.out.println("\n=== PHASE 2: BEHAVIOR & RULES ===");

        // Sorted item list — sorted ascending by value using Comparable
        System.out.println("--- Items by value ---");
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        Collections.sort(itemList);
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i));
        }

        // Room interaction — items interact with hero, monsters attack hero
        System.out.println("\n--- Before room interaction ---");
        System.out.println(hero);
        room.interact(hero);
        System.out.println("\n--- After room interaction ---");
        System.out.println(hero);

        // Setter validation
        System.out.println("\n--- Setter validation ---");
        hero.setHealth(-50);
        hero.setAttackPower(0);
        hero.setHealth(85);

        // ==================== PHASE 3 — Collections ====================
        System.out.println("\n=== PHASE 3: COLLECTIONS ===");

        // Dungeon setup
        Dungeon dungeon = new Dungeon();
        dungeon.addRoom(room);
        dungeon.addRoom(room2);
        dungeon.addRoom(room3);

        // Stack navigation — LIFO, last room entered is first to go back to
        Stack<Room> navStack = new Stack<>();
        navStack.push(room);
        System.out.println("> Entering: " + navStack.peek().getName());
        room.setVisited(true);

        navStack.push(room2);
        System.out.println("> Entering: " + navStack.peek().getName());
        room2.setVisited(true);

        navStack.push(room3);
        System.out.println("> Entering: " + navStack.peek().getName());
        room3.setVisited(true);

        navStack.pop();
        System.out.println("< Going back... now in: " + navStack.peek().getName());
        navStack.pop();
        System.out.println("< Going back... now in: " + navStack.peek().getName());

        // Queue combat — monsters fight in spawn order (FIFO)
        Room fightRoom = new Room("Arena", "A large pit filled with gore and monsters.");
        dungeon.addRoom(fightRoom);
        fightRoom.setVisited(true);
        fightRoom.addMonster(monster);
        fightRoom.addMonster(monster2);
        fightRoom.addMonster(monster3);
        fightRoom.loadMonsters();

        System.out.println("\n--- Queue Combat ---");
        while (fightRoom.hasMonsters()) {
            Monster m = fightRoom.spawnNextMonster();
            System.out.println("[COMBAT] " + m.getName() + " appears!");
            while (m.getHealth() > 0) {
                int randomInt = (int)(Math.random() * 100);
                if (randomInt > 50) {
                    System.out.println(hero.getName() + " attacks!");
                    hero.attack(m);
                } else {
                    System.out.println(m.getName() + " attacks!");
                    m.attack(hero);
                }
            }
            System.out.println(m.getName() + " has been defeated!\n");
        }

        // Inventory — HashSet prevents duplicate items
        System.out.println("--- Inventory ---");
        hero.getInventory().addItem(item);
        hero.getInventory().addItem(item2);
        hero.getInventory().addItem(item3);
        hero.getInventory().addItem(item4);
        System.out.println(hero);

        // Leaderboard — HashMap for fast score lookup by name
        System.out.println("\n--- Leaderboard ---");
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addScore("Aria", 1250);
        leaderboard.addScore("Theron", 840);
        leaderboard.addScore("Zara", 310);
        leaderboard.printLeaderboard();

        // Dungeon map
        System.out.println("\n--- Dungeon Map ---");
        System.out.println(dungeon);
    }

    public static void main(String [] args) throws Exception{
        GameEngine engine = new GameEngine();
        engine.setup(); // creates hero, dungeon, rooms, monsters, items
        engine.start(); // runs the game loop
    }
}