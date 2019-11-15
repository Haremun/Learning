package players;

import cards.Card;

public class PlayersManagement {
    private PlayersCollection playersCollection;

    public PlayersManagement(PlayersCollection playersCollection) {
        this.playersCollection = playersCollection;
    }

    public Card takeCardFromPlayer(int playerId) {
        return playersCollection.getPlayer(playerId).takeRandomCard();
    }

    public void givePlayerCard(int playerId, Card card) {
        playersCollection.getPlayer(playerId).addCardToHand(card);
    }

    public void checkPair(int playerId, Card card) {
        if (!playersCollection.getPlayer(playerId).removeCopy(card)) {
            playersCollection.getPlayer(playerId).addCardToHand(card);
        }
    }
    public boolean checkWin(int playerdId){
        return playersCollection.getPlayer(playerdId).getNumberOfCardsInHand() < 1;
    }
}
