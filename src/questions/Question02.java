package questions;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question02 {

    public static void main(String[] args) {
        /*Negatif olmayan int bir listesi verildiğinde, 9 ile biten sayıları atlayarak
            bu sayıların disinda bir listesini döndürün.
            no9 ([1, 2, 19]) → [1, 2]
                 */
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(19);
        System.out.println("no9(list) = " + no9(list));
    }

    public static List<Integer> no9(List<Integer> list){
        return list.
                stream().
                filter(t-> t%9!=0).
                collect(Collectors.toList());
    }
}
