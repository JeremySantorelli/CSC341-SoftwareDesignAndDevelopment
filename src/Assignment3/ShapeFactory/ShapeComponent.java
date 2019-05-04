package Assignment3.ShapeFactory;

import javax.swing.JComponent;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Shape;
import java.util.List;

/**
 * The JComponent that draws the list of shapes
 *
 * @author Jeremy Santorelli
 */

public class ShapeComponent extends JComponent {

    private final List<Shape> shapes;

    public ShapeComponent(List<Shape> shapes1) {
        shapes = shapes1;
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        shapes.forEach((shape) -> {
            g2.draw(shape);
        });

    }
}
