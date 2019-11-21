import java.util.ArrayList;

public class Speaker extends DB_Object implements IFront {


    private String speakerFName, speakerLName, speakerPhoneNumber, speakerEmail;
    ArrayList<DB_Object> speakerList = new ArrayList<>();


    Speaker(String speakerFName, String speakerLName, String speakerNumber, String speakerEmail){
        if(validateName(speakerFName,speakerLName) != 0 || validateNumber(speakerNumber) != 0 || validateEmail(speakerEmail) != 0){
            System.out.println("ERR: backEnd.Speaker object could not be created");
            System.exit(-1);
        }
//        Speaker temp = back.getSpeaker();
//        temp.speakerFName = speakerFName;
//        temp.speakerLName = speakerLName;
//        temp.speakerPhoneNumber = speakerNumber;
//        temp.speakerEmail = speakerEmail;
//        addToList(temp);
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

    @Override
    public void removeFromList(int index){
        speakerList.remove(index);
//        back.pushDB_Object(speakerList);
        //need to now update speaker list, send to backend to be updated, and return the new speakerList once it returns
    }

    @Override
    public void addToList(DB_Object object) {
        speakerList.add(object);
//        back.pushDB_Object(speakerList);
    }

    @Override
    public void ensureUID() {

    }

    @Override
    public String toString() {
        return null;
    }
}