public class Session extends DB_Object implements IFront{
    private String sessionName;
    private Timeslot timeslot;
    private Speaker speaker;
    private Room room;

   public Session(){
        super();
        this.sessionName = "Murder 101";
        this.timeslot = new Timeslot();
        this.speaker = new Speaker();
        this.room = new Room();
    }


    public Session(int UID,String sessionName, Timeslot timeslot, Speaker speaker,Room room){
        super(UID);
        this.sessionName = sessionName;
        this.timeslot = timeslot;
        this.speaker = speaker;
        this.room = room;
    }

    @Override
    public String toString() {
        return super.toString() + "Session Name: " + sessionName + "\nTimeslot: " + timeslot.toString() + "\nSpeaker: " + speaker.toString() + "\nRoom: " + room.toString() + "\n";
    }
}
