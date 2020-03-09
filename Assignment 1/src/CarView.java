import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends ViewFrame {
    private static final int X = 800; //800 på båda
    private static final int Y = 800;

    private static int x = 800;
    private static int y = 800; ;




    AnimationPanel drawPanel = new DrawPanel(x, y-240);
    //ControlPanel cPanel;
    CarControlPanel cPanel;
    AddRemoveCarPanel arcPanel;

    public static int getXCarView() {
        return X;
    }
    public int getYCarView() {
        return Y;
    }



    //Constructor for CarView w/o CarAndSpeedPanel
    public CarView(String framename, ControlPanel cPanel, AnimationPanel drawPanel, AddRemoveCarPanel arcPanel){
        super(framename, cPanel, drawPanel, x, y);
        this.arcPanel = arcPanel;
        //this.add(arcPanel);
        //arcPanel.setLocation(600,30);
        //initComponents(framename, cPanel, drawPanel);
        //drawPanel.setTimeList(timeList);

    }

    public AnimationPanel getAnimationPanel() {
        return drawPanel;
    }

    public ControlPanel getCPanel() {
        return cPanel;
    }

    public ControlPanel getControlPanel() {
        return cPanel;
    }








    //GARBAGE DAY

    // Constructor
    /*
    public CarView(String framename, ControlPanel cPanel, AnimationPanel drawPanel,
                   ControlPanel carAndSpeedPanel){
        super(framename, cPanel, drawPanel, x, y);
        //initComponents(framename, cPanel, drawPanel);
        //drawPanel.setTimeList(timeList);
        this.add(carAndSpeedPanel);
    }

     */

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    /*private void initComponents(String title, ControlPanel cPanel) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);
        this.add(cPanel);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

     */
}