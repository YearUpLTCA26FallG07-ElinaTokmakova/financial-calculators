import java.util.Scanner;

public class DepositFutureValue {
    public static void main (String[] args) {
       Scanner newScanner = new Scanner(System.in);

        System.out.println("=== CD calculator ===");

        System.out.print("\nEnter your deposit amount: ");
        double principal = newScanner.nextDouble();;
        newScanner.nextLine();

        System.out.print("Enter annual interest rate as a percent (e.g. 1.75): ");
        double interestPercent = newScanner.nextDouble();
        newScanner.nextLine();

        System.out.print("Enter CD term length in year (e.g. 5): ");
        int termInYears = newScanner.nextInt();
        newScanner.nextLine();

        double interestRate = interestRate(interestPercent);
        int totalDays = 365 * termInYears;
        double futureValue = futureValue(principal, interestRate, totalDays);
        double totalInterest = totalInterest(futureValue, principal);

        //display output
        System.out.println("\n--- Total interest earned: $" + Math.round(totalInterest * 100.0) / 100.0 +
                "\n--- Total future value in " + termInYears + " years: $" + Math.round(futureValue * 100.0) / 100.0);
    }

    public static double interestRate(double interestPercent) {
        return interestPercent / 100.0;
    }

    public static double futureValue(double principal, double interestRate, int totalDays) {
        return principal * Math.pow((1 + (interestRate / 365)), totalDays);
    }

    public static double totalInterest(double futureValue, double principal) {
        return futureValue - principal;
    }
}
