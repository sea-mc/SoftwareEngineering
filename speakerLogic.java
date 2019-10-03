public class speakerLogic {

    private String speakerName = "null", speakerPhoneNumber = "null";

    public int setSpeakerName(String inputtedName) {

        // check to ensure name only contains letter characters and spaces
        char[] nameChars = inputtedName.toCharArray();

        for (char c : nameChars) {

            if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && c != ' ' && c != '-') return -1;

        }

        speakerName = inputtedName;

        return 0;

    }

    public int setSpeakerPhoneNumber(String inputtedPhoneNumber) {

        char[] numberChars = inputtedPhoneNumber.toCharArray();

        for (char c : numberChars) {

            if (!(c >= '0' && c <= '9')) return -1; // display an error message

        }

        speakerPhoneNumber = inputtedPhoneNumber;

        return 0;

    }

    public String getSpeakerName() {
        return speakerName;
    }

    public String getSpeakerPhoneNumber() {
        return speakerPhoneNumber;
    }

}
