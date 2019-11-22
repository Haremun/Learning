import java.util.List;

public class CelebrityChecker {

    public void check (List<Celebrity> celebrities, CheckTalent checkTalent) {
        for (Celebrity celebrity :
                celebrities) {
            if ( checkTalent.test(celebrity))
                System.out.println(celebrity.toString());
        }
    }
}
