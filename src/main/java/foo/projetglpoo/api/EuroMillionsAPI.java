package foo.projetglpoo.api;

import java.util.List;

public interface EuroMillionsAPI {
    List<EuroMillionsResult> getResults(int year);
}