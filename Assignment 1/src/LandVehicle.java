import java.awt.*;
import java.util.ArrayList;

public class LandVehicle implements Movable {
    /**
     * IMPORTANT: This class could/should be renamed VehicleFrame, CarFrame or something along those lines. Although for
     * the sake of the assignment the name Car will be retained.
     */

    private int x;
    private int y;
    private int dir;

    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;




    public LandVehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int x, int y, int dir) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }


    public LandVehicle() {
        setNrDoors(3);
        setColor(Color.gray);
        setEnginePower(45);
        setModelName("NoBrand");
        setX(2);
        setY(2);
        setDir(2);
        stopEngine();

    }


    public int getNrDoors(){
        return nrDoors;
    }


    public double getEnginePower(){
        return enginePower;
    }


    public void setEnginePower(double power) {
        enginePower = power;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }


    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }


    public Color getColor(){
        return color;
    }


    public void setColor(Color clr){
        color = clr;
    }

    public void setNrDoors(int doors) {
        nrDoors = doors;
    }


    public String getModelName() {
        return modelName;
    }


    public void setModelName(String name) {
        modelName = name;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public void setX(int x) {
        this.x = x;
    }


    public void setY(int y) {
        this.y = y;
    }


    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }


    public void setDir(int dir) {
        this.dir = dir;
    }


    public int getDir() {
        return dir;
    }

    /**
     * Allows a Car object to move. It checks the Cars direction, and moves the Car with length currentSpeed in that
     * direction.
     */
    public void move() {
        if(dir == 0) {
            setX(x+= (int) getCurrentSpeed());
        }else if(dir == 1) {
             setY((int) getCurrentSpeed());
        } else if(dir == 2) {
            setX(x += (int) getCurrentSpeed() * -1);
        } else if (dir == 3) {
            setY((int) getCurrentSpeed() * -1);
        }
    }

    /**
     * Allows a Car object to turn left. It checks current direction, and changes to the left depending on where the
     * car is directed prior to moving.
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
     *  Allows a Car object to turn right. It checks current direction, and changes to the right depending on where the
     *    car is directed prior to moving.
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

}