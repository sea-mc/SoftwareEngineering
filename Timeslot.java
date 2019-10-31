public class Timeslot {

    private int startTime, endTime;

    Timeslot(int startTime, int endTime){
        if(validateTime(startTime,endTime) != 0){
            System.out.println("ERR: Timeslot object could not be created.");
            System.exit(-1);
        }
        //todo: determine how am/pm will be input/validated (boolean? string?)
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private int validateTime(int start, int end){
        if(start > 1259 || start < 100 || start < 0 || end < 0){
            return -1;
        }
        return 0;
    }


}
