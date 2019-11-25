import java.util.ArrayList;

public class Speaker extends DB_Object implements IFront {

   static Back back = new Back();
   static private String speakerFName, speakerLName, speakerEmail;
   static int UID
   static ArrayList<DB_Object> speakerList = new ArrayList<>();


    public Speaker(int UID, String speakerFName, String speakerLName, String speakerEmail){
        if(validateName(speakerFName,speakerLName) != 0 || validateEmail(speakerEmail) != 0){
            System.out.println("ERR: backEnd.Speaker object could not be created");
            System.exit(-1);
        }
        Speaker temp = back.getSpeaker();
        temp.UID=UID;
        temp.speakerFName = speakerFName;
        temp.speakerLName = speakerLName;
        temp.speakerEmail = speakerEmail;
        addToList(temp);
    }

    public Speaker() {
    	this.UID=-1;
    	this.speakerFName=null;
    	this.speakerLName=null;
    	this.speakerEmail=null;
		
	}

	public int validateName(String fname, String lname){
        String name = fname+lname;
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

    public int validateEmail(String speakerEmail){
        if(speakerEmail.matches("[^(.+)@(.+)$]+")){
            return 0;
        }
        return -1;
    }
    
    public static ArrayList<DB_Object> getSpeakerList() {
    	return speakerList;
    }
    
    public String getFullName() {
		// TODO Auto-generated method stub
		return this.speakerFName + " " + this.speakerLName;
	}

	public String getFirstName() {
		return speakerFName;
	}

	public void setFirstName(String firstName) {
		this.speakerFName = firstName;
	}

	public String getLastName() {
		return speakerLName;
	}

	public void setLastName(String lastName) {
		this.speakerLName = lastName;
	}

	public String getEmail() {
		return speakerEmail;
	}

	public void setEmail(String email) {
		this.speakerEmail = email;
	}
}


    @Override
    public void removeFromList(int index){
        speakerList.remove(index);
        back.pushDB_Object(speakerList);
        //need to now update speaker list, send to backend to be updated, and return the new speakerList once it returns
    }

    
    public static ArrayList<DB_Object> addToList(DB_Object object) {
        speakerList.add(object);
        back.pushDB_Object(speakerList);
        return speakerList;
    }

    @Override
    public void ensureUID() {

    }
}