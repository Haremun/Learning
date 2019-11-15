package cards;

import enums.CardColor;
import enums.CardRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsCollection {
    private List<Card> cardsCollection;

    public CardsCollection() {
        cardsCollection = new ArrayList<>();

        CardColor[] colors = CardColor.values();
        CardRank[] ranks = CardRank.values();
        for (CardRank rank : ranks)
            if (rank != CardRank.Black_widow)
                for (CardColor color : colors) {
                    cardsCollection.add(new Card(rank, color));
                }
            else
                cardsCollection.add(new Card(rank, null));

    }

    public void shuffle() {
        Collections.shuffle(cardsCollection);
    }

    public void showCards() {
        for (Card card :
                cardsCollection) {
            System.out.println(card.toString());
        }
    }

    public List<Card> getCardsCollection() {
        return cardsCollection;
    }
}
