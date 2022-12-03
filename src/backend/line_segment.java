package backend;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
public class line_segment extends AbstractShapeClass {
    private Point point2;
    public line_segment(double x1, double y1, double x2, double y2,String name){
         setPosition(new Point((int) x1, (int) y1));
         point2=new Point((int)x2,(int) y2);
        setName(name);
        setColor(Color.blue);
    }
    @Override
    public void draw(Graphics canvas) {
        Graphics2D g=(Graphics2D) canvas;
        Line2D.Double l=new Line2D.Double(getPosition().x,getPosition().y,point2.x,point2.y);
        if(super.getHelp().equals("")||super.getHelp().equals("border")){
            g.setColor(getColor());
            g.draw(l);
        }
        if (super.getHelp().equals("innerarea")){
            g.setColor(getFillColor());
            g.draw(l);
        }
    }
    @Override
    public boolean Contains(Point point) {
        Point startPoint = getPosition();
        Point endPoint = new Point(point2.x, point2.y);
        double lineLength = startPoint.distance( endPoint);
        double lengthFromPoint = startPoint.distance(point) + endPoint.distance(point);
        return Math.abs(lengthFromPoint - lineLength) <= 2;
    }
    @Override
    public void moveTo(Point point){
        Point oldPoint = getPosition();
        int x = point.x - oldPoint.x;
        int y = point.y - oldPoint.y;
        point2.x=point2.x+x;
        point2.y=point2.y+y;
        setPosition(point);
    };
}
