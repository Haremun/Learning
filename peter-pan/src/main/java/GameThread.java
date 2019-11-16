import cards.Card;
import cards.Cards;
import players.PlayersCollection;
import players.PlayersManagement;

import java.util.Arrays;

public class GameThread {

    private static final int NUMBER_OF_PLAYERS = 3;
    private int[] winners;
    private int winnersCounter = 0;

    public GameThread() {
        PlayersCollection playersCollection = new PlayersCollection();
        Cards cards = new Cards();
        cards.shuffle();

        winners = new int[NUMBER_OF_PLAYERS];

        playersCollection.createPlayers(NUMBER_OF_PLAYERS);

        PlayersManagement playersManagement = new PlayersManagement(playersCollection);
        playersManagement.dealTheCards(cards.getCardsCollection());
        playersManagement.showPlayersHands();

        Arrays.fill(winners, -1);

        while (winnersCounter < NUMBER_OF_PLAYERS - 1) {
            for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
                if (winners[i] != 1) {
                    int idNext = nextPlayerId(i);
                    Card card = playersManagement.takeCardFromPlayer(idNext);
                    if (playersManagement.checkWin(idNext)) {
                        setWinner(idNext);
                        break;
                    }
                    playersManagement.checkPair(i, card);
                    if (playersManagement.checkWin(i)) {
                        setWinner(i);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < winners.length; i++)
            System.out.println("Player " + (i + 1) + ": " + winners[i]);
    }
    private void setWinner(int id){
        winners[id] = 1;
        System.out.println("Win!!!!!!!!!!!!!!!!!!!!!!!!!" + id);
        winnersCounter++;
    }

    private int nextPlayerId(int id) {
        if (id + 1 >= winners.length)
            return nextPlayerId(-1);
        else if (winners[id + 1] == 1)
            return nextPlayerId(id + 1);
        else
            return id + 1 < NUMBER_OF_PLAYERS ? id + 1 : 0;

    }
}
