package Assignment8;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Jeremy Santorelli
 */
public class FrameBuilderCalculator implements FrameBuilder {

    private JFrame frame;
    private JPanel centerPanel;
    private JPanel northPanel;
    private JPanel contentPane;

    private JTextField calculatorScreen;
    private String lastEntry = null;

    private final String[] buttonText = {"C", ".", "/", "*", "7", "8", "9", "-", "4", "5",
        "6", "+", "1", "2", "3", "=", "0", "ls"};

    private final JButton[] button = new JButton[18];

    private int counter = 0;

    private GridBagConstraints gbc;

    //step 1
    @Override
    public void setPanels(String frameName, Font f) {
        frame = new JFrame(frameName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout(2, 2));

        calculatorScreen = new JTextField();
        calculatorScreen.setEditable(false);
        calculatorScreen.setHorizontalAlignment(SwingConstants.RIGHT);
        
        calculatorScreen.setFont(f);

        northPanel.add(calculatorScreen, BorderLayout.CENTER);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
    }

    //step 2
    @Override
    public void setGridConstraints(int w, int x, int y, int z) {
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(w, x, y, z);
    }

    //step 3
    @Override
    public void initButtons() {
        ActionListener btnListener = new ButtonListener();

        for (int i = 0; i < button.length; i++) {

            button[i] = new JButton(buttonText[i]);
            button[i].setActionCommand(buttonText[i]);
            button[i].addActionListener(btnListener);

        }
        button[17].setEnabled(false);//"ls" button is turned off when lastEntry string is null

    }

    //step 4
    @Override
    public void setButtonOrientation() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                gbc.gridx = j;
                gbc.gridy = i;
                if (counter < button.length) {
                    centerPanel.add(button[counter++], gbc);
                }
            }
        }

    }

    @Override
    public void display(int xSize, int ySize) {
        contentPane.add(northPanel, BorderLayout.PAGE_START);
        contentPane.add(centerPanel, BorderLayout.CENTER);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setSize(xSize, ySize);
    }

    class ButtonListener implements ActionListener {

        String digits = "[0-9]+";

        @Override
        public void actionPerformed(ActionEvent event) {

            String buttonPressed = event.getActionCommand();
            if (buttonPressed.equalsIgnoreCase("=")) {
                lastEntry = Calculator.getAnswer(calculatorScreen.getText().trim());
                calculatorScreen.setText(lastEntry);
                button[17].setEnabled(true);

            } else if (buttonPressed.equalsIgnoreCase("C")) {
                calculatorScreen.setText("");
            } else {
                if (buttonPressed.matches(digits) || buttonPressed.equals(".")) {
                    calculatorScreen.setText(calculatorScreen.getText() + buttonPressed);
                } else if (buttonPressed.equals("ls")) {
                    calculatorScreen.setText(calculatorScreen.getText() + lastEntry);
                } else {
                    calculatorScreen.setText(calculatorScreen.getText() + " " + buttonPressed + " ");
                }
            }

        }
    }
}
