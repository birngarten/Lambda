package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Stream05Digerleri {

    public static void main(String[] args) {

        /*
          Collection'larimizi stream method;u ile Stream'e cevirmeyi ogrendik.
          Collection : List,Map,HashMap vb..
          Stream'e cevirdikten sonra Stream API kullanarak pipeLine'a sokuyorduk.
          IntStream : Integer seklinde Stream olusturabiliriz.
          LongStream, DoubleStream
          Bunlarin ne artisi var ? Sayisal degerlerle islem yapacaksak isleri kolaylastiriyor.
          Biz istersek Integer, Double, Long tipinde Stream'ler olusturabiliyoruz.
         */

        System.out.println("topla(5) = " + topla(5));
        System.out.println("topla1(5) = " + topla1(5));
        System.out.println("\n========================");
        System.out.println("tekleriTopla(4,10) = " + tekleriTopla(4,10)); // 21
        System.out.println("faktoriyel(8) = " + faktoriyel(8));
        System.out.println("faktoriyel1(8) = " + faktoriyel1(20));
        System.out.println("faktoriyel2(34) = " + faktoriyel2(10));

        System.out.println("Notlari 50.0 den buyuk olanlar : " + doubleToStream());

        Double [] notlar = { 88.5, 52.3, 88.9, 100.0, 99.6, 42.0, 32.0};
        System.out.println("Notlari 50.0 den buyuk olanlar : " + doubleToStream1(notlar));
                    

    }
    //****************************************************************************************************
    // ÖRNEK25: 1'den belirtilen değere kadar olan tamsayıları toplayan ve sonucu döndüren metodu yazınız.
    //****************************************************************************************************
    public static int topla(int deger){
        return IntStream.range(1,deger +1).sum(); // *** range() methodu -e kadar aldigi icin girilen son rakami almiyor
                                                  //     bunu onlemek icin ya deger+1 yada
                                                  // *** rangeClosed() methodu kullanilmali
    }
    public static int topla1(int deger){
        return IntStream.rangeClosed(1,deger).sum();
    }
    
    //****************************************************************************************************
    // ÖRNEK26: 1'den belirtilen değere kadar olan tek tamsayıları toplayan ve sonucu döndüren metodu yazınız.
    // IntStream
    //****************************************************************************************************
    public static int tekleriTopla(int altAralik, int ustAralik){
        return IntStream.
                rangeClosed(altAralik,ustAralik).
                filter(Methodlar::tekMi).sum();
    }

    //****************************************************************************************************
    // ÖRNEK27: Belirtilen sayinin faktoriyelini hesaplayan bir metodu yazınız.
    // IntStream
    //****************************************************************************************************
    public static Integer faktoriyel(int n){
        return IntStream.rangeClosed(1,n).reduce(1,(x,y)-> x*y);
    }

    // ÖRNEK27'yi Long ile yapalim
    // *** LongStream
    public static Long faktoriyel1(int n){
        return LongStream.rangeClosed(1,n).reduce(1,(x, y)-> x*y);
    }

    public static Double faktoriyel2(int n){
        // *** Double'da virgulden sonra sonsuz sayi olsugunda range alamiyoruz.
        //     Dolayisiyla faktoriyel islemi icin iterate() methodunu kullanmamiz gerekiyor.
        return DoubleStream.iterate(1, t->t+1).limit(n).reduce(1,(x,y)->x*y);

    }

    //****************************************************************************************************
    // ÖRNEK28: Bir double diziyi (notlar) Stream nesnesine dönüştürerek bu dizi içerisinde bulunan
    // sayıların 50 den büyük olanlarını ayrı bir listeye kaydererek yazdıran metodu tanımlayınız
    //****************************************************************************************************
    public static List<Double> doubleToStream(){
        Double [] notlar = { 88.5, 52.3, 88.9, 100.0, 99.6, 42.0, 32.0};
        Stream<Double> streamNotlar = Stream.of(notlar);
        return streamNotlar.filter(t-> t>50).collect(Collectors.toList());
    }
    // 2.YOL
    public static List<Double> doubleToStream1(Double [] nums){
        return Arrays.stream(nums).filter(t-> t> 50).collect(Collectors.toList());
    }
}
