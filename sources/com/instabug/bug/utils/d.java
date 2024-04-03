package com.instabug.bug.utils;

import com.instabug.library.core.InstabugCore;

public abstract class d {
    public static String a(String str, int i11) {
        return str.replaceAll("\\[([^\\]]+)\\]\\(([^\\]]+)\\)", String.format("<font color=\"#%06X\"><a href=\"$2\">$1</a></font>", new Object[]{Integer.valueOf(i11 & 16777215)}));
    }

    public static String a(String str, String str2, String str3) {
        return b(a(str, InstabugCore.getPrimaryColor()), str2, str3);
    }

    public static String b(String str, String str2, String str3) {
        return str.replace(str2, str3);
    }
}
