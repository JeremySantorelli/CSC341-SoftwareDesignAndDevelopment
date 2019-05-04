package Assignment5;

import Assignment1.AppView.AppView;

/**
 * Manages the group of players
 *
 * @author Jeremy Santorelli
 */
public class PlayerManager {

    private final Player[] players;
    private final int count;
    private final int size;
    private final MessageWriter w;

    public PlayerManager(String numOfPlayers, MessageWriter w) {
        size = Integer.parseInt(numOfPlayers.trim());
        this.count = size - 1;
        this.players = new Player[size];
        this.w = w;
    }

    public Player createPlayer(String name, int playerType) {
        return new Player(name, playerType);
    }

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

    public Player getPlayerByIndex(int i) {
        return players[i];
    }

    public int getSize() {
        return size;
    }

    public void updateAllPlayersGamesPlayed() {

        for (int i = 0; i < size; i++) {
            players[i].setGamesPlayed(players[i].getGamesPlayed() + 1);
        }
    }

    public String displayPlayersHands() {
        String ret = "";
        for (Player p : players) {
            ret += p.getName() + " >> " + p.playersHandToString() + "\n";
        }
        return ret;
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
