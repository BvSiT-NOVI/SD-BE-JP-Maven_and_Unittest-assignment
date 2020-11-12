package nl.novi.javaprogrammeren;

import java.text.NumberFormat;
import java.util.Locale;

public class BadMoney {

    public static void main(String[] args) {
        // Example 1
        float originalPrice = 400000.00f;
        // to make the price more attractive, we'll reduce it to $399999.95
        float reducedPrice = originalPrice - 0.05f;
        float discount = originalPrice - reducedPrice;
        // Display discount amount
        System.out.println("De korting is: " + discount);

        // Example 2
        // The amount you have in the bank: $12,345,678.12
        float moneyInBank = 12345678.12f;
        int count;    // count number of iterations
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.GERMANY);  // for output formatting.

        // Display the original amount
        System.out.println( "Originele aantal geld in de bank: "
                + fmt.format(moneyInBank) + ".");

        // Add a dime to the principal a thousand times
        for (count = 1; count <= 1000; count = count + 1) {
            moneyInBank = moneyInBank + .10f;
        }

        // The result should be 100 dollars larger.
        System.out.println( "Het nieuwe aantal geld in de bank: "
                + fmt.format(moneyInBank) + ".");

        // Example 3
        double floatNumber = 4.35;
        int integerNumber = (int) (100 * floatNumber);
        System.out.println("Uitkomst van de berekening: " + integerNumber);

    }
}
