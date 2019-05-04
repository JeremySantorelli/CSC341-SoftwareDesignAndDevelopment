package Assignment7;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jeremy Santorelli
 */
public interface Racer {

    boolean boundsSet();

    BufferedImage getImg();

    String getName();

    Point getPoint();

    boolean isWinner();

    int move();

    void run();

    void setBounds(Rectangle bounds);

    void setPoint();

    int speedController();

}
