public interface IObserver {

    void update(int x, int y, ACar car);

    void subscribe(IObservable obs);

    void unsubscribe(IObservable obs);



}
