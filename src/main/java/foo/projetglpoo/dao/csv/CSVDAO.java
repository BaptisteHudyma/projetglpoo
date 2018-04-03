package foo.projetglpoo.dao.csv;

import foo.projetglpoo.dao.EuroMillionsDAO;
import foo.projetglpoo.dao.EuroMillionsResult;
import foo.projetglpoo.dao.SimpleEuroMillionsResult;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVDAO implements EuroMillionsDAO {
    private List<EuroMillionsResult> results;

    public CSVDAO() {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final InputStream inputStream = loader.getResourceAsStream("euromillion.csv");
        parseCSV(inputStream);
    }

    private void parseCSV(InputStream inputStream) {
       results = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        for (String line: (Iterable<String>) bufferedReader.lines()::iterator) {
            if (!line.startsWith("#")) { // drop comments
                try {
                    results.add(parseLine(line));
                } catch (ParseException e) {}
            }
        }
    }

    private static EuroMillionsResult parseLine(String line) throws ParseException {
        final String[] fields = line.split(";");
        if (fields.length < 12)
            throw new ParseException("uncomplete row", line.length());

        final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final Date date = dateFormat.parse(fields[2]);

        final int[] numbers = new int[5];
        for (int i=0; i < 5; i++) {
            numbers[i] = Integer.parseInt(fields[5 + i]);
        }

        final int[] stars = new int[2];
        for (int i=0; i < 2; i++) {
            stars[i] = Integer.parseInt(fields[10 + i]);
        }

        return new SimpleEuroMillionsResult(date, numbers, stars);
    }

    @Override
    public List<EuroMillionsResult> getResults() {
        return results;
    }
}