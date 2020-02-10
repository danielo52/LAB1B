import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;

public class Shop<T extends Transportable> {

    int x;
    int y;

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

    public static void main(String[] args) {

        Volvo240 testVolvo = new Volvo240();
        Transportable oldVolvo = new Volvo240();
        Saab95 testSaab = new Saab95();
        int maxxad = 8;

        ArrayList<Volvo240> genericList = new ArrayList<>();

/* "TESTING" FOR ARRAY
        Shop newShop = new Shop(Volvo240.class,5);
        newShop.getCars()[0] = new Volvo240();
        newShop.getCars()[1] = new Volvo240();
        //newShop.getCars()[2] = new Saab95();
        System.out.println(newShop.getCars()[0]);
        System.out.println(newShop.getCars()[1]);

 */

        ArrayList<Volvo240> listy = new ArrayList<>();

        Shop<Volvo240> shopV = new Shop<>(maxxad, "Pelles bilverkstad", 15, 15);
        Shop<Transportable> shopp = new Shop<>(maxxad, "tester", 20, 20);

        shopV.addCar(testVolvo);
        System.out.println("Tetsting");
        System.out.println(shopV.removeLastCar().getParent().getY());




        //System.out.println(shopV.toString());

        Shop<Transportable> shopTrans = new Shop<>(10, "Pelles bilservice", 15, 19);




        //System.out.println(shopV.getCars().toString());


        //listy.add(testSaab);

/*
            GARBAGE DAY
                /*
    public Shop(Class<T> c, int max) {
        maxCars = max;
        final T[] a = (T[]) Array.newInstance(c,maxCars);
        this.cars = a;
    }


    public T[] getCars() {
        return cars;
    }

     */


    /*

    public Shop(ArrayList<T> acceptableCars, int maxCars) {
        this.cars = acceptableCars;
        this.maxCars = maxCars;

    }

     */

/*
    public Shop(ArrayList<Transportable> cars, int maxCars, ArrayList<Transportable> acceptableCars) {
        this.cars = cars;
        this.maxCars = maxCars;
        this.acceptableCars = acceptableCars;
    }

 */
/*
    public Shop(int maxCars, ArrayList<CarList> cars2) {
        this.maxCars = maxCars;

    }

 */
/*
    public boolean checkAcceptableVehicles(Transportable theCar) {
        if(theCar.getClass().equals(T))

}

 */
/*
    public boolean checkAcceptableVehicles(Transportable theCar) {
        for(Transportable t : acceptableCars) {
            if(t.getClass().equals(theCar.getClass())) {
                return true;
            }

        }
        return false;
    }

 */
//if(checkAcceptableVehicles(t)) { //ERROR HÄR
/*
    public void addCar(T car) {
            cars[currentCars] = car;
            currentCars++;
        }

 */
/*
public boolean checkAcceptableVehicles(Transportable theCar) {
    for(Transportable t : acceptableCars) {
        if(t.getClass().equals(theCar.getClass())) {
            return true;
        }






        ArrayList<Transportable> cars1 = new ArrayList<>();
        cars1.add(testVolvo);

        ArrayList<Transportable> acceptCars = new ArrayList<>();
        acceptCars.add(testSaab);





        //Shop testingNy = new Shop(maxxad,cars1);
        //testingNy.addCar(oldVolvo);







        ArrayList<Volvo240> testList = new ArrayList<>();
        ArrayList<Transportable> testListTrans = new ArrayList<>();
        System.out.println(testSaab.getClass());

        testListTrans.add(testVolvo);
        testListTrans.add(testSaab);










        Shop nyaShoppen = new Shop(testList, maxxad);

        Shop nyShop = new Shop(testList, maxxad);

        ArrayList<Saab95> listSaab = new ArrayList<>();

        Shop saabShop = new Shop(listSaab, maxxad);


/*
        public void addCar(Volvo240 car) {
            if(currentCars < maxCars) {
                cars.add(car);
                currentCars++;
            }
        }

        public void addCar(Saab95 car) {
            if(currentCars < maxCars) {
                cars.add(car);
                currentCars++;
            }
        }

 */

        /*
        Shop nyShop = new Shop(testList, maxxad);
        Shop nyShop2 = new Shop();
        nyShop.getCars().add(testVolvo);
        nyShop.getCars().add(testSaab);
        System.out.println(nyShop.getCars().toString());

        nyShop2.getCars().add(testSaab);
        System.out.println(nyShop2.getCars().toString());


/*
    public T add(T element){
        cars.add(element);
        return element;
    }

 */














    }



}
