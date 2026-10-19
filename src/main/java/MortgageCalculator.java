import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.print("=== Mortgage calculator ===");

        System.out.print("\n\nEnter total amount of your loan (e.g. '53000'): ");
        double principal = myScanner.nextDouble();
        myScanner.nextLine();

        System.out.print("Enter annual interest rate in percent (e.g. '7.625'): ");
        double interestPercent = myScanner.nextDouble();
        myScanner.nextLine();

        System.out.print("Enter a loan term in years (e.g. '12'): ");
        int termInYears = myScanner.nextInt();
        myScanner.nextLine();

        double annualInterestRate = interestRate(interestPercent);
        int numberOfPayments = numberOfPayments(termInYears);
        double monthlyInterestRate = monthlyInterestRate(annualInterestRate);
        double monthlyPayment = monthlyPayment(principal, monthlyInterestRate, numberOfPayments);
        double totalInterest = totalInterest(monthlyPayment, numberOfPayments, principal);

        //display output
        System.out.println("\n--- Your monthly payment: $" + Math.round(monthlyPayment * 100.0) / 100.0 + " per month" +
                "\n--- Total interest over " + termInYears + " years: $" + Math.round(totalInterest * 100.0) / 100.0);
    }

    public static double interestRate(double interestPercent) {
        return interestPercent / 100.0;
    }

    public static int numberOfPayments(int termInYears) {
        return termInYears * 12;
    }

    public static double monthlyInterestRate(double annualInterestRate) {
        return annualInterestRate / 12.0;
    }

    public static double totalInterest(double monthlyPayment, int numberOfPayments, double principal) {
        return monthlyPayment * numberOfPayments - principal;
    }

    public static double monthlyPayment(double principal, double monthlyInterestRate, int numberOfPayments) {
        return principal * (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments) / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1));
    }
}
