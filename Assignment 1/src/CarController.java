import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    //private boolean isCollisionVar;

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<ACar> cars = new ArrayList<>();

    //methods:
    public static void main(String[] args) {
        // Instance of this class

        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());




        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    /**
     * isCollisionHigh & isCollisionLow checks whether the car has collided with the wall or not
     * moveCollision first stops the car, and then moves it away from the collision (i.e. the wall)
     * moveVolvo, moveSaab and moveScania are all methods from DrawPanel (changed from moveit() )
     *
     */
    // Some hacky moving, although not that hacky imo, works.
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (ACar car : cars) {
                if(isCollisionHigh(car)) {
                    moveCollision(car, -1);
                } else if(isCollisionLow(car)) {
                    moveCollision(car, 1);
                } else {
                    car.move();
                }
                int x = Math.round(car.getX()); //car.getX() or xTemp
                int y = Math.round(car.getY()); //same
                if(car.getClass() == Volvo240.class) {
                    frame.drawPanel.moveVolvo(x,y);
                } else if(car.getClass() == Saab95.class) {
                    frame.drawPanel.moveSaab(x,y);
                } else if(car.getClass() == Scania.class) {
                    frame.drawPanel.moveScania(x,y);
                } else {
                    System.out.println("ERROR");
                }
                //frame.drawPanel.moveit(x,y);
                frame.drawPanel.repaint();
            }
        }
    }

    private boolean isCollisionHigh(ACar car) {
        return (Math.round(car.getX()) > frame.getXCarView()-100);
    }

    private void moveCollision(ACar car, int mover) {
        stopCar(car);
        negateDir(car);
        car.setX(car.getX() + mover);
        startCar(car);
        car.move();
    }

    private boolean isCollisionLow(ACar car) {
        return (Math.round(car.getX()) < 0);
    }
    /*
    private boolean isCollision(ACar car) {
        if((Math.round(car.getX()) > frame.getXCarView()-100 || Math.round(car.getX()) < 0)) {
            isCollisionVar = true;
        } else {
            isCollisionVar = false;
        }
        return isCollisionVar;
    }

    private void setIsCollisionVarFalse() {
        isCollisionVar = false;
    }

     */





    public void negateDir(ACar car) {
        switch (car.getDir()) {
            case 0:
                car.setDir(2);
                break;
            case 1:
                car.setDir(3);
                break;
            case 2:
                car.setDir(0);
                break;
            case 3:
                car.setDir(1);
                break;
            default:
                System.out.println("Wrong directions");
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (ACar car : cars
                ) {
            car.gas(gas);
        }
    }
    //brakeAmount casting since I believe the dropdown list in the client gives us an Int (0-100) and we need a double
    void brake(int amount) {
        double brakeAmount = ((double) amount)/100;
        for(ACar car : cars) {
            car.brake(brakeAmount);
        }
    }

    void setTurboOn() {
        for(ACar car : cars) {
            if(car.getClass() == Saab95.class) {
                car.setTurboOn();
            } else {
                //Nothing
            }

        }
    }

    void setTurboOff() {
        for(ACar car : cars) {
            if(car.getClass() == Saab95.class) {
                car.setTurboOff();
            }else {
                //Nothing
            }
        }
    }

    void stopCar(ACar car) {
        car.setCurrentSpeed(0);
    }



    void startCar(ACar car) {
        car.setCurrentSpeed(1);
    }

    /**
     * BOTH stopCars and startCars could/should be simplified an call stopCar & startCar
     */
    void stopCars() {
        for(ACar car : cars) {
            car.setCurrentSpeed(0);
        }
    }

    void startCars() {
        for(ACar car : cars) {
            car.setCurrentSpeed(1);
        }
    }



    /*
                ***** GARBAGE DAY *****
     /*
    boolean isCollision(ACar car) {
        if(Math.round(car.getX()) > frame.getXCarView()-100 || Math.round(car.getX()) < 0) {
            return Math.round(car.getY()) < frame.getY() || Math.round(car.getY()) > 0;
        }
        return false;
    }

 */
    /*
    private boolean isCollision(ACar car) {
        if(Math.round(car.getX()) > frame.getX() || Math.round(car.getX()) < 0) {
            return Math.round(car.getY()) < frame.getY() || Math.round(car.getY()) > 0;
        }
        return false;
    }

     */
    /*
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (ACar car : cars) {
                int xTemp = car.getX();
                int yTemp = car.getY();
                if(isCollision(car)) {
                    stopCar(car);
                    negateDir(car);
                    startCar(car);
                    car.move();
                    int x = Math.round(xTemp); //car.getX() or xTemp
                    int y = Math.round(yTemp); //same
                    frame.drawPanel.moveit(x,y);
                    frame.drawPanel.repaint();
                } else {
                    car.move();
                    int x = (int) Math.round(car.getX());
                    int y = (int) Math.round(car.getY());
                    frame.drawPanel.moveit(x, y);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }
            }
        }
    }

 */



    /*
     int xTemp = car.getX();
                int yTemp = car.getY();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                car.move();
     */

    /*
    Turns out the problem with timeListener was:
     - We don't need temporary x and y, as long as we negate the direction.
     - The problem with getting stuck "between" the wall and the spot precisely prior to the wall was
        the stopCar() and startCar(), that is not necessary, now it runs smooth as fuck.
        This abomination just needs some refactoring and it's done I believe!.
     */
/*
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (ACar car : cars) {         //NOTES ARE ON WHEN I HAD moveit(xTemp, yTemp).
                int xTemp = car.getX(); //I THINK this sometimes turns into some loop where the cars bounce between
                int yTemp = car.getY(); //the spot exactly prior to getting stuck, and actually getting stuck in the
                if(isCollision(car)) { //wall, hence the "vibrating" effect in the display. WORK IT OUT!
                    //stopCar(car);
                    negateDir(car);
                    //startCar(car);
                    car.move();
                    int x = (int) Math.round(car.getX());
                    int y = (int) Math.round(car.getY());
                    frame.drawPanel.moveit(x, y);
                    //frame.drawPanel.repaint();
                } else {
                    car.move();
                    int x = (int) Math.round(car.getX());
                    int y = (int) Math.round(car.getY());
                    frame.drawPanel.moveit(x, y);
                    //frame.drawPanel.repaint();
                }
                frame.drawPanel.repaint();
                //frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                //frame.drawPanel.repaint();
            }
        }
    }

 */



    /*
    int xTemp = car.getX();
    int yTemp = car.getY();
    int x;
    int y;
    car.move();
    if (!Math.round(car.getX() > X || !Math.round(car.getX()) < 0) {
            x = (int) Math.round(car.getX());
            if(!Math.round(car.getY() > frame.getY() || !Math.round(car.getY()) < 0) {
            y = (int) Math.round(car.getY());
            } else() {
             x = xTemp;
             y = yTemp;
            }
            frame.drawPanel.moveit(x,y);
            frame.drawPanel.repaint();
        }
     */

    /*
    this "works" although the width (x) is a real hack, so is the length (y) to be honest.
    CURRENTLY: have a getter in CarView that returns X (the constant).
    AND! -100 since the pic is 100 pixels long so this could be solved in a prettier way as well.
    All in all the visuals work like a charm though.
     */




}

