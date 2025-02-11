import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTestParameterized {

    public IngredientType type;

    public IngredientTestParameterized(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] IngredientData() {
        return new Object[][]{
                {IngredientType.FILLING},
                {IngredientType.SAUCE}
        };
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(type, "BBQ", 79);
        assertEquals(type, ingredient.getType());
    }
}
