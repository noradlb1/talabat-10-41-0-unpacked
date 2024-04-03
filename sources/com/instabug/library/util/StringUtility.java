package com.instabug.library.util;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.util.List;

public class StringUtility {
    public static final String ELLIPSIZE = "…";

    @Nullable
    public static String applyDoubleQuotations(@Nullable String str) {
        if (str == null || str.trim().length() == 0 || str.startsWith("\"")) {
            return str;
        }
        return "\"" + str + "\"";
    }

    public static int compareVersion(String str, String str2) throws NumberFormatException {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i11 = 0;
        while (true) {
            if (i11 >= split.length && i11 >= split2.length) {
                return 0;
            }
            if (i11 >= split.length || i11 >= split2.length) {
                if (i11 < split.length) {
                    if (Integer.parseInt(split[i11]) != 0) {
                        return 1;
                    }
                } else if (i11 < split2.length && Integer.parseInt(split2[i11]) != 0) {
                    return -1;
                }
            } else if (Integer.parseInt(split[i11]) < Integer.parseInt(split2[i11])) {
                return -1;
            } else {
                if (Integer.parseInt(split[i11]) > Integer.parseInt(split2[i11])) {
                    return 1;
                }
            }
            i11++;
        }
    }

    public static String ellipsize(String str, @IntRange(from = 0) int i11) {
        if (str == null || str.trim().length() <= i11) {
            return str;
        }
        return str.trim().substring(0, i11) + ELLIPSIZE;
    }

    public static String formatOOMExceptionMessage(String str) {
        return String.format("An OOM error occurred while %s.", new Object[]{str});
    }

    public static boolean isNumeric(String str) {
        return str.matches("\\d+(?:\\.\\d+)?");
    }

    public static String removeExtension(String str) {
        return str.replaceFirst("[.][^.]+$", "");
    }

    public static String toCommaSeparated(List<String> list) {
        StringBuilder sb2 = new StringBuilder();
        if (list == null || list.size() == 0) {
            return sb2.toString();
        }
        for (int i11 = 0; i11 < list.size() - 1; i11++) {
            sb2.append(list.get(i11));
            sb2.append(",");
        }
        sb2.append(list.get(list.size() - 1));
        return sb2.toString();
    }

    public static String trimString(String str) {
        return trimString(str, 4096);
    }

    public static String[] trimStrings(String[] strArr) {
        for (int i11 = 0; i11 < strArr.length; i11++) {
            strArr[i11] = trimString(strArr[i11]);
        }
        return strArr;
    }

    public static String trimString(String str, int i11) {
        if (str == null) {
            return "null";
        }
        return str.length() > i11 ? str.substring(0, i11) : str;
    }
}
