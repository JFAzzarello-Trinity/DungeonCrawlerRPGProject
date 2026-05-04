public class DeadHeroException extends RuntimeException {
    public DeadHeroException(String heroName){
        super(heroName + " has fallen. The dungeon claims another soul.");
    }
}
