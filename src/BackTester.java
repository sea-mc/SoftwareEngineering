import java.util.ArrayList;

public class BackTester {
    private static Back bk;
    static ArrayList<DB_Object> roomz;

    public static void main(String[] args) throws InterruptedException {
        bk = new Back();
        Thread.sleep(10000);
        testAddRooms();
        Thread.sleep(15000);
        testRemoveRooms();
    }

    public static void testAddRooms(){
        System.out.println("\n\n\nPULLING DB");
        testPull();
        System.out.println(roomz);
        DB_Object Adams = new Room(1, "Adams","60");
        roomz.add(Adams);
        DB_Object shrek = new Room(2, "Shrek", "100");
        roomz.add(shrek);
        System.out.println("PUSHING ROOMS");
        System.out.println(bk.pushDB_Object(roomz));
    }

    public static void testRemoveRooms() {
        System.out.println("\n\n\nPULLING DB");
        testPull();
        System.out.println(roomz);
        System.out.println("\n\n\nREMOVING ROOMS");
        for (DB_Object r : roomz)
            System.out.println(bk.delDB_Object(r));
        System.out.println("\n\n\nPULLING DB");
        testPull();
        System.out.println(roomz);
    }

    public static void testPull(){
        roomz = bk.pushDB_Object(new Room());
    }
}
