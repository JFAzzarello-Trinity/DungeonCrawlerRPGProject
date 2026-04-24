public class Hero extends Character {
    private int level;
    private int experiencePoints;
    private String heroClass;

    public Hero(int experiencePoints, String heroClass, int level, String name, int health, int maxHealth, int attackPower, int defense) {
        super(name, health, maxHealth, attackPower, defense);
        this.experiencePoints = experiencePoints;
        this.heroClass = heroClass;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(level > 0 && level < 100){this.level = level;}
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

    public void gainExperience(int xp){
        if(xp >= 0){setExperiencePoints(xp + this.experiencePoints);}
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
           "+==============================================+";
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
}
