import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddRemoveCarPanel extends ControlPanel {

    private static int totalCars; //Not the best solution, but it's a solution.

    private JPanel panel;
    private JButton addCarButton = new JButton("Add Car");
    private JButton removeCarButton = new JButton("Remove Car");
    private IObservable observable;

    public AddRemoveCarPanel() {
        initComps();
    }

    void addAddCarListener(ActionListener list) {
        addCarButton.addActionListener(list);
    }

    void addRemoveCarListener(ActionListener list) {
        removeCarButton.addActionListener(list);
    }

    void addGasSpinnerChanger(ChangeListener list) {

    }
    void addGasListener(ActionListener list) {
        //nada
    }

    void setGasAmount(int i) {

    }

    int getGasAmount() {
        return 0;
    }

    public void update(int x, int y, ACar car) {

    }

    public void subscribe(IObservable obs) {
        this.observable = obs;
    }

    public void unsubscribe(IObservable obs) {


    }

    private void initComps() {
        initControlPanel();
        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(70,70));
        this.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        panel.add(addCarButton, 0);
        panel.add(removeCarButton, 1);
        panel.setBackground(Color.LIGHT_GRAY);

    }
}
