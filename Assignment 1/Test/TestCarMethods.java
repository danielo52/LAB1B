import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static junit.framework.TestCase.assertTrue;

public class TestCarMethods {

    private Volvo240 test;

    @Before
    public void init() {
        test = new Volvo240();
        test.setCurrentSpeed(30);
    }

    @Test
    public void testNrDoors() {
        assertTrue(test.getNrDoors() == 2);
    }

    @Test
    public void testGetEnginePower() {
        double enginePow = test.getEnginePower();
        assertTrue(enginePow == 100);
    }
    /*
    We decided to not furhter pursue the testing of these "simple" methods, since there's not much to test.
    Move, turnLeft and turnRight, gas, brake (incrementSpeed and decrementSpeed) are tested in the other test classes.
     */

}
