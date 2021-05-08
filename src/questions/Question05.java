package questions;

import java.util.Arrays;

public class Question05 {

    // verilen arrayin elemanlarinin 2 katinin 1 fazlasinin ortalamasini alalim
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        ortalama(arr);

    }

    public static void ortalama(int [] arr){
        Arrays.stream(arr).
                map(t-> t*2+1).
                average().
                ifPresent(System.out::print);
    }

}
