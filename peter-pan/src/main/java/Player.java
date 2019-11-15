import java.util.ArrayList;
import java.util.List;

public class Player {
    private int playerId;
    private List<Card> playerHand;

    public Player(int playerId) {
        playerHand = new ArrayList<>();

        this.playerId = playerId;
    }
    public void addCardToHand(Card card){
        playerHand.add(card);
    }
}
