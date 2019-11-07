import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class backTester {
    private Back back;
    private Room room;
    private Speaker speaker;
    private Session session;
    private Timeslot timeslot;

    @Before
    public void setUp(){
        back = new Back();
        room = mock(Room.class);
        speaker = mock(Speaker.class);
        session = mock(Session.class);
        timeslot = mock(Timeslot.class);
    }

    @Test
    public void test(){

    }
}
