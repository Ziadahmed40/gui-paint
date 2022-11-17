import java.awt.*;

public class line_segment implements shape{
    private  Point position;
    private int x2;
    private int y2;
    private  Point p;
    line_segment(int x1,int x2,int y1,int y2){
         setPosition(new Point(x1,y1));
      this.x2=x2;

      this.y2=y2;
    }
    @Override
    public void setPosition(Point position) {
     this.position=position;
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
