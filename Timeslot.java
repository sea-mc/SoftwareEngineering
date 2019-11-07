public class Timeslot{

    private int startTime, endTime;

    //TODO create default constructor, setters and getters, add UID
    Timeslot(int startTime, int endTime){
        if(validateTime(startTime,endTime) != 0){
            System.out.println("ERR: backEnd.Timeslot object could not be created.");
            System.exit(-1);
        }
        Back back = new Back();
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

}