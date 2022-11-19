package backend;
import java.awt.*;
import java.util.List;

public interface DrawingEngine {
        /* manage shapes objects */
       public void addShape(shape backend);
        public void removeShape(shape backend);
        /* return the created shapes objects */
        public  shape[] getshapes();
        /* redraw all shapes on the canvas */
        public void refresh(java.awt.Graphics canvas);

}
