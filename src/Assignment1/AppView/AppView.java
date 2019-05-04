package Assignment1.AppView;

import java.text.ParseException;

/**
 * @author Whoever
 *
 */
public interface AppView {

    String getInput(String prompt);

    String getResult() throws ParseException;

    void display(String msg);
}
