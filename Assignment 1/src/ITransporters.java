public interface ITransporters {

     boolean isIdle();

     boolean isRampDown();

     void loadCar(Transportable carLoad);

     Transportable unloadCar();

     boolean isInVicinity(Transportable c);






}
