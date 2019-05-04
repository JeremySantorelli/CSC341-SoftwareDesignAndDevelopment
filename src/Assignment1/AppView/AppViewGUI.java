package Assignment1.AppView;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import Assignment1.ListContainer;
import java.text.ParseException;

public final class AppViewGUI implements AppView {

    String input;
    ListContainer list;
    JTextArea area;

    public AppViewGUI(ListContainer b) {
        list = b;
        getFrame("diaplay frame").setVisible(true);
    }

    JFrame getFrame(String title) {
        JFrame frame = new JFrame(title);
        area = new JTextArea();
        frame.add(area);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    @Override
    public String getInput(String prompt) {
        input = JOptionPane.showInputDialog(prompt).trim();
        return input;
    }

    @Override
    public String getResult() throws ParseException {
        return MessageWriter.listResult(input, list.getMessagesByDate(input));

    }

    @Override
    public void display(String msg) {
        area.append("\n" + msg);
    }
}
