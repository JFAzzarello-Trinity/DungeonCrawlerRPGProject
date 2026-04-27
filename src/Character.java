public abstract class Character {
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
        if(health < 0){
            this.health = 0;
            System.out.println("[WARNING] Health cannot be negative. Value unchanged.");
        }
        else if(health > this.getMaxHealth()){
            this.health = maxHealth;
        }
        else{
            this.health = health;
        }
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
        if(attackPower >= 0){
            this.attackPower = attackPower;
            System.out.println("[WARNING] Attack power must be greater than 0. Value unchanged.");
        }
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        if(defense >= 0){this.defense = defense;}
    }

    public abstract String toString();

    public abstract void attack(Character target);
}
