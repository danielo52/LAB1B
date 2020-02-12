/*
Interface for Cars that are transportable.
 */

public interface Transportable {



    LandVehicle getParent();

    void setIsLoadedTrue();

    void setIsLoadedFalse();

    boolean getIsLoaded();

}
