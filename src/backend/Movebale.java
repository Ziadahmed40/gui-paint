package backend;

import java.awt.*;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface Movebale  {
    public void setDraggingPoint(Point point);
    public Point GetDraggingPoint();
    public boolean Contains(Point point);
    public void moveTo(Point point);
}
