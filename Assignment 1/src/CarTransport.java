import com.sun.jdi.connect.Transport;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CarTransport implements ITransporters /*, ITruck*/ {
/*
We assumed that this is a "normal" 12/18-wheeler type of truck, that can transport cars and nothing bigger
(i.e. it CANNOT transport "Scania").
 */



    private Car parent;
    private boolean rampDown;
    private ArrayList<Transportable> transports;
    private int maxLoad;
    private int currentLoad;

    public CarTransport(Car parent, boolean rampDown, ArrayList<Transportable> transports, int maxLoad, int currentLoad) {
        this.parent = parent;
        this.rampDown = rampDown;
        this.transports = transports;
        this.maxLoad = maxLoad;
        this.currentLoad = currentLoad;
    }

    public CarTransport() {
        parent = new Car(2, 200, 0, Color.green, "CarTransporter 9000",
                1,1,1);
        setRampDownTrue();
        maxLoad = 8;
        transports = new ArrayList<Transportable>();
        currentLoad = 0;

    }

    public Car getParent() {
        return parent;
    }

    /**
     *
     * @return we can load if the ramp is DOWN.
     *          we can drive if the ramp is UP!
     */
    public boolean isRampDown() {
        return rampDown;
    }


    public boolean isIdle() {
        return (parent.getCurrentSpeed() == 0);
    }

    public void setRampDownTrue() {
        if(isIdle()) {
            rampDown = true;
        }
    }

    public void setRampDownFalse() {
        rampDown = false;
    }

    public boolean getRampState() {
        return rampDown;
    }

    public ArrayList<Transportable> getTransports() {
        return transports;
    }


    //     ********** LOAD AND UNLOAD **********

    /**
     *
     * @param carLoad takes a car to load. Checks that the car is close, ramp is down, there's room to load
     *                and that the CarTransport isn't moving.
     */
    public void loadCar(Transportable carLoad) {
        if(isInVicinity(carLoad) && isRampDown() && transports.size() < maxLoad && isIdle()) {
            transports.add(carLoad);
            currentLoad++;
        } else {
            System.out.println("Please consult with the driver for further instructions");
        }
    }

    /**
     * Assures that the CarTransport isn't moving, and that the ramp is down. (Loadable when rampDown == true);
     */
    public void unloadCar() {
        if(isRampDown() && isIdle()) {
            Transportable t = transports.get(currentLoad-1);
            transports.remove(currentLoad-1);
            currentLoad--;
            t.getParent().setY(parent.getY() + 1);
            t.getParent().setX(parent.getX() + 1);
        }
    }

    /*
    Move() för en CarTransport ska flytta som vanligt. Men dessutom sätta X/Y för varje element i carStacken till samma
    x/y som CarTransporten har.
     */

    /**
     * moves the CarTransports. And moves every element in transports (i.e. the cars on the ramp) to the same position.
     */
    public void moveCarTransport() {
        getParent().move();
        int xtemp = getParent().getX();
        int ytemp = getParent().getY();
        for(int i = 0; i <= transports.size()-1; i++) {
            transports.get(i).getParent().setX(xtemp);
            transports.get(i).getParent().setY(ytemp);
        }
    }

    /**
     * Enables us to turn the CarTransport AND it's currentLoad to the left
     */
    public void carTransportTurnLeft() {
        getParent().turnLeft();
        int tempdir = getParent().getDir();
        for(int i = 0; i < currentLoad; i++) {
            transports.get(i).getParent().setDir(tempdir);
        }
    }

    /**
     * Enables us to turn the CarTransport AND it's currentLoad to the right
     */
    public void carTransportTurnRight() {
        getParent().turnRight();
        int tempdir = getParent().getDir();
        for(int i = 0; i < currentLoad; i++) {
            transports.get(i).getParent().setDir(tempdir);
        }
    }


/*
    public void turnLeft() {
        int direction = parent.getDir();
        if(direction == 0) {
            parent.setDir(1);
        } else if(direction == 1) {
            parent.setDir(2);
        } else if(direction == 2) {
            parent.setDir(3);
        } else if(direction == 3) {
            parent.setDir(0);
        }
    }

 */






/*
    public void move() { //Bit of a temporary solution. It ain't a beauty but hey it's alright.
        if ((isRampDown())) {
            if (parent.getDir() == 0) {
                parent.setX((int) parent.getCurrentSpeed());
            } else if (getParent().getDir() == 1) {
                parent.setY((int) parent.getCurrentSpeed());
            } else if (getParent().getDir() == 2) {
                parent.setX((int) parent.getCurrentSpeed() * -1);
            } else if (getParent().getDir() == 3) {
                parent.setY((int) parent.getCurrentSpeed() * -1);
            }
        }


    }

 */


    public boolean isInVicinity(Transportable c) {
        // c's X should be within CarTrans's x +/- 1. Though X's can be negative which is a bummer
        //same with c's Y
        if(c.getParent().getX() <= (getParent().getX() + 1) &&
                c.getParent().getX() >= (getParent().getX() - 1)) {
            if(c.getParent().getY() <= (getParent().getY() + 1) &&
                    c.getParent().getY() >= (getParent().getY() - 1) ) {
                return true;
            }
        }
        return false;
    }



    public static void main(String args[]) {
        /*CarTransport test = new CarTransport();
        test.setRampDownFalse();
        System.out.println(test.getRampState());

        Volvo240 testV = new Volvo240();
        Saab95 testS = new Saab95();

        CarTransport testCT = new CarTransport();
        testV.getParent().setY(12);
        testS.getParent().setY(12);

        testCT.loadCar(testS);
        testCT.loadCar(testV);

        System.out.println(testCT.getTransports().size());

        System.out.println("INIT PRINT");
        System.out.println(testS.getParent().getY() + " SAAB " + testS.getParent().getX());
        System.out.println(testV.getParent().getY() + " VOLVO " + testV.getParent().getX());

         */
        CarTransport test = new CarTransport();
        test.getParent().turnLeft();
        test.getParent().turnLeft();
        System.out.println(test.getParent().getDir());






    }

/*
    public CarTransport(int x, int y, int dir, String modelName, double enginePower, double currentSpeed, Color color,
                        boolean rampDown, Transportable[] transports) {
        this.x = x; this.y = y; this.dir = dir; this.modelName = modelName; this.enginePower = enginePower;
        this.currentSpeed = currentSpeed; this.color = color; this.rampDown = rampDown;
        this.transports = transports;
    }

    public CarTransport() {
        setEnginePower(200);
        setColor(Color.black);
        setDir(1);
        setX(1);
        setY(1);


    }

 */


    // ********* GETTERS AND SETTERS *********
    //public Transportable[] createStorage(int size) {}
/*
    public double getEnginePower(){
        return enginePower;
    }

    public void setEnginePower(double power) {
        enginePower = power;
    }

    public int getX(){
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDir(){
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }


    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

 */


    //RANDOM METHODS
/*
    public void stopEngine(){
        currentSpeed = 0;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

 */





}
