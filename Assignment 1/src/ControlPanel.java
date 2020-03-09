import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class ControlPanel extends JPanel implements IObserver {

    JPanel controlPanel = new JPanel();
    private IObservable timeList;
    ActionListener listener;

    public ControlPanel() {
        initControlPanel();
    }

    public void setTimeList(IObservable timeList) {
        this.timeList = timeList;
    }

    public ControlPanel(TimerListener listener) {
        initControlPanel();
        this.listener = listener;

    }

    abstract void addGasListener(ActionListener list);
    abstract void addGasSpinnerChanger(ChangeListener list);
    abstract void setGasAmount(int i);
    abstract int getGasAmount();
    /**
     * This feels like a "general" type of spinnerModel. Therefore we put it in the superclass.
     */
    /*
    SpinnerModel spinnerModel =
            new SpinnerNumberModel(0, //initial value
                    0, //min
                    100, //max
                    1);//step

     */

    public void initControlPanel() {
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            //this.add(controlPanel);
        }


}




