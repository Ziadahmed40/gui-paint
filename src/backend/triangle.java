package backend;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class triangle extends AbstractShapeClass  {
    private Point point2;
    private Point point3;

    public triangle(double x, double y, double x2, double y2,double x3, double y3,String name){
        setPosition(new Point((int) x, (int) y));
        point2=new Point((int) x2, (int) y2);
        point3=new Point((int) x3, (int) y3);
        setName(name);
        setColor(Color.blue);
    }
    public  triangle(){

    }
    @Override
    public ArrayList<Integer> geter() {
        ArrayList<Integer> get = new ArrayList<>();
        get.add((int) this.point2.getX());
        get.add((int) this.point2.getY());
        get.add((int) this.point3.getX());
        get.add((int) this.point3.getY());
        return  get;
    }
    @Override
    public void draw(Graphics canvas) {
        Graphics2D g=(Graphics2D) canvas;
         Polygon tri=new Polygon(new int[]{getPosition().x,point2.x,point3.x},new int[]{getPosition().y,point2.y,point3.y},3);
        if (super.getHelp().equals("")){
            g.setColor(getColor());
            g.draw(tri);
        }
        if(super.getHelp().equals("border")){
            if(x){
                g.setColor(getFillColor());
                g.fill(tri);
            }
            g.setColor(getColor());
            g.draw(tri);
        }
        if (super.getHelp().equals("innerarea")){
            g.setColor(getFillColor());
            g.fill(tri);
            g.setColor(getColor());
            g.draw(tri);
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
        Point[] points=points();
        if (points[0].equals(CONRNER)) {
            setPosition(p);
            return points()[0];
        }
        if (points[1].equals(CONRNER)) {
            point2=p;
            return points()[1];

        }
        if (points[2].equals(CONRNER)) {
            point3=p;
            return points()[2];
        }
        return null;
    }

    private double sign(Point p1, Point p2, Point p3) {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
    }
    @Override
    public boolean Contains(Point point) {
        Point[] points = {getPosition(),point2,point3};
        double d1, d2, d3;
        boolean hasNegative, hasPositive;
        d1 = sign(point, points[0], points[1]);
        d2 = sign(point, points[1], points[2]);
        d3 = sign(point, points[2], points[0]);
        hasNegative = (d1 < 0) || (d2 < 0) || (d3 < 0);
        hasPositive = (d1 > 0) ||(d2 > 0) || (d3 > 0);
        return !(hasNegative && hasPositive);
    }

    @Override
    public Point[] points() {
        ArrayList<Point> p=new ArrayList<>();
        p.add(new Point(this.getPosition().x,this.getPosition().y));
        p.add(new Point(this.point2.x,this.point2.y));
        p.add(new Point(this.point3.x,this.point3.y));
        return p.toArray(new Point[0]);
    }

    @Override
    public void moveTo(Point point){
        try {
            Point drag=GetDraggingPoint();
            Point oldPoint = getPosition();
            point.x+=(getPosition().x-drag.x);
            point.y+=(getPosition().y-drag.y);
            int x = point.x - oldPoint.x;
            int y = point.y - oldPoint.y;
            point2.x=point2.x+x;
            point3.x=point3.x+x;
            point2.y=point2.y+y;
            point3.y=point3.y+y;
            setPosition(point);
        }catch (NullPointerException n){}

    };
}
