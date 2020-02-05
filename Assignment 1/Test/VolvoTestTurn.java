import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static junit.framework.TestCase.assertTrue;


public class VolvoTestTurn {
    /**
     * The turn methods are inherited directly from Car so we decided to test it solely through a Volvo object.
     */
    private Volvo240 test;
    @Before
    public void init() {
        test = new Volvo240();
    }

    /*
    Följande tester kollar så att  initial direction är 1. Samt att turnRight-metoden fungerar som det är tänkt.
     */
    @Test
    public void testInitDirectionIs1() {
        assertTrue(test.getDir() == 1);
    }

    @Test
    public void testDirection1TurnRightIs0() {
        test.turnRight();
        assertTrue(test.getDir() == 0);
    }

    @Test
    public void testDirection2TurnRightIs1() {
        test.setDir(2);
        test.turnRight();
        assertTrue(test.getDir() == 1);
    }

    @Test
    public void testDirection3turnRightIs2() {
        test.setDir(3);
        test.turnRight();
        assertTrue(test.getDir() == 2);
    }

    @Test
    public void testDirection0turnRightIs3() {
        test.setDir(0);
        test.turnRight();
        assertTrue(test.getDir() == 3);
    }


    /*
    The following test asserts that the turnLeft method acts accordingly.
     */
    @Test
    public void testDirection0turnLeftIs1() {
        test.setDir(0);
        test.turnLeft();
        assertTrue(test.getDir() == 1);
    }

    @Test
    public void testDirection1turnLeftIs2() {
        test.setDir(1);
        test.turnLeft();
        assertTrue(test.getDir() == 2);
    }

    @Test
    public void testDirection2turnLeftIs3() {
        test.setDir(2);
        test.turnLeft();
        assertTrue(test.getDir() == 3);
    }

    @Test
    public void testDirection3turnLeftIs0() {
        test.setDir(3);
        test.turnLeft();
        assertTrue(test.getDir() == 0);
    }
    

    /*
     *Testing for the move method, to assert that it acts accordingly.
     * Testing for several turns. init = start-dir. L = left, R = right.
     */
     @Test
        public void testMoveForSeveralTurnsInit1LLR() {
            test.setDir(1);
            test.turnLeft();
            test.turnLeft();
            test.turnRight();
            assertTrue(test.getDir() == 2);
        }
     @Test
        public void testMoveForSeveralTurnsInit2LRR() {
         test.setDir(2);
         test.turnLeft();
         test.turnRight();
         test.turnRight();
         assertTrue(test.getDir() == 1);
     }
}
