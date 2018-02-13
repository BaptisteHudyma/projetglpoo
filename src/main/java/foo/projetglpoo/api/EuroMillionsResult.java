package foo.projetglpoo.api;

import java.util.Date;

public interface EuroMillionsResult {
    Date getDate();

    int[] getNumbers();

    int[] getStars();
}