package praktikum;

import praktikum.dependency.injection.IBun;
import praktikum.dependency.injection.IIngredient;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private final List<IBun> buns = new ArrayList<>();
    private final List<IIngredient> ingredients = new ArrayList<>();

    public Database() {
        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));

        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));
    }

    public List<IBun> availableBuns() {
        return new ArrayList<>(buns);
    }

    public List<IIngredient> availableIngredients() {
        return new ArrayList<>(ingredients);
    }
}