package praktikum.dependency.injection;

import praktikum.IngredientType;

public interface IIngredient {
    float getPrice();
    String getName();
    IngredientType getType();
}
