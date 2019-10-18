/*Taoufik Laaroussi
 * Assignment 3 COP 3300 Class*/

public class SavingsAccount {

    //Private static and private instance variables declaration
    private static double annualInterestRate;
    private double savingsBalance;
//Public method to calculate the monthly interest rate and the new balance
    public void calculateMonthlyInterest(double balance, int numMonths){
        double monthlyInterest;
        savingsBalance = balance;
        System.out.printf("\nThe current balance is: $%.2f\n", savingsBalance );
        System.out.printf("--------------------------------------\n");
        for(int i=0; i<numMonths; ++i) {
            monthlyInterest = (savingsBalance * (annualInterestRate/100)) / 12;
            savingsBalance += monthlyInterest;
            System.out.printf("Interest for month %d is: $%.2f\n", (i+1) , monthlyInterest);
        }
        System.out.printf("--------------------------------------");
        System.out.printf("\nThe new balance is: $%.2f\n", savingsBalance );
        System.out.printf("--------------------------------------\n");

    }
//Public method to save the annual rate on private static variable annualInterestRate
    public static void modifyInterestRate(double annualInterest){
        annualInterestRate = annualInterest;
        System.out.println("Interest rate is: " + annualInterest + " %");
    }
}
