package machine;

public enum CoffeeTypes {
    ESPRESSO(250, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    int water;
    int milk;
    int beans;
    int price;

    CoffeeTypes(int water, int beans, int price) {
        this.water = water;
        this.beans = beans;
        this.price = price;
    }

    CoffeeTypes(int water, int milk, int beans, int price) {
        this(water, beans, price);
        this.milk = milk;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getPrice() {
        return price;
    }



}
