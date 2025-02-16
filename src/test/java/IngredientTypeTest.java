import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testEnumValues() {
        // Проверка, что в перечислении есть два значения: SAUCE и FILLING
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
        assertSame(IngredientType.SAUCE, values[0]);
        assertSame(IngredientType.FILLING, values[1]);
    }

    @Test
    public void testEnumNamesSauces() {
        // Проверка, что имена перечислений верные
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testEnumNamesFilling() {
        // Проверка, что имена перечислений верные
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}
