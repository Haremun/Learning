import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Celebrity> celebrities = new ArrayList<>();
        celebrities.add(new Celebrity("Kasia", true, false));
        celebrities.add(new Celebrity("Natalka", true, true));
        celebrities.add(new Celebrity("Wiktoria", false, false));

        CelebrityChecker celebrityChecker = new CelebrityChecker();

        //celebrityChecker.check(celebrities, c -> c.canDance());
        celebrityChecker.check(celebrities, Celebrity::canDance);

    }
}
