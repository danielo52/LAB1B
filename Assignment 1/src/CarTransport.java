import java.awt.*;
import java.util.ArrayList;

public class CarTransport implements ITransporters, Car  {


    private LandVehicle parent;
    private boolean rampDown;
    private ArrayList<Transportable> transports;
    private int maxLoad;
    private int currentLoad;

    public CarTransport(LandVehicle parent, boolean rampDown, ArrayList<Transportable> transports, int maxLoad, int currentLoad) {
        this.parent = parent;
        this.rampDown = rampDown;
        this.transports = transports;
        this.maxLoad = maxLoad;
        this.currentLoad = currentLoad;
    }

    /**
     * A "default" CarTransport
     */
    public CarTransport() {
        parent = new LandVehicle(2, 200, 0, Color.green, "CarTransporter 9000",
                1,1,1);
        setRampDownTrue();
        maxLoad = 8;
        transports = new ArrayList<Transportable>();
        currentLoad = 0;

    }

    public LandVehicle getParent() {
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

    /**
     *
     * @return assures that the CarTransport is idle
     */
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
     *                And we cannot load a Car that is already loaded.
     */
    public void loadCar(Transportable carLoad) {
        if(isInVicinity(carLoad) && isRampDown() && transports.size() < maxLoad && isIdle()
                && !carLoad.getIsLoaded()) {
            transports.add(carLoad);
            carLoad.setIsLoadedTrue();
            currentLoad++;
        } else {
            System.out.println("Please consult with the driver for further instructions");
        }
    }

    /**
     * Assures that the CarTransport isn't moving, and that the ramp is down. (Loadable when rampDown == true);
     * We cast t to the desired type, i.e. to be the same as the object. Could remove that part and return t as a
     * Transportable
     */
    public Transportable unloadCar() {
        Transportable t = transports.get(currentLoad-1);
        if(isRampDown() && isIdle()) {
            transports.remove(currentLoad-1);
            currentLoad--;
            t.getParent().setY(parent.getY() + 1);
            t.getParent().setX(parent.getX() + 1);
            t.setIsLoadedFalse();
            if(t.getClass() == Volvo240.class) {
                 return (Volvo240) t;
            } else if(t.getClass() == Saab95.class) {
                return (Saab95) t;
            }
        }
        return null;
    }

    /*
    Move() för en CarTransport ska flytta som vanligt. Men dessutom sätta X/Y för varje element i carStacken till samma
    x/y som CarTransporten har.
     */

    /**
     * moves the CarTransports. And moves every element in transports (i.e. the cars on the ramp) to the same position.
     */
    public void move() {
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
    public void turnLeft() {
        getParent().turnLeft();
        int tempdir = getParent().getDir();
        for(int i = 0; i < currentLoad; i++) {
            transports.get(i).getParent().setDir(tempdir);
        }
    }

    /**
     * Enables us to turn the CarTransport AND it's currentLoad to the right
     */
    public void turnRight() {
        getParent().turnRight();
        int tempdir = getParent().getDir();
        for(int i = 0; i < currentLoad; i++) {
            transports.get(i).getParent().setDir(tempdir);
        }
    }



    public void incrementSpeed(double amount){
        parent.setCurrentSpeed(Math.min(parent.getCurrentSpeed() + 1.4 * amount, parent.getEnginePower()));
    }

    public void decrementSpeed(double amount){
        parent.setCurrentSpeed(Math.max(parent.getCurrentSpeed() - 1.4 * amount,0));
    }

    public void brake(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else {
            decrementSpeed(amount);
        }

    }

    /**
     *
     * @param amount an amount between 0 - 1 that scales the gas.
     */
    public void gas(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else  {
            incrementSpeed(amount);
        }
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


}
