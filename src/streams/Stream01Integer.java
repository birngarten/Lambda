package streams;

import java.util.ArrayList;
import java.util.List;

public class Stream01Integer {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(9);
        list.add(11);
        list.add(12);
        list.add(8);
        list.add(-7);
        list.add(16);
        list.add(17);

        // tek olan elemanlari yazdiralim
        list.stream().filter(t-> t%2==1 ).forEach(System.out::println);
        System.out.println("=======tekMi========="); // bir yukaridaki ve bir asagidaki method ayni sayilari verir
        list.stream().filter(Stream01Integer::tekMi).forEach(System.out::println);

        System.out.println("================");

        // cift olan elemanlari yazdiralim
        list.stream().filter(t-> t%2==0 ).forEach(System.out::println);
        System.out.println("=======ciftMi========="); // bir yukaridaki ve bir asagidaki method ayni sayilari verir
        list.stream().filter(Stream01Integer::ciftMi).forEach(System.out::println);

        System.out.println("================");
        // Metod Referansi ile 9'dan buyuk sayilari yazdir?
        list.stream().filter(t -> t > 9).forEach( Stream01Integer :: yazdir ); // 11 11 12 17 16 17
        //                                            ClassAdi  :: methodAdi
    }

    public static boolean tekMi(int num){
        return num % 2 == 1;
    }

    public static boolean ciftMi(int num){
        return num % 2 == 0;
    }

    public static void yazdir(int num){
        System.out.print(num + " ");
    }
}
