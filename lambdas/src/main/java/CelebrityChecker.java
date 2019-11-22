import java.util.List;
import java.util.function.Predicate;

public class CelebrityChecker {


    public void check(List<Celebrity> celebrities, Predicate<Celebrity> checker) {
        for (Celebrity celebrity :
                celebrities) {
            if (checker.test(celebrity))
                System.out.println(celebrity.toString());
        }
    }

}
