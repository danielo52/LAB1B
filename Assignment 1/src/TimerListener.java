
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerListener implements ActionListener, IObservable {

    ArrayList<IObserver> observers;
    ArrayList<ACar> carsList;
    CarModel model;

    public void actionPerformed(ActionEvent e) {
        for (ACar car : model.getCars()) {
            if (model.isCollisionHigh(car)) {
                model.moveCollision(car, -1);
                notifyObs(car.getX(), car.getY(), car);
            } else if (model.isCollisionLow(car)) {
                model.moveCollision(car, 1);
                notifyObs(car.getX(), car.getY(), car);
            } else {
                car.move();
                notifyObs(car.getX(), car.getY(), car);
            }
            int x = Math.round(car.getX()); //car.getX() or xTemp
            int y = Math.round(car.getY()); //same              OBS OBS OBS
            notifyObs(car.getX(), car.getY(), car);

        }
    }

    public TimerListener(CarModel model) {
        this.model = model;
        //this.cars = new ArrayList<ACar>();
        observers = new ArrayList<IObserver>();
        //this.observers = observers;
        //this.frame = frame;
    }


    public void add(IObserver obs) {
        this.observers.add(obs);
    }

    public void remove(IObserver obs) {
        int observerIndex = observers.indexOf(obs);
        System.out.println("Observer at index : " + (observerIndex + 1) + " deleted!");
        observers.remove(observerIndex);
    }


    public void notifyObs(int x, int y, ACar car) {
        for (IObserver obs : this.observers) {
            obs.update(x, y, car);
        }
    }

    public void setObservers(ArrayList<IObserver> observers) {
        this.observers = observers;
    }

    public CarModel getModel() {
        return model;
    }
}
/*

    public ArrayList<ACar> getCars() {
        return cars;
    }

    private boolean isCollisionHigh(ACar car) {
        return (Math.round(car.getX()) > CarView.getXCarView() - 100);
    }

    private void moveCollision(ACar car, int mover) {
        stopCar(car);
        negateDir(car);
        car.setX(car.getX() + mover);
        startCar(car);
        car.move();

    }

    private void moveCar(ACar car) {
            car.move();
    }

    private boolean isCollisionLow(ACar car) {
        return (Math.round(car.getX()) < 0);
    }

    private void negateDir(ACar car) {
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
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (ACar car : cars
        ) {
            car.gas(gas);
        }
    }

    //brakeAmount casting since I believe the dropdown list in the client gives us an Int (0-100) and we need a double
    public void brake(int amount) {
        double brakeAmount = ((double) amount) / 100;
        for (ACar car : cars) {
            car.brake(brakeAmount);
        }
    }


    public void setTurboOn() {
        for (ACar car : cars) {
            if (car.getClass() == Saab95.class) {
                car.setTurboOn();
            } else {
                //Nothing
            }

        }
    }

    public void setTurboOff() {
        for (ACar car : cars) {
            if (car.getClass() == Saab95.class) {
                car.setTurboOff();
            } else {
                //Nothing
            }
        }
    }

    public void raiseBed() {
        for (ACar car : cars) {
            if(car.getClass() == Scania.class) {
                car.raiseBed();
            } else {
                //Nothing
            }
        }
    }

    public void lowerBed() {
        for(ACar car : cars) {
            if(car.getClass() == Scania.class) {
                car.lowerBed();
            } else {
                //Nothing
            }
        }
    }

    public void stopCar(ACar car) {
        car.setCurrentSpeed(0);
    }

    public void startCar(ACar car) {
        car.setCurrentSpeed(1);
    }

 */

    /**
     * BOTH stopCars and startCars could/should be simplified an call stopCar & startCar
     */
    /*
    public void stopCars() {
        for (ACar car : cars) {
            car.setCurrentSpeed(0);
        }
    }

    public void startCars() {
        for (ACar car : cars) {
            car.setCurrentSpeed(1);
        }
    }

     */


    /*
                if (car.getClass() == Volvo240.class) {         //  _SHOULD_ BE ABLE TO REMOVE THIS ONCE WE GET
                    frame.drawPanel.moveVolvo(x, y);            //  THE OBSERVER PATTERN UP AND RUNNING
                } else if (car.getClass() == Saab95.class) {
                    frame.drawPanel.moveSaab(x, y);
                } else if (car.getClass() == Scania.class) {
                    frame.drawPanel.moveScania(x, y);
                } else {
                    System.out.println("ERROR");
                }


                /* public void getState(int x, int y, ACar car) {
            frame.getDrawPanel().moveit(x,y,car);
            frame.getDrawPanel().repaint();
        }







}

     */



