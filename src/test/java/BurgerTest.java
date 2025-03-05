package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.dependency.injection.IBun;
import praktikum.dependency.injection.IIngredient;

import static org.junit.Assert.assertEquals;

public class BurgerTest {
    private IBun mockBun;
    private IIngredient mockIngredient1;
    private IIngredient mockIngredient2;
    private Burger burger;

    @Before
    public void setUp() {
        mockBun = Mockito.mock(IBun.class);
        mockIngredient1 = Mockito.mock(IIngredient.class);
        mockIngredient2 = Mockito.mock(IIngredient.class);

        // Настройка поведения моков
        Mockito.when(mockBun.getName()).thenReturn("mock bun");
        Mockito.when(mockBun.getPrice()).thenReturn(100f);
        Mockito.when(mockIngredient1.getName()).thenReturn("mock ingredient 1");
        Mockito.when(mockIngredient1.getPrice()).thenReturn(50f);
        Mockito.when(mockIngredient2.getName()).thenReturn("mock ingredient 2");
        Mockito.when(mockIngredient2.getPrice()).thenReturn(75f);

        burger = new Burger(mockBun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testGetPrice() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        float expectedPrice = (100f * 2) + 50f + 75f; // 2 * цена булочки + цена ингредиентов
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0); // Удаляем первый ингредиент
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2.getName(), burger.ingredients.get(0).getName());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1); // Перемещаем первый ингредиент на вторую позицию
        assertEquals(mockIngredient2.getName(), burger.ingredients.get(0).getName());
        assertEquals(mockIngredient1.getName(), burger.ingredients.get(1).getName());
    }

    @Test
    public void testGetReceipt() {
        burger.addIngredient(mockIngredient1); // mock ingredient 1
        burger.addIngredient(mockIngredient2); // mock ingredient 2

        Mockito.when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);

        String expectedReceipt = String.format(
                "(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %.6f%n",
                mockBun.getName(),
                mockIngredient1.getType().toString().toLowerCase(),
                mockIngredient1.getName(),
                mockIngredient2.getType().toString().toLowerCase(),
                mockIngredient2.getName(),
                mockBun.getName(),
                burger.getPrice()
        );

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
