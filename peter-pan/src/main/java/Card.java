import enums.CardColor;
import enums.CardRank;

public class Card {
    private CardRank rank;
    private CardColor color;

    public Card(CardRank rank, CardColor color) {
        this.rank = rank;
        this.color = color;
    }

    public CardRank getRank() {
        return rank;
    }
    public CardColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", color=" + color +
                '}';
    }
}
