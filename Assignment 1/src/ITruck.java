
public interface ITruck  {


    boolean isIdle();

    void incrementAngle(int amount);

    void decrementAngle(int amount);

    void raiseBed();

    void lowerBed();

    boolean isBedDown();






    /*
    Methods that all MotorVehicles should implement

    -setEnginePower
    -incrementSpeed
    -decrementSpeed
    -getModelName, (setmodelName)
    - maybe more

    MotorVehicle extends Movable since all MotorVehicles are Movable.

     */



}
