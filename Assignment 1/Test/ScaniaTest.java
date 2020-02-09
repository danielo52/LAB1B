import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ScaniaTest {


    private Scania test;
    @Before
    public void init() {
        test = new Scania();
        /*
        test starts at X = 1, Y = 1 and DIR = 1
         */
    }

    @Test
    public void testBedAngleNotMoreThan70() {
        test.setBedAngle(71);
        assertTrue(test.getBedAngle() == 0);

    }

    @Test
    public void testBedAngleNotLessThan0() {
        test.setBedAngle(-4);
        assertTrue(test.getBedAngle() == 0);
    }

    @Test
    public void testThatNotMovingWhenBedIsUp() {
        test.setBedAngle(12);
        //test.setCurrentSpeed(10);
        System.out.println(test.getParent().getCurrentSpeed());
        System.out.println(test.getBedAngle());
        test.move(); //if(move() works) then Y = 11. SHOULD NOT WORK: so y = 1 i.e. no movement
        assertTrue(test.getParent().getY() == 1);

    }


}
