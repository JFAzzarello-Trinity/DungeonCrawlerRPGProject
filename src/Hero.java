
public class Hero extends Character {
    private int level;
    private int experiencePoints;
    private String heroClass;
    private Inventory<Item> inventory;

    public Hero(int experiencePoints, String heroClass, int level, String name, int health, int maxHealth, int attackPower, int defense) {
        super(name, health, maxHealth, attackPower, defense);
        this.experiencePoints = experiencePoints;
        this.heroClass = heroClass;
        this.level = level;
        this.inventory = new Inventory<>();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level >= 1 && level <= 99) {
            this.level = level;
        } else {
            System.out.println("[WARNING] Level must be between 1 and 99. Value unchanged.");
        }
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        if(experiencePoints >= 0){this.experiencePoints = experiencePoints;}
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public void gainExperience(int xp) {
        if (xp >= 0) {
            setExperiencePoints(xp + this.experiencePoints);
        } else {
            System.out.println("[WARNING] XP cannot be negative. Value unchanged.");
        }
    }

    public Inventory<Item> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        String hpBar = "";
        for (int i = 0; i < 20; i++) {
            if (i < (getHealth() * 20 / getMaxHealth())) {
                hpBar += "█";
            } else {
                hpBar += "░";
            }
        }
        return """
            +==============================================+
            |  """ + getName() + " [" + heroClass + "] Level " + level + "\n" +
           "|----------------------------------------------|\n" +
           "| HP : " + hpBar + " " + getHealth() + "/" + getMaxHealth() + "\n" +
           "| ATK : " + getAttackPower() + "  DEF : " + getDefense() + "\n" +
           "| XP : " + experiencePoints + "\n" +
           "+==============================================+ \n" +
            "--- " + getName() + "'s Inventory (" + inventory.getSize() + " items) ---\n" +
            inventory.displaySorted();
    }

    @Override
    public void attack(Character target){
        int damage = 0;
        if(target.getDefense() >= getAttackPower()){
            damage = 1;
            target.setHealth(target.getHealth() - damage);
        }else{
            damage = getAttackPower() - target.getDefense();
            target.setHealth(target.getHealth() - damage);
        }
        System.out.println("The monster took " + damage + " damage!");
    }
    
    public void useItem(Item item, String expectedType) throws InvalidItemException, EmptyRoomException{
        if (!item.getItemType().equals(expectedType)) {
            throw new InvalidItemException(item.getName(), expectedType);
        }
        try {
            ((Interactable) item).interact(this);
        } catch (EmptyRoomException e) {
        }
    }
}
