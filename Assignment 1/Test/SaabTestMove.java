import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class SaabTestMove {

    private Saab95 test;
    @Before
    public void init() {
        test = new Saab95();
        test.getParent().setCurrentSpeed(50);

    }


    @Test
    public void testGetEnginePower() {
        assertTrue(test.getParent().getEnginePower() == 125);
    }

    @Test
    public void testIncrementSpeedEnginePower() {
        test.incrementSpeed(1);
        assertTrue(test.getParent().getCurrentSpeed() <= 125);
    }

    @Test
    public void testDecrementSpeedActuallyDecrementing() {
        double testSpeed = test.getParent().getCurrentSpeed();
        test.decrementSpeed(5);
        assertTrue(test.getParent().getCurrentSpeed() < testSpeed);
    }

    @Test
    public void testMoveForDir0X() {
        test.getParent().setDir(0);
        test.getParent().setCurrentSpeed(50);
        test.getParent().move();
        assertTrue(test.getParent().getX() == 50);
    }

    @Test
    public void testMoveForDir0Y() {
        test.getParent().setDir(0);
        test.getParent().setCurrentSpeed(50);
        test.getParent().move();
        assertTrue(test.getParent().getY() == 1);
    }

    @Test
    public void testMoveForDir1X() {
        test.getParent().setDir(1);
        test.getParent().setCurrentSpeed(50);
        test.getParent().move();
        assertTrue(test.getParent().getX() == 1);
    }

    @Test
    public void testMoveForDir1Y() {
        test.getParent().setDir(1);
        test.getParent().setCurrentSpeed(50);
        test.getParent().move();
        assertTrue(test.getParent().getY() == 50);
    }

    @Test
    public void testMoveForDir2X() {
        test.getParent().setDir(2);
        test.getParent().setCurrentSpeed(30);
        test.getParent().move();
        assertTrue(test.getParent().getX() == -30);
    }

    @Test
    public void testMoveForDir2Y() {
        test.getParent().setDir(2);
        test.getParent().setCurrentSpeed(30);
        test.getParent().move();
        assertTrue(test.getParent().getY() == 1);
    }



    //Testning move efter flera turns. Init = initial dir. L = turnLeft. R = turnRight.
    @Test
    public void testMoveAfterSeveralTurnsInit1LLL() {
        test.getParent().setCurrentSpeed(30);
        test.getParent().setDir(1);
        test.getParent().turnLeft();
        test.getParent().turnLeft();
        test.getParent().turnLeft();
        test.getParent().move();
        assertTrue(test.getParent().getX() == 30 && test.getParent().getY() == 1); //init test. båda true så behöver ej testa igen
    }

    @Test
    public void testMoveSeveralTurnsInit1LRRRAndCheckXY() {
        test.getParent().setCurrentSpeed(40);
        test.getParent().setDir(1);
        test.getParent().turnLeft();
        test.getParent().turnRight();
        test.getParent().turnRight();
        test.getParent().turnRight();
        test.getParent().move();
        assertTrue(test.getParent().getX() == 1 && test.getParent().getY() == -40);
    }

    @Test
    public void testTurnRLLMoveThenTurnLRR() {
        test.getParent().setDir(1);
        test.getParent().setCurrentSpeed(30);
        test.getParent().turnLeft();
        test.getParent().move();
        test.getParent().turnRight();
        test.getParent().move();
        assertTrue(test.getParent().getX() == -30 && test.getParent().getY() == 30);
    }

    @Test
    public void testTurnsAndMove() {
        test.getParent().setDir(1);
        test.getParent().setCurrentSpeed(10);
        test.getParent().turnLeft();
        test.getParent().move(); //y = 1, x = -10
        test.getParent().turnLeft();
        test.getParent().move(); //y = -10, x = 10
        assertTrue(test.getParent().getX() == -10 && test.getParent().getY() == -10);
    }
    @Test
    public void testGasNotDecrementing() {
        test.getParent().setCurrentSpeed(20);
        double testSpeed = test.getParent().getCurrentSpeed();
        test.gas(0);
        assertTrue(test.getParent().getCurrentSpeed() >= testSpeed);

    }

    @Test
    public void testGasNotAcceptingHigherValues() {
        test.getParent().setCurrentSpeed(20);
        test.gas(12);
        assertTrue(test.getParent().getCurrentSpeed() == 20);
    }

    @Test
    public void testGasNotAcceptingLowerValues() {
        test.getParent().setCurrentSpeed(20);
        test.gas(-10);
        assertTrue(test.getParent().getCurrentSpeed() == 20);
    }




}
