public class Weapon extends Item implements Interactable{
    
    public Weapon(String name, int value, String description) {
        super(name, "WEAPON", value, description);
    }

    @Override
    public void interact(Hero hero) {
        hero.setAttackPower(hero.getAttackPower() + getValue());
        System.out.println("⚔ " + hero.getName() + " equips " + getName() + "! ATK +" + getValue());
    }
    
}
