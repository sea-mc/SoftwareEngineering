import java.lang.reflect.Array;
import java.util.ArrayList;

public class Timeslot extends DB_Object implements IFront {

    static Back back = new Back();
    private int startTime, endTime, startTimeHour, startTimeMin, endTimeHour, endTimeMin, UID;
    static ArrayList<DB_Object> timeslotList = new ArrayList<>();

    //TODO create default constructor, setters and getters, add UID
   public Timeslot(int UID,int startTimeHour, int startTimeMin, int endTimeHour, int endTimeMin){
    	if(startTimeHour < 10 && startTimeHour > 0) {
    		String tempStartTimeHour = "0" + startTimeHour;
        	startTimeHour = Integer.parseInt(tempStartTimeHour);
    	}
    	if(endTimeHour < 10 && endTimeHour > 0) {
    		String tempEndTimeHour = "0" + endTimeHour;
        	endTimeHour = Integer.parseInt(tempEndTimeHour);
    	}
    	
    	String tempStart = startTimeHour + ""+ startTimeMin;
    	startTime = Integer.parseInt(tempStart);
    	
    	String tempBack = endTimeHour + "" + endTimeMin;
    	endTime = Integer.parseInt(tempBack);
        if(validateTime(startTime,endTime) != 0){
            System.out.println("ERR: backEnd.Timeslot object could not be created.");
            System.exit(-1);
        }
        Timeslot temp = back.getTimeslot();
        temp.UID=UID;
        temp.startTime = startTime;
        temp.endTime = endTime;
        addToList(temp);
    }

    public Timeslot() {
    	UID=-1;
		startTimeHour = 00;
		startTimeMin = 00;
		String tempStart = startTimeHour + ""+ startTimeMin;
    	startTime = Integer.parseInt(tempStart);
		endTimeHour = 00;
		endTimeMin = 00;
		String tempBack = endTimeHour + "" + endTimeMin;
    	endTime = Integer.parseInt(tempBack);
    	
    	Timeslot temp = back.getTimeslot();
    	temp.startTime = startTime;
    	temp.endTime = endTime;
	}

	private int validateTime(int start, int end){
        if(start > 1259 || start < 100 || start < 0 || end < 0){
            return -1;
        }
        return 0;
    }

    @Override
    public void removeFromList(int index){
        timeslotList.remove(index);
        back.pushDB_Object(timeslotList);
        //need to now return the new speakerList once it returns from backend
    }

    public static ArrayList<DB_Object> addToList(DB_Object o){
        timeslotList.add(o);
        back.pushDB_Object(timeslotList);
        return timeslotList; 
    }



    @Override
    public void ensureUID() {

    }

	public static ArrayList<DB_Object> getTimeSlotList() {
		return timeslotList;
	}
}