package foo.projetglpoo.dao;

import java.util.Date;

public interface EuroMillionsResult {
    Date getDate();

    int[] getNumbers();

    int[] getStars();
}