public class Monster extends Character {
    private int rewardXP;
    private String monsterType;
    public Monster(int rewardXP, String monsterType, String name, int health, int maxHealth, int attackPower, int defense) {
        super(name, health, maxHealth, attackPower, defense);
        this.rewardXP = rewardXP;
        this.monsterType = monsterType;
    }

    public int getRewardXP() {
        return rewardXP;
    }

    public void setRewardXP(int rewardXP) {
        this.rewardXP = rewardXP;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    @Override
    public String toString() {
        return """
            +-----------------------------+
            |  """ + getName() + " [" + monsterType + "]\n" +
           "| HP : " + getHealth() + "/" + getMaxHealth() + "\n" +
           "| ATK : " + getAttackPower() + "  DEF : " + getDefense() + "\n" +
           "| Reward XP : " + rewardXP + "\n" +
           "+-----------------------------+";
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
        System.out.println("The " + getMonsterType() + " whacks you on the head!");
    }
}
