import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;



// This panel represent the animated part of the view with the car images.

public class DrawPanel extends AnimationPanel implements IObserver {

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a singel cars position
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    private IObservable observable;
    //private TimerListener timeList;

    // TODO: Make this genereal for all cars

    /**
     * moveVolvo, moveSaab and moveScania move their respective Car.
     * Uses 3 different methods because the cars should not all move in unison. These are implemented in
     * TimeListener.
     * @param x Coordinate
     * @param y Coordinate
     */
    void moveVolvo(int x, int y) {
        volvoPoint.x = x;
        volvoPoint.y = y;
    }

    void moveSaab(int x, int y) {
        saabPoint.x = x;
        saabPoint.y = y+100;
    }

    void moveScania(int x, int y) {
        scaniaPoint.x = x;
        scaniaPoint.y = y+200;
    }

    public void moveit(int x, int y, ACar car) {
        if(car.getClass() == Volvo240.class) {
            moveVolvo(x,y);
        } else if(car.getClass() == Saab95.class) {
            moveSaab(x,y);
        } else if(car.getClass() == Scania.class) {
            moveScania(x,y);
        } else {
            //nada
        }

    }

    public DrawPanel getDrawPanel() {
        return null;
    }

    public void setTimeList(IObservable observable) {
        this.observable = observable;
    }



    public void update(int x, int y, ACar car) {
        moveit(x,y,car);
        repaint();
        //this.timeList.actionPerformed();

    }

    public void subscribe(IObservable obs) {
        this.observable = obs;
    }

    public void unsubscribe(IObservable obs) {

    }

    public void tryAddImages() {
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));
        //Users/Daniel/IdeaProjects/dit953-vt20 LAB2BTest3/Assignment 1/src/View/pics/Saab95.jpg
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        super(x,y);
        //this.timeList = observable;

        //this.setDoubleBuffered(true); //drawing done in buffer, then copied to screen MOVED TO SUPER
        //this.setPreferredSize(new Dimension(x, y)); //sets the size MOVED TO SUPER
        this.setBackground(Color.LIGHT_GRAY); //color of backgrund...
        tryAddImages();


    }
    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
        g.drawImage(volvoImage, volvoPoint.x+40, volvoPoint.y+40, null);

    }
}
