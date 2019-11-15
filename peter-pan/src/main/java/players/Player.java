package players;

import cards.Card;

import java.util.ArrayList;
import java.util.List;

class Player {
    private int playerId;
    private List<Card> playerHand;

    Player(int playerId) {
        playerHand = new ArrayList<>();

        this.playerId = playerId;
    }
    void addCardToHand(Card card){
        playerHand.add(card);
    }
    int getNumberOfCardsInHand(){
        return playerHand.size();
    }
    void showPlayerHand(){
        System.out.println("Player " + playerId);
        for (Card card :
                playerHand) {
            System.out.println(card.toString());
        }
    }
}
