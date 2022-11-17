import backend.shape;
import java.awt.*;

public interface DrawingEngine {
        /* manage shapes objects */
       // public void addShape(Shape backend.shape);
       // public void removeShape(Shape backend.shape);
        /* return the created shapes objects */
        public Shape[] getShapes();
        /* redraw all shapes on the canvas */
        public void refresh(java.awt.Graphics canvas);

}
