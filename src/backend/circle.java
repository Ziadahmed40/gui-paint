package backend;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class circle extends AbstractShapeClass{
    private double horizontalradius;
    private double verticalradius;

    public circle(double x, double y, double hradius,double vradius,String name){
        setPosition(new Point((int) x, (int) y));
        this.horizontalradius=hradius;
        this.verticalradius=vradius;
        setColor(Color.blue);
        setName(name);
    }
    public circle(){

    }

    @Override
    public ArrayList<Integer> geter() {
        ArrayList<Integer> get = new ArrayList<>();
        get.add((int) this.horizontalradius);
        get.add((int) this.verticalradius);
        return  get;
    }
    @Override
    public void draw(Graphics canvas) {
        Graphics2D g=(Graphics2D) canvas;
        Ellipse2D.Double c=new Ellipse2D.Double(getPosition().x,getPosition().y,this.horizontalradius*2,this.verticalradius*2);
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
    public Point resize(Point CONRNER, Point p) {
        Point[] points=points();
        if (points[0].equals(CONRNER)) {
            horizontalradius=Math.abs(horizontalradius+(getPosition().x-p.x));
            verticalradius=Math.abs(verticalradius+(getPosition().y-p.y));
            setPosition(p);
            return points()[0];
        }
        if (points[1].equals(CONRNER)) {
            this.verticalradius=getPosition().y+verticalradius-p.y;
            this.horizontalradius=p.x-getPosition().x;
            setPosition(new Point(getPosition().x,p.y));
            return points()[1];
        }
        if (points[2].equals(CONRNER)) {
            this.verticalradius=p.y-getPosition().y;
            this.horizontalradius=getPosition().x+horizontalradius-p.x;
            setPosition(new Point(p.x,getPosition().y));
            return points()[2];

        }
        if (points[3].equals(CONRNER)) {
            this.horizontalradius=Math.abs(horizontalradius+(p.x-points[3].x));
            this.verticalradius=Math.abs(verticalradius+(p.y-points[3].y));
            return points()[3];
        }
        return null;

    }

    @Override
    public boolean Contains(Point point) {
        Point point1=getPosition();
        Point center=new Point((int) (point1.x+horizontalradius), (int) (point1.y+verticalradius));
        if(point.distance(center)<horizontalradius&&point.distance(center)<verticalradius)
          return true;
        return false;
    }

    @Override
    public Point[] points() {
        ArrayList<Point> p=new ArrayList<>();
        p.add(this.getPosition());
        p.add(new Point(this.getPosition().x, (int) (this.getPosition().y+verticalradius*2)));
        p.add(new Point((int) (this.getPosition().x+horizontalradius*2), this.getPosition().y));
        p.add(new Point((int) (this.getPosition().x+horizontalradius*2), (int) (this.getPosition().y+verticalradius*2)));

        return p.toArray(new Point[0]);
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
