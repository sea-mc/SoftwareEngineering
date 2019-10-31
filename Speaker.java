public class Speaker {
    private String speakerFName, speakerLName, speakerPhoneNumber, speakerEmail;

    Speaker(String speakerFName, String speakerLName, String speakerNumber, String speakerEmail){
        if(validateName(speakerFName,speakerLName) != 0 || validateNumber(speakerNumber) != 0 || validateEmail(speakerEmail) != 0){
            System.out.println("ERR: Speaker object could not be created");
            System.exit(-1);
        }
        this.speakerFName = speakerFName;
        this.speakerLName = speakerLName;
        this.speakerPhoneNumber = speakerNumber;
        this.speakerEmail = speakerEmail;
    }

    public int validateName(String fname, String lname){
        String name = fname+lname;
        char[] nameArr = name.toCharArray();

        for(char c : nameArr){
            if(!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && c != ' ' && c != '-'){
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




}
