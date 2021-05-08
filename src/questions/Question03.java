package questions;

import java.util.*;
import java.util.stream.Collectors;

public class Question03 {

    /*
     int bir listesi verildiğinde, 13 ile 19
     arasındaki sayıları çıkararak bu sayıların bir listesini döndürün.
 noTeen ([12, 13, 19, 20]) → [12, 20]
      */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(13);
        list.add(19);
        list.add(20);
        System.out.println("noTeen(list) = " + noTeen(list));
    }

    public static List<Integer> noTeen(List<Integer> l){
        return l.
                stream().
                filter(t-> t<13 || t>19).
                collect(Collectors.toList());
    }
}
