import java.util.ArrayList;

public class Speaker extends DB_Object implements IFront {

    Back back = new Back();
    private String speakerFName, speakerLName, speakerEmail;
    int UID;
    private ArrayList<DB_Object> speakerList = new ArrayList<>();

    public Speaker() {
        this.UID=-1;
        this.speakerFName=null;
        this.speakerLName=null;
        this.speakerEmail=null;
    }

    public Speaker(int UID, String speakerFName, String speakerLName, String speakerEmail){
        if(validateName(speakerFName,speakerLName) != 0 || validateEmail(speakerEmail) != 0){
            System.out.println("ERR: backEnd.Speaker object could not be created");
            System.exit(-1);
        }
        Speaker temp = new Speaker(UID, speakerFName, speakerFName, speakerEmail);
        IFront.addToList(temp);
    }

	public int validateName(String fname, String lname){
        String name = getFullName(fname, lname);
        char[] nameArr = name.toCharArray();

        for(char c : nameArr){
            if(!(name.matches("^[\\p{L} .'-]+$"))){
                return -1;
            }
        }
        speakerFName = fname;
        speakerLName = lname;
        return 0;
    }

    public int validateNumber(String number){
        if(number.matches("[0-9]+")) {
            return 0;
        }
        return -1;
    }

    private int validateEmail(String speakerEmail){
        if(speakerEmail.matches("[^(.+)@(.+)$]+")){
            return 0;
        }
        return -1;
    }
    
    private String getFullName(String fname, String lname) {
		return fname+ " " +lname;
	}

    public ArrayList<DB_Object> getSpeakerList() {
        return speakerList;
    }
}