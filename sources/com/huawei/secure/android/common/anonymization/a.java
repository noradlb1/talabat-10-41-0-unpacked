package com.huawei.secure.android.common.anonymization;

public class a {
    public static String[] a(String[] strArr, String[] strArr2) {
        if (strArr.length <= 0) {
            return strArr2.length <= 0 ? new String[0] : strArr2;
        }
        if (strArr2.length <= 0) {
            return strArr;
        }
        String[] strArr3 = new String[(strArr.length + strArr2.length)];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    public static String[] b(String str, String[] strArr) {
        return a(new String[]{str}, strArr);
    }

    public static String[] b(String str, char c11) {
        if (str == null) {
            return new String[0];
        }
        if (str.length() <= 0) {
            return new String[]{str};
        }
        int i11 = 1;
        for (int i12 = 0; i12 < str.length(); i12++) {
            if (str.charAt(i12) == c11) {
                i11++;
            }
        }
        if (i11 <= 1) {
            return new String[]{str};
        }
        String[] strArr = new String[i11];
        StringBuilder sb2 = new StringBuilder(str.length());
        int i13 = 0;
        for (int i14 = 0; i14 < str.length() && i13 < i11; i14++) {
            char charAt = str.charAt(i14);
            if (charAt == c11) {
                strArr[i13] = sb2.toString();
                sb2.setLength(0);
                i13++;
            } else {
                sb2.append(charAt);
            }
        }
        strArr[i13] = sb2.toString();
        return strArr;
    }

    public static String[] a(String[] strArr, String str) {
        return a(strArr, new String[]{str});
    }

    public static String[] a(String str, int i11, int i12) {
        String[] a11 = a(str, i11);
        return b(a(a11, 0), a(a(a11, 1), i12 - i11));
    }

    public static String[] a(String str, int i11, int i12, int i13) {
        String[] a11 = a(str, i11);
        return b(a(a11, 0), a(a(a11, 1), i12 - i11, i13 - i11));
    }

    public static String[] a(String str, int... iArr) {
        if (str == null) {
            return new String[]{""};
        }
        if (str.length() <= 1 || iArr.length <= 0) {
            return new String[]{str};
        } else if (iArr.length <= 1) {
            return a(str, iArr[0]);
        } else {
            int i11 = iArr[0];
            int length = iArr.length - 1;
            int[] iArr2 = new int[length];
            int i12 = 0;
            while (i12 < length) {
                int i13 = i12 + 1;
                iArr2[i12] = iArr[i13] - i11;
                i12 = i13;
            }
            String[] a11 = a(str, i11);
            return b(a(a11, 0), a(a(a11, 1), iArr2));
        }
    }

    public static String[] a(String str, int i11) {
        if (str == null) {
            return new String[]{"", ""};
        }
        if (i11 < 0 || i11 > str.length()) {
            return new String[]{str, ""};
        }
        return new String[]{str.substring(0, i11), str.substring(i11)};
    }

    public static String a(String str, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(strArr[0]);
        for (int i11 = 1; i11 < strArr.length; i11++) {
            if (strArr[i11] != null) {
                sb2.append(str);
                sb2.append(strArr[i11]);
            }
        }
        return sb2.toString();
    }

    public static String a(String str, String str2, String str3) {
        if (str == null || str.length() <= 0 || str2.length() <= 0 || str3.length() <= 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] cArr = new char[str.length()];
        char charAt = str3.charAt(str3.length() - 1);
        for (int i11 = 0; i11 < charArray.length; i11++) {
            char c11 = charArray[i11];
            int lastIndexOf = str2.lastIndexOf(c11);
            if (lastIndexOf < 0) {
                cArr[i11] = c11;
            } else {
                cArr[i11] = lastIndexOf >= str3.length() ? charAt : str3.charAt(lastIndexOf);
            }
        }
        return new String(cArr);
    }

    public static String a(String[] strArr, int i11) {
        if (strArr == null || strArr.length <= 0 || i11 < 0 || i11 >= strArr.length) {
            return "";
        }
        return strArr[i11];
    }

    public static String a(String str, char c11) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int length = str.length();
        char[] cArr = new char[length];
        for (int i11 = 0; i11 < length; i11++) {
            cArr[i11] = c11;
        }
        return new String(cArr);
    }

    public static int a(String str, char c11, int i11) {
        int length = str.length() - 1;
        while (length >= 0 && (str.charAt(length) != c11 || i11 - 1 > 0)) {
            length--;
        }
        return length;
    }
}
