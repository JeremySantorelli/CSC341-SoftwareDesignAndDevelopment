package Assignment7;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * A virtual representation of a Racer that can run on a RaceTrack
 *
 * @author Jeremy Santorelli
 */
public final class GUIRacer implements Racer {

    private Point p;
    private int magnitude = 1;

    private boolean isWinner;

    private final String name;
    private BufferedImage img = null;
    private double speed;
    private final int finishlineDistance;

    private long start;
    private Rectangle bounds;

    public GUIRacer(String name, String imageLocation, double speed, int f) {
        try {
            this.img = ImageIO.read(new File(imageLocation));
        } catch (IOException ex) {
            Logger.getLogger(GUIRacer.class.getName()).log(Level.SEVERE, null, ex);
        }
        isWinner = false;
        start = 0;
        this.speed = speed;
        this.finishlineDistance = f - 400;
        this.name = name;
        if (this.bounds != null) {
            setPoint();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    @Override
    public void setPoint() {
        p = new Point();
        p.x = 0;
        p.y = bounds.y + (bounds.height - magnitude) / 2;
    }

    @Override
    public boolean isWinner() {
        return isWinner;
    }

    @Override
    public void run() {
        if (p.x < finishlineDistance) {
            speedController();
        } else {
            isWinner = true;
        }

    }

    @Override
    public int speedController() {
        long end = System.nanoTime();
        long inter = TimeUnit.SECONDS.convert(end - start, TimeUnit.NANOSECONDS);

        if (inter >= speed / 5) {
            start = end;
            p.x += speed;
        }
        return move();
    }

    @Override
    public Point getPoint() {
        return p;
    }

    @Override
    public int move() {

        if (p.x + magnitude >= (bounds.x + bounds.width)) {

            speed *= -1;
            p.x = ((bounds.x + bounds.width) - magnitude) + (int) speed;

        } else if (p.x <= bounds.x) {

            speed *= -1;
            p.x = bounds.x + (int) speed;

        }

        p.y = bounds.y + (bounds.height - magnitude) / 2;

        return (int) speed;

    }

    @Override
    public BufferedImage getImg() {
        return img;
    }

    @Override
    public boolean boundsSet() {
        return bounds == null;
    }

}
