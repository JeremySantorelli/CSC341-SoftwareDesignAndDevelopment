package Assignment5;

import Assignment2.*;
import Assignment1.AppView.AppView;

/**
 * This class Controls the flow of the Crazy eights game.
 *
 * @author Jeremy Santorelli
 */
public final class GameControllerCrazy8 implements GameController {

    private AppView view;
    private String input;
    private GameManager gm;
    private MessageWriter w;

    @Override
    public void setView(String language) {

        if (language.equalsIgnoreCase("english")) {
            w = new MessageWriterEnglish();
        }
        view = new AppViewConsole(w);

    }

    @Override
    public void run() {
        //Get Players        
        input = view.getInput(w.howManyPlayers());
        PlayerManager p = new PlayerManager(input, w);
        p.setupPlayers(view);

        //Play
        gm = new GameManager(view, new Deck(false), p, w);
        gm.checkGameState();

        if (gm.startGame() == 0) {//Game Ends
            System.exit(1);
        }

    }

}
