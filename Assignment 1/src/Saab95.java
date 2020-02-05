import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;

    /**
     * Constructor for Saab95. Total of 9 parameters.
     * @param turboOn some
     * @param nrDoors of
     * @param enginePower which
     * @param currentSpeed are
     * @param color obvious as
     * @param modelName to what they represent.
     * @param x A Saab95's position represented along the x-axis.
     * @param y A Saab95's position represented along the y-axis.
     * @param dir represents a Saabs's position. There are 4 directions. These directions are represented by an int, which has a
     * value between 0 and 3. (Where the values represent: 0: "east", 1: "north", 2: "west, 3: "south").
     */
    public Saab95(boolean turboOn,int nrDoors, double enginePower, double currentSpeed, Color color,
                  String modelName, int x, int y, int dir) {
        super(nrDoors,enginePower,currentSpeed,color,modelName, x,y, dir);
        this.turboOn = turboOn;
    }


    /**
     * A constructor used to instanciate a Saab95 object where no arguments are given. This creates a "default" Saab
     */
    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
        turboOn = false;
        setModelName("Saab95");
        setX(1);
        setY(1);
        stopEngine();
    }



    /**
     * Activates the Saab's turbo.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Deactivates the Saab's turbo.
     */
    public void setTurboOff(){
	    turboOn = false;
    }


    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }


    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }


    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
