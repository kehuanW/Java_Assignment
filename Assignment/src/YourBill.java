import java.util.Scanner;

public class YourBill {
    public static void main(String[] args) {


        //Scanner the name, quantity and price of item 1
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Input name of item 1:");
        String item1Name = scanner1.nextLine();

        System.out.println("Input quantity of item 1:");
        long item1Quantity = scanner1.nextLong();

        System.out.println("Input price of item 1:");
        double item1Price = scanner1.nextDouble();


        //Scanner the name, quantity and price of item 2
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Input name of item 2:");
        String item2Name = scanner2.nextLine();

        System.out.println("Input quantity of item 2:");
        long item2Quantity = scanner2.nextLong();

        System.out.println("Input price of item 2:");
        double item2Price = scanner2.nextDouble();


        //Scanner the name, quantity and price of item 3
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Input name of item 3:");
        String item3Name = scanner3.nextLine();

        System.out.println("Input quantity of item 3:");
        long item3Quantity = scanner3.nextLong();

        System.out.println("Input price of item 3:");
        double item3Price = scanner3.nextDouble();


        //calculate each item total price
        double item1Total = item1Price * item1Quantity;
        double item2Total = item2Price * item2Quantity;
        double item3Total = item3Price * item3Quantity;


        //calculate the total price of all items
        double subtotal = item1Total + item2Total + item3Total;

        //calculate the actual tax the user should pay
        double itemsTax = subtotal * 0.0625;


        //calculate the final amount
        double Total = subtotal + itemsTax;

        //crate lengthFormat
        LengthFormat lengthFormat = new LengthFormat();


        //Output result
        //Title
        System.out.println("Your bill:");
        System.out.println();

        //1st line: attributes
        System.out.printf("%-30s","Item");
        System.out.printf("%-10s","Quantity");
        System.out.printf("%-10s","Price");
        System.out.printf("%-10s","Total");
        System.out.println();

        //2nd line: information of item 1
        System.out.printf("%-30s",lengthFormat.Lengthcontrol(item1Name,30));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item1Quantity,10));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item1Price,10));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item1Total,10));
        System.out.println();

        //3th line: information of item 2
        System.out.printf("%-30s",lengthFormat.Lengthcontrol(item2Name,30));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item2Quantity,10));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item2Price,10));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item2Total,10));
        System.out.println();

        //4th line: information of item 3
        System.out.printf("%-30s",lengthFormat.Lengthcontrol(item3Name,30));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item3Quantity,10));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item3Price,10));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item3Total,10));
        System.out.println();

        //5th line: subtotal
        System.out.printf("%-50s","Subtotal");
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(subtotal,10));
        System.out.println();

        //6th line: tax
        System.out.printf("%-50s","6.25% sales tax");
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(itemsTax,10));
        System.out.println();

        //7th line: total
        System.out.printf("%-50s","Total");
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(Total,10));
        System.out.println();

    }
}

class LengthFormat {
    /**
     * @param object Variables that need to be formatted
     * @param characterNumber Maximum number of characters in the variable
     * @return A string that meets the length and decimal places requirements
     */

    public static String Lengthcontrol(Object object, int characterNumber) {

        if (object instanceof Double) {
            String str = String.format("%.2f",object);
            if (str.length() <= characterNumber) {
                return str;
            } else {
                return str.substring(0, characterNumber);
            }

        } else {
            String str = object.toString();
            if (str.length() <= characterNumber) {
                return str;
            } else {
                return str.substring(0, characterNumber);
            }
        }
    }
}
