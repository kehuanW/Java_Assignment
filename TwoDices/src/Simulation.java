import java.text.NumberFormat;
import java.util.*;

public class Simulation {
    public static void display(int n, int[] totalArray) {
        int[] totalFrequency = new int[n];

        for (int i = 0; i < n; i++) {
            int frequency = 0;
            for (int j = 0; j < n; j++) {
                if (totalArray[i] == totalArray[j]) {
                    frequency = frequency + 1;
                    totalFrequency[i] = frequency;
                }
            }
        }

        //生成去除相同元素
        //首先将totalList和totalFrequency转化为ArrayList，名称后面都加了1
        ArrayList totalList1 = new ArrayList();
        for (int i = 0; i < totalArray.length; i++){
            totalList1.add(totalArray[i]);
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

        //将频数和频率对应存入frequencyMap
        Map<Integer,Integer> frequencyMap = new HashMap();
        for (int i = 0; i < totalList2.size(); i++){
            frequencyMap.put((int)totalList2.get(i),(int)totalFrequency2.get(i));
        }

        Map <Integer,Double> probabilityMap = new HashMap<>();
        for (int i = 0; i < totalList2.size(); i++){
            probabilityMap.put((int)totalList2.get(i),(int)totalFrequency2.get(i)/(n * 1.00));
        }

        System.out.println("DISTRIBUTION OF SUM OF TWO DICE IN " + n + " ROLLS");
        if (n <= 100){
            for (int i = 0; i < totalList2.size();i++){
                System.out.printf("%2s",totalList2.get(i) + ":");
                for (int x = 0; x < frequencyMap.get((int)totalList2.get(i)); x++){
                    System.out.print("*");
                }
                NumberFormat percent = NumberFormat.getPercentInstance();
                System.out.printf("%40s",
                        (percent.format(probabilityMap.get((int)totalList2.get(i)))).toString());
                System.out.println();
            }
        } else {
            for (int i = 0; i < totalList2.size();i++){
                System.out.printf("%2s",totalList2.get(i) + ":");
                for (int x = 0; x < probabilityMap.get((int)totalList2.get(i)) * 100; x++){
                    System.out.print("*");
                }
                NumberFormat percent = NumberFormat.getPercentInstance();
                System.out.printf("%40s",
                        (percent.format(probabilityMap.get((int)totalList2.get(i)))).toString());
                System.out.println();
            }

        }

    }
}
