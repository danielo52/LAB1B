import java.awt.*;

public class Saab95 implements Transportable, ACar {

    private boolean turboOn;
    private LandVehicle parent;
    private boolean isLoaded;

    public Saab95(boolean turboOn, LandVehicle parent, boolean isLoaded) {
        this.parent = parent;
        this.isLoaded = isLoaded;
    }

    // int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int x, int y, int dir
    public Saab95() {
        parent = new LandVehicle(2, 125, 0, Color.red, "Saab95", 1, 1, 0);
        setIsLoadedFalse();
    }

    public LandVehicle getParent() {
        return parent;
    }

    public int getX() {
        return parent.getX();
    }

    public int getY() {
        return parent.getY();
    }

    public void setX(int x) {
        parent.setX(x);
    }

    public void setY(int y) {
        parent.setY(y);
    }

    public int getDir() {return parent.getDir();}

    public void setCurrentSpeed(int speed) {
        parent.setCurrentSpeed(speed);
    }

    public void setDir(int dir) {
        parent.setDir(dir);
    }

    public boolean getTurboState() {
        return turboOn;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public void setIsLoadedTrue() {
        isLoaded = true;
    }

    public void setIsLoadedFalse() {
        isLoaded = false;
    }

    public boolean getIsLoaded() {
        return isLoaded;
    }

    public void move() {
        parent.move();
    }

    public void turnLeft() {
        parent.turnLeft();
    }

    public void turnRight() {
        parent.turnRight();
    }



    /**
     *
     * @param amount an amount to scale the speedFactor. Method currently public due to testing.
     */
    public void decrementSpeed(double amount) {
        parent.setCurrentSpeed(parent.getCurrentSpeed() - speedFactor() * amount);
    }

    /**
     *
     * @param amount an amount to scale the speedFactor. Method currently public due to testing.
     */
    public void incrementSpeed(double amount) {
        parent.setCurrentSpeed(parent.getCurrentSpeed() + speedFactor() * amount);
    }


    private double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return parent.getEnginePower() * 0.01 * turbo;
    }

    /**
     *
     * @param amount an amount between 0 - 1 that scales the braking.
     */
    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else {
            decrementSpeed(amount);
        }

    }

    /**
     *
     * @param amount between 0 - 1 which scales the gas.
     */
    public void gas(double amount) {
        if (amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else {
            incrementSpeed(amount);
        }
    }

    public void moveCar() {
        parent.move();
    }

    public void  turnRightCar() {
        parent.turnRight();
    }

    public void turnLeftCar() {
        parent.turnLeft();
    }

}

