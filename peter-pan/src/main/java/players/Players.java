package players;

import cards.Card;
import cards.CardsCollection;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Player> players;
    private int numberOfPlayers;

    public Players(int numberOfPlayers) {
        players = new ArrayList<>();
        this.numberOfPlayers = numberOfPlayers;

        if (numberOfPlayers > 1 && numberOfPlayers < 5)
            for (int i = 1; i <= numberOfPlayers; i++)
                players.add(new Player(i));
        else
            throw new IllegalArgumentException("You can only create 2-4 players");
    }

    public void dealTheCards(List<Card> cards) {
        if (cards.size() % numberOfPlayers == 1) {
            int counter = 0;
            while (counter < cards.size()) {
                for (Player player : players) {
                    if (counter < cards.size()) {
                        player.addCardToHand(cards.get(counter));
                        counter++;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("There is not enough cards for players");
        }
    }

    public void showPlayersHands() {
        for (Player player :
                players) {
            System.out.println(player.getNumberOfCardsInHand());
            player.showPlayerHand();
        }
    }
}
