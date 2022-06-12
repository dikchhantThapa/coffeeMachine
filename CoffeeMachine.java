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

        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String userActionChoice = scanner.next();
            if ("buy".equals(userActionChoice)) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                int userMenuChoice = scanner.nextInt();

                if (userMenuChoice == 1) {
                    if (totalWater >= 250 && totalCoffeeBeans >= 16 && totalCups >= 1) {
                        System.out.println("I have enough resources, making you a coffee!");
                        totalWater -= 250;
                        totalCoffeeBeans -= 16;
                        totalMoney += 4;
                        totalCups -= 1;
                    } else if (totalWater < 250) {
                        System.out.println("Sorry, not enough water!");
                    } else if (totalCoffeeBeans < 16) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (totalCups < 1) {
                        System.out.println("Sorry, not enough cups");
                    }
                } else if (userMenuChoice == 2) {
                    if (totalWater >= 350 && totalMilk >= 75 && totalCoffeeBeans >= 75 && totalCups >= 1) {
                        System.out.println("I have enough resources, making you a coffee!");
                        totalWater -= 350;
                        totalMilk -= 75;
                        totalCoffeeBeans -= 20;
                        totalMoney += 7;
                        totalCups -= 1;
                    } else if (totalWater < 350) {
                        System.out.println("Sorry, not enough water!");
                    } else if (totalMilk < 75) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (totalCoffeeBeans < 20) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (totalCups < 1) {
                        System.out.println("Sorry, not enough cups");
                    }
                } else if (userMenuChoice == 3) {
                    if (totalWater >= 200 && totalMilk >= 100 && totalCoffeeBeans >= 12 && totalCups >= 1) {
                        System.out.println("I have enough resources, making you a coffee!");
                        totalWater -= 200;
                        totalMilk -= 100;
                        totalCoffeeBeans -= 12;
                        totalMoney += 6;
                        totalCups -= 1;
                    } else if (totalWater < 200) {
                        System.out.println("Sorry, not enough water!");
                    } else if (totalMilk < 100) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (totalCoffeeBeans < 12) {
                        System.out.println("Sorry, not enough coffee beans");
                    } else if (totalCups < 1) {
                        System.out.println("Sorry, not enough cups");
                    }

                }
            } else if ("fill".equals(userActionChoice)) {
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
            } else if ("take".equals(userActionChoice)) {
                totalMoney = 0;
                System.out.println("I gave you $" + totalMoney);
            } else if ("remaining".equals(userActionChoice)) {
                System.out.println("The coffee machine has: ");
                System.out.println(totalWater + " ml of water");
                System.out.println(totalMilk + " ml of milk");
                System.out.println(totalCoffeeBeans + " g of coffee beans");
                System.out.println(totalCups + " disposable cups");
                System.out.println("$" + totalMoney + " of money");
            } else if ("exit".equals(userActionChoice)) {
                continueProgram = false;
            }
        }

    }

}
