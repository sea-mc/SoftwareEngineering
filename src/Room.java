import java.util.*;

public class Room extends DB_Object implements IFront{

    static Back back = new Back();
    private String roomName, capacity;
    private int UID;
	static ArrayList<DB_Object> roomList = new ArrayList<>();

	//TODO create default constructor, setters and getters, add UID
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
		Room temp = back.getRoom();
		temp.UID=UID;
		temp.roomName = roomName;
		temp.capacity = capacity;
		addToList(temp);
	}

	public static ArrayList<DB_Object> getRoomList(){
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
    public void removeFromList(int index){
        roomList.remove(index);
        back.pushDB_Object(roomList);
        //need to now update speaker list, send to backend to be updated, and return the new speakerList once it returns
    }

	
	public static ArrayList<DB_Object> addToList(DB_Object object) {
		roomList.add(object);
		back.pushDB_Object(roomList);
		return roomList;
	}

	@Override
	public void ensureUID() {

	}
}
