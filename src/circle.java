import java.awt.*;

public class circle implements shape {
    private int x;
    private int y;
    private int radius;
    circle(int x,int y,int radius){
        this.x=x;
        this.y=y;
        this.radius=radius;
    }
    @Override
    public void setPosition(Point position) {
          position.x=this.x;
          position.y=this.y;
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
