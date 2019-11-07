import java.util.ArrayList;

public class Session {

    private String sessionName;
    ArrayList<Session> sessionList = new ArrayList<>();



    Session(String sessionName){
        Back back = new Back();
        Session temp = back.getSession();
        temp.sessionName = sessionName;
        sessionList.add(temp);
    }

    public void removeSession(int index){
        sessionList.remove(index);
        //need to now update speaker list, send to backend to be updated, and return the new speakerList once it returns
    }
}
