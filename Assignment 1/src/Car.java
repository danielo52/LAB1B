import java.awt.*;

public abstract class Car implements Movable {

    private int x;
    private int y;
    private int dir;

    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;

    public Car() {

    }


    /**
     * Constructor for a Car. Takes a total of 8 parameters. Some of which are obvious in terms of what they represent.
     * @param nrDoors
     * @param enginePower
     * @param currentSpeed Represents the currentSpeed of a Car.
     * @param color
     * @param modelName
     * @param x A Car's position represented in terms of x and y coordinates.
     * @param y A Cars's position represented in terms of x and y coordinates.
     * @param dir represents a Car's position. There are 4 directions. These directions are represented by an int, which has a
     *            value between 0 and 3. (Where the values represent: 0: "east", 1: "north", 2: "west, 3: "south").
     */
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int x, int y, int dir) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    /**
     *
     * @return returns the number of doors for a Car.
     *
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     *
     * @return returns a Car's enginePower.
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     *
     * @param power lets us set the enginePower of a Car by passing a double.
     */
    public void setEnginePower(double power) {
        enginePower = power;
    }

    /**
     *
     * @return returns the currentSpeed of a Car.
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     *
     * @param speed lets us set the currentSpeed of a Car by passing a double.
     */
    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    /**
     *
     * @return returns the Color of a Car.
     */
    public Color getColor(){
        return color;
    }

    /**
     *
     * @param clr lets us set the Color of a Car by passing a Color.
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     *
     * @param doors lets us set the number of doors on a Car, by passing an int.
     */
    public void setNrDoors(int doors) {
        nrDoors = doors;
    }

    /**
     *
     * @return returns a Cars modelname.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     *
     * @param name lets us set the modelName of a Car by passing a String.
     */
    public void setModelName(String name) {
        modelName = name;
    }

    /**
     *
     * @return returns a Car's x coordinate. (Which represents the Cars position along the x-axis).
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return returns a Car's y coordinate. (Which represents the Cars position along the y-axis).
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param x lets us set the x coordinate of a Car by passing an int.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param y lets us set the y coordinate of a Car by passing an int.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * lets us "start" the engine by setting the currentSpeed to 0.1 (i.e. "barely" moving).
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * lets us "shut down" the engine. This is achieved by setting the currentSpeed to 0. In this system, the car being
     * stagnant and the Car being turned off are considered equivalent.
     * (Which obviously isn't the case with a "real life car")
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     *
     * @param dir lets us set the direction of a Car. As mentioned earlier the Car can assume 4 positions, which are
     *            represented by an int with value 0-3.
     */
    public void setDir(int dir) {
        this.dir = dir;
    }

    /**
     *
     * @return returns a Car's direcetion.
     */
    public int getDir() {
        return dir;
    }

    /**
     * This method allows us to move a Car. A Car is moved in its direction, and travels for the length
     * of its currentSpeed.
     */
    public void move() {
        if(dir == 0) {
            setX((int) getCurrentSpeed());
        }else if(dir == 1) {
             setY((int) getCurrentSpeed());
        } else if(dir == 2) {
            setX((int) getCurrentSpeed() * -1);
        } else if (dir == 3) {
            setY((int) getCurrentSpeed() * -1);
        }
    }

    /**
     * Enables a Car to turn left. This is achieved through changing the Cars direction.
     * Note: the car does not move by turning, it just changes the Cars direction.
     */
    public void turnLeft() {
        int direction = getDir();
        if(direction == 0) {
            setDir(1);
        } else if(direction == 1) {
            setDir(2);
        } else if(direction == 2) {
            setDir(3);
        } else if(direction == 3) {
            setDir(0);
        }
    }

    /**
     * Enables a Car to turn right. This is achieved through changing the Cars direction.
     * Note: the car does not move by turning, it just changes the Cars direction.
     */
    public void turnRight() {
        int direction = getDir();
        if(direction == 0) {
            setDir(3);
        } else if(direction == 1) {
            setDir(0);
        } else if(direction == 2) {
            setDir(1);
        } else if(direction == 3) {
            setDir(2);
        }

    }

    /**
     *
     * @return returns a double (speedFactor) that is part of the calculation for the level at which a Cars speed is
     * incremented or decremented when increment- and decrementSpeed are called upon a Car.
     * (This is the speedFactor given for Saab95. If this is applicable to other sub classes of Car it can be used as such,
     * otherwise override it.
     */
    public abstract double speedFactor();

    /**
     *
     * @param amount a double that is used to scale the speedFactor when calculating currentSpeed when decrementing the
     *               speed
     */
    public abstract void decrementSpeed(double amount);



    /**
     * @param amount amount of which we wish to decrement the speed with.
     * Note that the method only decrements the speed by amounts in the interval 0 - 1. If amount is outside this interval
     * the currentSpeed is maintained and the user is asked to enter a acceptable value.
     */
    public void brake(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else {
            decrementSpeed(amount);
        }

    }

    /**
     *
     * @param amount a double that is used to scale the speedFactor when calculating currentSpeed when incrementing the
     *               speed.
     */
    public abstract void incrementSpeed(double amount);

    /**
     *
     * @param amount amount of which we wish to increment the speed with.
     * Note hat the method only increments the speed with amounts in the interval 0 - 1. If amount is outside this interval
     * the currentSpeed is maintained and the user is asked to enter a acceptable value.
     */
    public void gas(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else  {
            incrementSpeed(amount);
        }
    }

    public static void main(String[] args) {

    }

}