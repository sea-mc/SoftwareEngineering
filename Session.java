public class Session {

    private String sessionName;


    Session(String sessionName){
        Back back = new Back();
        Session temp = back.getSession();
        temp.sessionName = sessionName;
    }
}
