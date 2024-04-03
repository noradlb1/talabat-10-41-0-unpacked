package org.apache.commons.lang3;

public class CharSetUtils {
    public static boolean containsAny(String str, String... strArr) {
        if (!StringUtils.isEmpty(str) && !deepEmpty(strArr)) {
            CharSet instance = CharSet.getInstance(strArr);
            for (char contains : str.toCharArray()) {
                if (instance.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int count(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return 0;
        }
        CharSet instance = CharSet.getInstance(strArr);
        int i11 = 0;
        for (char contains : str.toCharArray()) {
            if (instance.contains(contains)) {
                i11++;
            }
        }
        return i11;
    }

    private static boolean deepEmpty(String[] strArr) {
        if (strArr == null) {
            return true;
        }
        for (String isNotEmpty : strArr) {
            if (StringUtils.isNotEmpty(isNotEmpty)) {
                return false;
            }
        }
        return true;
    }

    public static String delete(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return str;
        }
        return modify(str, strArr, false);
    }

    public static String keep(String str, String... strArr) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty() || deepEmpty(strArr)) {
            return "";
        }
        return modify(str, strArr, true);
    }

    private static String modify(String str, String[] strArr, boolean z11) {
        CharSet instance = CharSet.getInstance(strArr);
        StringBuilder sb2 = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (instance.contains(charArray[i11]) == z11) {
                sb2.append(charArray[i11]);
            }
        }
        return sb2.toString();
    }

    public static String squeeze(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return str;
        }
        CharSet instance = CharSet.getInstance(strArr);
        StringBuilder sb2 = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c11 = ' ';
        for (int i11 = 0; i11 < length; i11++) {
            char c12 = charArray[i11];
            if (c12 != c11 || i11 == 0 || !instance.contains(c12)) {
                sb2.append(c12);
                c11 = c12;
            }
        }
        return sb2.toString();
    }
}
