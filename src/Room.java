import java.util.*;

public class Room extends DB_Object implements IFront{

    private String roomName, capacity;
    private int UID;
    ArrayList<DB_Object> roomList = new ArrayList<>();

	public Room() {
		this.UID=-1;
		this.roomName=null;
		this.capacity=null;
	}

	public Room(int UID,String roomName, String capacity){
		if(checkPositive(capacity) != 0 || checkCapacity(capacity) != 0){
			System.out.println("ERR: Couldn't create room object");
			System.exit(-1);
		}
		Room temp = new Room(UID, roomName, capacity);
		IFront.addToList(temp);
	}

	public ArrayList<DB_Object> getRoomList(){
		return roomList;
	}
	
	private int checkPositive(String capacityCheck) {
		int capacity = Integer.parseInt(capacityCheck);
		if(capacity > 0) {
			return 0;
		}
		return -1;
	}

	public int checkCapacity(String capacityCheck) {
		if(capacityCheck.matches("[0-9]+")) {
			return 0;
		}
		return -1;
	}

	@Override
	public void ensureUID() {

	}
}
