import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestCarTransport {

    private CarTransport test;
    private Volvo240 testV;
    private Saab95 testS;
    private Transportable testTran;
    @Before
    public void init() {
        test = new CarTransport();
        testV = new Volvo240();
        testS = new Saab95();
        testTran = new Volvo240();
    }

    @Test
    public void testThatCTLoadsCorrect() {
        test.loadCar(testS);
        test.loadCar(testV);
        assertTrue(test.getTransports().contains(testV));
    }

    @Test
    public void testThatCTUnLoadsLastCar() {
        test.loadCar(testS);
        test.loadCar(testV);
        test.unloadCar();
        assertFalse(test.getTransports().contains(testV));
    }

    @Test
    public void testThatMoveWorksForCT() {
        test.loadCar(testS);
        test.loadCar(testV);
        test.getParent().setCurrentSpeed(10);
        test.move();
        assertTrue(test.getParent().getY() == 10);
    }

    @Test
    public void testThatMoveWorksForCTAndAllTransports() {
        test.loadCar(testS);
        test.loadCar(testV);
        test.getParent().setCurrentSpeed(10);
        test.move();
        assertTrue(testS.getParent().getY() == 10);
    }

    @Test
    public void testCarTranSportGas() {
        test.getParent().setCurrentSpeed(10);
        test.gas(1);
        assertTrue(test.getParent().getCurrentSpeed() == 11.4);
    }

    @Test
    public void tesCarTransportBrake() {
        test.getParent().setCurrentSpeed(10);
        test.brake(1);
        assertTrue(test.getParent().getCurrentSpeed() == 8.6);
    }



    @Test
    public void testCTTurnRightIsCorrect() {
        test.turnRight();
        assertTrue(test.getParent().getDir() == 0);

    }

    @Test
    public void testCTTurnLeftIsCorrect() {
        test.turnLeft();
        assertTrue(test.getParent().getDir() == 2);

    }

    @Test
    public void testCTTurnLeftIsCorrectForTransports() {
        test.loadCar(testV);
        test.turnLeft();
        assertTrue(testV.getParent().getDir() == 2);
    }

    @Test
    public void testCTTurnRightIsCorrectForTransports() {
        test.loadCar(testV);
        test.turnRight();
        assertTrue(testV.getParent().getDir() == 0);
    }



}
