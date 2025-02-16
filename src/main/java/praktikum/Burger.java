package praktikum;

import praktikum.dependency.injection.IBun;
import praktikum.dependency.injection.IIngredient;

import java.util.ArrayList;
import java.util.List;

public class Burger {
    private IBun bun;
    List<IIngredient> ingredients = new ArrayList<>();

    public Burger(IBun bun) {
        this.bun = bun;
    }

    public void setBuns(IBun bun) {
        this.bun = bun;
    }

    public void addIngredient(IIngredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(int index) {
        ingredients.remove(index);
    }

    public void moveIngredient(int index, int newIndex) {
        ingredients.add(newIndex, ingredients.remove(index));
    }

    public float getPrice() {
        float price = bun.getPrice() * 2;

        for (IIngredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }

        return price;
    }

    public String getReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (IIngredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", getPrice()));

        return receipt.toString();
    }
}
