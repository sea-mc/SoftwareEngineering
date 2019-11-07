import java.util.ArrayList;

public class Back implements IBack {
    Room room;
    Speaker speaker;
    Timeslot timeBlk;
    Session session;

    /** Creates new, blank backEnd.Room object
     *
     * @return backEnd.Room object
     */
    public Room getRoom(){
        return new Room("", "");
    }

    /** Creates new, blank backEnd.Speaker object
     *
     * @return backEnd.Speaker object
     */
    public Speaker getSpeaker(){
        return new Speaker("", "", "", "");
    }

    /** Creates new, blank backEnd.Session object
     *
     * @return backEnd.Session object
     */
    public Session getSession(){
        return new Session("");
    }

    /** Creates new, blank backEnd.Timeslot object
     *
     * @return backEnd.Timeslot object
     */
    public Timeslot getTimeslot(){
        return new Timeslot(0, 0);
    }

    //I will look into making these methods not needing to be repeated by using a more generic Object list, just putting these here for a placeholder.
    public void updateTimeslotList(ArrayList<Timeslot> timeslotList){
        for(int i=0; i <timeslotList.size(); i++){
            //pushDB_Object(timeSlotList.indexOf(i))
        }
    }

    public void updateSpeakerList(ArrayList<Timeslot> speakerList){
        for(int i=0; i <speakerList.size(); i++){
            //pushDB_Object(timeSlotList.indexOf(i))
        }
    }

//    /** checks if object has a UID, if not gives it one
//     *
//     * @param o Object
//     */
//    public static void ensureUID(I_DB_Object o){
//
//    }
//
//    /** pushes object to the DB
//     *
//     * @param o
//     */
//    public static void pushDB_Object(I_DB_Object o){
//        ensureUID(o);
//    }
}
