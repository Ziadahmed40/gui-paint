package backend;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class navigator implements DrawingEngine{
    private List<shape>shapes;
    private  String key="";
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
    public List<shape> getshapes() {
        return this.shapes;
    }

    @Override
    public void refresh(Graphics canvas) {
        Graphics2D g=(Graphics2D) canvas;
        g.clearRect(returnshape(this.key).getPosition().x,returnshape(this.key).getPosition().y, (int) returnshape(this.key).getindex1(), (int) returnshape(this.key).getindex2());

    }
}
