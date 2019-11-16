import cards.Card;
import cards.Cards;
import players.PlayersCollection;
import players.PlayersManagement;

import java.util.Arrays;

public class GameThread extends Thread {

    private static final int NUMBER_OF_PLAYERS = 3;
    private int[] winners;
    private int winnersCounter;

    private PlayersManagement playersManagement;

    GameThread() {
        Cards cards = new Cards();
        cards.shuffle();

        winners = new int[NUMBER_OF_PLAYERS];
        Arrays.fill(winners, -1);

        PlayersCollection playersCollection = new PlayersCollection();
        playersCollection.createPlayers(NUMBER_OF_PLAYERS);

        playersManagement = new PlayersManagement(playersCollection);
        playersManagement.dealTheCards(cards.getCardsCollection());
    }

    @Override
    public void run() {
        winnersCounter = 0;
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
            if (winners[i] == 1)
                System.out.println("Player " + (i + 1) + ": Winner");
            else
                System.out.println("Player " + (i + 1) + ": Looser");
    }

    private void setWinner(int id) {
        winners[id] = 1;
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
