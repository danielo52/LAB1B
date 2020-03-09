public interface IObservable {

     void add(IObserver obs);

     void remove(IObserver obs);

     void notifyObs(int x, int y, ACar car);

     CarModel getModel();

}
