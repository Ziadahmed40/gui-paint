package backend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class navigator extends JPanel implements DrawingEngine{
    private List<shape>shapes;
    private  String key="";

    private Point[] points = {};

    public navigator(){
        this.shapes=new ArrayList<>();
    }
    public void setKey(String key) {
        this.key=this.key.concat(key);
    }
    public void resetkey(){
        this.key="";
    }
    public  shape returnshape(String s){
        for (int i = 0; i < this.shapes.size(); i++) {
            if(shapes.get(i).getname().equals(s)){
                return shapes.get(i);
            }
        }
        return null;
    }
    @Override
    public void addShape(shape nav) {
      this.shapes.add(nav);
    }
    @Override
    public void removeShape(shape nav) {
     this.shapes.removeIf(shape->shape.getname().equals(this.key));
    }

    @Override
    public  shape[] getshapes() {
        return this.shapes.toArray(new shape[0]);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (shape s: shapes) {
            s.draw(g);
        }

        for (Point point: points) {
            g.setColor(Color.black);
            g.fillRect(point.x-5, point.y-5, 10, 10);
        }
    }

    public void setPoints(Point[] points) {
        this.points = points;

        refresh();
    }

    @Override
    public void refresh(Graphics canvas) {
        this.repaint();
    }

    public void refresh() {
        this.refresh(null);
    }
}
