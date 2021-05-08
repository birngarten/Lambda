package questions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question04 {

    /*
   verilen bir string listte her elemanin sonuna y ekleyen ve iki y (yy) olan elemanlari
   olmayan bir list donduren method yazalim
   noYY(["a", "b", "cy"]) → ["ay", "by"]
    */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("cy");
        System.out.println("noYY(list) = " + noYY(list));

    }

    public static List<String> noYY(List<String> l){
        return l.
                stream().
                map(t-> t+"y").
                filter(t-> !t.contains("yy")).
                collect(Collectors.toList());
    }
}
