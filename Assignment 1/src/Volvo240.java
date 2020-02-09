import java.awt.*;

public class Volvo240 implements Transportable{

    private final static double trimFactor = 1.25;
    private Car parent;



    public Volvo240(double trimFactor, Car parent) {
        this.parent = parent;
    }

//int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int x, int y, int dir
   public Volvo240() {
       parent = new Car(2, 100, 0, Color.black, "Volvo240", 1,1,1);

   }




    public Car getParent() {
        return parent;
    }


    public void move() {
        if(parent.getDir() == 0) {
            parent.setX((int) parent.getCurrentSpeed());
        }else if(parent.getDir() == 1) {
            parent.setY((int) parent.getCurrentSpeed());
        } else if(parent.getDir() == 2) {
            parent.setX((int) parent.getCurrentSpeed() * -1);
        } else if (parent.getDir() == 3) {
            parent.setY((int) parent.getCurrentSpeed() * -1);
        }
    }

    public double speedFactor(){
        return parent.getEnginePower() * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    parent.setCurrentSpeed(Math.min(parent.getCurrentSpeed() + speedFactor() * amount, parent.getEnginePower()));
    }



    public void decrementSpeed(double amount){
        parent.setCurrentSpeed(Math.max(parent.getCurrentSpeed() - speedFactor() * amount,0));
    }

    public void brake(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else {
            decrementSpeed(amount);
        }

    }

    public void gas(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else  {
            incrementSpeed(amount);
        }
    }

}

// *********   GARBAGE DAY   *********

  /*
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

     */

   /*
    public Volvo240(double trimFactor, int nrDoors, double enginePower, double currentSpeed, Color color,
                    String modelName, int x, int y, int dir) {
        super(nrDoors,enginePower,currentSpeed,color,modelName,x,y, dir);

    }

    */


