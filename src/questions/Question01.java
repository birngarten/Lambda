package questions;

import java.util.*;
import java.util.stream.Collectors;

public class Question01 {

    public static void main(String[] args) {
        // verilen listteki tum "x" leri yok eden method olustularim
        //ornegin noX (["xxax", "xbxbx", "xxcx"]) → ["a "," bb "," c "]
        List<String> list = new ArrayList<>();
        list.add("xxax");
        list.add("xbxbx");
        list.add("xxcx");
        System.out.println(noX(list));

    }

    public static List<String> noX(List<String> list){
        return list.stream().
                map(t-> t.replaceAll("x","")).
                collect(Collectors.toList());
    }
}
