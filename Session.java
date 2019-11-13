import java.util.ArrayList;

public class Session extends DB_Object implements IFront{
    Back back = new Back();
    private String sessionName;
    ArrayList<DB_Object> sessionList = new ArrayList<>();



    Session(String sessionName){
        Back back = new Back();
        Session temp = back.getSession();
        temp.sessionName = sessionName;
        addToList(temp);
    }

    @Override
    public void ensureUID() {
        //some code to ensure there is a UID attached, if not we set the UID
    }

    @Override
    public void removeFromList(int index) {
        sessionList.remove(index);
        back.pushDB_Object(sessionList);
    }

    @Override
    public void addToList(DB_Object o) {
        sessionList.add(o);
        back.pushDB_Object(sessionList);
    }
}
