import java.util.Scanner;

public class roomLogic {

	public static String[] array = new String[2];
	public static void main(String args[]) {
		System.out.println("Enter a room");
		Scanner reader = new Scanner(System.in);
		String room = reader.nextLine();
		System.out.println("Enter the capacity");
		String capacity = reader.nextLine();
		add(room, capacity);
		for(int i = 0; i < 2; i++) {
			System.out.println(array[i]);
		}
		
	}
	
	public static void add(String roomEntry, String capacityEntry) {
		if(checkCapacity(capacityEntry) == 1 & checkPositive(capacityEntry) > 0) {
			array[0] = capacityEntry;
			array[1] = roomEntry;
			System.out.println("Room Entered");
			
		} else if(checkPositive(capacityEntry) == 0){
			System.out.println("Enter a positive capacity");
			
		} else {
			System.out.println("Enter the capacity in number form");
		}
	}
	
	private static int checkPositive(String capacityCheck) {
		int capacity = Integer.parseInt(capacityCheck);
		if(capacity > 0) {
			return 1;
		}
		return 0;
	}

	public static int checkCapacity(String capacityCheck) {
		if(capacityCheck.matches("[0-9]+")) {
			return 1;
		}
		return 0;
	}

}
