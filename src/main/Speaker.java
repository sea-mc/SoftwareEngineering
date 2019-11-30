package main;

public class Speaker extends DB_Object implements IFront {
    private String speakerFName, speakerLName, speakerEmail;

    public Speaker() {
        super();
        this.speakerFName="Mike";
        this.speakerLName="Hunt";
        this.speakerEmail="HuntM@wit.edu";
    }

    public Speaker(int UID, String speakerFName, String speakerLName, String speakerEmail){
        super(UID);
        if(validateName(speakerFName,speakerLName) != 0 || validateEmail(speakerEmail) != 0){
            System.out.println("ERR: backEnd.main.Speaker object could not be created");
            System.exit(-1);
        }
        this.speakerLName = speakerFName;
        this.speakerLName = speakerLName;
        this.speakerEmail = speakerEmail;
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

    public String getFullName(String fname, String lname) {
		return fname+ " " +lname;
	}

    @Override
    public String toString() {
        return super.toString() + "First Name: " + speakerFName + "\nLast Name: " + speakerLName + "\nEmail: " + speakerEmail + "\n";
    }
}