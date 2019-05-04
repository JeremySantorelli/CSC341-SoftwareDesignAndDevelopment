package Assignment3.ShapeFactory;

/**
 * Allows for further factories to be added in the future (ex. 3dShapeBuilder)
 *
 * @author Jeremy Santorelli
 */
public abstract class ShapeFactory {

    public static ShapeFactory getFactory() {

        return new ShapeFactoryBuilder();

    }

    public abstract ShapeHolder getShape(String shapeType);
}
