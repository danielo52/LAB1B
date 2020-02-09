import java.util.Deque;

public class Shop {

    private Deque<Car> cars;
    private int maxCars;


    public Shop(Deque<Car> cars, int maxCars) {
        this.cars = cars;
        this.maxCars = maxCars;
    }


}
