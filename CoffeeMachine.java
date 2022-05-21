package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has: ");
        int totalWaterML = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has: ");
        int totalMilkML = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int totalCoffeeBeansGM = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need: ");
        int totalCupsOfCoffeeRequired = scanner.nextInt();

        int waterReqPerCupML = 200;
        int milkReqPerCupML = 50;
        int coffeeBeansReqPerCupGM = 15;

        // actual possible per ingredient
        int actualWaterPossible = totalWaterML / waterReqPerCupML;
        int actualMilkPossible = totalMilkML / milkReqPerCupML;
        int actualCoffeeBeansPossible = totalCoffeeBeansGM / coffeeBeansReqPerCupGM;

        int totalCoffeePossibleActual = Math.min(actualWaterPossible, Math.min(actualMilkPossible, actualCoffeeBeansPossible));
        // finds the minimum number of coffee that can be made

        if (totalCoffeePossibleActual == totalCupsOfCoffeeRequired) {
            System.out.println("Yes, I can make that amount of coffee");
        }   else if (totalCoffeePossibleActual > totalCupsOfCoffeeRequired) {
            int extraCupsCanBeMade = totalCoffeePossibleActual - totalCupsOfCoffeeRequired;
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCupsCanBeMade +
                    " more than that)");
        }   else {
            System.out.println("no, I can make only " + totalCoffeePossibleActual + " cup(s) of coffee");
        }



    }
}
