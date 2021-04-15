package streams;

import java.util.ArrayList;
import java.util.List;

public class Stream03Integer {

    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(4);
        liste.add(12);
        liste.add(15);

        System.out.println("En BUYUK DEGER : " + buyukBul(liste));
        System.out.println("En BUYUK DEGER : " + buyukBul1(liste));
    }

    //
    public static int buyukBul(List<Integer> l){
        return l.stream().reduce(0,(x,y) -> x>y? x:y); //15
    }
    // buyukBul() == buyukBul1()
    public static int buyukBul1(List<Integer> l){
        return l.stream().reduce(0,Math::max); //15
    }
}
