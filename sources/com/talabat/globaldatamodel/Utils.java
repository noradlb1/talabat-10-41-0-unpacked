package com.talabat.globaldatamodel;

public class Utils {
    public static boolean isNullOrEmpty(String str) {
        if (str == null) {
            return true;
        }
        return str.trim().equals("");
    }
}
