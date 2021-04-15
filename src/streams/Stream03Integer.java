package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        liste.add(-5);
        liste.add(-1);

        System.out.println("En BÜYÜK DEĞER:" + buyukBul(liste));
        System.out.println("En BÜYÜK DEĞER:" + buyukBul1(liste));
        System.out.println("En KÜÇÜK DEĞER:" + kucukBul(liste));
        System.out.println("ÇARPIM DEĞERİ:" + carpimBul(liste));
        System.out.println("9 Sayısı :" + dokuzSay(liste));
        negatifSayilariYazdır(liste);
        List<Integer> negatifler = negatifSayiListesi(liste);
        System.out.println("\nnegatif liste:" + negatifler);
        System.out.println("siraliTekElemanlarinKaresiListesi : " + siraliTekElemanlarinKaresiListesi(liste));
    }
    public static int buyukBul(List<Integer> liste){
        return liste.stream().reduce(0, (x,y)-> x >y ? x:y);
    }
    public static int buyukBul1(List<Integer> liste){
        return liste.stream().reduce(0,Math::max);
    }
    public static int buyukBul2(List<Integer> liste){
        return liste.stream().sorted().reduce(0,(x,y)->y);
    }
    public static int kucukBul(List<Integer> liste){
        return liste.stream().reduce(0,(x,y)-> x < y ? x:y);
    }
    public static int carpimBul(List<Integer> liste){
        return liste.stream().reduce(1,(x,y)-> x*y);
    }
    // Liste içerisinde kaç tane 9 sayısı bulunmaktadır.
    // Bunun bulan bir metot yazalım
    public static int  dokuzSay(List <Integer> liste){
        return (int) liste.stream().filter(x -> x==9).count();
    }
    // Listedeki negatif sayıları yazdıran metodu yazalım.
    public static void negatifSayilariYazdır(List<Integer> liste){
        liste.stream().filter(x-> x<0).forEach(System.out::print);
    }
    // Listedeki negatif sayıları ayrı bir liste olarak döndüren metodu yazalım.
    public static List<Integer> negatifSayiListesi(List<Integer> liste){
        return liste.stream().filter(x-> x<0).collect(Collectors.toList());
    }

    // SORU : Listedeki tek elemanlarin karelerini sirali olarak ve tekrarasiz
    //        bir sekilde listeye kaydeden metodu yaziniz
    public static List<Integer> siraliTekElemanlarinKaresiListesi(List<Integer> l){
        return l.stream().
                filter(Methodlar::tekMi).
                map(x-> x*x). // veya ==> map(x-> (int)Math.pow(x,2))
                distinct().
                sorted(). // buyukten kucuge ==> sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
    }

}
