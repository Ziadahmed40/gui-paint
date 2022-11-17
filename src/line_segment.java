import java.awt.*;

public class line_segment implements shape{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private  Point p;
    line_segment(int x1,int x2,int y1,int y2){
      this.x1=x1;
      this.x2=x2;
      this.y1=y1;
      this.y2=y2;
    }
    @Override
    public void setPosition(Point position) {
       p.x=this.x1;
       p.y=this.y1;
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
