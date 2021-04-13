package lambda;

import java.util.Arrays;
import java.util.List;

// Javada Lambda fonksiyonları sadece Fonksiyonel interface'ler ile kullanılabilir.
// Sadece bir adet abstract metodu olan interface'lere fonksiyonel interface denilir.
// Kullanıcı isterse kendi fonksiyonel interface'ini yazabilir. Ama Javada hali hazırda
// Consumer, Function, Supplier, Predicate gibi tanımlanmış interfaceler bulunmaktadır.
// Ayrıca bu interface'leri parametre olarak alabilen High Order Function (HOF)'lar da bulunmaktadır.
// foreEach(), map(), filter(), reduce() gibi HOF'lar fonksiyonel interfaceler ile çalıştığı için
// içerisinde Lambda fonksiyonları yazmak mümkündür.
// Javada genelde bu gibi fonksiyonlar üzerinden Lambda ifadeleri kullanılmaktadır.

public class Lambda01Kurallar {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        // forEach() bir collection'nin iterasyonu icin kullanilan bir HOF'tur.
        // parametre olarak bir lambda fonksiyonu alabilir

        // Dizinin Elemanlarini yazdiralim
        list.forEach(i -> System.out.print(i + " ")); // 1 2 3 4 5

        System.out.println("\n===========");

        // Listenin elemanlarini 2 artirarak yazdirralim.
        list.forEach(t -> System.out.print(t+2 + " ")); // 3 4 5 6 7

        System.out.println("\n Eger satir sayisi 1'den fazla ise {} kullanmaliyiz...");
        list.forEach(t -> {
            int miktar = 2;
            System.out.print(t + miktar + " \n");
        });

        // Veri tipi kullanilirsa Explicit
        list.forEach((Integer x) -> System.out.print(x*2 + " ")); // 2 4 6 8 10

        // Bir dis degisken kullanalim!!
        System.out.println("\nBir dis degisken kullanalim!!");

        int deger = 5;
        list.forEach(t -> System.out.print(t+deger + " ")); // 6 7 8 9 10

        // *** METHOD REFERANSI ***
        // Metod Referansi ile yazma ====> Class adi :: MethodAdi
        System.out.println("\nMethod referansi ile yazdirma !!!");
        list.forEach(System.out::print); // 12345

        // Class adi :: MethodAdi
        System.out.println("\nMethod referansi ile yazdirma !!!");
        list.forEach(Lambda01Kurallar::yazdir); // 1 2 3 4 5
                    //   Class adi   :: MethodAdi
    }

    public static void yazdir(int x){
        System.out.print(x + " ");

    }

}
