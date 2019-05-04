package Assignment2;

/**
 * Startup method for Crazy 8's Game
 *
 * @author Jeremy Santorelli
 */
public class Startup {

    public static void main(String[] args) {
        //Setup Environment                                
        GameController gc = new GameControllerCrazy8();
        gc.setView("english");
        gc.run();
    }
}
