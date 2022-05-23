package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int totalMoney = 550;
        int totalWater = 400;
        int totalMilk = 540;
        int totalCoffeeBeans = 120;
        int totalCups = 9;

        System.out.println("The coffee machine has: \n400 ml of water \n540 ml of milk\n" +
                "120 g of coffee beans\n9 disposable cups\n$550 of money");

        System.out.println("Write action (buy, fill, take): ");
        String userActionChoice = scanner.next();

        switch (userActionChoice) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                int userMenuChoice = scanner.nextInt();
                if (userMenuChoice == 1) {
                    totalWater -= 250;
                    totalCoffeeBeans -= 16;
                    totalMoney += 4;
                    totalCups -= 1;
                } else if (userMenuChoice == 2) {
                    totalWater -= 350;
                    totalMilk -= 75;
                    totalCoffeeBeans -= 20;
                    totalMoney += 7;
                    totalCups -= 1;
                } else if (userMenuChoice == 3) {
                    totalWater -= 200;
                    totalMilk -= 100;
                    totalCoffeeBeans -= 12;
                    totalMoney += 6;
                    totalCups -= 1;
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                int fillWater = scanner.nextInt();
                totalWater = totalWater + fillWater;
                System.out.println("Write how many ml of milk you want to add:");
                int fillMilk = scanner.nextInt();
                totalMilk = totalMilk + fillMilk;
                System.out.println("Write how many grams of coffee beans you want to add:");
                int fillCoffeeBeans = scanner.nextInt();
                totalCoffeeBeans = totalCoffeeBeans + fillCoffeeBeans;
                System.out.println("Write how many disposable cups of coffee you want to add:");
                int fillCoffeeCups = scanner.nextInt();
                totalCups = totalCups + fillCoffeeCups;
                break;
            case "take":
                totalMoney = 0;
                System.out.println("I gave you $" + totalMoney);
                break;
        }

        System.out.println("The coffee machine has: ");
        System.out.println(totalWater + " ml of water");
        System.out.println(totalMilk + " ml of milk");
        System.out.println(totalCoffeeBeans + " g of coffee beans");
        System.out.println(totalCups + " disposable cups");
        System.out.println("$" + totalMoney + " of money");

    }
}
