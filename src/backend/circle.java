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
    public void seter(ArrayList<Integer> x) {
        this.horizontalradius=x.get(0);
        this.verticalradius=x.get(1);
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
//        Point[] point = points();
//        for (Point point1 : point) {
//            Rectangle2D.Double r= new Rectangle2D.Double(point1.x,point1.y,10,10);
//            g.setColor(Color.black);
//            g.fill(r);
//            g.draw(r);
//        }

    }

    @Override
    public Point resize(Point CONRNER, Point p) {
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
        p.add(new Point(this.getPosition().x, (int) (this.getPosition().y+verticalradius*2)-10));
        p.add(new Point((int) (this.getPosition().x+horizontalradius*2)-10, (int) (this.getPosition().y+verticalradius*2)-10));
        p.add(new Point((int) (this.getPosition().x+horizontalradius*2)-10, this.getPosition().y));
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
