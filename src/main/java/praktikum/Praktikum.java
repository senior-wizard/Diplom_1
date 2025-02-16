package praktikum;

import praktikum.dependency.injection.IBun;
import praktikum.dependency.injection.IIngredient;

import java.util.List;

public class Praktikum {

    public static void main(String[] args) {
        // Инициализируем базу данных
        Database database = new Database();

        // Соберём список доступных булочек из базы данных
        List<IBun> buns = database.availableBuns();

        // Соберём список доступных ингредиентов из базы данных
        List<IIngredient> ingredients = database.availableIngredients();

        // Создадим новый бургер с первой доступной булочкой
        Burger burger = new Burger(buns.get(0));

        // Добавим ингредиенты в бургер
        burger.addIngredient(ingredients.get(1)); // sour cream
        burger.addIngredient(ingredients.get(4)); // dinosaur
        burger.addIngredient(ingredients.get(3)); // cutlet
        burger.addIngredient(ingredients.get(5)); // sausage

        // Переместим слой с ингредиентом
        burger.moveIngredient(2, 1);

        // Удалим ингредиент
        burger.removeIngredient(3); // Удаляем индекс 3 (sausage)

        // Распечатаем рецепт бургера
        System.out.println(burger.getReceipt());
    }
}