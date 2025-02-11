import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, "bacon", 79);
    }

    @Test
    public void testGetPrice() {
        assertEquals(79, ingredient.getPrice(), 0.001);
    }

    @Test
    public void testGetName() {
        assertEquals("bacon", ingredient.getName());
    }
}
