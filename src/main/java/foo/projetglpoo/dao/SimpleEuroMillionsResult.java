package foo.projetglpoo.dao;

import java.util.Date;

public class SimpleEuroMillionsResult implements EuroMillionsResult {
    private final Date date;
    private final int[] numbers;
    private final int[] stars;

    public SimpleEuroMillionsResult(Date date, int[] numbers, int[] stars) {
        if (numbers.length != 5) {
            throw new IllegalArgumentException("numbers must have 5 fields");
        }

        if (stars.length != 2) {
            throw new IllegalArgumentException("stars must have 2 fields");
        }

        this.date = date;
        this.numbers = numbers;
        this.stars = stars;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public int[] getNumbers() {
        return numbers;
    }

    @Override
    public int[] getStars() {
        return stars;
    }
}
