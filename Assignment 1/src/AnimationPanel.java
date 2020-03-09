import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class AnimationPanel extends JPanel implements IObserver {

    private ArrayList images;
    private ArrayList positions;

    private IObservable timeList;

    public ArrayList<BufferedImage> createImageList() {
        images = new ArrayList<BufferedImage>();
        return images;
    }

    public ArrayList createPositionList() {
        positions = new ArrayList<Point>();
        return positions;
    }
    public void setTimeList(IObservable timeList) {
        this.timeList = timeList;
    }

    public AnimationPanel() {

    }
    public AnimationPanel(int x, int y) {
        this.setDoubleBuffered(true); //drawing done in buffer, then copied to screen
        this.setPreferredSize(new Dimension(x, y)); //sets the size

    }







}
