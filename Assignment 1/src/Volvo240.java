import java.awt.*;

public class Volvo240 implements Transportable, ACar {

    private final static double trimFactor = 1.25;
    private LandVehicle parent;
    private boolean isLoaded;


    public Volvo240(double trimFactor, LandVehicle parent, boolean isLoaded) {
        this.parent = parent;
        this.isLoaded = isLoaded;

    }
    public Volvo240() {
       parent = new LandVehicle(2, 100, 0, Color.black, "Volvo240", 1,1,1);
       setIsLoadedFalse();

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


    public LandVehicle getParent() {
        return parent;
    }

    public int getX() {
        return parent.getX();
    }

    public int getY() {
        return parent.getY();
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


    private double speedFactor(){
        return parent.getEnginePower() * 0.01 * trimFactor;
    }

    /**
     *
     * @param amount an amount to scale the speedFactor. Method currently public due to testing.
     */
    public void incrementSpeed(double amount){
	    parent.setCurrentSpeed(Math.min(parent.getCurrentSpeed() + speedFactor() * amount, parent.getEnginePower()));
    }

    /**
     *
     * @param amount an amount to scale the speedFactor. Method currently public due to testing.
     */
    public void decrementSpeed(double amount){
        parent.setCurrentSpeed(Math.max(parent.getCurrentSpeed() - speedFactor() * amount,0));
    }

    /**
     *
     * @param amount an amount between 0 - 1 that scales the braking.
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
     * @param amount an amount between 0 - 1 that scales the gas.
     */
    public void gas(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else  {
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




