package com.talabat.helpers;

public class TalabatParser {
    public static float toFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static int toInt(String str) {
        try {
            return Integer.parseInt(str.replaceAll("\\D+", ""));
        } catch (Exception unused) {
            return -1;
        }
    }
}
