package streams;

import java.io.IOException;
import java.nio.file.*;
//import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class Stream06Files {

    public static void main(String[] args) throws IOException {

        String path = "src/streams/mars.txt";

        Stream<String> satirlar = Files.lines(Path.of(path)); // Path.of()
        satirlar.forEach(System.out::println);

        System.out.println("==============================================================");

        // SORU : Dosyayi BUYUK harf olarak konsola yazdiralim
       Files.lines(Paths.get(path)).
               map(String::toUpperCase).  // veya ==> map(t-> t.toUpperCase()) kullanabiliriz
               forEach(System.out::println);

        System.out.println("==============sadece ilk satiri BUYUK harf=================\n");
       // limit()
       // SORU : Dosyadan sadece ilk satiri BUYUK harf olarak konsola yazdiralim.
        Files.lines(Paths.get(path)).
                limit(1). // limit() method'u ile sinirliyoruz. ve sadece birinci satiri oliyoruz.
                map(String::toUpperCase).
                forEach(System.out::println);

        System.out.println();
        System.out.println("============== uc ve dorduncu satirlari BUYUK harf ===============\n");
        // skip()  : Girilen sayi kadar satir/ eleman atla demek
        // limit() : Kac satirin / elemanin alacagini limitliyoruz
        // SORU : Dosyadan sadece uc ve dorduncu satirlari BUYUK harf olarak konsola yazdiralim.
        Files.lines(Paths.get(path)).
                skip(2).  // skip(2) ==> ilk satiri atla(alma)
                limit(2). // limit() ile iki satirla sinirliyoruz
                map(String::toUpperCase).
                forEach(System.out::println);

        System.out.println();
        System.out.println("============== Metindeki 've' sayisi ===============\n");

        // SORU : Metinde kac tane "ve" vardir?
        int count = (int) Files.lines(Paths.get(path)).
                     map(String::toLowerCase).
                     filter(t-> t.contains("ve")).
                     count();
        System.out.println("Metinde " + count + " tane 've' var");

        System.out.println("============== =============== ===============\n");
        // SOR : Dosyadaki tum farkli kelimeleri alt alta yazdiralim
        // flatMap() : Nested yapilarini tek bir yapi haline getiriyor.
        Files.lines(Path.of(path)).
                     map(t-> t.toLowerCase().
                     split(" ")).
                     flatMap(Arrays::stream).
                     distinct().
                     forEach(System.out::println);

        // Kac tane M/m harfi oldugunu sayalim
        long mCount =   Files.lines(Path.of(path)).
                        map(t-> t.toLowerCase().
                        split("")).
                        flatMap(Arrays::stream).
                        filter(t-> t.equals("m")).
                        count();
        System.out.println("m sayisi = " + mCount);

        // Boşluk ve noktalama işaretleri hariç dosyada kaç adet karakter kullanıldığını
        // hesaplayarak sonucu konsola yazdıran uygulamayı yazınız.
        long charactersCount =  Files.lines(Paths.get(path)).
                                map(t-> t.replace("_","").
                                        replaceAll("\\W",""). // \\W ==> tum kontrol karakterler
                                        split("")).
                                flatMap(Arrays::stream).
                                count();
        System.out.println(charactersCount);

    }
}
