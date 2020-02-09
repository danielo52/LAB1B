import java.awt.*;
import java.util.ArrayList;

public class Car implements Movable {

    private int x;
    private int y;
    private int dir;

    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;




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


    public Car() {
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

 //      ******* THESE ARE THE METHODS THAT AREN'T WORKING ATM *******

    //public abstract double speedFactor();


    //public abstract void decrementSpeed(double amount);

    /*
    public void brake(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else {
            decrementSpeed(amount);
        }

    }


    public abstract void incrementSpeed(double amount);

    public void gas(double amount){
        if(amount < 0 || amount > 1) {
            System.out.println("Please enter a value between 0 and 1");
        } else  {
            incrementSpeed(amount);
        }
    }

     */





    public static void main(String[] args) {
        //THIS IS FUCKING GOLDEN! USE THIS FOR THE CAR TRAILER AND THE FERRY


        Car[] carArray = new Car[4]; //Create array of cars, length 4.
        //carArray[0] = new Volvo240();

        Transportable[] carTransSlots = new Transportable[6];
        Transportable[] shopSlots = new Transportable[10]; //ex, different shops, different lists (ex: Saab95[])

        Movable[] movArray = new Movable[3];
        //movArray[1] = new Volvo240();

        //Saab95 testSaab = new Saab95();
        //System.out.println(testSaab.getParent().getDir());

        Volvo240 test = new Volvo240();
        System.out.println(test.getParent().getDir());

        Transportable hej = new Volvo240();

        CarTransport cT = new CarTransport();
        cT.getParent().setX(12);
        cT.getParent().setY(12);

        test.getParent().setY(11);
        test.getParent().setX(11);

        System.out.println(cT.isInVicinity(test));

        ArrayList<Transportable> listan = new ArrayList<>();
        int testInt = 4;

        Shop testShop = new Shop(listan, testInt);

        ArrayList<Volvo240> testListVolvo = new ArrayList<>();

        Shop testShopVolvo = new Shop(testListVolvo, testInt);





        Volvo240 testBil = new Volvo240();



    /*
    public void testDirection2TurnRightIs1() {
        test.getParent().setDir(2);
        test.getParent().turnRight();
        assertTrue(test.getParent().getDir() == 1);
     */



    }

}