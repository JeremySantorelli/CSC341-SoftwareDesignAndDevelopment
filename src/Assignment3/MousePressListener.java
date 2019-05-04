package Assignment3;

import Assignment3.ShapeFactory.ShapeHolder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Manages the ShapeFactory, ShapeList, and repaint when Canvas is clicked
 *
 * @author Jeremy Santorelli
 */
public class MousePressListener extends AppMain implements MouseListener {

    @Override
    public void mousePressed(MouseEvent event) {

        int x = event.getX();
        int y = event.getY();

        ShapeHolder shape = shapeFactory.getShape(shapeName);
        setShape(shape.draw(x, y, horizontal, vertical));
        component.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
