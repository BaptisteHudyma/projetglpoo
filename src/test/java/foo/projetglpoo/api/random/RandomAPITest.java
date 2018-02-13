package foo.projetglpoo.api.random;

import foo.projetglpoo.api.EuroMillionsAPI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomAPITest {
    private EuroMillionsAPI api;

    @Before
    public void setUp() {
        api = new RandomAPI();
    }

    @Test
    public void testNotNull() {
        Assert.assertNotNull(api.getResults(2010));
    }
}
