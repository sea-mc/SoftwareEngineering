import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class Back {
    String NAME = "root";
    String PASSWORD = "";
    String URL = "http://localhost/phpmyadmin/db_structure.php?db=codecamp";

    // cmds
    private String pullRoom = "SELECT * FROM Room";
    private String delRoom = "DELETE * FROM ROOM WHERE RoomID = [ID]";
    private String pushRoom = "INSERT INTO ROOM (json)";
    private String updateRoom = "UPDATE Room SET Room_JSON ([new_json]) WHERE RoomID = [ID]";
    private String pullSpeaeker = "SELECT * FROM Speaker";
    private String delSpeaker = "DELETE * FROM SPEAKER WHERE SpeakerID = [ID]";
    private String pushSpeaker = "INSERT INTO SPEAKER (json)";
    private String updateSpeaker = "UPDATE Speaker SET Speaker_JSON ([new_json]) WHERE SpeakerID = [ID]";
    private String E = "SELECT * FROM userResponse";
    private String R = "DELETE * FROM USERRESPONSE WHERE userResponseID = [ID]";
    private String O = "INSERT INTO USERRESPONSE (json)";
    private String r = "UPDATE userResponse SET userResponse_JSON ([new_json]) WHERE userResponseID = [ID]";

    public Back(){
        try {
            connect2DB();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
            Connection c = DriverManager.getConnection(u, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            String msg = e instanceof SQLException ? "COULD NOT CONNECT TO THE DATABASE" : "Class.forName failed";
            System.out.println("FATAL ERROR! " + msg + " ");
        }
    }

    private UUID getLastUID(){
        return null;
    }
}
