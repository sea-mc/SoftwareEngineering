public class Session extends DB_Object{
    public String sessionName;

    Session(String sessionName){
        this.sessionName = sessionName;
    }

    @Override
    public void ensureUID() {
        //some code to ensure there is a UID attached, if not we set the UID
    }
}