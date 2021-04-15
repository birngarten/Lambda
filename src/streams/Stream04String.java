package streams;

import java.util.*;

public class Stream04String {

    public static void main(String[] args) {
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Jackson");
        liste.add("Amanda");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Christ");

        aHarfiyleBaslayanlar(liste);
        System.out.println("\n");
        buyukHarfeCevir(liste);
    }

    // Listedeki bas harfi A ile baslayan isimleri yazdiran metodu tanimlayalim...
    public static void aHarfiyleBaslayanlar(List<String> l){
        l.stream().
                filter(t -> t.startsWith("A")). // 2.Yol (t -> t.charAt(0)=='A')
                forEach(System.out::println);
    }

    // Tum isimleri BUYUK harfe cevirerek yazdiriniz
    public static void buyukHarfeCevir(List<String> liste){
        liste.
              stream().
              map(t -> t.toUpperCase()).
              forEach(System.out::println);
    }
}
