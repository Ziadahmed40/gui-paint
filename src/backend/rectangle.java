package backend;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class rectangle  extends AbstractShapeClass  {
    private double length;
    private double width;

    public rectangle(double x, double y, double length, double width,String name){
        setPosition(new Point((int) x, (int) y));
        this.length=length;
        this.width=width;
        setName(name);
        setColor(Color.blue);
    }
    public rectangle(){

    }
    @Override
    public ArrayList<Integer> geter() {
        ArrayList<Integer> get = new ArrayList<>();
        get.add((int) this.length);
        get.add((int) this.width);
        return  get;
    }
    @Override
    public void draw(Graphics canvas) {
        Graphics2D g=(Graphics2D) canvas;
        Rectangle2D.Double r= new Rectangle2D.Double(getPosition().x,getPosition().y,this.length,this.width);

        if (super.getHelp().equals("")){
            g.setColor(getColor());
            g.draw(r);
        }
        if(super.getHelp().equals("border")){
            if(x){
                g.setColor(getFillColor());
                g.fill(r);
            }
            g.setColor(getColor());
            g.draw(r);
        }
        if (super.getHelp().equals("innerarea")){
            g.setColor(getFillColor());
            g.fill(r);
            g.setColor(getColor());
            g.draw(r);
            x=true;
        }
    }

    @Override
    public Point resize(Point corner, Point p) {
        Point[] points=points();
        if (points[0].equals(corner)) {
            length=Math.abs(length+(getPosition().x-p.x));
            width=Math.abs(width+(getPosition().y-p.y));
            setPosition(p);
            return points()[0];
        }
        if (points[1].equals(corner)) {
            this.length=Math.abs(length+(corner.x-p.x));
            this.width=Math.abs(width+(p.y-corner.y));

            return points()[1];
        }
        if (points[2].equals(corner)) {
            this.length=Math.abs(length+(p.x-corner.x));
            this.width=Math.abs(width+(corner.y-p.y));
            return points()[2];

        }
        if (points[3].equals(corner)) {
            this.length=Math.abs(length+(p.x-points[3].x));
            this.width=Math.abs(width+(p.y-points[3].y));
            return points()[3];
        }
        return null;
    }


    @Override
    public boolean Contains(Point point) {
        Rectangle2D.Double r= new Rectangle2D.Double(getPosition().x,getPosition().y,this.length,this.width);
            return r.contains(point);
    }
    @Override
    public void moveTo(Point point){
        try {
            Point drag=GetDraggingPoint();
            point.x+=(getPosition().x-drag.x);
            point.y+=(getPosition().y-drag.y);
            setPosition(point);
        }catch (NullPointerException N){}
    };
    public Point[] points(){
        ArrayList<Point> p=new ArrayList<>();
        p.add(new Point(this.getPosition().x-5, this.getPosition().y-5));
        p.add(new Point(this.getPosition().x-5, (int) (this.getPosition().y+width)-5));
        p.add(new Point((int) (this.getPosition().x+length)-5, this.getPosition().y-5));
        p.add(new Point((int) (this.getPosition().x+length)-5, (int) (this.getPosition().y+width)-5));
        return p.toArray(new Point[0]);
    }
}
