import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class Back {
    String NAME = "root";
    String PASSWORD = "";
    String URL = "http://localhost/phpmyadmin/db_structure.php?db=codecamp";

    /** Creates new, blank backEnd.Room object
     *
     * @return backEnd.Room object
     */
    Room getRoom(){
        return new Room("", "");
    }

    /** Creates new, blank backEnd.Speaker object
     *
     * @return backEnd.Speaker object
     */
    Speaker getSpeaker(){
        return new Speaker("", "", "", "");
    }

    /** Creates new, blank backEnd.Session object
     *
     * @return backEnd.Session object
     */
    Session getSession(){
        return new Session("");
    }

    /** Creates new, blank backEnd.Timeslot object
     *
     * @return backEnd.Timeslot object
     */
    Timeslot getTimeslot(){
        return new Timeslot(0, 0);
    }

    /** pushes a list of DB objects to the database
     *
     * @param list list of objects to push
     */
    ArrayList<DB_Object> pushDB_Object(ArrayList<DB_Object> list){
        for(DB_Object o : list)
            pushDB_Object(o);
        return null;//TODO return DB Object arrayList instead of array
    }

    /** pushes a single DB object to the database
     *
     * @param o singular object to be pushed to the database
     */
    ArrayList<DB_Object> pushDB_Object(DB_Object o) {
        return null;
    }

    /** attempts to connect to the database using default values
     *
     * @throws ClassNotFoundException from connect2DB
     * @throws SQLException from connect2DB
     */
    void connect2DB() throws SQLException, ClassNotFoundException {
        connect2DB(URL, NAME, PASSWORD);
    }

    /** Attempts a connection to the DB using non standard URL, name, and pass
     *
     * @param u url at which the DB exists
     * @param user username to use to connect to the DB
     * @param pass password for access to the DB
     */
    void connect2DB(String u, String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

            Connection c = DriverManager.getConnection(u, user, pass);
        } catch (SQLException e) {
            String msg = e instanceof SQLException ? "COULD NOT CONNECT TO THE DATABASE" : "";
            System.out.println("FATAL ERROR! " + msg + " ");
        }
    }

    private UUID getLastUID(){
        return null;
    }
}
