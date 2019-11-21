import org.mockito.Mockito;

import java.sql.SQLException;

public class BackTester extends Mockito {

    public static void main(String [] args) {
        Back ba = new Back();
        try {
            ba.connect2DB();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}