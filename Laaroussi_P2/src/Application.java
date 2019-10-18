
/*Taoufik Laaroussi
* Assignment 3 COP 3300 Class*/

public class Application {

    public static void main(String[] args){
        //Create 2 objects os SavingAccount
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        // Call methodes inside the class SavingsAccount for 2 objects
        System.out.printf("\n Saver 1 account information ");
        System.out.printf("\n--------------------------------\n");
        saver1.modifyInterestRate(4);
        saver1.calculateMonthlyInterest(2000.00, 12);
        System.out.printf("\n Saver 2 Account information ");
        System.out.printf("\n--------------------------------\n");
        saver2.modifyInterestRate(4);
        saver2.calculateMonthlyInterest(3000.00, 12);

        System.out.printf("\n Saver 1 Account information ");
        System.out.printf("\n--------------------------------\n");
        saver1.modifyInterestRate(5);
        saver1.calculateMonthlyInterest(2000.00, 1);
        System.out.printf("\n Saver 2 Account information ");
        System.out.printf("\n--------------------------------\n");
        saver2.modifyInterestRate(5);
        saver2.calculateMonthlyInterest(3000.00, 1);
    }
}
