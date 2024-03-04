import java.util.Random;
import java.util.Scanner;

class CrapsSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        char playAgain;

        do {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("You rolled: " + die1 + " and " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You won.");
            } else {
                System.out.println("Point is set to " + sum);
                boolean gameOver = false;

                while (!gameOver) {
                    int roll1 = rnd.nextInt(6) + 1;
                    int roll2 = rnd.nextInt(6) + 1;
                    int rollSum = roll1 + roll2;
                    System.out.println("You rolled: " + roll1 + " and " + roll2 + " = " + rollSum);

                    if (rollSum == sum) {
                        System.out.println("You made the point! You won.");
                        gameOver = true;
                    } else if (rollSum == 7) {
                        System.out.println("You rolled a 7. You lost.");
                        gameOver = true;
                    } else {
                        System.out.println("Trying for point again.");
                    }
                }
            }

            System.out.println("Do you want to play again? (Y/N)");
            playAgain = scanner.next().charAt(0);
            scanner.nextLine(); // consume newline
        } while (Character.toUpperCase(playAgain) == 'Y');

        scanner.close();
    }
}
