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
    public void seter(ArrayList<Integer> x) {
        this.length=x.get(0);
        this.width=x.get(1);
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
        Point[] points = points();

        int x = 0;
        int y = 0;

        int index = 0;

        if(corner.equals(points[0])) {
            x = corner.x - p.x;
            y = corner.y - p.y;
        }

        if(corner.equals(points[1])) {
            x = corner.x - p.x;
            y = p.y - corner.y;
            index = 1;
        }

        if(corner.equals(points[2])) {
            x = p.x - corner.x;
            y = corner.y - p.y;
            index = 2;
        }

        if(corner.equals(points[3])) {
            x = p.x - corner.x;
            y = p.y - corner.y;
            index = 3;
        }

        length= Math.abs(length+ x);
         width = Math.abs(width + y);

        return points()[index];
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
        p.add(new Point((int) (this.getPosition().x+length)-5, (int) (this.getPosition().y+width)-5));
        p.add(new Point((int) (this.getPosition().x+length)-5, this.getPosition().y-5));
        return p.toArray(new Point[0]);
    }
}
