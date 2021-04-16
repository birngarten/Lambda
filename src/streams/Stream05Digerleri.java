package streams;

import java.util.stream.IntStream;

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
    //****************************************************************************************************
    public static int tekleriTopla(int altAralik, int ustAralik){
        return IntStream.
                rangeClosed(altAralik,ustAralik).
                filter(Methodlar::tekMi).sum();
    }
}
