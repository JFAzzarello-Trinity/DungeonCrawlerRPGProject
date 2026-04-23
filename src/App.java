public class App {
    public static void main(String[] args) throws Exception {
        Hero hero = new Hero(15, "Warrior", 1, "Jorge", 85, 100, 20, 10);
        Monster monster = new Monster(10, "Goblin", "Greeb", 50, 50, 5, 10);
        Monster monster2 = new Monster(20, "Orc", "Grob", 80, 80, 15, 15);
        Item item = new Item("Spear", "Weapon", 100, "A sharp blade for far-ranged combat.");
        Item item2 = new Item("Health Potion", "Consumable", 50, "Restores 50 health points when consumed.");
        Item item3 = new Item("Helmet", "Armor", 150, "Provides extra defense against attacks.");
        Room room = new Room("Dining Hall", "A candle-lit room with a long dining table and several chairs. The walls are adorned with faded tapestries depicting ancient battles.");
        room.addMonster(monster);
        room.addMonster(monster2);
        room.addItem(item);
        room.addItem(item2);
        room.addItem(item3);
        System.out.println(hero);
        System.out.println(monster);
        System.out.println(monster2);
        System.out.println(item);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(room);
    }
}
