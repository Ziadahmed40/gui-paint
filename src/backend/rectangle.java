import java.awt.*;

public class rectangle implements shape{
     private Point postion;
    private int length;
    private int width;
    rectangle(int x, int y , int length , int width){
        setPosition(new Point(x, y));
        this.length=length;
        this.width=width;
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
