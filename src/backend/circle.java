package backend;
import javax.xml.namespace.QName;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
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
    public boolean Contains(Point point) {
        Point point1=getPosition();
        Point center=new Point((int) (point1.x+horizontalradius), (int) (point1.y+verticalradius));
        if(point.distance(center)<horizontalradius&&point.distance(center)<verticalradius)
          return true;
        return false;
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
