public class Character {
    private String name;
    private int health;
    private int maxHealth;
    private int attackPower;
    private int defense;

    public Character(String name, int health, int maxHealth, int attackPower, int defense) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
