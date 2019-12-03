import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Back {
    private final String NAME = "admin";
    private final String PASS = "password";
    private final String URL = "jdbc:mysql://localhost/codecamp";
    private Gson g;
    private Connection con;

    Back(){
        connect2DB();
        g = new Gson();
    }

    /** pushes a list of DB objects to the database
     *
     * @param list list of objects to push
     */
    ArrayList<DB_Object> pushDB_Object(ArrayList<DB_Object> list){
        for(DB_Object o : list)
            pushDB_Object(o);
        return pullTable(list.get(0));
    }

    /** pushes a single DB object to the database, if object with same UID exists in the DB it is overwritten
     * @param o singular object to be pushed to the database
     */
    public ArrayList<DB_Object> pushDB_Object(DB_Object o) {
        if(o.UID>0){
            try {
                if(con.isClosed())
                    connect2DB();
                ResultSet rs = con.createStatement().executeQuery(allUUIDCmd(o));
                while(rs.next()){
                    if(o.UID==rs.getInt(1)){
                        con.createStatement().execute(updateCmd(o));
                        return pullTable(o);
                    }
                }
                con.createStatement().execute(pushCmd(o));
            } catch (SQLException e) {
                System.out.println("FATAL ERROR! >:|");
                e.printStackTrace();
            }
        }
        return pullTable(o);
    }

    /** attempts to connect to the database using default values
     *
     */
    private void connect2DB() {
        connect2DB(URL, NAME, PASS);
    }

    /** Attempts a connection to the DB using non standard URL, name, and pass
     *
     * @param u url at which the DB exists
     * @param user username to use to connect to the DB
     * @param pass password for access to the DB
     */
    private void connect2DB(String u, String user, String pass) {
        try {
            con = DriverManager.getConnection(u, user, pass);
        } catch (SQLException e) {
            System.out.println("FATAL ERROR! COULD NOT CONNECT TO THE DATABASE\n"+e.getMessage());
        }
    }

    /**
     * Pulls everything from the DB and stores it into an Array List directly
     * @param o Object used to specify which table
     * @return ArrayList of DB_Objects containing all Objects in DB in Table o
     */
    private ArrayList<DB_Object> pullTable(DB_Object o){
        ResultSet rs;
        ArrayList<DB_Object> res = new ArrayList<>();
        try {
            if(con.isClosed())
                connect2DB();
            rs = con.createStatement().executeQuery(pullTableCmd(o));
            while(rs.next())
                res.add(g.fromJson(rs.getString(1),o.getClass()));
            con.close();
        } catch (SQLException e) {
            System.out.println("FATAL ERROR! >:|");
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Deletes a main.DB_Object with same UID as o, if UID is < 0, it WILL delete all entries from the table
     * @param o Object used to identify UID
     * @return Resultant list from the DB
     */
    public ArrayList<DB_Object> delDB_Object(DB_Object o){
        try {
            if (con.isClosed())
                connect2DB();
            if(o.UID<0)
                con.createStatement().execute(delAllCmd(o));
            else
                con.createStatement().execute(delCmd(o));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pullTable(o);
    }

    /**
     *  calculates the highest UID in use
     * @param o object that indicates which table to look at
     * @return highest UID in use
     */
    public int nextUID(DB_Object o){
        int max = 1;
        try {
            if(con.isClosed())
                connect2DB();
            ResultSet rs = con.createStatement().executeQuery(maxUUIDCmd(o));
            rs.next();
            max = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return max;
    }

    /**
     * generates and formats a simple SQL command for pulling a single object of type o from table o
     * @param o Object used to specify Type / UID
     * @return String representation of SQL command
     */
    private static String pullCmd(DB_Object o){
        return String.format("SELECT * FROM %s WHERE UUID = %d", o.getClass().getName(), o.UID);
    }

    /**
     * generates and formats a simple SQL command for pulling a table o
     * @param o Object used to specify Type / UID
     * @return String representation of SQL command
     */
    private static String pullTableCmd(DB_Object o){
        return String.format("SELECT * FROM %s", o.getClass().getName());
    }

    /**
     * generates and formats a simple SQL command for pushing a single object of type o to table o
     * @param o Object used to specify Type / UID
     * @return String representation of SQL command
     */
    private static String pushCmd(DB_Object o){
        return String.format("INSERT INTO %s VALUES ('%s', %d);", o.getClass().getName(), g.toJson(o), o.UID);
    }

    /**
     * generates and formats a simple SQL command for updating a single object of type o to table o
     * @param o Object used to specify Type / UID
     * @return String representation of SQL command
     */
    private static String updateCmd(DB_Object o){
        return String.format("UPDATE %s SET Object = '%s', UUID = %d WHERE UUID = %d", o.getClass().getName(), g.toJson(o), o.UID, o.UID);
    }

    /**
     * generates and formats a simple SQL command for deleting a single object of type o from table o
     * @param o Object used to specify Type / UID
     * @return String representation of SQL command
     */
    private static String delCmd(DB_Object o){
        return String.format("DELETE FROM %s WHERE UUID = %d", o.getClass().getName(), o.UID);
    }

    /**
     * generates and formats a simple SQL command for deleting all objects of type o from table o
     * @param o Object used to specify Type / UID / table
     * @return String representation of SQL command
     */
    private static String delAllCmd(DB_Object o){
        return String.format("DELETE FROM %s", o.getClass().getName());
    }

    /**
     * generates and formats a simple SQL command for pulling a full list of UIDs as these are faster to compare
     * @param o Object used to specify table
     * @return String representation of SQL command
     */
    private static String allUUIDCmd(DB_Object o){
        return String.format("SELECT UUID FROM %s", o.getClass().getName());
    }

    /**
     * generates and formats a simple SQL command for pulling the largest UID found in table o
     * @param o Object used to specify Type / UID / Table
     * @return String representation of SQL command
     */
    private static String maxUUIDCmd(DB_Object o){
        return String.format("SELECT MAX(UUID) FROM %s", o.getClass().getName());
    }
}
