import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ferry  {


    private CarTransport parent;

    /*
    private boolean rampDown;
    private ArrayList<Transportable> transports;
    private int maxLoad;
    private int currentLoad;
     */
    int nrLanterns;
    int totalCrew;

//int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int x, int y, int dir

    public Ferry(CarTransport parent, int nrLanterns, int totalCrew) {
        this.parent = parent;
        this.nrLanterns = nrLanterns;
        this.totalCrew = totalCrew;
    }

    public Ferry() {

    }


    public int getNrLanterns() {
        return nrLanterns;
    }

    public void setNrLanterns(int nrLanterns) {
        this.nrLanterns = nrLanterns;
    }

    public int getTotalCrew() {
        return totalCrew;
    }

    public void setTotalCrew(int totalCrew) {
        this.totalCrew = totalCrew;
    }
/*
    public boolean isIdle() {

    }

 */

    public void loadCar(Transportable carLoad) {

    }

    public void unloadCar() {

    }
/*
    public boolean isInVicinity(Transportable c) {

    }

    public boolean isRampDown() {

    }

 */


}
