import javax.swing.*;
import java.awt.*;

public class Application {

    public static void main(String[] args) {
        // Instance of this class





        //create TimerListener
        CarModel carMod = new CarModel();

        carMod.addCar(new Volvo240());
        carMod.addCar(new Saab95());
        carMod.addCar(new Scania());

        TimerListener timeList = new TimerListener(carMod);

        //Create ControlPanel, CarView, AnimationPanel
        CarControlPanel cPanel = new CarControlPanel();
        AnimationPanel drawPanel = new DrawPanel(800, 455);

        AddRemoveCarPanel arcPanel = new AddRemoveCarPanel();
        ControlPanel casPanel = new CarSpeedPanel(timeList);
        CarView carView = new CarView("CarSim 1.0", cPanel, drawPanel, arcPanel);
        carView.add(casPanel); //TODO nice.
        carView.setBackground(Color.LIGHT_GRAY);
        //subscribe to the Observable
        casPanel.subscribe(timeList);
        cPanel.subscribe(timeList);
        drawPanel.subscribe(timeList);

        //Add the observer(s)
        timeList.add(casPanel);
        timeList.add(cPanel);
        timeList.add(drawPanel);


        CarController cc = new CarController(carView, carMod, cPanel);
        //carView.subscribe(timeList);

        //Set the Timer in the CarController to: delay, and our TimerListener
        cc.setTimer(new Timer(cc.getDelay(), timeList));
        cc.getTimer().start();
    }


    /*
        ********** GARBAGE DAY **********

        //set TimerListeners CarView to carView
        //timeList.frame = carView;
        //add the observers
        //timeList.add(carView.drawPanel);
        // Start a new view and send a reference of self
        //cc.frame = new CarView("CarSim 1.0", cPanel);
        // Start the timer




     */
}
