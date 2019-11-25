import java.lang.reflect.Array;
import java.util.ArrayList;

public class Timeslot extends DB_Object {

    Back back = new Back();
    public int startTime, endTime;
    ArrayList<DB_Object> timeslotList = new ArrayList<>();

    //TODO create default constructor, setters and getters, add UID
    Timeslot(int startTime, int endTime){
        if(validateTime(startTime,endTime) != 0){
            System.out.println("ERR: backEnd.Timeslot object could not be created.");
            System.exit(-1);
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private int validateTime(int start, int end){
        if(start > 1259 || start < 100 || start < 0 || end < 0){
            return -1;
        }
        return 0;
    }

    @Override
    public void ensureUID() {

    }
}