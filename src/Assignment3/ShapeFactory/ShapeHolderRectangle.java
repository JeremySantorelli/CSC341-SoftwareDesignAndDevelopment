package Assignment3.ShapeFactory;

import java.awt.Rectangle;
import java.awt.Shape;

/**
 * Returns a Rectangle ShapeHolder
 *
 * Note to Professor: I did not add the other ShapeHolders to save paper. They
 * look just like this one but return the appropriate shape
 *
 * @author Jerermy Santorelli
 */
public class ShapeHolderRectangle implements ShapeHolder {

    @Override
    public Shape draw(int x, int y, int h, int v) {
        return new Rectangle(x, y, h, v);
    }
}
