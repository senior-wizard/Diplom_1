import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTestParameterized {

    public String name;
    public float price;

    public BunTestParameterized(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Black", -3},
                {"White", 0},
        };
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBunException() {
        Bun bun = new Bun(name, price);
        bun.getPrice();
    }
}
