import java.util.Scanner;

public class sessionLogic {
    private static String response = "";
    public static void setTopic(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the topic/title of the talk?:");
        String response = input.nextLine();
    }

    public static String getTopic(){
        return response;
    }

}
