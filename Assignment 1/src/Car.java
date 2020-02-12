/**
 * Interface for Cars, so that we can create type Car, and call all methods on that Car.
 * i.e. a user should be able to call move() on a Car, and it should work fine.
 * (Saab, Volvo, Scania & CarTransport all implement Car.
 */
public interface Car {

    void move();

    void turnRight();

    void turnLeft();

    void gas(double amount);

    void brake(double amount);

}
