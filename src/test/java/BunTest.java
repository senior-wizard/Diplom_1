import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Black", 123);
    }

    @Test
    public void testGetName() {
        assertEquals("Black", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(123, bun.getPrice(), 0.001);
    }
}
