import java.util.Stack;
public class GameEngine {
    private Hero hero;
    private Dungeon dungeon;
    private Leaderboard leaderboard;
    private Stack<Room> navigationHistory;
    private int score;

    public GameEngine(){
        this.leaderboard = leaderboard;
        this.navigationHistory = new Stack<>();
        this.score = score;
    }

    public void setup() {
        hero = new Hero(0, "Warrior", 1, "Aria", 100, 100, 20, 5);

        Weapon sword = new Weapon("Iron Sword", 15, "A sturdy iron sword.");
        Potion potion = new Potion("Health Potion", 30, "Restores 30 HP.");
        Armor armor = new Armor("Leather Armor", 10, "Basic leather armor.");

        Monster goblin = new Monster(50, "Goblin", "Greeb", 30, 30, 8, 2);
        Monster orc = new Monster(100, "Orc", "Grob", 60, 60, 12, 5);
        Monster boss = new Monster(300, "Dragon", "Ignis", 200, 200, 30, 15);

        Room entrance = new Room("Entrance Hall", "A cold stone corridor. Torches flicker.");
        entrance.addItem(sword);
        entrance.addItem(potion);
        entrance.addMonster(goblin);

        Room corridor = new Room("Dark Corridor", "A narrow hallway filled with shadows.");
        corridor.addItem(armor);
        corridor.addMonster(orc);

        // Empty room — will trigger EmptyRoomException
        Room cellar = new Room("Dusty Cellar", "An abandoned room covered in dust.");

        Room bossRoom = new Room("Boss Chamber", "A massive chamber. The ground shakes.");
        bossRoom.addMonster(boss);

        dungeon = new Dungeon();
        dungeon.addRoom(entrance);
        dungeon.addRoom(corridor);
        dungeon.addRoom(cellar);
        dungeon.addRoom(bossRoom);

        // Add a previous run to leaderboard
        leaderboard.addScore("Theron", 1250);
    }

    public void start(){
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   ☠   DUNGEON CRAWLER RPG   ☠            ║");
        System.out.println("║      Survive. Loot. Conquer.             ║");
        System.out.println("╚══════════════════════════════════════════╝");

        try {
            enterRoom("Entrance Hall");
            enterRoom("Dark Corridor");
            enterRoom("Dusty Cellar");   // triggers EmptyRoomException
            goBack();
            goBack();
            goBack();
            goBack();                    // triggers empty stack message

            // Demonstrate InvalidItemException
            try {
                hero.useItem(new Weapon("Iron Sword", 15, "A sturdy sword."), "POTION");
            } catch (InvalidItemException e) {
                System.out.println("[WRONG ITEM] " + e.getMessage());
            }

            enterRoom("Boss Chamber");

        } catch (DeadHeroException e) {
            System.out.println("[HERO FALLEN] " + e.getMessage());
            System.out.println("Final score: " + score + " points");
            addScore(score);
            printGameOver();
        }
    }

    public void enterRoom(String roomName){
        Room room = dungeon.getRoom(roomName);
        if (room == null) {
            System.out.println("Room not found: " + roomName);
            return;
        }
        navigationHistory.push(room);
        System.out.println("> Entering: " + room.getName());
        try {
            room.interact(hero);
            fightMonsters(room);
            addScore(50);
        } catch (EmptyRoomException e) {
            System.out.println("[EMPTY ROOM] " + e.getMessage());
        }
    }

    public void goBack() {
        if (navigationHistory.isEmpty()) {
            System.out.println("You are at the entrance. There is no going back.");
            return;
        }
        navigationHistory.pop();
        if (!navigationHistory.isEmpty()) {
            System.out.println("< Going back... now in: " + navigationHistory.peek().getName());
        } else {
            System.out.println("< You have left the dungeon.");
        }
    }

    public void fightMonsters(Room room) {
        room.loadMonsters();
        while (room.hasMonsters()) {
            Monster m = room.spawnNextMonster();
            System.out.println("[COMBAT] " + m.getName() + " appears!");
            while (m.getHealth() > 0) {
                int roll = (int)(Math.random() * 100);
                if (roll > 50) {
                    System.out.println(hero.getName() + " attacks!");
                    hero.attack(m);
                } else {
                    System.out.println(m.getName() + " attacks!");
                    m.attack(hero);
                }
            }
            System.out.println(m.getName() + " has been defeated!");
            hero.gainExperience(m.getRewardXP());
            addScore(m.getRewardXP());
        }
    }

    public void addScore(int points) {
        score += points;
        leaderboard.addScore(hero.getName(), score);
    }

    private void printGameOver(){
        System.out.println("+==========================================+");
        System.out.println("|              GAME  OVER                  |");
        System.out.println("+==========================================+");
        System.out.println("|  Hero   : " + hero.getName());
        System.out.println("|  Score  : " + score);
        System.out.println("|  Rooms  : " + navigationHistory.size() + " explored");
        System.out.println("+==========================================+");
        System.out.println();
        leaderboard.printLeaderboard();
    }
}
