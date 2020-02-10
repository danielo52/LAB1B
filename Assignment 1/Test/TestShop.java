import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestShop {

    private Shop<Volvo240> testV;
    private Shop<Saab95> testS;
    private Shop<Transportable> testTr;
    private int max = 8;
    private Volvo240 volvo;
    private Saab95 saab;
    @Before
    public void init() {
        testV = new Shop(max, "Ronnys Bil och Sil");
        testS = new Shop(max,"Ronnys Bil och Sil");
        testTr = new Shop(max,"Ronnys Bil och Sil");
        volvo = new Volvo240();
        saab = new Saab95();
    }
    /*
    "Testing" is done "automatically" by the code does not compile when adding "wrong" cars to a Shop.
     */

    @Test
    public void testThatCanAddSaabToShopTransportabe() {
        testTr.addCar(saab);
        assertTrue(testTr.getCars().contains(saab));


    }

    @Test
    public void testThatCanAddVolvoToShopTransportabe() {
        testTr.addCar(volvo);
        assertTrue(testTr.getCars().contains(volvo));
    }
}
