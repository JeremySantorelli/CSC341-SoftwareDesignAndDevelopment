package Assignment2;

/**
 * This class was made in the event that this game needs to be multilingual
 *
 * NOTE: This class should be made primarily into an JAVA ENUM. The remaining
 * classes that take variables could remain.
 *
 * @author Jeremy Santorelli
 */
public class MessageWriterEnglish implements MessageWriter {

    //GameControllerCrazy8
    @Override
    public String howManyPlayers() {
        return "How many players?";
    }

    //GameManager
    @Override
    public String gameStateSuccess() {
        return "Your game was successfully created. lets begin";
    }

    @Override
    public String gameStateError() {
        return "An error occured while setting up game. Shutting Down";
    }

    @Override
    public String startRoundMessage(int round) {
        return "Round " + round + " start";
    }

    @Override
    public String humanDialogCardPick() {
        return "Which card would you like to play input list number"
                + " or 0 to add a card to your hand";
    }

    @Override
    public String humanSetSuit() {
        return "Which suit would you like to set 1. Spades 2. Hearts"
                + " 3. Diamonds 4. Clubs";
    }

    @Override
    public String cardNotAllowed() {
        return "The card you selected is not a valid move. Please select a card "
                + "that matched suit or value of top card.";
    }

    @Override
    public String ranOutOfCards() {
        return "Ran out of cards. There is no winner";
    }

    @Override
    public String displayWinner(String name) {
        return name + " is the Winner!";
    }

    @Override
    public String playAgainDialog() {
        return "Play another Round? (Y/N)";
    }

    @Override
    public String isDealer(String name) {
        return name + " is Dealer";
    }

    @Override
    public String startNextPlayer(Card card, String name) {
        return "TopCard: " + card + " >> Players Turn: " + name + "\n";
    }

    //PlayerManager
    @Override
    public String howManyComputers() {
        return "How many players would you like to be computers?";
    }

    @Override
    public String playerNameDialog(int i) {
        return "what is Player " + (i + 1) + "'s name?";
    }

    @Override
    public String playersSetDialog(String list) {
        return "All players have been set \nPlayers are: \n" + list;
    }

    @Override
    public String computerSymbol() {
        return "<C>";
    }

    @Override
    public String humanSymbol() {
        return "<H>";
    }

    @Override
    public String display(String msg) {
        return msg;
    }

}
