package foo.projetglpoo;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import foo.projetglpoo.api.EuroMillionsAPI;
import foo.projetglpoo.api.EuroMillionsResult;
import foo.projetglpoo.api.webscrap.WebScrapAPI;

public class Launcher {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger log = Logger.getLogger(Launcher.class);

        EuroMillionsAPI api = new WebScrapAPI();
        List<EuroMillionsResult> results = api.getResults(2017);
        for (EuroMillionsResult result: results) {
            log.debug("result:");
            log.debug(result.getDate());
            log.debug(Arrays.toString(result.getNumbers()));
            log.debug(Arrays.toString(result.getStars()));
        }
    }
}