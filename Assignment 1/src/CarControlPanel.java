import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarControlPanel extends ControlPanel  {

    // The controller member

    IObservable timeList;
    IObservable obs;

    //JPanel controlPanel = new JPanel();

    private IObservable observable;
    private ControlPanel arcPanel;


    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JPanel brakePanel = new JPanel();
    JSpinner brakeSpinner = new JSpinner();
    int brakeAmount = 0;
    JLabel brakeLabel = new JLabel("Amount braking");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Scania Lower Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");


/*
    public void add() {
        super.add(this);
    }

 */
    public void setGasAmount(int i) {
        this.gasAmount = i;
    }
    public int getGasAmount() {
        return gasAmount;
    }

    public int getBrakeAmount() {
        return brakeAmount;
    }

    public void subscribe(IObservable obs) {
        observable = obs;

    }

    public void unsubscribe(IObservable obs) {

    }

    public void update(int x, int y, ACar car) {
        //nada
    }


    // Constructor
    public CarControlPanel() {
        initComponents();

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

    }


    void addGasListener(ActionListener list) {
        gasButton.addActionListener(list);
    }
    void addBrakeListener(ActionListener list) {
        brakeButton.addActionListener(list);
    }

    void addStopCarsListener(ActionListener list) {
        stopButton.addActionListener(list);
    }

    void addStartCarsListener(ActionListener list) {
        startButton.addActionListener(list);
    }

    void addTurboOnListener(ActionListener list) {
        turboOnButton.addActionListener(list);
    }
    void addTurboOffListener(ActionListener list) {
        turboOffButton.addActionListener(list);
    }
    void addLiftBedListener(ActionListener list) {
        liftBedButton.addActionListener(list);
    }

    void addLowerBedListener(ActionListener list) {
        lowerBedButton.addActionListener(list);
    }

    void addGasSpinnerChanger(ChangeListener list) {
        gasSpinner.addChangeListener(list);
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents() {
        //initControlPanel();
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step


        gasSpinner = new JSpinner(spinnerModel);

/*
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

 */
/*
        brakeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                brakeAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

 */

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));


        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((CarView.getXCarView()/2)+4, 200)); //(X/2)+4 -> (X)+4
        this.add(controlPanel);
        controlPanel.setBackground(Color.LIGHT_GRAY);

        arcPanel = new AddRemoveCarPanel();
        this.add(arcPanel);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(CarView.getXCarView()/6-15,100));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(CarView.getXCarView()/6-15,100));
        this.add(stopButton);



        //GARBAGE, moved most of these to Controller.



        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
/*
        void addGasListener(ActionListener listenForGasButton) {
                gasButton.addActionListener(listenForGasButton);
        }

 */
        /*
        void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage)
        }
         */




/*
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeList.getModel().gas(gasAmount);
            }
        });

 */
/*
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeList.getModel().brake(brakeAmount);
            }
        });

 */
/*
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeList.getModel().setTurboOn();
            }
        });

 */
/*
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeList.getModel().setTurboOff();
            }
        });

 */
/*
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeList.getModel().stopCars();
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeList.getModel().startCars();
            }
        });

 */
        /*
        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeList.getModel().raiseBed();
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeList.getModel().lowerBed();
            }
        });

         */
    }


}
