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
        liste.add("Alonso");
        liste.add("Alfonso");
        liste.add("Christ");

        aIleBaslayanlar(liste);
        System.out.println("===========");
        buyukHarfeCevir(liste);
        System.out.println("===========");
        uzunlugunaGoreYazKucukHarfeCevir(liste);
        System.out.println("===========");
        uzunlugaGoreYazdir(liste,5);
        System.out.println("===========");
        System.out.println("Tum degerler verilen degerden kucuk = " + uzunlukKucukMu(liste,8)); // true
        System.out.println("baslamayanHarfVarMi(liste,\"B\") = " + baslamayanHarfVarMi(liste,"B")); // true
        System.out.println("belirtilenHarfleBitenVarMi() = " + belirtilenHarfleBitenVarMi(liste,"r")); //true
        System.out.println("===========");
        belirtilenleBaslayipBitenleriYazdir(liste);
        System.out.println("===========");
        listeleHesaplaYazdir(liste);
        System.out.println("\n===========");
        yazdir(liste);

    }

    //********************************************************************************************
    // ORNEK16: Listedeki baş harfi A ile başlayan isimleri yazdıran metodu tanımlayalım..
    //********************************************************************************************
    public static void aIleBaslayanlar(List<String> liste){
        liste.stream().filter(h-> h.startsWith("A")).forEach(System.out::println);
    }

    //********************************************************************************************
    // ORNEK17: Listedeki tüm isimleri büyük harfe çeviren metodu tanımlayalım..
    //********************************************************************************************
    public static void buyukHarfeCevir(List<String> liste){
        liste.stream().map(h-> h.toUpperCase()).forEach(System.out::println);
    }

    //********************************************************************************************
    // ORNEK18: Listedeki tüm elemanlari uzunluklarina gore siralayan ve kucuk harfe çeviren metodu tanımlayalım..
    // *** Comparator.comparing()
    //********************************************************************************************
    public static void uzunlugunaGoreYazKucukHarfeCevir(List<String> liste){
        liste.stream().
                sorted(Comparator.comparing(t-> t.length())).
                map(t-> t.toLowerCase()).forEach(System.out::println);
    }

    //********************************************************************************************
    // ORNEK19: Listedeki tüm elemanlarin uzunluklari belirtilen uzunluktan fazla ise
    // bunlari yazdiran metodu tanımlayalım..
    //********************************************************************************************
    public static void uzunlugaGoreYazdir(List<String> liste, int uzunluk){
        liste.stream().filter(t->t.length() > uzunluk).forEach(System.out::println);
    }

    //********************************************************************************************
    // ORNEK20: Listedeki tüm elemanlarin uzunluklari belirtilen uzunluktan KUCUK mu diye
    // kontrol eden metodu tanımlayalım..
    // *** allMatch() : Belirtilen sartlari tum elemanlar sagliyorsa true, yoksa false dondurur
    //********************************************************************************************
    public static boolean uzunlukKucukMu(List<String> liste, int uzunluk){
        return liste.stream().allMatch(t-> t.length()<uzunluk);
    }

    //********************************************************************************************
    // ORNEK21: Listedeki TUM elemanlarin belirtilen harf ile baslayip baslamadigini 
    // kontrol eden metodu tanımlayalım..
    // *** noneMatch() : Belirtilen sartlari tum elemanlar SAGLAMIYORSA true, yoksa false dondurur
    //********************************************************************************************
    public static boolean baslamayanHarfVarMi(List<String> liste, String harf){
        return liste.stream().noneMatch(t-> t.startsWith(harf));
    }

    //********************************************************************************************
    // ORNEK22: Listede belirtile eleman verilen harfle biten var mi diye kontrol eden metodu tanımlayalım..
    // *** anyMatch() : Belirtilen sartlari TEK eleman bile SAGLIYORSA true, yoksa false dondurur
    //********************************************************************************************
    public static boolean belirtilenHarfleBitenVarMi(List<String> liste, String harf){
        return liste.stream().anyMatch(t-> t.endsWith(harf));
    }

    //********************************************************************************************
    // ORNEK23: Listede belirtile harfle baslayip, belirtilen harfle biten elemanlari
    // yazdiran metodu tanımlayalım..
    //********************************************************************************************
    public static void belirtilenleBaslayipBitenleriYazdir(List<String> liste){
        liste.stream().
                filter(t-> t.startsWith("A") && t.endsWith("o")).
                forEach(System.out::println);
    }

    //********************************************************************************************
    // ORNEK24: Asagidaki formata gore listedeki her bir elemanin uzunlugunu, uzunluga gore yazdiran method
    // ALI: 3       Mark: 4         Amanda: 6       vb.
    //********************************************************************************************
    public static void listeleHesaplaYazdir(List<String> liste){
        liste.stream().
                sorted(Comparator.comparing(String::length)).
                map(t-> t +": "+t.length() + "\t").
                forEach(System.out::print);
    }

    public static void yazdir(List<String> liste){
        liste.stream().
                map(String::toLowerCase).
                filter(t-> t.startsWith("a")).
                forEach(System.out::println);
    }

}
