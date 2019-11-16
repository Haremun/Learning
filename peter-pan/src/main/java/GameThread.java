import cards.Card;
import cards.Cards;
import enums.CardColor;
import enums.CardRank;
import players.PlayersCollection;
import players.PlayersManagement;

import java.util.Arrays;

public class GameThread {

    private int numberOfPlayers = 4;
    private int[] winners = new int[numberOfPlayers];
    private int winnersCounter = 0;

    public GameThread() {
        PlayersCollection playersCollection = new PlayersCollection();
        Cards cards = new Cards();
        cards.shuffle();
        playersCollection.createPlayers(numberOfPlayers);
        playersCollection.dealTheCards(cards.getCardsCollection());
        PlayersManagement playersManagement = new PlayersManagement(playersCollection);
        //playersCollection.showPlayersHands();

        playersCollection.showPlayersHands();

        Arrays.fill(winners, -1);

        while (winnersCounter < numberOfPlayers - 1) {
            for (int i = 0; i < numberOfPlayers; i++) {
                if (winners[i] != 1) {
                    int idNext = nextPlayerId(i);
                    System.out.println("Current player: " + i);
                    System.out.println("Next player: " + idNext);
                    Card card = playersManagement.takeCardFromPlayer(idNext);
                    if (playersManagement.checkWin(idNext)) {
                        setWinner(idNext);
                        break;
                    }
                    playersManagement.checkPair(i, card); //Black widow in loop to fix
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
            return id + 1 < numberOfPlayers ? id + 1 : 0;

    }
}
