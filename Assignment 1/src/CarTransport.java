import com.sun.jdi.connect.Transport;

import java.awt.*;

public class CarTransport implements ITransporters /*, ITruck*/ {
/*
We assumed that this is a "normal" 12/18-wheeler type of truck, that can transport cars and nothing bigger
(i.e. it CANNOT transport "Scania").
 */

/*
    private int x;
    private int y;
    private int dir;
    private String modelName;
    private double enginePower;
    private double currentSpeed;
    private Color color;

 */

    private Car parent;
    private boolean rampDown;
    private CarStack transports;

    public CarTransport(Car parent, boolean rampDown, CarStack transports) {
        this.parent = parent;
        this.rampDown = rampDown;
        this.transports = transports;
    }
    //int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int x, int y, int dir
    public CarTransport() {
        parent = new Car(2, 200, 0, Color.green, "CarTransporter 9000",
                1,1,1);
        setRampDownTrue();
        transports = new CarStack();
    }




    //WE NEED MORE FIELDS BUT WE START OFF WITH THESE. JUST SO WE CAN IMPLEMENT SOME VERY NECESSARY METHODS
    public Car getParent() {
        return parent;
    }

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


    //     ********** LOAD AND UNLOAD **********

    public void loadCar(Transportable carLoad) {
        if(isInVicinity(carLoad) && isRampDown()) {
            transports.push(carLoad);
        }
    }

    public void unloadCar(Transportable carLoad) {
        if(isRampDown()) {
            transports.pop();
        }
        /*
        if(c.isElementOf(carTrans.getTransports()) && carTrans.isIdle()) -> unload to "nearby" x/y.
         */
    }

    /*
    Move() för en CarTransport ska flytta som vanligt. Men dessutom sätta X/Y för varje element i carStacken till samma
    x/y som CarTransporten har.
     */

    public void move() { //Bit of a temporary solution. It ain't a beauty but hey it's alright.
        if (()) {
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

    public void putInVicinity(Transportable t, CarTransport cT) {
        int xtemp = cT.getParent().getX();
        int ytemp = cT.getParent().getY();

        cT.getParent().setX(xtemp);
    }

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
        CarTransport test = new CarTransport();
        test.setRampDownFalse();
        System.out.println(test.getRampState());

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
