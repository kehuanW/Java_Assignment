import java.util.Arrays;

public class TwoDices {
    public static int[] roll (int n) {

        int[] totalArray = new int[n];

        for (int i = 0; i < n; i++){

            //for one time
            //int temp=m+(int)(Math.random()*(n+1-m)); //生成从m到n的随机整数[m,n]
            int dice1 = (int)(Math.random() * 6) + 1;
            int dice2 = (int)(Math.random() * 6) + 1;

            int total = dice1 + dice2;
            totalArray[i] = total;

        }
        Arrays.sort(totalArray);
        return totalArray;
    }
}
