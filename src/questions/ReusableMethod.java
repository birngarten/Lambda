package questions;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethod {

    public static List<Integer> twoDimantionArrayToList(int [][] arr){
        List<Integer> list = new ArrayList<>();
        for (int[] arr1: arr){
            for (int i: arr1){
                list.add(i);
            }
        }
        return list;
    }
}
