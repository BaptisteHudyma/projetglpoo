package foo.projetglpoo.api.random;

import foo.projetglpoo.api.EuroMillionsAPI;
import foo.projetglpoo.api.EuroMillionsResult;
import foo.projetglpoo.api.SimpleEuroMillionsResult;

import java.util.*;

public class RandomAPI implements EuroMillionsAPI {
    private final Map<Integer, List<EuroMillionsResult>> resultsByYear = new HashMap<>();

    private void genRandomYear(int year) {
        final List<EuroMillionsResult> results = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            final Calendar cal = Calendar.getInstance();
            final int[] numbers = new int[5];
            final int[] stars = new int[2];

            Random rng = new Random();

            // TODO: better date
            cal.set(year, Calendar.JANUARY, 1);

            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = rng.nextInt(50 - 1) + 1;
            }

            for (int j = 0; j < stars.length; j++) {
                stars[j] = rng.nextInt(12 - 1) + 1;
            }

            results.add(new SimpleEuroMillionsResult(cal.getTime(), numbers, stars));
        }

        resultsByYear.put(year, results);
    }

    @Override
    public List<EuroMillionsResult> getResults(int year) {
        if (!resultsByYear.containsKey(year)) {
            genRandomYear(year);
        }

        return resultsByYear.get(year);
    }
}
