package com.instabug.bug.utils;

import androidx.annotation.NonNull;
import java.util.regex.Pattern;

public abstract class e {
    public static String a(String str, String str2) {
        return str.replaceAll("\\[([^\\]]+)\\]\\((https?[^\\]]+)\\)", str2);
    }

    public static boolean a(@NonNull String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("^[+]*([0-1]{0,3}\\s?)?([0-9]{1}[\\s\\-])?((\\([0-9]{3}\\))|[0-9]{3})[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{4}$").matcher(str.trim()).matches();
    }
}
