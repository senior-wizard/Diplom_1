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
        bun = new Bun("Black", 123);
        assertEquals("Black", bun.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNameException() {
        bun = new Bun("", 123);
        bun.getName();
    }

    @Test
    public void testGetPrice() {
        bun = new Bun("Black", 123);
        assertEquals(123, bun.getPrice(), 0.001);
    }
}
