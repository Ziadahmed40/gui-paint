import java.awt.*;

public class rectangle implements shape{
    private int x;
    private int y;
    private int length;
    private int width;
    rectangle(int x, int y , int length , int width){
        this.x=x;
        this.y=y;
        this.length=length;
        this.width=width;
    }
    @Override
    public void setPosition(Point position) {
        position.y=this.y;
        position.x=this.x;

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
