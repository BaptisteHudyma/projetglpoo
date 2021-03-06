package foo.projetglpoo.dao.random;

import foo.projetglpoo.dao.EuroMillionsDAO;
import foo.projetglpoo.dao.EuroMillionsResult;
import foo.projetglpoo.dao.SimpleEuroMillionsResult;

import java.util.*;

public class RandomDAO implements EuroMillionsDAO {
    @Override
    public List<EuroMillionsResult> getResults() {
        final List<EuroMillionsResult> results = new ArrayList<>();

        final Random rng = new Random();

        for (int i = 0; i < 20; i++) {
            final Calendar cal = Calendar.getInstance();
            final int[] numbers = new int[5];
            final int[] stars = new int[2];

            // TODO: better date
            cal.set(2017, Calendar.JANUARY, 1);

            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = rng.nextInt(50 - 1) + 1;
            }

            for (int j = 0; j < stars.length; j++) {
                stars[j] = rng.nextInt(12 - 1) + 1;
            }

            results.add(new SimpleEuroMillionsResult(cal.getTime(), numbers, stars));
        }

        return results;
    }
}
