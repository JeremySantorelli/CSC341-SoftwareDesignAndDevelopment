package Assignmentt10;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class NotifierGUI implements Notifier {

    @Override
    public void notify(int type) {
        String msg = "";

        switch (type) {

            case 0:
                msg = "It is Time to wake Up!!";
                break;
            case 1:
                msg = "WARNING: It would be who of you to get to sleep soon";
                break;
            case 2:
                msg = "ALERT: You really need to get to bed now";
                break;
            case 3:
                msg = "It is Time to go to Sleep!!";            
        }

        msg += "\n  Current Date/Time is " + Calendar.getInstance().getTime();
        
        JOptionPane.showMessageDialog(null, msg, msg, JOptionPane.ERROR_MESSAGE);
    }

}
