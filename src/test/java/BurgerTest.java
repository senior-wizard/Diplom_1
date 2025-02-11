import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Burger burger;
    private Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = new Bun("Sesame Bun", 1); // Предполагаем, что класс Bun уже существует
        burger.setBuns(bun);
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "bacon", 2);
        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
        assertEquals("bacon", burger.ingredients.get(0).getName());
    }

    @Test
    public void testRemoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "bacon", 2);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "BBQ", 1);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0); // Удаляем ингредиент по индексу 0
        assertEquals(1, burger.ingredients.size());
        assertEquals("BBQ", burger.ingredients.get(0).getName());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "bacon", 2);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "BBQ", 1);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1); // Перемещаем Cheese на вторую позицию
        assertEquals("BBQ", burger.ingredients.get(0).getName());
        assertEquals("bacon", burger.ingredients.get(1).getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "bacon", 2);
        burger.addIngredient(ingredient);

        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice(); // Основная цена
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceipt() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "bacon", 2);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "BBQ", 1);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Формируем ожидаемый чек
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName()) +
                String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
