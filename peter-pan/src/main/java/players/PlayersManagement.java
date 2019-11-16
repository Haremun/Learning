package players;

import cards.Card;

import java.util.List;

public class PlayersManagement {
    private PlayersCollection playersCollection;

    public PlayersManagement(PlayersCollection playersCollection) {
        this.playersCollection = playersCollection;
    }

    public Card takeCardFromPlayer(int playerId) {
        return playersCollection.getPlayer(playerId).takeRandomCard();
    }

    public void dealTheCards(List<Card> cards) {
        int numberOfPlayers = playersCollection.getNumberOfPlayers();

        if (numberOfPlayers != 0) {
            if (cards.size() % numberOfPlayers == 1) {
                int counter = 0;
                while (counter < cards.size()) {
                    for (Player player : playersCollection.getPlayers()) {
                        if (counter < cards.size()) {
                            player.addCardToHand(cards.get(counter));
                            counter++;
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("There is not enough cards for players");
            }
        } else {
            throw new IllegalStateException("You need declare players first");
        }

    }

    public void checkPair(int playerId, Card card) {
        if (!playersCollection.getPlayer(playerId).removeCopy(card)) {
            playersCollection.getPlayer(playerId).addCardToHand(card);
        }
    }
    public boolean checkWin(int playerId){
        return playersCollection.getPlayer(playerId).getNumberOfCardsInHand() < 1;
    }

    public void showPlayersHands() {
        for (Player player :
                playersCollection.getPlayers()) {
            System.out.println(player.getNumberOfCardsInHand());
            player.showPlayerHand();
        }
    }
}
