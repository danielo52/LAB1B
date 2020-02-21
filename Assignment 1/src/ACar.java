/**
 * Interface for Cars, so that we can create type Car, and call all methods on that Car.
 * i.e. a user should be able to call move() on a Car, and it should work fine.
 * (Saab, Volvo, Scania & CarTransport all implement Car.
 */
public interface ACar {

    void move();

    void turnRight();

    void turnLeft();

    void gas(double amount);

    void brake(double amount);

    int getX();

    int getY();

    void setTurboOn();

    void setTurboOff();

    /*
    ADD METHODS FOR LOWERING AND RAISING THE BED THEN ADD THEM IN THE CARS
     */

    int getDir();

    void setDir(int dir);

    void setX(int x);

    void setY(int y);

    void setCurrentSpeed(int speed);

}
