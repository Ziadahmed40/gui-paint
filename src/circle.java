import java.awt.*;

public class circle implements shape {
     private  Point postion;
    private int radius;
    circle(int x,int y,int radius){
        setPosition(new Point(x, y));
        this.radius=radius;
    }
    @Override
    public void setPosition(Point position) {
         this.postion=position;
    }
    @Override
    public Point getPosition() {
        return null;
    }
    @Override
    public void setColor(Color color) {

    }
    @Override
    public Color getColor() {
        return null;
    }
    @Override
    public void setFillColor(Color color) {

    }
    @Override
    public Color getFillColor() {
        return null;
    }
    @Override
    public void draw(Graphics canvas) {

    }
}
