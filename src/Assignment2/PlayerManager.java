package Assignment2;

import Assignment1.AppView.AppView;

/**
 * This is the interpretation of the physical game area in a virtual way. This
 * class manages the group of players, How many players are in the group, and
 * routes output messages to the players.
 *
 * @author Jeremy Santorelli
 */
public class PlayerManager {

    private final Player[] players;
    private final int count;
    private final int size;
    private final MessageWriter w;

    /**
     *
     * @param numOfPlayers the input denoting the size of the group
     * @param w The MessageWriter associated to that player. This is done so
     * that each player gets their own preferred language.
     *
     * **********************************************PLAYER MANAGER CONSTRUCTOR
     */
    public PlayerManager(String numOfPlayers, MessageWriter w) {
        size = Integer.parseInt(numOfPlayers.trim());
        this.count = size - 1;
        this.players = new Player[size];
        this.w = w;
    }

    /**
     * Builds a Player Object with an unique player name and type
     *
     * @param name The unique name of the player
     * @param playerType denotes player type (ex. "human", "computer")
     * @return Player object with assigned attributes
     *
     * ***********************************************************CREATE PLAYER
     */
    public Player createPlayer(String name, int playerType) {
        return new Player(name, playerType);
    }

    /**
     * A switch that aligns the game to the player that is next to take a turn
     *
     * @param previousPlayer The previous player is used to find the next player
     * @return the next Player Object
     *
     * *********************************************************GET NEXT PLAYER
     */
    public Player getNextPlayer(Player previousPlayer) {
        int priorLocation = players.length + 1;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getName().equals(previousPlayer.getName())) {
                priorLocation = i;
            }
        }
        if (priorLocation + 1 < count) {
            return players[priorLocation + 1];
        } else {
            return players[0];
        }
    }

    /**
     *
     * @param a
     */
    public void setupPlayers(AppView a) {

        String input = a.getInput(w.howManyComputers());
        int computerCount = Integer.parseInt(input.trim());
        int count1 = 0;
        for (int i = 0; i < computerCount; i++) {
            players[count1++] = createPlayer("Computer" + (i + 1), 0);
        }

        int humanSize = players.length - computerCount;

        for (int i = 0; i < humanSize; i++) {
            input = a.getInput(w.playerNameDialog(i + 1));
            players[count1++] = createPlayer(input.trim(), 1);
        }

        a.display(w.playersSetDialog(this.toString()));
    }

    /**
     *
     * @param i Player's Index # in the array
     * @return the Player Object associated to i
     *
     * *****************************************************GET PLAYER BY INDEX
     */
    public Player getPlayerByIndex(int i) {
        return players[i];
    }

    /**
     * Adds 1 to all players when they complete a game.
     */
    public void updateAllPlayersGamesPlayed() {

        for (int i = 0; i < size; i++) {
            players[i].setGamesPlayed(players[i].getGamesPlayed() + 1);
        }
    }

    /**
     * Used to output the current game state to output. Displays all players and
     * their hands in one function
     *
     * @return Full string output of players hands
     */
    public String displayPlayersHands() {
        String ret = "";
        for (Player p : players) {
            ret += p.getName() + " >> " + p.playersHandToString() + "\n";
        }
        return ret;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String ret = "";
        for (Player p : players) {
            ret += p.getName() + " ";
            if (p.getPlayerType() == 0) {
                ret += w.computerSymbol();
            } else {
                ret += w.humanSymbol();
            }
            ret += "\n";
        }

        return ret;
    }

}
