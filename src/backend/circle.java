package backend;

import javax.xml.namespace.QName;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class circle implements shape {
    private String name="";
     private  Point postion;
    private double radius;
    private  Color colorcanvis;
    private  Color colorshape;
    private  String help="";
    private boolean x=false;
    public circle(double x, double y, double radius,String name){
        setPosition(new Point((int) x, (int) y));
        this.radius=radius;
        setColor(Color.blue);
        this.name=this.name.concat(name);
    }
    @Override
    public String getname() {
        return this.name;
    }

    @Override
    public double getindex1() {
        return this.radius*2;
    }

    @Override
    public double getindex2() {
        return this.radius*2;
    }

    @Override
    public void sethelp(String S) {
        this.help=S;
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
        return this.colorshape;
    }
    @Override
    public void draw(Graphics canvas) {
        Graphics2D g=(Graphics2D) canvas;
        Ellipse2D.Double c=new Ellipse2D.Double(getPosition().x,getPosition().y,this.radius*2,this.radius*2);
        if (this.help.equals("")){
            g.setColor(getColor());
            g.draw(c);
        }
        if(this.help.equals("border")){
            if(x){
                g.setColor(getFillColor());
                g.fill(c);
            }
            g.setColor(getColor());
            g.draw(c);
        }
        if (this.help.equals("innerarea")){
            g.setColor(getFillColor());
            g.fill(c);
            g.setColor(getColor());
            g.draw(c);
            x=true;
        }
    }



}
