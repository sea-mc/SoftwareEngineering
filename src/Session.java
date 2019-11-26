public class Session extends DB_Object implements IFront{
    private String sessionName;
    private Timeslot timeslot;
    private Speaker speaker;
    private Room room;
    private int UID;

   public Session(){
        this.UID=-1;
        this.sessionName = null;
        this.timeslot=null;
        this.speaker=null;
        this.room=null;
    }


    public Session(int UID,String sessionName, Timeslot timeslot, Speaker speaker,Room room){
        Back back = new Back();
        Session temp = new Session(UID, sessionName, timeslot, speaker, room);
        IFront.addToList(temp);
    }

    @Override
    public void ensureUID() {
        //some code to ensure there is a UID attached, if not we set the UID
    }
}
