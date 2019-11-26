import java.util.ArrayList;

public class Timeslot extends DB_Object implements IFront {

    private int startTime, endTime, startTimeHour, startTimeMin, endTimeHour, endTimeMin, UID;
    ArrayList<DB_Object> timeslotList = new ArrayList<>();

    public Timeslot() {
        int UID=-1;
        startTimeHour = 00;
        startTimeMin = 00;
        String tempStart = startTimeHour + ""+ startTimeMin;
        startTime = Integer.parseInt(tempStart);
        int endTimeHour = 00;
        int endTimeMin = 00;
        String tempBack = endTimeHour + "" + endTimeMin;
        endTime = Integer.parseInt(tempBack);

        Timeslot temp = new Timeslot();
        temp.startTime = startTime;
        temp.endTime = endTime;
    }

    public Timeslot(int UID,int startTimeHour, int startTimeMin, int endTimeHour, int endTimeMin){
        if(validateTime(startTimeHour,endTimeHour,startTimeMin,endTimeMin) != 0){
            System.out.println("ERR: backEnd.Timeslot object could not be created.");
            System.exit(-1);
        }
        String tempBack = endTimeHour + "" + endTimeMin;
        endTime = Integer.parseInt(tempBack);
        Timeslot temp = new Timeslot(UID, startTimeHour, startTimeMin, endTimeHour, endTimeMin);
        IFront.addToList(temp);
    }

	private int validateTime(int startHour, int endHour, int startMin, int endMin){
        if(startTimeHour < 10 && startTimeHour > 0) {
            String tempStartTimeHour = "0" + startTimeHour;
            startTimeHour = Integer.parseInt(tempStartTimeHour);
        }

        String tempStart = startTimeHour + ""+ startTimeMin;
        startTime = Integer.parseInt(tempStart);

        if(endTimeHour < 10 && endTimeHour > 0) {
            String tempEndTimeHour = "0" + endTimeHour;
            endTimeHour = Integer.parseInt(tempEndTimeHour);
        }
        if(startHour > 23 || startHour < 0 || startMin > 59  || startMin < 0 || endHour > 23 || endHour < 0 || endMin > 59 || endMin < 0){
            return -1;
        }
        return 0;
    }

    @Override
    public void ensureUID() {

    }

	public ArrayList<DB_Object> getTimeSlotList() {
		return timeslotList;
	}
}