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
        int winnersCounter = 0;
        boolean skip;
        while (winnersCounter < numberOfPlayers - 1) {
            for (int i = 0; i < numberOfPlayers; i++) {
                skip = false;
                if (winners[i] == 1) {
                    skip = true;
                    //System.out.println(i + "k");
                }
                if (!skip) {
                    int id = nextPlayerId(i);
                    System.out.println("Current player: " + i);
                    System.out.println("Next player: " + id);
                    try {
                        if (playersManagement.checkWin(i)) {
                            winners[i] = 1;
                            System.out.println("Win!!!!!!!!!!!!!!!!!!!!!!!!!" + i);
                            winnersCounter++;
                            break;
                        } else {
                            playersCollection.showPlayersHands();
                        }
                        Card card = playersManagement.takeCardFromPlayer(id);
                        playersManagement.checkPair(i, card); //Black widow in loop to fix
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                        playersCollection.showPlayersHands();
                    }


                }
            }
        }
        for (int i = 0; i < winners.length; i++)
            System.out.println("Player " + (i + 1) + ": " + winners[i]);
        //playersCollection.showPlayersHands();
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
