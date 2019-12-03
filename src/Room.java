public class Room extends DB_Object implements IFront {

    private String roomName, capacity;

	public Room() {
		super();
		this.roomName=null;
		this.capacity=null;
	}

	public Room(int UID,String roomName, String capacity){
	    super(UID);
		if(checkPositive(capacity) != 0 || checkCapacity(capacity) != 0){
			System.out.println("ERR: Couldn't create room object");
			System.exit(-1);
		}
		this.roomName = roomName;
		this.capacity = capacity;

	}
	
	private int checkPositive(String capacityCheck) {
		int capacity = Integer.parseInt(capacityCheck);
		if(capacity > 0) {
			return 0;
		}
		return -1;
	}

	private int checkCapacity(String capacityCheck) {
		if(capacityCheck.matches("[0-9]+")) {
			return 0;
		}
		return -1;
	}

    @Override
    public String toString() {
        return super.toString() + "main.Room Name: " + roomName + "\nCapacity: " + capacity + "\n";
    }
}
