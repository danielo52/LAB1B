import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;



    /** Constructor for Volvo240. Total of 9 parameters.
     *
     * @param trimFactor
     * @param nrDoors
     * @param enginePower
     * @param currentSpeed
     * @param color
     * @param modelName
     * @param x A Volvo240's position represented along the x-axis.
     * @param y A Volvo240's position represented along the y-axis.
     * @param dir represents a Volvo's position. There are 4 directions. These directions are represented by an int, which has a
     * value between 0 and 3. (Where the values represent: 0: "east", 1: "north", 2: "west, 3: "south").
     */
    public Volvo240(double trimFactor, int nrDoors, double enginePower, double currentSpeed, Color color,
                    String modelName, int x, int y, int dir) {
        super(nrDoors,enginePower,currentSpeed,color,modelName,x,y, dir);

    }


    /**
     * A constructor used to instanciate a Volvo240 object where no arguments are given. This creates a "default" Volvo
     */
    public Volvo240(){
        setNrDoors(2);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        setX(1);
        setY(1);
        setDir(1);
        stopEngine();
    }

    /**
     * Overriden method from super (Car), since speedFactor is calculated differently for a Volvo240.
     * @return Speedfactor: used to determine rate at which speed is incremented and decremented.
     */


    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


    /**
     *
     * @param amount A double that scales the level at which speedFactor is added to the currentSpeed.
     * the method then sets the currentSpeed to the lowest of the two arguments passed in Math.min.
     * Overriden method from super (Car) since the calculation differs.
     */


    public void incrementSpeed(double amount){
	    setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     *
     * @param amount A double that scales the level at which speedFactor is subtracted from the currentSpeed.
     * the method then sets the currentSpeed to the greatest of the two arguments passed in Math.max.
     * Overriden method from super (Car) since the calculation differs.
     */

    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

}
