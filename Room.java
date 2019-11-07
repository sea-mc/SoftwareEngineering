import java.util.*;

public class Room {

    Back back = new Back();
    private String roomName, capacity;
	ArrayList<Room> roomList = new ArrayList<>();

	//TODO create default constructor, setters and getters, add UID
	public Room(String roomName, String capacity){
		if(checkPositive(capacity) != 0 || checkCapacity(capacity) != 0){
			System.out.println("ERR: Couldn't create room object");
			System.exit(-1);
		}
		Room temp = back.getRoom();
		temp.roomName = roomName;
		temp.capacity = capacity;
		roomList.add(temp);
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

    public void removeRoom(int index){
        roomList.remove(index);
        //need to now update speaker list, send to backend to be updated, and return the new speakerList once it returns
    }

}
