import javax.swing.*;
import java.awt.*;


public abstract class ViewFrame extends JFrame {

    private int x;
    private int y;

    AnimationPanel drawPanel;
    ControlPanel cPanel;


    public ViewFrame(String title, ControlPanel cPanel, AnimationPanel drawPanel, int x, int y) {
        initComponents(title, cPanel, drawPanel, x, y);
        this.cPanel = cPanel;
        this.drawPanel = drawPanel;
        this.x = x;
        this.y = y;

    }

    public abstract ControlPanel getCPanel();

    protected void initComponents(String title, ControlPanel cPanel, AnimationPanel drawPanel, int x, int y) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(x,y));
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

}
