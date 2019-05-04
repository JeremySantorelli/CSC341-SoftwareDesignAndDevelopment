package Assignment2;

import Assignment1.AppView.AppView;

/**
 * This class manages all aspects of the game play
 *
 * @author Jeremy Santorelli
 */
public class GameManager {

    private Deck deck = null;
    private PlayerManager players = null;
    private int gamesPlayed;
    private final AppView view;
    private int dealer;
    private final MessageWriter w;

    public GameManager(AppView m, Deck d, PlayerManager p, MessageWriter w) {
        this.deck = d;
        this.view = m;
        this.gamesPlayed = 0;
        this.players = p;
        this.dealer = 0;
        this.w = w;
    }

    /**
     * Ensures the deck and players were set up properly
     */
    public void checkGameState() {
        if (checkDeck() + checkPlayers() > 0) {
            view.display(w.gameStateError());
            System.exit(1);
        } else {
            view.display(w.gameStateSuccess());
        }
    }

    /**
     * Used to run the game. 
     *
     * @return Will return 0 to close the game
     */
    int startGame() {
        //increment round Number
        //Display round to Players
        boolean go = true;
        while (go) {

            int winnerNum = startRound();
            if (winnerNum == -1) {
                view.display(w.ranOutOfCards());
            } else {
                Player winner = players.getPlayerByIndex(winnerNum);
                view.display(w.displayWinner(winner.getName()));
                winner.setWins(winner.getWins() + 1);
            }
            players.updateAllPlayersGamesPlayed();

            String input = view.getInput(w.playAgainDialog());

            if (!input.equalsIgnoreCase("y")) {
                go = false;
            }
        }
        return 0;
    }

    /**
     * Runs a single round of a game
     *
     * @return winner's index (Note returns -1 if no winner)
     */
    public int startRound() {

        view.display(w.startRoundMessage(++gamesPlayed));

        int winner = -2;

        dealer++;
        if (dealer > players.getSize() - 1) {
            dealer = 0;
        }
        deck.shuffle();
        view.display(w.isDealer(
                players.getPlayerByIndex(dealer).getName()));
        deal();
        //Set first card
        Card discardPileTopCard = deck.dealCard();

        int nextPlayer = dealer + 1;
        while (winner == -2) {

            if (nextPlayer > players.getSize() - 1) {
                nextPlayer = 0;
            }
            Player currentPlayer = players.getPlayerByIndex(nextPlayer++);
            view.display(w.startNextPlayer(
                    discardPileTopCard, currentPlayer.getName()));

            PlayerTurn pt = null;
            while (pt == null) {
                pt = takeTurn(currentPlayer, discardPileTopCard);
                if (deck.cardsLeft() == 0) {
                    break;
                }
            }
            if (pt != null) {
                discardPileTopCard = pt.getTopCard();
                currentPlayer = pt.getP();
            }
            if (currentPlayer.getCardCount() <= 0) {
                winner = nextPlayer - 1;
            }
            if (deck.cardsLeft() == 0) {
                winner = -1;
            }
        }

        return winner;

    }

    /**
     * This simulates a single turn of a player. this function will make a
     * single decision. It will either select a card to discard or it will add a
     * card to the players hand
     *
     * @param currentPlayer The current player taking a turn
     * @param discardPileTopCard the current card the player must play off of.
     * @return player turn object returns the updated player and new top card.
     */
    private PlayerTurn takeTurn(Player currentPlayer,
            Card discardPileTopCard) {
        if (currentPlayer.getPlayerType() == 0) {

            Card bestCard = currentPlayer.findAvailableCard(
                    discardPileTopCard);
            if (bestCard == null) {
                currentPlayer.addCardToHand(deck.dealCard());
                return null;
            } else {
                discardPileTopCard = bestCard;
                currentPlayer.removeCardFromHand(bestCard);
            }
        } else {
            view.display(currentPlayer.playersHandInPickMode());
            String input = view.getInput(w.humanDialogCardPick());
            int selection = Integer.parseInt(input.trim());
            if (selection == 0) {
                currentPlayer.addCardToHand(deck.dealCard());
                return null;
            } else {
                Card pCard = currentPlayer.getCardByIndex(selection - 1);
                if (pCard.getValue() == 8) {
                    String suitInput = view.getInput(w.humanSetSuit());
                    int suit = Integer.parseInt(suitInput.trim());
                    Card setSuit = new Card(8, suit - 1);
                    currentPlayer.removeCardFromHand(pCard);
                    discardPileTopCard = setSuit;

                } else if (validateCard(pCard, discardPileTopCard)) {
                    currentPlayer.removeCardFromHand(pCard);
                } else {
                    view.display(w.cardNotAllowed());
                    return null;
                }
            }
        }
        return new PlayerTurn(currentPlayer, discardPileTopCard);
    }

    /**
     * Deals the cards to all players
     */
    void deal() {
        //Deal 7 cards to each player.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < players.getSize(); j++) {
                players.getPlayerByIndex(j).addCardToHand(deck.dealCard());
            }
        }

        for (int i = 0; i < i; i++) {
            view.display(w.display(
                    players.getPlayerByIndex(i).toString()));
        }
    }

    /**
     * Ensures there is a deck to play with
     *
     * @return 0 means deck was set. 1 means it was not.
     */
    private int checkDeck() {
        if (deck == null) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Ensures that players were properly set
     *
     * @return 0 means deck was set. 1 means they were not.
     */
    private int checkPlayers() {
        if (players == null) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Ensures a human player is selecting a card that can be played.
     *
     * @param pCard players card to validate
     * @param discard top card to validate against.
     * @return whether it is a valid selection or not.
     */
    private boolean validateCard(Card pCard, Card discard) {
        return pCard.getSuit() == discard.getSuit()
                || pCard.getValue() == discard.getValue();
    }

}
