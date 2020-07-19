package com.utils;

import java.util.ArrayList;
import java.util.List;

public class FireUtil {

    private static List<String> fireInfoList = new ArrayList<>();

    public static void addFire(String info) {
        fireInfoList.add(info);
    }

    public static void printFire() {
        if (fireInfoList.size() > 0) {
            System.out.println("fireInfoList*****");
            for (String info : fireInfoList
                    ) {
                System.out.println(info);
            }
            System.out.println("fireInfoList*****");
        }
    }
}
