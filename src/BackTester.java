import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;

public class BackTester {
    private static Back bk;
    static ArrayList<DB_Object> roomz;

    public static void main(String[] args) throws SQLException {
        bk = new Back();
        roomz = bk.pushDB_Object(new Room());
        testAdd();
        System.out.println("\n\n\n\n\n");
        testPull();
        testRemove();
        System.out.println(bk.pushDB_Object(new Room()));
    }

    public static void testAdd(){

        DB_Object bob = new Room(3, "bob", "300");
        DB_Object Jack = new Room(2, "Jack", "200");
        DB_Object Anne = new Room(1, "Anne", "100");

        System.out.println(roomz);
    }

    public static void testRemove(){
        bk.delTable(new Room());
    }

    public static void testPull(){
        roomz = bk.pushDB_Object(new Room());


    }
}
