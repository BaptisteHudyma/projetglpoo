package foo.projetglpoo.api.webscrap;

import java.util.ArrayList;
import java.util.List;

import foo.projetglpoo.api.EuroMillionsAPI;
import foo.projetglpoo.api.EuroMillionsResult;
import foo.projetglpoo.api.SimpleEuroMillionsResult;

public class WebScrapAPI implements EuroMillionsAPI {
    @Override
    public List<EuroMillionsResult> getResults(int year) {
        final List<EuroMillionsResult> results = new ArrayList<>();

        // TODO

        return results;
    }
}