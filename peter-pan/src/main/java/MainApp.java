import enums.CardRank;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        CardsCollection cardsCollection = new CardsCollection();
        cardsCollection.showCards();
        System.out.println("-------------------------");
        cardsCollection.shuffle();
        cardsCollection.showCards();
    }
}
