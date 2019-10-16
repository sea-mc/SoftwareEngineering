public class Speaker {

    private  String speakerName = "null", speakerPhoneNumber = "null";
    private  String[] Speaker = new String[2];


    Speaker(){
        this.speakerName = getSpeakerName();
        this.speakerPhoneNumber = getSpeakerPhoneNumber();
    }

    public Speaker addSpeaker(){
        if(setSpeakerName(speakerName) == -1 || setSpeakerPhoneNumber(speakerPhoneNumber) == -1){
            System.out.println("ERR: Couldn't create speaker object");
            System.exit(-1);
        }
        Speaker mySpeaker = new Speaker();
        System.out.println("Successfully created speaker object!");
        return mySpeaker;
    }

    //inputtedName comes from the GUI
    public int setSpeakerName(String inputtedName) {

        // check to ensure name only contains letter characters and spaces
        char[] nameChars = inputtedName.toCharArray();

        for (char c : nameChars) {

            if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && c != ' ' && c != '-') return -1;

        }

        speakerName = inputtedName;

        return 0;

    }

    public  int setSpeakerPhoneNumber(String inputtedPhoneNumber) {

        char[] numberChars = inputtedPhoneNumber.toCharArray();

        for (char c : numberChars) {

            if (!(c >= '0' && c <= '9')) return -1; // display an error message

        }

        speakerPhoneNumber = inputtedPhoneNumber;

        return 0;

    }

    public  String getSpeakerName() {
        return speakerName;
    }

    public  String getSpeakerPhoneNumber() {
        return speakerPhoneNumber;
    }

}
