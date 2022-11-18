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
    private  String help="";
    private boolean x=false;
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
         return this.colorshape;
    }
    @Override
    public void draw(Graphics canvas) {
        Graphics2D g=(Graphics2D) canvas;
        Rectangle2D.Double r= new Rectangle2D.Double(getPosition().x,getPosition().y,this.length,this.width);
        if (this.help.equals("")){
            g.setColor(getColor());
            g.draw(r);
        }
        if(this.help.equals("border")){
            if(x){
                g.setColor(getFillColor());
                g.fill(r);
            }
            g.setColor(getColor());
            g.draw(r);
        }
        if (this.help.equals("innerarea")){
            g.setColor(getFillColor());
            g.fill(r);
            g.setColor(getColor());
            g.draw(r);
        }
    }
    @Override
    public void sethelp(String S) {
       this.help=S;
    }
}
