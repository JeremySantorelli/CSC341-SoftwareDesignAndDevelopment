package Assignment3.ShapeFactory;

/**
 * Returns the appropriate ShapeHolder from shapeType Input
 *
 * @author Jeremy Santorelli
 */
public class ShapeFactoryBuilder extends ShapeFactory {

    @Override
    public ShapeHolder getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new ShapeHolderRectangle();
        } else if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new ShapeHolderCircle();
        } else if (shapeType.equalsIgnoreCase("TRIANGLE")) {
            return new ShapeHolderTriangle();
        }
        return null;
    }
}
