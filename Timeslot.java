public class Timeslot {

    public  int[] times = new int[2];
    //Need to see how to set amPm based on the website.
    public boolean[] amPm = new boolean[2];

    Timeslot(){
        this.times = createTimeslot(getStartTime(),getEndTime());
    }

    public Timeslot addTimeSlot(){
        if(validateTime(times[0],times[1]) == -1){
            System.out.println("ERROR: Couldn't create time-slot object.");
            System.exit(-1);
        }
        Timeslot timeslot = new Timeslot();
        return timeslot;
    }

    public  int[] createTimeslot(int start, int end){
        if(validateTime(start, end) < 0){
            System.out.println("Error occurred while creating a time slot.");
            System.exit(-1);
        }
        times[0]=start;
        times[1]=end;
        return times;
    }

    public  int getStartTime(){
        //how do we get this information from the DB/UI in the future.
        int startTime = 1130;
        return startTime;
    }

    public  int getEndTime(){
        //See getStartTime() comment
        int end = 1030;
        return end;
    }

    private int validateTime(int start, int end){
        if(start > 1259 || start < 100 || start < 0 || end < 0){
            return -1;
        }
        return 0;
    }


}
