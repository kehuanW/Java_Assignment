import java.util.Scanner;

public class YourBill {
    public static void main(String[] args) {

        //Scanner the name, quantity and price of item 1
        System.out.println("Input name of item 1:");
        Scanner item1_name = new Scanner(System.in);
        String item1_name_string = item1_name.nextLine();

        System.out.println("Input quantity of item 1:");
        Scanner item1_quantity = new Scanner(System.in);
        long item1_quantity_long = item1_quantity.nextLong();

        System.out.println("Input price of item 1:");
        Scanner item1_price = new Scanner(System.in);
        double item1_price_double = item1_price.nextDouble();


        //Scanner the name, quantity and price of item 2
        System.out.println("Input name of item 2:");
        Scanner item2_name = new Scanner(System.in);
        String item2_name_string = item2_name.nextLine();

        System.out.println("Input quantity of item 2:");
        Scanner item2_quantity = new Scanner(System.in);
        long item2_quantity_long = item2_quantity.nextLong();

        System.out.println("Input price of item 2:");
        Scanner item2_price = new Scanner(System.in);
        double item2_price_double = item2_price.nextDouble();


        //Scanner the name, quantity and price of item 3
        System.out.println("Input name of item 3:");
        Scanner item3_name = new Scanner(System.in);
        String item3_name_string = item3_name.nextLine();

        System.out.println("Input quantity of item 3:");
        Scanner item3_quantity = new Scanner(System.in);
        long item3_quantity_long = item3_quantity.nextLong();

        System.out.println("Input price of item 3:");
        Scanner item3_price = new Scanner(System.in);
        double item3_price_double = item3_price.nextDouble();


        //calculate each item total price
        double item1_total = item1_price_double * item1_quantity_long;
        double item2_total = item2_price_double * item2_quantity_long;
        double item3_total = item3_price_double * item3_quantity_long;


        //calculate the total price of all items
        double subtotal = item1_total + item2_total + item3_total;

        //calculate the actual tax the user should pay
        double items_tax = subtotal * 0.0625;


        //calculate the final amount
        double Total = subtotal + items_tax;

        //crate lengthFormat
        LengthFormat lengthFormat = new LengthFormat();


        //Output result
        //Title
        System.out.println("Your bill:");
        System.out.println();
        System.out.println();

        //1st line: attributes
        System.out.printf("%-30s","Item");
        System.out.printf("%-10s","Quantity");
        System.out.printf("%-10s","Price");
        System.out.printf("%-10s","Total");
        System.out.println();

        //2nd line: information of item 1
        System.out.printf("%-30s",lengthFormat.Lengthcontrol(item1_name_string,30));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item1_quantity_long,10));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item1_price_double,10));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item1_total,10));
        System.out.println();

        //3th line: information of item 2
        System.out.printf("%-30s",lengthFormat.Lengthcontrol(item2_name_string,30));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item2_quantity_long,10));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item2_price_double,10));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item2_total,10));
        System.out.println();

        //4th line: information of item 3
        System.out.printf("%-30s",lengthFormat.Lengthcontrol(item3_name_string,30));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item3_quantity_long,10));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item3_price_double,10));
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(item3_total,10));
        System.out.println();

        //5th line: subtotal
        System.out.printf("%-50s","Subtotal");
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(subtotal,10));
        System.out.println();

        //6th line: tax
        System.out.printf("%-50s","6.25% sales tax");
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(items_tax,10));
        System.out.println();

        //7th line: total
        System.out.printf("%-50s","Total");
        System.out.printf("%-10s",lengthFormat.Lengthcontrol(Total,10));
        System.out.println();

    }
}

class LengthFormat {
    /**
     *
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
