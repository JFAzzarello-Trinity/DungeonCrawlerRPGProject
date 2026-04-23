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
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
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
}
