import java.util.Scanner;

public class Main {
    /**
     * Two six-sided dice are rolled. Their sum lies between 2 and 12.
     * ask the user for n (the number of rolls) and then simulates the rolling of the two dice n times.
     * simulate the rolling of each die and then add to compute the total.
     * draw a bar chart showing the respective frequency of each total. (a console based application)
     * Your program will use "*" characters to represent dice rolls.
     * The number of stars that you use and the design of the output is up to you but must be clear to the user.
     * generate the same number of stars despite the number of requested rolls.
     * That is, each star should represent a percentage of rolls.
     */
    public static void main(String[] args) {

        System.out.println("How many times do you want to roll the two dice?");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("Let's roll " + n + " times.");
        int[] totalArray = TwoDices.roll(n);
        Simulation.display(n, totalArray);

    }
}
