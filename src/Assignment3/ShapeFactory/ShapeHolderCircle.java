package Assignment3.ShapeFactory;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author jerem
 */
public class ShapeHolderCircle implements ShapeHolder {

    @Override
    public Shape draw(int x, int y, int h, int v) {
        return new Ellipse2D.Float(x, y, h, v);
    }
}
