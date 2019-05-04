package Assignment5;

/**
 * Creates a player with appropriate attributes
 *
 * @author Jeremy Santorelli
 */
public class Player {

    private final String name;
    private int wins;
    private int gamesPlayed;
    private final int playerType;
    private final Hand hand;

    public Player(String name, int playerType) {
        this.name = name;
        this.wins = 0;
        this.gamesPlayed = 0;
        this.playerType = playerType;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getPlayerType() {
        return playerType;
    }

    public void addCardToHand(Card c) {
        hand.addCard(c);
    }

    public Card findAvailableCard(Card topCard) {
        hand.sortByValue();
        Card cardCheck = null;
        for (int i = 0; i < hand.getCardCount(); i++) {
            try {
                cardCheck = hand.getCard(i);
            } catch (IllegalArgumentException e) {

            }
            if (cardCheck != null) {
                if (cardCheck.getValue() == topCard.getValue()
                        || cardCheck.getSuit() == topCard.getSuit()) {
                    hand.removeCard(i);
                    return cardCheck;
                }
            }
        }
        return null;
    }

    public String playersHandToString() {
        String ret = "";
        for (int i = 0; i < hand.getCardCount(); i++) {
            Card temp = hand.getCard(i);
            ret += " |" + temp.getValueAsString() + " of "
                    + temp.getSuitAsString() + "| ";
        }
        return ret;
    }

    public String playersHandInPickMode() {
        String ret = "";
        for (int i = 0; i < hand.getCardCount(); i++) {
            Card temp = hand.getCard(i);
            ret += (i + 1) + " |" + temp.getValueAsString()
                    + " of " + temp.getSuitAsString() + "| \n";
        }
        return ret;

    }

    public void removeCardFromHand(Card remove) {
        hand.removeCard(remove);
    }

    public int getCardCount() {
        return hand.getCardCount();
    }

    public Card getCardByIndex(int i) {
        return hand.getCard(i);
    }
}
