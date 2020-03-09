import com.sun.jdi.VoidValue;

import java.awt.*;
import java.awt.image.ConvolveOp;
import java.util.ArrayList;

public class RandomCarFactory implements ACarFactory {

    /*
    Thought: Might want to Create an Abstract Factory Pattern that has methods createCar & createPoint...
    We could have VolvoPoint, SaabPoint & ScaniaPoint --> We put these in a List in DrawPanel, then cycle through them
    when we move (would need to keep the conditionals).
    So a VolvoFactory would then contain: createCar which returns a new Volvo240, and createPoint which returns a new VolvoPoint
        Same with SaabFactory and ScaniaFactory.
        Could we then possibly put the ACar in the cars list? (used by the model) and the Volvo/Saab/ScaniaPoints in DrawPanel.

     */
    ArrayList<ACar> possibleCars;

    public RandomCarFactory() {

    }

    public RandomCarFactory(ArrayList<ACar> possibleCars) {
        this.possibleCars = possibleCars;
    }

    public Point createPoint() {
        return new Point();
    }

    public ACar createVolvo() {
        ACar newCar = new Volvo240();
        return newCar;
    }

    public ACar createSaab() {
        ACar newCar = new Saab95();
        return newCar;
    }

    public ACar createScania() {
        ACar newCar = new Scania();
        return newCar;
    }


    public ACar createCar(int decider) {
        ACar newCar;
        if(decider == 0) {
            newCar = new Volvo240();
            return newCar;
        } else if(decider == 1) {
            newCar = new Saab95();
            return newCar;
        } else if (decider == 2) {
            newCar = new Scania();
            return newCar;
        } else {
            System.out.println("Could not add additional car.");
        }
        return null;
    }


}
