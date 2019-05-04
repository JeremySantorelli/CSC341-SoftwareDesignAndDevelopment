package Assignment1;

import java.text.ParseException;
import java.util.Arrays;

/**
 *
 * @author Jeremy Santorelli
 */
public class Startup {

    public static void main(String[] args) {
        AppController app;
        try {
            app = new AppControllerToDo();
            app.setView(Config.getViewProperty());
            app.run();
        } catch (ParseException ex) {
            System.out.println("ERROR: " + ex.getMessage() + "\n \n" + Arrays.toString(ex.getStackTrace()));
        }

    }
}
