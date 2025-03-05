package praktikum;

import praktikum.dependency.injection.IBun;

public class Bun implements IBun {
    public String name;
    public float price;

    public Bun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        if (!name.isEmpty()) {
            return name;
        } else {
            throw new IllegalArgumentException ("Название не может быть пустым");
        }
    }

    @Override
    public float getPrice() {
        if (price > 0) {
            return price;
        } else {
            throw new IllegalArgumentException ("Цена булочки не может быть отрицательной");
        }
    }
}