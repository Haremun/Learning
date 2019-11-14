import enums.CardColors;
import enums.CardSymbols;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Hello peter");
        CardSymbols[] cardSymbols = CardSymbols.values();
        List<CardSymbols> cardSymbolsList = Arrays.asList(cardSymbols);
    }
}
