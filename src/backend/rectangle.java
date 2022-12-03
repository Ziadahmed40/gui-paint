package backend;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

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
    public boolean Contains(Point point) {
        Rectangle2D.Double r= new Rectangle2D.Double(getPosition().x,getPosition().y,this.length,this.width);
            return r.contains(point);
    }
    @Override
    public void moveTo(Point point){
        setPosition(point);
    };

}
