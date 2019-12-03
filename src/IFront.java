import java.util.ArrayList;

public interface IFront {
    Back back = new Back();
    ArrayList<DB_Object> objectList = new ArrayList<>();

    static ArrayList<DB_Object> removeFromList(int index, ArrayList<DB_Object> list){
        list.remove(index);
        return list;
    }

    static ArrayList<DB_Object> addToList(DB_Object o){
        objectList.add(o);
        back.pushDB_Object(objectList);
        return objectList;
    }
}
