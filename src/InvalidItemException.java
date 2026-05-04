public class InvalidItemException extends Exception {
    public InvalidItemException(String itemName, String expectedType){
        super("Cannot use " + itemName + " here -- Expected a " + expectedType + ".");
    }
}
