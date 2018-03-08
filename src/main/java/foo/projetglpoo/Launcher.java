package foo.projetglpoo;

import foo.projetglpoo.dao.EuroMillionsDAO;
import foo.projetglpoo.dao.EuroMillionsResult;
import foo.projetglpoo.dao.random.RandomDAO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger log = Logger.getLogger(Launcher.class);

        EuroMillionsDAO api = new RandomDAO();
        List<EuroMillionsResult> results = api.getResults(2017);
        for (EuroMillionsResult result : results) {
            log.debug("result:");
            log.debug(result.getDate());
            log.debug(Arrays.toString(result.getNumbers()));
            log.debug(Arrays.toString(result.getStars()));
        }
    }
}