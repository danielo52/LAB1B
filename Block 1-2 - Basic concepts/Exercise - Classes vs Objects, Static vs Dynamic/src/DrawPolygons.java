import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DrawPolygons extends Component{
    private ArrayList<String> polygonNames;
    private ArrayList<Point>  centerPoints;

    public DrawPolygons(){
        polygonNames = new ArrayList<>(10);
        centerPoints = new ArrayList<>(10);

        polygonNames.add("square");
        polygonNames.add("triangle");
        polygonNames.add("rectangle");


        centerPoints.add(new Point(100,100));
        centerPoints.add(new Point(150,150));
        centerPoints.add(new Point(100,200));

    }//constructor

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < polygonNames.size(); i++) {
            String currentPolygon = polygonNames.get(i);
            Point currentCenter = centerPoints.get(i);
            if (currentPolygon.equals("square"))
                g.drawRect(currentCenter.x -10, currentCenter.y -10, 20, 20);
            else if (currentPolygon.equals("triangle")) {
                g.drawLine(currentCenter.x, currentCenter.y-10, currentCenter.x-10, currentCenter.y+10);
                g.drawLine(currentCenter.x-10, currentCenter.y+10,
                        currentCenter.x+10, currentCenter.y+10);
                g.drawLine(currentCenter.x+10, currentCenter.y+10, currentCenter.x, currentCenter.y-10);
            } else if (currentPolygon.equals("rectangle"))
                g.drawRect(currentCenter.x -20, currentCenter.y -10, 40, 20);
        }
    }//paint

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawPolygons polygons = new DrawPolygons();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(30,30,300,300);
        frame.getContentPane().add(polygons);
        frame.setVisible(true);

    }//main

}//DrawPolygons