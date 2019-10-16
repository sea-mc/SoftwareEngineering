import java.util.Scanner;

public class Room {

	public  String[] room = new String[2];
	private  String roomName = "";
	private  String capacity = "";

	public Room(){
		this.roomName = getRoomName();
		this.capacity = getCapacity();
	}

	public  String getRoomName(){
		return roomName;
	}

	public void setRoomName(){
		System.out.println("Enter a room name: ");
		Scanner reader = new Scanner(System.in);
		String roomName = reader.nextLine();
		reader.close();
	}

	public  String getCapacity(){
		return capacity;
	}

	public void setCapacity(){
		System.out.println("Enter the capacity");
		Scanner read = new Scanner(System.in);
		String capacity = read.nextLine();
		read.close();
	}
	
	public Room addRoom() {
		setRoomName();
		setCapacity();
		if(checkCapacity(getCapacity()) == -1 || checkPositive(getCapacity()) == -1) {
			System.out.println("ERROR: Capacity must be positive, and a positive integer.");
			System.exit(-1);
		}
		Room room = new Room();
		room.capacity = capacity;
		room.roomName = roomName;
		System.out.println("Room Entered");
		return room;
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
