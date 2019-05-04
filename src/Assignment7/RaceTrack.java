package Assignment7;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A virtual representation of a race track.
 *
 * @author Jeremy Santorelli
 */
public class RaceTrack extends JPanel {
    
    JLabel message;

    Racer[] racer;
    boolean raceRunning = false;
    private Timer timer;

    public RaceTrack(GUIRacer[] racer) {

        this.racer = racer;

        message = new JLabel("Race Running");

    }

    public boolean runRace() {
        this.add(message);
        timer = new Timer(40, (ActionEvent e) -> {
            for (Racer r : racer) {
                if (r.boundsSet()) {
                    r.setBounds(getTrack());
                    r.setPoint();
                }
                r.run();
                if (r.isWinner()) {
                    message.setText(r.getName() + " is the Winner!");
                    timer.stop();
                } else {
                    raceRunning = true;
                }
            }
            repaint();
        });

        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
        return raceRunning;
    }

    private Rectangle getTrack() {
        return new Rectangle(new Point(0, 0), getPreferredSize());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1100, 1000);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int lanePoint = 0;
        for (int i = 0; i < racer.length; i++) {
            if (racer[i].getImg() != null && racer[i].getPoint() != null) {
                Point p = racer[i].getPoint();
                g.drawImage(racer[i].getImg(), p.x, p.y - lanePoint, null);
                lanePoint += 400;
            }
        }
    }

}
