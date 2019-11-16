package players;

import cards.Card;

import java.util.ArrayList;
import java.util.List;

public class PlayersCollection {
    private List<Player> players;
    private int numberOfPlayers;

    public PlayersCollection() {
        this.players = new ArrayList<>();
        this.numberOfPlayers = 0;
    }

    public void createPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;

        if (numberOfPlayers > 1 && numberOfPlayers < 5)
            for (int i = 0; i < numberOfPlayers; i++)
                players.add(new Player(i));
        else
            throw new IllegalArgumentException("You can only create 2-4 players");
    }



    Player getPlayer(int playerId) {
        return players.get(playerId);
    }

    List<Player> getPlayers() {
        return players;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
