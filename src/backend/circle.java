package backend;
import javax.xml.namespace.QName;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class circle extends AbstractShapeClass{

    private double radius;
    public circle(double x, double y, double radius,String name){
        setPosition(new Point((int) x, (int) y));
        this.radius=radius;
        setColor(Color.blue);
        setName(name);

    }
    @Override
    public void draw(Graphics canvas) {
        Graphics2D g=(Graphics2D) canvas;
        Ellipse2D.Double c=new Ellipse2D.Double(getPosition().x,getPosition().y,this.radius*2,this.radius*2);
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
        Point center=new Point((int) (point1.x+radius), (int) (point1.y+radius));
        if(point.distance(center)<radius)
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
