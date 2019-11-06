public class Room {

	private String roomName, capacity;

	//TODO create default constructor, setters and getters, add UID
	public Room(String roomName, String capacity){
		if(checkPositive(capacity) != 0 || checkCapacity(capacity) != 0){
			System.out.println("ERR: Couldn't create room object");
			System.exit(-1);
		}
		this.roomName = roomName;
		this.capacity = capacity;
	}

	private  int checkPositive(String capacityCheck) {
		int capacity = Integer.parseInt(capacityCheck);
		if(capacity > 0) {
			return 0;
		}
		return -1;
	}

	public  int checkCapacity(String capacityCheck) {
		if(capacityCheck.matches("[0-9]+")) {
			return 0;
		}
		return -1;
	}

}
