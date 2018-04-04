package foo.projetglpoo.dao.random;

import foo.projetglpoo.dao.EuroMillionsDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomDAOTest {
    private EuroMillionsDAO api;

    @Before
    public void setUp() {
        api = new RandomDAO();
    }

    @Test
    public void testNotNull() {
        Assert.assertNotNull(api.getResults());
    }
}
