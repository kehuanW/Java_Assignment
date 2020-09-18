import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //generate the freshbox
    FreshBox freshbox = new FreshBox();
    Map <String,String> freshboxMap;
    freshboxMap = freshbox.boxGenerate();

    //display the freshbox
    freshbox.toString(freshboxMap);

    ArrayList numList = new ArrayList();
    numList.add("1");
    numList.add("2");
    numList.add("3");
    numList.add("4");

    Map <String,String> foodMap = new HashMap();
    foodMap.put("1","Apple");
    foodMap.put("2","Banana");
    foodMap.put("3","Cauliflower");
    foodMap.put("4","Potato");
    foodMap.put("5","Capsicum");

    while(true){

      System.out.println("Have you finished buying?");
      System.out.println("Press number 1 - 4 if you want to change your order. Press other key to finalize the purchase.");
      Scanner scanner = new Scanner(System.in);
      String reviseNum = scanner.next();

      if (numList.contains(reviseNum)) {

        System.out.println("You want to change item number " + reviseNum);
        System.out.println("What do you want to replace it with?");
        System.out.println("  " + "Press 1 for apple");
        System.out.println("  " + "Press 2 for banana");
        System.out.println("  " + "Press 3 for cauliflower");
        System.out.println("  " + "Press 4 for potato");
        System.out.println("  " + "Press 5 for capsicum");
        System.out.println("  " + "Press any other key to cancel the change.");

        Scanner scanner1 = new Scanner(System.in);
        String targetNum = scanner1.next();

        ArrayList foodNumList = new ArrayList();
        foodNumList.add("1");
        foodNumList.add("2");
        foodNumList.add("3");
        foodNumList.add("4");
        foodNumList.add("5");

        if (foodNumList.contains(targetNum)){
          freshboxMap.replace(reviseNum,foodMap.get(targetNum));
          freshbox.toString(freshboxMap);
        }

      } else {
        break;
      }
    }
    System.out.println(" Here is your receipt:");
    System.out.println("FreshBox Receipt Australia");
    freshbox.receipt(freshboxMap);

    System.out.println("You get additional Potato Yoghurt Recipe.");
    System.out.println();
    System.out.println("Thank you for your purchase!");
    }

  }
