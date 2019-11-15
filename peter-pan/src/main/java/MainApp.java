import cards.CardsCollection;
import players.Players;

public class MainApp {
    public static void main(String[] args) {
        CardsCollection cardsCollection = new CardsCollection();
        //cardsCollection.showCards();
        //System.out.println("-------------------------");
        cardsCollection.shuffle();
        //cardsCollection.showCards();

        Players players = new Players(4);
        players.dealTheCards(cardsCollection.getCardsCollection());
        players.showPlayersHands();
    }
}
