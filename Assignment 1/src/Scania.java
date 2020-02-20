import java.awt.*;

public class Scania implements ITruck, ACar {

    private LandVehicle parent;
    private int nrGears;

    /**
     * For lack of a better term, we call the back of the Scania for bed.
     */
    private int bedAngle;


    public Scania(LandVehicle parent, int nrGears, int bedAngle) {
        this.parent = parent;
        this.nrGears = nrGears;
        this.bedAngle = bedAngle;
    }

    public Scania() {
        parent = new LandVehicle(2, 150, 0, Color.black, "Scania 79", 1, 1 ,0);
        setNrGears(12);
        setBedAngle(0);
    }


    /*
       ***** GENERAL METHODS SUCH AS MOVE AND TURN, ENGINE RELATED ETC *****
     */
    public LandVehicle getParent() {
        return parent;
    }

    public int getX() {
        return parent.getX();
    }

    public int getY() {
        return parent.getY();
    }


    /**
     *
     * @return speedFactor, depends on the nrGears of the Scania
     */
    private double speedFactor() {
        return parent.getEnginePower() * 0.001 * nrGears;
    }

    public void incrementSpeed(double amount) {
        if(isBedDown()) {
            parent.setCurrentSpeed(Math.min(parent.getCurrentSpeed() + speedFactor() * amount, parent.getEnginePower()));
        } else {
            //Nothing
        }
    }

    public void decrementSpeed(double amount) {
        parent.setCurrentSpeed(Math.max(parent.getCurrentSpeed() - speedFactor() * amount,0));
    }

    public void brake(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else {
            decrementSpeed(amount);
        }

    }

    public void move() {
        if (isBedDown()) {
            parent.move();
        }
    }

    public void turnLeft() {
        parent.turnLeft();
    }

    public void turnRight() {
        parent.turnRight();
    }



    /**
     *
     * @param amount an amount between 0 - 1 that scales the gas.
     *               Assuring that the bed is down is done in increment speed.
     */
    public void gas(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else  {
            incrementSpeed(amount);
        }
    }



    // **************** GETTERS & SETTERS ****************

    /**
     *
     * @return nrGears used for speedFactor.
     */
    public int getNrGears() {
        return nrGears;
    }

    public void setNrGears(int nrGears) {
        this.nrGears = nrGears;
    }

    /**
     *
     * @return checks whether the
     */
    public boolean isIdle() {
        return (parent.getCurrentSpeed() == 0);
    }



/*
***** METHODS FOR THE BED *****
 */
    private void incrementAngle(int amount) {
        if(amount > 0 && (bedAngle + amount <= 70)) {
            bedAngle += amount;
        }
    }

    private void decrementAngle(int amount) {
        if(amount > 0 && (bedAngle - amount >= 0)) {
            bedAngle -= amount;
        }
    }

    /**
     * raiseBed and lowerBed both assures that the Scania is idle. If so, they increment/decrement by 10.
     */
    public void raiseBed() {
        if(isIdle()){
            incrementAngle(10);
        }
    }

    public void lowerBed() {
        if(isIdle()) {
            decrementAngle(10);
        }
    }

    /**
     *
     * @return bed must be down to enable the Scania to move/drive.
     */
    public boolean isBedDown() {
        return getBedAngle() == 0;
    }



    //GETTERS AND SETTERS FOR THE BED
    public int getBedAngle() {
        return bedAngle;
    }


    /**
     *
     * @param amount sets to bedAngle to some amount. Used for testing. When/if program is released towards users,
     *               this method will be hidden.
     */
    public void setBedAngle(int amount) {
        if((amount >= 0 && amount <= 70) && isIdle()) {
            bedAngle = amount;
        } else {
            System.out.println("Please enter a valid amount for the angle of the bed");
        }
    }


}
