package Assignmentt10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentInterface extends JPanel {

    Alarm wake, sleep;
    
    JTextField input;
    JRadioButton sleepRadio, wakeRadio;
    JButton submit;

    public void run() {

        input = new JTextField();
        input.setColumns(20);
        
        sleepRadio = new JRadioButton("Sleep Alarm");
        wakeRadio = new JRadioButton("Wake Alarm");
        submit = new JButton("Submit");
        
        this.add(input);
        this.add(sleepRadio);
        this.add(wakeRadio);
        this.add(submit);

        ActionListener btnListener = new ButtonListener();

        submit.addActionListener(btnListener);
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            if (sleepRadio.isSelected()) {
                if(sleep == null){
                sleep = new Alarm(new NotifierGUI(), 3);
                }
                
                try {
                    System.out.println(sleep.SetAlarm(input.getText().trim()));
                } catch (ParseException ex) {
                    Logger.getLogger(StudentInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if (wakeRadio.isSelected()) {
                if(wake == null){
                wake = new Alarm(new NotifierGUI(), 0);
                }
                
                try {
                    System.out.println(wake.SetAlarm(input.getText().trim()));
                } catch (ParseException ex) {
                    Logger.getLogger(StudentInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
