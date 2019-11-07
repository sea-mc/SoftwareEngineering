import java.lang.reflect.Array;
import java.util.ArrayList;

public class Timeslot{

    Back back = new Back();
    private int startTime, endTime;
    ArrayList<Timeslot> timeslotList = new ArrayList<>();

    //TODO create default constructor, setters and getters, add UID
    Timeslot(int startTime, int endTime){
        if(validateTime(startTime,endTime) != 0){
            System.out.println("ERR: backEnd.Timeslot object could not be created.");
            System.exit(-1);
        }
        Timeslot temp = back.getTimeslot();
        temp.startTime = startTime;
        temp.endTime = endTime;
        timeslotList.add(temp);
    }

    private int validateTime(int start, int end){
        if(start > 1259 || start < 100 || start < 0 || end < 0){
            return -1;
        }
        return 0;
    }

    public void removeTimeslot(int index){
        timeslotList.remove(index);
        updateTimeslotList(timeslotList);
        //need to now return the new speakerList once it returns from backend
    }

    public void updateTimeslotList(ArrayList<Timeslot> timeslots){
        back.updateTimeslotList(timeslots);
    }

}