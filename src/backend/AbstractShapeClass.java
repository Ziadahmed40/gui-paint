package backend;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public abstract class AbstractShapeClass implements Movebale,shape{
    private Point postion;
    private Point DraggingPoint;
    private String name="";
    private  Color colorcanvis;
    private  Color colorshape;
    private  String help="";
    public boolean x=false;
    @Override
    public String getname() {
        return this.name;
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
  public abstract ArrayList<Integer>geter();
    public abstract void draw(Graphics canvas) ;
    @Override
    public void sethelp(String S) {
        this.help=S;
    }

    public void setName(String x) {
        this.name=this.name.concat(x);
    }

    public String getHelp() {
        return this.help;
    }
    @Override
    public void setDraggingPoint(Point point) {
          this.DraggingPoint=point;
    }
    @Override
    public Point GetDraggingPoint(){
        return this.DraggingPoint;
    }
    public abstract boolean Contains(Point point);

    public void moveTo(Point point){};
}
