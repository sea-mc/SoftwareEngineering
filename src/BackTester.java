import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;

public class BackTester {
    private static Back bk;
    static ArrayList<DB_Object> roomz;

    public static void main(String[] args) throws SQLException {
        bk = new Back();
        roomz = bk.pushDB_Object(new Room());
        Room broken = new Room(bk.nextUID(new Room()), "Adams", "100");
        bk.delDB_Object(broken);
        testAdd();
    }

    public static void testAdd(){
        DB_Object bob = new Room(3, "bob", "300");
        DB_Object Jack = new Room(2, "Jack", "200");
        DB_Object Anne = new Room(1, "Anne", "100");

        roomz.add(bob);
        roomz.add(Anne);
        bk.pushDB_Object(Jack);
        System.out.println(bk.pushDB_Object(roomz));
    }

    public static void testRemove(){

    }
}
