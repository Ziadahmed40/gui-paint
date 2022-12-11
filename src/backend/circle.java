package backend;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class circle extends AbstractShapeClass{
    private double width;
    private double length;

    public circle(double x, double y, double hradius,double vradius,String name){
        setPosition(new Point((int) x, (int) y));
        this.width=hradius;
        this.length=vradius;
        setColor(Color.blue);
        setName(name);
    }
    public circle(){

    }

    @Override
    public ArrayList<Integer> geter() {
        ArrayList<Integer> get = new ArrayList<>();
        get.add((int) this.width);
        get.add((int) this.length);
        return  get;
    }
    @Override
    public void draw(Graphics canvas) {
        Graphics2D g=(Graphics2D) canvas;
        Ellipse2D.Double c=new Ellipse2D.Double(getPosition().x - width/2, getPosition().y-length/2 ,this.width,this.length);
        if (super.getHelp().equals("")){
            g.setColor(getColor());
            g.draw(c);
        }
        if(super.getHelp().equals("border")){
            if(x){
                g.setColor(getFillColor());
                g.fill(c);
            }
            g.setColor(getColor());
            g.draw(c);
        }
        if (super.getHelp().equals("innerarea")){
            g.setColor(getFillColor());
            g.fill(c);
            g.setColor(getColor());
            g.draw(c);
            x=true;
        }
    }
    @Override
    public Point resize(Point corner, Point to) {
        Point[] points = points();

        int x = 0;
        int y = 0;

        int index = 0;

        if(corner.equals(points[0])) {
            x = corner.x - to.x;
            y = corner.y - to.y;
        }

        if(corner.equals(points[1])) {
            x = corner.x - to.x;
            y = to.y - corner.y;
            index = 1;
        }

        if(corner.equals(points[2])) {
            x = to.x - corner.x;
            y = corner.y - to.y;
            index = 2;
        }

        if(corner.equals(points[3])) {
            x = to.x - corner.x;
            y = to.y - corner.y;
            index = 3;
        }

        width = Math.abs(width + x);
        length = Math.abs(length + y);

        return points()[index];
    }

    @Override
    public boolean Contains(Point point) {
        Point point1=getPosition();
        Point center=new Point((int) (point1.x), (int) (point1.y));
        if(point.distance(center)<width&&point.distance(center)<length)
          return true;
        return false;
    }
    @Override
    public Point[] points() {
        Point point = new Point(
                getPosition()
        );

        int x = (int) width/2;
        int y = (int) length/2;

        return new Point[] {
                new Point(point.x - x, point.y - y), // Top Left
                new Point(point.x - x, point.y + y), // Bottom Left
                new Point(point.x + x, point.y - y), // Top Right
                new Point(point.x + x, point.y + y), // Bottom Right
        };
    }

    @Override
    public void moveTo(Point point){
        try {
            Point drag=GetDraggingPoint();
            point.x+=(getPosition().x-drag.x);
            point.y+=(getPosition().y-drag.y);
            setPosition(point);
        }catch (NullPointerException nullPointerException){}
    };
}
