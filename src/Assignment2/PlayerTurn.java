package Assignment2;

/**
 * This class is used to control a player and the top card related to that
 * players top card
 *
 * @author Jeremy Santorelli
 */
public class PlayerTurn {

    Player p;
    Card topCard;

    public PlayerTurn(Player p, Card topCard) {
        this.p = p;
        this.topCard = topCard;
    }

    public Player getP() {
        return p;
    }

    public Card getTopCard() {
        return topCard;
    }

}
