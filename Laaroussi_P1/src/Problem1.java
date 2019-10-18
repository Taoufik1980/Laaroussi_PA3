/*Taoufik Laaroussi
* Assignment 3 Problem 1
* Class COP 3300*/

import java.util.Scanner;
import java.util.Random;

public class Problem1 {

    // Method that return the comment based on the users answer
    public static void answerComment(int value) {
        Random rand = new Random();
        if (value == 0) {
            int randVal = rand.nextInt(4);
            switch (randVal) {
                case 0:
                    System.out.println("No. Please try again.");
                    break;
                case 1:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 2:
                    System.out.println("Don’t give up!");
                    break;
                case 3:
                    System.out.println("No. Keep trying.");
                    break;
            }
        } else if (value == 1) {
            int randVal = rand.nextInt(4);
            switch (randVal) {
                case 0:
                    System.out.println("Very good!");
                    break;
                case 1:
                    System.out.println("Excellent!");
                    break;
                case 2:
                    System.out.println("Nice work!");
                    break;
                case 3:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }

    }

    // Method that generate the questions based on the user choice of arithmetic operations
    // and return the result to the previous method
    public static double generateQuestion(int num1, int num2, int artChoice) {
        double result = 0;
        if (artChoice == 1) {
            System.out.println("How much is " + num1 + " plus " + num2 + "?");
            result = (double) num1 + num2;
        } else if (artChoice == 2) {
            System.out.println("How much is " + num1 + " times " + num2 + "?");
            result = (double) num1 * num2;
        } else if (artChoice == 3) {
            System.out.println("How much is " + num1 + " mines " + num2 + "?");
            result = (double) num1 - num2;
        } else if (artChoice == 4) {
            System.out.println("How much is " + num1 + " divided by " + num2 + "?");
            result = (double) num1 / num2;
        }

        return result;
    }

    // Method generate random number based on the user choice of level of difficulty
    public static double getRandomQuestion(int level, int artChoice) {
        Random rand = new Random();
        int size = 2;
        double result = 0;
        int[] numArray = new int[size];
        if (level == 1) {
            for (int i = 0; i < size; ++i) {
                numArray[i] = rand.nextInt(9) + 1;
            }
        } else if (level == 2) {
            for (int i = 0; i < size; ++i) {
                numArray[i] = rand.nextInt(89) + 10;
            }
        } else if (level == 3) {
            for (int i = 0; i < size; ++i) {
                numArray[i] = rand.nextInt(899) + 100;
            }
        } else if (level == 4) {
            for (int i = 0; i < size; ++i) {
                numArray[i] = rand.nextInt(8999) + 1000;
            }
        }
        if (artChoice == 1 || artChoice == 2 || artChoice == 3 || artChoice == 4) {
            result = generateQuestion(numArray[0], numArray[1], artChoice);
        } else if (artChoice == 5) {
            int numrand = rand.nextInt(4) + 1;
            result = generateQuestion(numArray[0], numArray[1], numrand);
        }
        return result;
    }

    // Method check the user result using floating-point comparison
    public static int answerCheck(double num1, double num2) {

        if (Math.abs(num1 - num2) < 0.0001) {
            return 1;
        } else return 0;
    }

    // Method to evaluate the number of correct questions and return 1 in case of pass and 0 for fail
    public static int evaluation(int count) {
        double result;
        result = (count / 10.0) * 100;
        if (result >= 75) {
            return 1;
        } else return 0;
    }

    // Method display a Menu for level choice and returns the number corresponding to each operation
    // based on the user choice
    public static int difficultyLevel(Scanner sc) {
        System.out.println("Choose your level of difficulty: ");
        System.out.println("1. For one digit operations.");
        System.out.println("2. For two digits operations.");
        System.out.println("3. For three digits operations.");
        System.out.println("4. For four digits operations.");
        System.out.print("Enter your choice here: ");
        int usrLevel = sc.nextInt();
        if (usrLevel == 1) {
            return 1;
        } else if (usrLevel == 2) {
            return 2;
        } else if (usrLevel == 3) {
            return 3;
        } else if (usrLevel == 4) {
            return 4;
        } else
            return 0;
    }

    // Method display a Menu for operation type and returns the number corresponding to each operation
    // based on the user choice
    public static int operationType(Scanner sc) {
        System.out.println("Choose your type of arithmetic problem to study: ");
        System.out.println("1. Addition problems only.");
        System.out.println("2. Multiplication problems only.");
        System.out.println("3. Subtraction problems only.");
        System.out.println("4. Division problems only.");
        System.out.println("5. Random mixture of all these types.");
        System.out.print("Enter your choice here: ");
        int usrLevel = sc.nextInt();
        if (usrLevel == 1) {
            return 1;
        } else if (usrLevel == 2) {
            return 2;
        } else if (usrLevel == 3) {
            return 3;
        } else if (usrLevel == 4) {
            return 4;
        } else if (usrLevel == 5) {
            return 5;
        } else
            return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int evalAns, count, tries = 10, result, level, aritChoice;
        double answer, usrAnswer;
        char choice = 'y';

        // Loop to keep running the program based on the user choice
        while (choice == 'y' || choice == 'Y') {
            System.out.printf("\n<<<  Welcome to the arithmetic operations learning  >>>\n");
            System.out.printf("                         Program                     \n");
            System.out.printf("||-------------------------------------------------------||\n");
            aritChoice = operationType(sc);
            level = difficultyLevel(sc);
            count = 0;
            for (int i = 0; i < tries; i++) {
                answer = getRandomQuestion(level, aritChoice);
                usrAnswer = sc.nextDouble();
                evalAns = answerCheck(answer, usrAnswer);
                if (evalAns == 1) {
                    answerComment(evalAns);
                    count++;
                } else answerComment(evalAns);
            }
            result = evaluation(count);

            // Final result display to the user
            if (result == 1) {
                System.out.println("Congratulations, you are ready to go to the next level!");
                System.out.println("You have " + count + " Correct of 10 questions");
            } else {
                System.out.println("Please ask your teacher for extra help.");
                System.out.println("You have " + count + " Correct of 10 questions");
            }
            System.out.print("Do you want another try? Y / N : ");
            choice = sc.next().charAt(0);
        }
    }
}
