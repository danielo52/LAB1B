import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;

public class Shop<T extends Transportable> {

    private int x;
    private int y;

    private int maxCars;
    private int currentCars = 0;
    private ArrayList<T> cars;
    private String shopName;


    /**
     * when we instansiate a Shop, we set the type of the arrayList to the same type as the Shop.
     * i.e. Shop<Volvo240> sets cars = ArrayList<Volvo240>
     *     x and y since a shop needs a position/location as well. No dir since it's not moving.
     */
    public Shop(int maxCars, String shopName, int x, int y) {
        this.cars = new ArrayList<T>();
        this.maxCars = maxCars;
        this.shopName = shopName;
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param car a car to bed added to the Transport. Can't load if Transport is full.
     */
    public void addCar(T car) {
            if(currentCars < maxCars) {
                cars.add(car);
                currentCars++;
            }
        }

    /**
     * Here we implement FILO - So if we want to remove a car, we remove the last one in the list. (-1 due to indexing).
     * it also
     */
    public T removeLastCar() {
            T t = cars.get(currentCars-1);
            cars.remove(currentCars-1);
            currentCars--;
            t.getParent().setX(getX() + 1);
            t.getParent().setY(getX() + 1);
            return t;
        }

    public int getMaxCars() {
        return maxCars;
    }

    public ArrayList getCars() {
            return cars;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String name) {
        shopName = name;
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



}
