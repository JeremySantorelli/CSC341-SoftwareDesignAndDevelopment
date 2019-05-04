package Assignment2;

/**
 *
 * @author Jeremy Santorelli
 */
public interface MessageWriter {

    String cardNotAllowed();

    String computerSymbol();

    String display(String msg);

    String displayWinner(String name);

    String gameStateSuccess();

    String gameStateError();

    String howManyPlayers();

    String howManyComputers();

    String humanDialogCardPick();

    String humanSetSuit();

    String humanSymbol();

    String playAgainDialog();

    String playerNameDialog(int i);

    String playersSetDialog(String list);

    String ranOutOfCards();

    String startRoundMessage(int round);

    String startNextPlayer(Card card, String name);

    String isDealer(String name);

}
