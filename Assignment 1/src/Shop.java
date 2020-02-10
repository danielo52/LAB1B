import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;

public class Shop<T> {

    //public ArrayList cars;
    private int maxCars;
    private int currentCars = 0;
    private Class c;
    T t;
    ArrayList<T> cars = new ArrayList<>();
    //ArrayList<T> acceptableCars;

    T[] cars2;
    //CarList.getList(c);
    public Shop(int maxCars) {
        this.cars = new ArrayList<T>();
        this.maxCars = maxCars;
    }




    public T add(T element){
        cars.add(element);
        return element;
    }
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

 */


        public void addCar(T car) {
            if(currentCars < maxCars) {
                cars.add(car);
                currentCars++;
            }
        }

        public void removeLastCar() {
            cars.remove(currentCars);
            currentCars--;
        }
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


    public void removeCar(Transportable t) {


    }

    public int getMaxCars() {
        return maxCars;
    }

    public ArrayList getCars() {
            return cars;
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
        Shop<Volvo240> shopV = new Shop(maxxad);
        shopV.add(testVolvo);
        shopV.removeLastCar();
        System.out.println(shopV.toString());



        System.out.println(shopV.getCars().toString());


        //listy.add(testSaab);

/*
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






/*
        Shop nyaShoppen = new Shop(testList, maxxad);

        Shop nyShop = new Shop(testList, maxxad);

        ArrayList<Saab95> listSaab = new ArrayList<>();

        Shop saabShop = new Shop(listSaab, maxxad);

 */


















        /*
        Shop nyShop = new Shop(testList, maxxad);
        Shop nyShop2 = new Shop();
        nyShop.getCars().add(testVolvo);
        nyShop.getCars().add(testSaab);
        System.out.println(nyShop.getCars().toString());

        nyShop2.getCars().add(testSaab);
        System.out.println(nyShop2.getCars().toString());

         */







    }



}
