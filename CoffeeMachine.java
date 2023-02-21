package machine;

import java.util.Locale;

public class CoffeeMachine {
    private MachineState current;
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        menu();
    }

    public void menu() {
        current = MachineState.MENU;
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
    }


    public void inputHandler(String input) {
        switch (current) {
            case MENU:
                action(input);
                break;
            case BUYINGCOFFEE:
                coffeeOption(input);
                break;
            case FILLINGWATER:
                fillingWater(input);
                break;
            case FILLINGMILK:
                fillingMilk(input);
                break;
            case FILLINGBEANS:
                fillingBeans(input);
                break;
            case FILLINGCUPS:
                fillingCups(input);
                break;
        }
    }

    public void action(String input) {
        switch (input.toLowerCase(Locale.ROOT)) {
            case "buy":
                buy();
                current = MachineState.BUYINGCOFFEE;
                break;
            case "fill":
                System.out.println("\nWrite how many ml of water you want to add: ");
                current = MachineState.FILLINGWATER;
                break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
                break;
            case "exit":
                System.exit(0);
                break;
        }
    }


    public void remaining() {
        System.out.println("\nThe coffee machine has: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        menu();
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
        menu();
    }

    public void fillingWater(String input) {
        water += Integer.parseInt(input);
        current = MachineState.FILLINGMILK;
        System.out.println("Write how many ml of milk you want to add: ");
    }

    public void fillingMilk(String input) {
        milk += Integer.parseInt(input);
        current = MachineState.FILLINGBEANS;
        System.out.println("Write how many grams of coffee beans you want to add: ");
    }

    public void fillingBeans(String input) {
        beans += Integer.parseInt(input);
        current = MachineState.FILLINGCUPS;
        System.out.println("Write how many disposable cups of coffee you want to add:");
    }

    public void fillingCups(String input) {
        cups += Integer.parseInt(input);
        menu();
    }


    public void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
    }

    public void coffeeOption(String input) {
        switch (input) {
            case "1":
                coffeeMaking(CoffeeTypes.ESPRESSO);
                break;
            case "2":
                coffeeMaking(CoffeeTypes.LATTE);
                break;
            case "3":
                coffeeMaking(CoffeeTypes.CAPPUCCINO);
                break;
            case "back":
                menu();
                break;
        }
    }

    public void coffeeMaking (CoffeeTypes coffeeTypes) {
        // boolean checks to see if ingredients are sufficient or not
        boolean isWater = water > coffeeTypes.getWater();
        boolean isMilk = milk > coffeeTypes.getMilk();
        boolean isBeans = beans > coffeeTypes.getBeans();
        boolean isCups = cups > 0;

        // if all items sufficient = true, then
        if (isWater && isMilk && isBeans && isCups) {
            water -= coffeeTypes.getWater();
            milk -= coffeeTypes.getMilk();
            beans -= coffeeTypes.getBeans();
            money += coffeeTypes.getPrice();
            cups -= 1;
            System.out.println("I have enough resources, making you a coffee!");
            menu();
        }   else {
            // if everything is not true, then individual checks on what item is insufficient
            if (!isWater) {
                System.out.println("Sorry, not enough water!");
            } else if (!isMilk) {
                System.out.println("Sorry, not enough milk!");
            } else if (!isBeans) {
                System.out.println("Sorry, not enough coffee beans!");
            } else if (!isCups) {
                System.out.println("Sorry, not enough cups!");
            }
            menu();
        }

    }

}