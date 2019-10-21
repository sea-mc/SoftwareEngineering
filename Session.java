import java.util.Scanner;

public class Session {

    private String session = "";

    public void main(String[] args){
        //Stub will be information from the UI. TBD how we process. IDK how to stub if that isn't obvious.
        String stub = "";
        int[] timeSlot = new int[2];
        String[] speaker = new String[2];

        if(stub.equals("room")){
            //go to room, allow a room object to be created
            //validate input from the room object inside of Room.java
            Room room = new Room();
            room.addRoom(); //this is the best approach.
        }
        else if(stub.equals("timeslot")){
            Timeslot timeslot = new Timeslot();
            timeslot.addTimeSlot();
        }
        else if(stub.equals("speaker")){
            //same as the previous two for speaker
            Speaker mySpeaker = new Speaker();
            mySpeaker.addSpeaker();
        }
        else if(stub.equals("session")){
            //stay local, do the same as the previous
            setTopic();
            session = getTopic();
        }
        else{
            System.out.println("Error: Unable to create object of that kind.");
            System.exit(-1);
        }
        //Fill a large array in this method with the recorded information that can be sent to the Database.
    }


    private  String response="";
    public  void setTopic(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the topic/title of the talk?:");
        String sessionTopic = input.nextLine().toLowerCase();
    }

    public  String getTopic(){
        return response;
    }
}
