package foo.projetglpoo.api.webscrap;

import foo.projetglpoo.api.EuroMillionsAPI;
import foo.projetglpoo.api.EuroMillionsResult;

import java.util.ArrayList;
import java.util.List;

public class WebScrapAPI implements EuroMillionsAPI {
    @Override
    public List<EuroMillionsResult> getResults(int year) {
        final List<EuroMillionsResult> results = new ArrayList<>();

        // TODO

        return results;
    }
}