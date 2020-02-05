import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static junit.framework.TestCase.assertTrue;

public class SaabTestMove {

    private Saab95 test;
    @Before
    public void init() {
        test = new Saab95();
        test.setCurrentSpeed(50);

    }

    /*
    Testning av incremenet/decrement speed först.
    Sedan testning av move().
     */
    @Test
    public void testGetEnginePower() {
        assertTrue(test.getEnginePower() == 125);
    }

    @Test
    public void testIncrementSpeedEnginePower() {
        test.incrementSpeed(1);
        assertTrue(test.getCurrentSpeed() <= 125);
    }

    @Test
    public void testDecrementSpeedActuallyDecrementing() {
        double testSpeed = test.getCurrentSpeed();
        test.decrementSpeed(5);
        assertTrue(test.getCurrentSpeed() < testSpeed);
    }

    @Test
    public void testMoveForDir0X() {
        test.setDir(0);
        test.setCurrentSpeed(50);
        test.move();
        assertTrue(test.getX() == 50);
    }

    @Test
    public void testMoveForDir0Y() {
        test.setDir(0);
        test.setCurrentSpeed(50);
        test.move();
        assertTrue(test.getY() == 1);
    }

    @Test
    public void testMoveForDir1X() {
        test.setDir(1);
        test.setCurrentSpeed(50);
        test.move();
        assertTrue(test.getX() == 1);
    }

    @Test
    public void testMoveForDir1Y() {
        test.setDir(1);
        test.setCurrentSpeed(50);
        test.move();
        assertTrue(test.getY() == 50);
    }

    @Test
    public void testMoveForDir2X() {
        test.setDir(2);
        test.setCurrentSpeed(30);
        test.move();
        assertTrue(test.getX() == -30);
    }

    @Test
    public void testMoveForDir2Y() {
        test.setDir(2);
        test.setCurrentSpeed(30);
        test.move();
        assertTrue(test.getY() == 1);
    }
    /*
    Gör klart de sista testerna
     */


    //Testning move efter flera turns. Init = initial dir. L = turnLeft. R = turnRight.
    @Test
    public void testMoveAfterSeveralTurnsInit1LLL() {
        test.setCurrentSpeed(30);
        test.setDir(1);
        test.turnLeft();
        test.turnLeft();
        test.turnLeft();
        test.move();
        assertTrue(test.getX() == 30 && test.getY() == 1); //init test. båda true så behöver ej testa igen
    }

    @Test
    public void testMoveSeveralTurnsInit1LRRRAndCheckXY() {
        test.setCurrentSpeed(40);
        test.setDir(1);
        test.turnLeft();
        test.turnRight();
        test.turnRight();
        test.turnRight();
        test.move();
        assertTrue(test.getX() == 1 && test.getY() == -40);
    }

    @Test
    public void testTurnRLLMoveThenTurnLRR() {
        test.setDir(1);
        test.setCurrentSpeed(30);
        test.turnLeft();
        test.move();
        test.turnRight();
        test.move();
        assertTrue(test.getX() == -30 && test.getY() == 30);
    }

    @Test
    public void testTurnsAndMove() {
        test.setDir(1);
        test.setCurrentSpeed(10);
        test.turnLeft();
        test.move(); //y = 1, x = -10
        test.turnLeft();
        test.move(); //y = -10, x = 10
        assertTrue(test.getX() == -10 && test.getY() == -10);
    }
    @Test
    public void testGasNotDecrementing() {
        test.setCurrentSpeed(20);
        double testSpeed = test.getCurrentSpeed();
        test.gas(0);
        assertTrue(test.getCurrentSpeed() >= testSpeed);

    }

    @Test
    public void testGasNotAcceptingHigherValues() {
        test.setCurrentSpeed(20);
        test.gas(12);
        assertTrue(test.getCurrentSpeed() == 20);
    }

    @Test
    public void testGasNotAcceptingLowerValues() {
        test.setCurrentSpeed(20);
        test.gas(-10);
        assertTrue(test.getCurrentSpeed() == 20);
    }

}
