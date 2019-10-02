public class timeslotLogic {
    /* FOR TIMESLOT:
    *   Verify start and end time
    *       End must be after start
    *       data entered with dropdown menus
    *
    *
    *
    *
     */
    public static int[] times = new int[2];
    public static String[] amPm = new String[2];
    public static void main(String[] args){
        getStart();
        //get the am/pm response and validate it
        int startTime = getStart();
        int endTime = getEnd();

        createTimeslot(startTime,endTime);

        for(int i = 0; i < times.length; i++) {
            System.out.println(times[i]);
        }

    }

    public static void createTimeslot(int start, int end){
        if(validateTime(start, end) == 0){
            times[0]=start;
            times[1]=end;
        }
    }

    private static int getStart(){
        int startTime = 1130;
        return startTime;
    }

    private static int getEnd(){
        int end = 1030;
        return end;
    }

    private static int validateTime(int start, int end){
        if(start > 1259 || start < 100 || start < 0 || end < 0){
            return 1;
        }
        /*else if(startAmPm.equals(endAmPm)){
            if(start > end){
                return 1;
            }
        }
        else if(!startAmPm.equals(endAmPm)){
            if(!startAmPm.equals("am")){
                return 1;
            }
        }*/
        return 0;
    }


}
