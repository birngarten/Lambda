package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Stream02Integer {

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

        tekKareYazdir(liste);

        System.out.println("\ntekKupToplami = " + tekKupToplami(liste));
    }

    // tek sayilarin karesini donduren bir method yaziniz?
    public static void tekKareYazdir(List<Integer> l){
        l.stream().distinct().filter(Stream01Integer::tekMi).map(t -> t*t).forEach(Stream01Integer::yazdir);
    }

    // tek sayilarin kuplerinin toplamini return eden bir method yazin
    public static Optional<Integer> tekKupToplami(List<Integer> l){
//      int toplam =  l.stream().filter(Stream01Integer::tekMi).map(t-> t*t*t).reduce(0,(x,y) -> (x+y));
//        return toplam;

        return l.stream().filter(Stream01Integer::tekMi).map(t-> t*t*t).reduce(Math::addExact); // Optional[7030]
//        return l.stream().filter(Stream01Integer::tekMi).map(t-> t*t*t).reduce(Integer::sum); // Optional[7030]

    }


}
