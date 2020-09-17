import java.util.*;

public class FreshBox {

    static final double bananaPrice = 1.5;
    static final double applePrice = 1.6;
    static final double cauliflowerPrice = 1.7;
    static final double potatoPrice = 1.8;
    static final double capsicumPrice = 1.9;

    String[] foodArray = new String[]{"Banana", "Apple", "Cauliflower", "Potato", "Capsicum"};
    double[] priceArray = new double[]{bananaPrice,applePrice,cauliflowerPrice,potatoPrice,capsicumPrice};


    //System.out.println(Arrays.toString(foodBox));


    public Map boxGenerate() {
        //随机生成一个食物盒子
        ArrayList freshBox = new ArrayList();
        for (int i  = 0; i < 4; i++){
            freshBox.add(foodArray[(int)(Math.random() * 5)]);
        }
        System.out.println(freshBox);

        Map<String,String> freshboxMap = new HashMap<>();
        for (int s = 1; s <= freshBox.size(); s++){
            freshboxMap.put(String.valueOf(s), (String) freshBox.get(s-1));
        }

        System.out.println(freshboxMap);
        return freshboxMap;

    }

    public void toString(Map freshboxMap) {
        //展示随机食物盒子
        Map <String,Double> foodInformation = new HashMap();
        foodInformation.put("Apple",applePrice);
        foodInformation.put("Banana",bananaPrice);
        foodInformation.put("Cauliflower",cauliflowerPrice);
        foodInformation.put("Potato",potatoPrice);
        foodInformation.put("Capsicum",capsicumPrice);

        System.out.println( "The contents of your FreshBox are:");
        for (int i = 1; i < 5; i++){

            double price = foodInformation.get(freshboxMap.get(String.valueOf(i)));
            System.out.println(String.valueOf(i) + " " + freshboxMap.get(String.valueOf(i)) + " for $" + price);

        }


    }

    public void receipt(Map freshboxMap) {
        //展示菜单
        Map <String,Double> foodInformation = new HashMap();
        foodInformation.put("Apple",applePrice);
        foodInformation.put("Banana",bananaPrice);
        foodInformation.put("Cauliflower",cauliflowerPrice);
        foodInformation.put("Potato",potatoPrice);
        foodInformation.put("Capsicum",capsicumPrice);

        for (int i = 1; i <= freshboxMap.size(); i++){

            double price = foodInformation.get(freshboxMap.get(String.valueOf(i)));
            System.out.println(" " + freshboxMap.get(String.valueOf(i)) + " for $" + price);

        }

        double total = 0;
        for (int r = 1; r <= freshboxMap.size(); r++){

            total += (double) foodInformation.get(freshboxMap.get(String.valueOf(r)));

        }

        System.out.println(" TOTAL PURCHASE $" + total);

    }

}
