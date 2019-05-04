package Assignmentt10;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * intializes application
 * 
 *  "MMddyyyyHHmm"
 *
 * @author Jeremy Santorelli
 */
public class Startup {

    StudentInterface si = null;

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


            si = new StudentInterface();

            JFrame frame = new JFrame("Assignment 10 - GUI >> Student Sleep Notifier");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(si);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setBounds(100, 100, 200, 400);

            si.run();

        });

    }

}
