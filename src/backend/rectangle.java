package backend;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class rectangle implements shape  {
     private Point postion;
    private String name="";
    private double length;
    private double width;
    private  Color colorcanvis;
    private  Color colorshape;
    public rectangle(double x, double y, double length, double width,String name){
        setPosition(new Point((int) x, (int) y));
        this.length=length;
        this.width=width;
        this.name=this.name.concat(name);
        setColor(Color.blue);
    }
    @Override
    public String getname() {
        return this.name;
    }

    @Override
    public double getindex1() {
        return this.length;
    }

    @Override
    public double getindex2() {
        return this.width;
    }


    @Override
    public void setPosition(Point position) {
      this.postion=position;

    }
    @Override
    public Point getPosition() {
        return this.postion;
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
        Rectangle2D.Double r= new Rectangle2D.Double(getPosition().x,getPosition().y,this.length,this.width);
        g.setColor(getFillColor());
        g.fill(r);
    }


}
