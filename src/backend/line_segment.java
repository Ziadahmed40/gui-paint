package backend;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class line_segment implements shape {
    private  Point position;
    private String name="";
    private double x2;
    private double y2;
    private  Point p;
    private Point postion;
    private  Color colorcanvis;
    private  Color colorshape;
    public line_segment(double x1, double y1, double x2, double y2,String name){
         setPosition(new Point((int) x1, (int) y1));
      this.x2=x2;
      this.y2=y2;
        this.name=this.name.concat(name);
        setColor(Color.blue);
    }
    @Override
    public String getname() {
        return this.name;
    }

    @Override
    public double getindex1() {
        return this.y2;
    }

    @Override
    public double getindex2() {
        return this.x2;
    }


    @Override
    public void setPosition(Point position) {
     this.position=position;
    }
    @Override
    public Point getPosition() {
        return this.position;
    }
    @Override
    public void setColor(Color color) {
        this.colorcanvis=color;
    }
    @Override
    public Color getColor() {
        return this.colorcanvis;
    }
    @Override
    public void setFillColor(Color color) {
        this.colorshape=color;
    }
    @Override
    public Color getFillColor() {
        if(this.colorshape==null)
            return this.colorcanvis;
        else return this.colorshape;
    }
    @Override
    public void draw(Graphics canvas) {
        Graphics2D g=(Graphics2D) canvas;
        Line2D.Double l=new Line2D.Double(getPosition().x,getPosition().y,this.x2,this.y2);
        g.setColor(getFillColor());
        g.draw(l);
    }


}
