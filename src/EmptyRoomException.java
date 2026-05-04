public class EmptyRoomException extends Exception {
    public EmptyRoomException(String roomName){
        super(roomName + " is silent... nothing stirs here.");
    }
}
