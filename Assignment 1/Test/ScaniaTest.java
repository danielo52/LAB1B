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
        test.getParent().setCurrentSpeed(10);
        System.out.println(test.getParent().getCurrentSpeed());
        System.out.println(test.getBedAngle());
        test.move(); //if(move() works) then Y = 11. SHOULD NOT WORK: so y = 1 i.e. no movement
        assertTrue(test.getParent().getY() == 1);

    }

    @Test
    public void testMovingWithBedDown() {
        test.getParent().setCurrentSpeed(10);
        test.move();
        assertTrue(test.getParent().getY() == 10);
    }

    @Test
    public void testGasScania() {
        test.getParent().setCurrentSpeed(50);
        test.gas(1); //adds 1.8 to currentSpeed. 1.8 is the max amount for gas()
        assertTrue(test.getParent().getCurrentSpeed() == 51.8);
    }

    @Test
    public void testBrakeScania() {
    test.getParent().setCurrentSpeed(50);
    test.brake(1);
    assertTrue(test.getParent().getCurrentSpeed() == 48.2);
    }

    @Test
    public void testTurnRightScania() {
        test.getParent().setDir(2);
        test.turnRight();
        assertTrue(test.getParent().getDir() == 1);
    }

    @Test
    public void testTurnLeftScania() {
        test.getParent().setDir(1);
        test.turnLeft();
        assertTrue(test.getParent().getDir() == 2);
    }

    @Test
    public void testRaiseBed() {
        test.setBedAngle(10);
        test.raiseBed();
        assertTrue(test.getBedAngle() == 20);
    }

    @Test
    public void testLowerBed() {
        test.setBedAngle(20);
        test.lowerBed();
        assertTrue(test.getBedAngle() == 10);
    }








}
