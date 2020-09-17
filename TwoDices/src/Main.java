import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

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
        int[] totalList = new int[n];


        System.out.println("Let's roll " + n + " times.");

        for (int j = 1; j <= n; j++){

            //for one time
            //int temp=m+(int)(Math.random()*(n+1-m)); //生成从m到n的随机整数[m,n]
            int dice1 = (int)(Math.random() * 6) + 1;
            int dice2 = (int)(Math.random() * 6) + 1;

            int total = dice1 + dice2;
            totalList[j - 1] = total;

        }
        //数组内容从小到大进行排列
        Arrays.sort(totalList);

        //频率统计
        int[] totalFrequency = new int[n];

        for (int i = 0; i < n; i++){
            int frequency = 0;
            for (int j = 0; j < n; j++){
                if (totalList[i] == totalList[j]){
                    frequency = frequency + 1;
                    totalFrequency[i] = frequency;

                }

            }
        }

        //生成去除相同元素
        //首先将totalList和totalFrequency转化为ArrayList，名称后面都加了1
        ArrayList totalList1 = new ArrayList();
        for (int i = 0; i < totalList.length; i++){
            totalList1.add(totalList[i]);
        }
        ArrayList totalFrequency1 = new ArrayList();
        for (int i = 0; i < totalFrequency.length; i++){
            totalFrequency1.add(totalFrequency[i]);
        }

        //totallist2是直接去除了totalList1中的相同元素
        ArrayList totalList2 = new ArrayList(new TreeSet(totalList1));

        //index是totallist去重后（成为totallist2），留下的元素在totallist1中的位置
        ArrayList index = new ArrayList();
        for (int k = 0; k < totalList2.size(); k++){
            index.add(totalList1.indexOf(totalList2.get(k)));
        }
        index = new ArrayList(new TreeSet(index));


        //通过将index的内容在totalfrequency/totalfrequency1中搜索，找到每个元素对应的频率
        ArrayList totalFrequency2 = new ArrayList();

        for (int m = 0; m < index.size(); m++){
            totalFrequency2.add(totalFrequency1.get((int) index.get(m)));
        }
//        System.out.println(totalList2);
//        System.out.println(totalFrequency2);

        //计算概率
        ArrayList eventProbability  = new ArrayList();
        ArrayList eventProbability0 = new ArrayList();
        for (int i = 0; i < totalList2.size(); i++){

            double probability = (int)totalFrequency2.get(i) / (n * 1.00);

            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMinimumFractionDigits(0);
            eventProbability.add(percent.format(probability));
            eventProbability0.add((int) (probability * 100));
        }
//        System.out.println(eventProbability);

        BarChart barChart = new BarChart();
        barChart.chartPrinter(n, totalList2, totalFrequency2, eventProbability,eventProbability0);

    }
}

class BarChart {
    public void chartPrinter(int n, ArrayList event, ArrayList frenquency,
                             ArrayList eventProbability, ArrayList eventProbability0) {
        System.out.println("DISTRIBUTION OF SUM OF TWO DICE IN " + n + " ROLLS");

        if (n < 100) {
            for (int s = 2; s < 13; s++) {
                if (event.contains(s)) {
                    System.out.print(s + ":");
                    BarChartTool barChartTool = new BarChartTool();
                    barChartTool.starsPrinter((int) frenquency.get(event.indexOf(s)));

                } else {
                    System.out.print(s + ":");
                }

                System.out.printf("%30s", eventProbability.get(event.indexOf(s)).toString());
                System.out.println();
            }
        } else {
            for (int j = 2; j < 13; j++) {
                System.out.printf("%-2s", j);
                for (int k = 0; k < (int) eventProbability0.get(event.indexOf(j)); k++) {
                    System.out.print("*");
                }
                System.out.printf("%40s",eventProbability.get(event.indexOf(j)).toString());
                System.out.println();
            }

        }
    }
}
class BarChartTool{
    public void starsPrinter (int stars) {

        for (int i = 0; i < stars; i++) {
            System.out.print("*");
        }

    }
}
