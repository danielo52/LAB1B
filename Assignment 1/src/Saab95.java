import java.awt.*;
import java.util.ArrayList;

public class Saab95 implements Transportable{

    private boolean turboOn;
    private Car parent;

    public Saab95(boolean turboOn, Car parent) {
        this.parent = parent;
    }

    // int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int x, int y, int dir
    public Saab95() {
        parent = new Car(2, 125, 0, Color.red, "Saab95", 1,1,1);
    }



    /*
    public Saab95(boolean turboOn,int nrDoors, double enginePower, double currentSpeed, Color color,
                  String modelName, int x, int y, int dir) {
        super(nrDoors,enginePower,currentSpeed,color,modelName, x,y, dir);
        this.turboOn = turboOn;
    }

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

     */

    public Car getParent() {
        return parent;
    }

    public void setTurboOn(){
	    turboOn = true;
    }


    public void setTurboOff(){
	    turboOn = false;
    }


    public void decrementSpeed(double amount){
        parent.setCurrentSpeed(parent.getCurrentSpeed() - speedFactor() * amount);
    }

    public void incrementSpeed(double amount){
        parent.setCurrentSpeed(parent.getCurrentSpeed() + speedFactor() * amount);
    }


    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return parent.getEnginePower() * 0.01 * turbo;
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

    public static ArrayList createArrayList() {
        return new ArrayList<Saab95>();
    }

}
