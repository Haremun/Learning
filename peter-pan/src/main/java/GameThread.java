import cards.Card;
import cards.Cards;
import enums.CardColor;
import enums.CardRank;
import players.PlayersCollection;
import players.PlayersManagement;

public class GameThread {

    private int numberOfPlayers = 3;

    public GameThread() {
        PlayersCollection playersCollection = new PlayersCollection();
        Cards cards = new Cards();
        cards.shuffle();
        playersCollection.createPlayers(numberOfPlayers);
        playersCollection.dealTheCards(cards.getCardsCollection());
        PlayersManagement playersManagement = new PlayersManagement(playersCollection);
        playersCollection.showPlayersHands();

        playersCollection.showPlayersHands();
        boolean win = false;
        while (!win) {
            for (int i = 0; i < numberOfPlayers; i++) {
                int id = nextPlayerId(i);
                Card card = playersManagement.takeCardFromPlayer(id);
                playersManagement.checkPair(i, card);
                if (playersManagement.checkWin(i)) {
                    win = true;
                    System.out.println("Win!!!!!!!!!!!!!!!!!!!!!!!!!");
                    playersCollection.showPlayersHands();
                    break;
                }
            }
        }
    }

    private int nextPlayerId(int id) {
        return (id + 1) < numberOfPlayers ? (id + 1) : 0;
    }
}
