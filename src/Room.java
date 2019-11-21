import java.util.*;

public class Room extends DB_Object implements IFront{

    Back back = new Back();
    public String roomName, capacity;
	ArrayList<DB_Object> roomList = new ArrayList<>();

	public Room(String roomName, String capacity){
		if(checkPositive(capacity) != 0 || checkCapacity(capacity) != 0){
			System.out.println("ERR: Couldn't create room object");
			System.exit(-1);
		}
		Room temp = back.getRoom();
		temp.roomName = roomName;
		temp.capacity = capacity;
		System.out.println("Adding Room to the list.");
		addToList(temp);
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

	@Override
	public void addToList(DB_Object object) {
		roomList.add(object);
		System.out.println("Calling backend.");
		back.pushDB_Object(roomList);
	}

	@Override
	public void ensureUID() {

	}
}