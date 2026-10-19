import java.util.Scanner;

public class AnnuityPresentValue {
    public static void main (String[] args) {
        System.out.println("=== Present value of annuity calculator ===");

        Scanner myScanner = new Scanner(System.in);

        System.out.print("\nEnter your monthly payment in dollars (e.g. 3000): ");
        double monthlyPayment = myScanner.nextDouble();
        myScanner.nextLine();

        System.out.print("Enter the expected annual interest rate as a percent (e.g. 2.5): ");
        double annualInterest = myScanner.nextDouble();
        myScanner.nextLine();

        System.out.print("Enter the number of years the annuity pays out (e.g. 20): ");
        int years = myScanner.nextInt();
        myScanner.nextLine();

        int numberOfPayments = numberOfPayments(years);
        double monthlyRate = monthlyRate(annualInterest);
        double presentValue = presentValue(monthlyPayment, numberOfPayments, monthlyRate);

        System.out.println("\n--- Present value of the annuity: $" + Math.round(presentValue * 100.0) / 100.0 +
                "\n* To fund an annuity that pays $" + monthlyPayment + " monthly for " + years +
                " years\nand earns an expected " + annualInterest + "% interest,\nyou would need to invest $" + Math.round(presentValue * 100.0) / 100.0 + " today.");
    }

    public static double presentValue(double monthlyPayment, int numberOfPayments, double monthlyRate) {
        // present value = payment * (1 - Math.pow((1 + interest), - number of payments)) / interest
        return monthlyPayment * (1 - Math.pow((1 + monthlyRate), -numberOfPayments)) / monthlyRate;
    }

    public static int numberOfPayments(int years) {
        //years multiplied by 12 months to calculate total number of payments
        return years * 12;
    }

    public static double monthlyRate(double annualInterest) {
        return annualInterest / 100.0 / 12;
    }
}
