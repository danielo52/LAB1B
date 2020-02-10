

public interface ITransporters {

    public boolean isIdle();

    public void loadCar(Transportable carLoad);

    public void unloadCar();

    public boolean isInVicinity(Transportable c);


}
