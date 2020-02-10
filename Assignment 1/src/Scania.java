import java.awt.*;
public class Scania {

    private Car parent;
    private int nrGears;

    //private boolean bedDown; -> We probably won't need this.
    //For lack of a better term, the back of the truck is called "Bed".
    private int bedAngle;


    public Scania(Car parent, int nrGears, int bedAngle) {
        this.parent = parent;
        this.nrGears = nrGears;
        this.bedAngle = bedAngle;
    }

    public Scania() {
        parent = new Car(2, 150, 0, Color.black, "Scania 79", 1, 1 ,1);
        setNrGears(12);
        setBedAngle(0);
    }

/*
    public Scania(int nrDoors, double enginePower, double currentSpeed, Color color,
                  String modelName, int x, int y, int dir, int nrGears, boolean bedDown, int bedAngle) {
        super(nrDoors,enginePower,currentSpeed,color,modelName,x,y, dir);
                this.nrGears = nrGears;
                this.bedDown = bedDown;
                this.bedAngle = bedAngle;
    }

 */




/*
    public Scania(double enginePower, double currentSpeed, int x, int y, int dir, boolean bedDown, int bedAngle, Color color,
                  String modelName, IBed regularBed, int nrGears) {
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.bedDown = bedDown;
        this.bedAngle = bedAngle;
        this.color = color;
        this.modelName = modelName;
        this.regularBed = regularBed;
    }

 */
/*
    public Scania() {
        setEnginePower(150);
        setNrDoors(2);
        setBedAngle(0);
        setModelName("Scania 79");
        setX(1);
        setY(1);
        setDir(1);
        stopEngine();
        setNrGears(12);

    }

 */


    /*
       ***** GENERAL METHODS SUCH AS MOVE AND TURN, ENGINE RELATED ETC *****
     */
    public Car getParent() {
        return parent;
    }


    /**
     * Similar to the original method from Car, but it also checks that the bed is down.
     */
    public void move() {
        if (isBedDown()) {
            if (parent.getDir() == 0) {
                parent.setX((int) parent.getCurrentSpeed());
            } else if (getParent().getDir() == 1) {
                parent.setY((int) parent.getCurrentSpeed());
            } else if (getParent().getDir() == 2) {
                parent.setX((int) parent.getCurrentSpeed() * -1);
            } else if (getParent().getDir() == 3) {
                parent.setY((int) parent.getCurrentSpeed() * -1);
            }
        }


    }

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



public static void main(String[] args) {

        // Half asses testing prior to Junit.
        Scania test = new Scania();
        //test.setBedAngle(20);
        test.parent.setCurrentSpeed(10);
        System.out.println(test.isIdle());
        test.parent.setCurrentSpeed(50);
        System.out.println(test.parent.getCurrentSpeed());
        /*
        test.incrementAngle(70);
        System.out.println(test.getCurrentBedAngle()); //Should print 20 - OK
        test.decrementAngle(15);
        System.out.println(test.getCurrentBedAngle()); //Should print 5 - OK

         */

        Scania nyTest = new Scania();
        System.out.println(nyTest.getBedAngle());
        nyTest.incrementAngle(20);
        System.out.println(nyTest.getBedAngle());

    }



    /*
                ***** GARBAGE DAY *****

   //private int nrDoors;
    //private double enginePower;
    //private double currentSpeed;
    //private Color color;
    //private String modelName;

    //private int x;
    //private int y;
    //private int dir;


    public void stopEngine(){
        currentSpeed = 0;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

// ***** GETTERS AND SETTERS *****



    public double getEnginePower() {
        return enginePower;
    }

    public IBed getRegularBed() {
        return regularBed;
    }

    public void setEnginePower(double power) {
        enginePower = power;
    }

    public int getX(){
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDir(){
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public void setNrDoos(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

 */
/*
    public double getCurrentSpeed() {
        return currentSpeed;
    }


    public void setCurrentSpeed(int currentSpeed){
        if(getBedAngle() == 0) {
            this.currentSpeed = currentSpeed;
        } else {
            System.out.println("Please lower the bed before acceleration");
        }
    }

    public void setBedDownTrue() {
        bedDown = true;
    }

    public void setBedDownFalse() {
        bedDown = false;
    }

 */

//int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int x, int y, int dir
    /*setEnginePower(150);
    setNrDoors(2);
    setBedAngle(0);
    setModelName("Scania 79");
    setX(1);
    setY(1);
    setDir(1);
    stopEngine();
    setNrGears(12);

     */








}
