package Assignment5;

/**
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
