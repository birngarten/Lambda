package questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question06 {
    /*Verilen array icin
    1) negatif elemanlari yazdiralim
    2)pozitifleri tekrarsiz larak yazdiralim
    3)5 den buyuk elemanlarin 2 katindan olusan elemanlari yazdiralim
    4) tum elemanlarin toplamini bulan method olusturalim
     */
    public static void main(String[] args) {
        int[][] a = {{1, -2, 3, 5}, {4, 5, -6, 9}, {7, -3, -4, 1},};
        negatifNums(a);
        System.out.println("\n");
        pozitifNums(a);
        System.out.println("\n");
        System.out.println("a = " + numsDouble(a));
        sum(a);

    }
    // Negatif Elemanlar
    public static void negatifNums(int [][] arr){
        Arrays.stream(arr).
                flatMapToInt(t-> Arrays.stream(t)).
                filter(t-> t<0).forEach(t-> System.out.print(t+ " "));
    }

    // Tekrarsiz pozitif Elemanlar
    public static void pozitifNums(int [][] arr){
        Arrays.stream(arr).
                flatMapToInt(t-> Arrays.stream(t)).
                distinct().
                filter(t-> t>0).
                forEach(t-> System.out.print(t+ " "));
    }

    // 5 den buyuk elemanlarin 2 kati
    public static List<Integer> numsDouble(int [][] arr){
       List<Integer> list = ReusableMethod.twoDimantionArrayToList(arr);
        return list.stream().
                filter(t-> t>5).
                map(t-> t*2).collect(Collectors.toList());

    }

    // tum elemanlarin toplami
    public static void sum(int [][] arr){
        System.out.println(Arrays.stream(arr).
                           flatMapToInt(t-> Arrays.stream(t)).
                           reduce(0, (x,y)-> x+y));
    }

}
