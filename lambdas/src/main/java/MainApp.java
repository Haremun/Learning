import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainApp {
    public static void main(String[] args) {
        List<Celebrity> celebrities = new ArrayList<>();
        celebrities.add(new Celebrity("Kasia", true, false));
        celebrities.add(new Celebrity("Natalka", true, true));
        celebrities.add(new Celebrity("Wiktoria", false, false));

        CelebrityChecker celebrityChecker = new CelebrityChecker();

        /*celebrityChecker.check(celebrities, new CheckTalent() {
            @Override
            public boolean test(Celebrity celebrity) {
                return celebrity.canDance();
            }
        });*/ //Without lambda
        //celebrityChecker.check(celebrities, c -> c.canDance()); standard lambda
        celebrityChecker.check(celebrities, Celebrity::canDance); //Predicate returns boolean

        celebrities.forEach(celebrity -> System.out.println(celebrity.toString())); //Consumer

        new Thread(() -> System.out.println("Thread")).start();

    }
}
