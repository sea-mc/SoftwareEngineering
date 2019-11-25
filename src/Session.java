import java.util.ArrayList;

public class Session extends DB_Object implements IFront{
    Back back = new Back();
    private String sessionName;
    private Timeslot timeslot;
    private Speaker speaker;
    private Room room;
    private int UID;
    ArrayList<DB_Object> sessionList = new ArrayList<>();
    
   public Session(){
        this.UID=-1;
        this.sessionName = null;
        this.timeslot=null;
        this.speaker=null;
        this.room=null;
    }


    public Session(int UID,String sessionName, Timeslot timeslot, Speaker speaker,Room room){
        Back back = new Back();
        Session temp = back.getSession();
        temp.UID=UID;
        temp.sessionName = sessionName;
        temp.timeslot=timeslot;
        temp.speaker=speaker;
        temp.room=room;
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
    public ArrayList<DB_Object> addToList(DB_Object o) {
        sessionList.add(o);
        back.pushDB_Object(sessionList);
		return sessionList;
    }
}
