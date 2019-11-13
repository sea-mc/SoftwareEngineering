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

    /** pushes a list of DB objects to the database
     *
     * @param list list of objects to push
     */
    public void pushDB_Object(ArrayList<DB_Object> list){
        for(DB_Object o : list)
            pushDB_Object(o);
    }

    /** pushes a single DB object to the database
     *
     * @param o singular object to be pushed to the database
     */
    private void pushDB_Object(DB_Object o) {
        //some sql method
    }
}
