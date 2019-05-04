package Assignment3.ShapeFactory;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 *
 * @author jerem
 */
public class ShapeHolderTriangle implements ShapeHolder {

    @Override
    public Shape draw(int x, int y, int h, int v) {

        return new TriangleShape(
                new Point2D.Double(h + x, 0 + y),
                new Point2D.Double(h + x, v + y),
                new Point2D.Double(0 + x, v + y)
        );
    }

    class TriangleShape extends Path2D.Double {

        public TriangleShape(Point2D... points) {
            moveTo(points[0].getX(), points[0].getY());
            lineTo(points[1].getX(), points[1].getY());
            lineTo(points[2].getX(), points[2].getY());
            closePath();
        }

    }
}
