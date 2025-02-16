package praktikum;

import praktikum.dependency.injection.IIngredient;

public class Ingredient implements IIngredient {
    public IngredientType type;
    public String name;
    public float price;

    public Ingredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IngredientType getType() {
        return type;
    }
}
