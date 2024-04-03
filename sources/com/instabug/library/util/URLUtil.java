package com.instabug.library.util;

public final class URLUtil {
    public static String resolve(String str) {
        if (str == null || str.startsWith("https://") || str.startsWith("http://")) {
            return str;
        }
        return "http://" + str;
    }
}
