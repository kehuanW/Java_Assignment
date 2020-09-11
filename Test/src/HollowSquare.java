
import java.util.Scanner;

public class HollowSquare {
    public static void main(String[] args) {
        /**
         * prompts the user to enter the size of the side of a square
         * then displays a hollow square of that size made of asterisks.
         * The program should work for squares of all side lengths between 1 and 20.
         */

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter the size of the side of a square");
//        int size = scanner.nextInt();

        int size = 10;

        //第1行
        int k = 0;
        while(k < size) {
            System.out.print("*");
            k++;
        }
        System.out.println();

        //第2行到第9行
        for (int i = 1;i < size-1; i++){
            System.out.print("*");
            for (int j = 0; j < size - 2; j++){
                System.out.print(" ");
            }
            System.out.println("*");
        }

        //第10行
        int m = 0;
        while(m < size) {
            System.out.print("*");
            m++;
        }

    }
}
