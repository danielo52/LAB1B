import java.util.ArrayList;
import java.util.Random;

public class CarModel {
    private static final int maxCars = 10;
    private int currentCars;
    private ArrayList<ACar> cars;
    ACarFactory randomCarFactory;
    Random rand;

    public CarModel() {
        cars = new ArrayList<>();
        randomCarFactory = new RandomCarFactory();
    }

    void addAdditionalCar() {
        if(cars.size() < maxCars) {
            int decider = rand.nextInt(3);
            ACar newCar = randomCarFactory.createCar(decider);
            cars.add(newCar);
        } else {
            System.out.println("Too many cars");
        }
    }

    //Always removes the Car that was added last. FILO.
    void removeACar() {
        int length = cars.size();
        cars.remove(length-1);
    }

    public CarModel(ArrayList<ACar> cars) {
        this.cars = cars;
    }


    public ArrayList<ACar> getCars() {
        return cars;
    }

    public void addCar(ACar car) {
        cars.add(car);
    }

    public void removeCar(ACar car) {
        cars.remove(car);
    }


    /**
     *
     * Methods for operating on the CarModel as a whole.
     *
     */

    public boolean isCollisionHigh(ACar car) {
        return (Math.round(car.getX()) > CarView.getXCarView() - 100);
    }

    public void moveCollision(ACar car, int mover) {
        stopCar(car);
        negateDir(car);
        car.setX(car.getX() + mover);
        startCar(car);
        car.move();

    }

    public void moveCar(ACar car) {
        car.move();
    }

    public boolean isCollisionLow(ACar car) {
        return (Math.round(car.getX()) < 0);
    }

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
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (ACar car : cars) {
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

    /**
     * BOTH stopCars and startCars could/should be simplified an call stopCar & startCar
     */
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


}
