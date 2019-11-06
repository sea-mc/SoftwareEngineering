public class Back {
    Room room;
    Speaker speaker;
    Timeslot timeBlk;
    Session session;

    /** Creates new, blank backEnd.Room object
     *
     * @return backEnd.Room object
     */
    public static Room getRoom(){
        return new Room("", "");
    }

    /** Creates new, blank backEnd.Speaker object
     *
     * @return backEnd.Speaker object
     */
    public static Speaker getSpeaker(){
        return new Speaker("", "", "", "");
    }

    /** Creates new, blank backEnd.Session object
     *
     * @return backEnd.Session object
     */
    public static Session getSession(){
        return new Session("");
    }

    /** Creates new, blank backEnd.Timeslot object
     *
     * @return backEnd.Timeslot object
     */
    public static Timeslot getTimeslot(){
        return new Timeslot(0, 0);
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
