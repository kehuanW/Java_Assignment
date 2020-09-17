import java.util.ArrayList;

public class MyList{
    public ArrayList Listgenrate(String str) {
        //list
        ArrayList list = new ArrayList();

        for (int i = 1; i < 5; i++) {
            String letter0 = String.valueOf(str.charAt(0));
            String letter2 = letter0.concat(String.valueOf(str.charAt(i)));

            for (int j = 2; j < 5; j++){
                if ( j>i ){
                    String letter3 = letter2.concat(String.valueOf(str.charAt(j)));
                    list.add(letter3);
                }
            }
        }

        for (int i = 4; 0 < i; i--) {
            String letter0 = String.valueOf(str.charAt(0));
            String letter2 = letter0.concat(String.valueOf(str.charAt(i)));

            for (int j = 1; j < 5; j++){
                if ( i > j ){
                    String letter3 = letter2.concat(String.valueOf(str.charAt(j)));
                    list.add(letter3);
                }
            }
        }

        for(int r =0; r < list.size() - 1; r++){
            for(int s = list.size()-1; s > r; s--){
                if(list.get(r).equals(list.get(s))){
                    list.remove(s);
                }
            }
        }

        for (int n = 0; n < list.size(); n++){

            System.out.println(list.get(n));
        }

        return list;

    }
}