import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        /**
         * Write an application that reads a five-letter word from the user
         * produces every possible three-letter string that can be derived from the letters of that word.
         */

        //Read every letter in the word
        String str = "";

        while (str.length() != 5){

            System.out.println("Please enter a five-letter word!");
            Scanner scanner = new Scanner(System.in);
            str = scanner.next();

        }

        char data[] = new char[5];
        for (int k = 0; k < str.length(); k++){
            data[k] = str.charAt(k);

        }

        String str_change0 = new String(data);
        MyList myList0 = new MyList();
        myList0.Listgenrate(str_change0);


        //Every letter has a chance to get to the first position
        int m = 0;
        while (m < str.length()) {

            if(data[0] != data[m]){
                char temp = data[0];
                data[0] = data[m];
                data[m] = temp;
                String str_change = new String(data);
                MyList myList = new MyList();
                myList.Listgenrate(str_change);
                m++;
            } else {
                m++;
            }

        }

    }

}


