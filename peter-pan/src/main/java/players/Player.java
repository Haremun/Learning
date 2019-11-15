package players;

import cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Player {
    private int playerId;
    private List<Card> playerHand;

    Player(int playerId) {
        playerHand = new ArrayList<>();

        this.playerId = playerId;
    }

    Card takeRandomCard(){
        if(playerHand.size() > 0){
            Random random = new Random();
            int temp = random.nextInt(playerHand.size());
            Card card = playerHand.get(temp);
            playerHand.remove(card);
            return card;
        } else {
            throw new IllegalStateException("Player " + playerId + " has no cards");
        }

    }
    boolean removeCopy(Card cardToFind){
        for (Card card :
                playerHand) {
            if(card.getRank() == cardToFind.getRank()){
                playerHand.remove(card);
                return true;
            }
        }
        return false;
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
