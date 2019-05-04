package Assignment7;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * intializes application
 *
 * @author Jeremy Santorelli
 */
public class Startup {

    int finishlineDistance = 1100;
    RaceTrack whiteSquareSpeedway = null;

    public static void main(String[] args) {
        new Startup();
    }

    public Startup() {

        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName()
                );
            } catch (ClassNotFoundException | IllegalAccessException
                    | InstantiationException | UnsupportedLookAndFeelException ex) {
            }

            String turtleImgLocation = "Images\\turtle.png";
            String hareImgLocation = "Images\\rabbit.png";

            GUIRacer[] racers = {
                new GUIRacer("Hare", hareImgLocation, 45, finishlineDistance),
                new GUIRacer("Tortise", turtleImgLocation,
                10, finishlineDistance)
            };

            whiteSquareSpeedway = new RaceTrack(racers);

            JFrame frame = new JFrame("Assignment 7 - GUI >> Turtle & Hare");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(whiteSquareSpeedway);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            whiteSquareSpeedway.runRace();

        });

    }

}
