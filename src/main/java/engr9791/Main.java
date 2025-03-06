package engr9791;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an integer: ");
            int value = scanner.nextInt();

            try {
                int result = Factorial.factorial(value);
                System.out.println(result);
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }

            System.out.print("Another factorial? (y/n): ");
            String answer = scanner.next();

            if (answer.toLowerCase().equals("n")) {
                break;
            }
        }

        scanner.close();
    }
}