import java.util.Scanner;

public class Session {

    private String session = "";
    private  String response="";

    public void main(String[] args) {
        //Stub will be information from the UI. TBD how we process. IDK how to stub if that isn't obvious.
        String stub = "";
        int[] timeSlot = new int[2];
        String[] speaker = new String[2];

    }

    public  void setTopic(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the topic/title of the talk?:");
        String sessionTopic = input.nextLine().toLowerCase();
    }

    public  String getTopic(){
        return response;
    }
}
