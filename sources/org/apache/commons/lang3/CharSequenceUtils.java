package org.apache.commons.lang3;

public class CharSequenceUtils {
    public static int indexOf(CharSequence charSequence, int i11, int i12) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(i11, i12);
        }
        int length = charSequence.length();
        if (i12 < 0) {
            i12 = 0;
        }
        while (i12 < length) {
            if (charSequence.charAt(i12) == i11) {
                return i12;
            }
            i12++;
        }
        return -1;
    }

    public static int lastIndexOf(CharSequence charSequence, int i11, int i12) {
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(i11, i12);
        }
        int length = charSequence.length();
        if (i12 < 0) {
            return -1;
        }
        if (i12 >= length) {
            i12 = length - 1;
        }
        while (i12 >= 0) {
            if (charSequence.charAt(i12) == i11) {
                return i12;
            }
            i12--;
        }
        return -1;
    }

    public static boolean regionMatches(CharSequence charSequence, boolean z11, int i11, CharSequence charSequence2, int i12, int i13) {
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            while (true) {
                int i14 = i13 - 1;
                if (i13 <= 0) {
                    return true;
                }
                int i15 = i11 + 1;
                char charAt = charSequence.charAt(i11);
                int i16 = i12 + 1;
                char charAt2 = charSequence2.charAt(i12);
                if (charAt != charAt2) {
                    if (!z11) {
                        return false;
                    }
                    if (!(Character.toUpperCase(charAt) == Character.toUpperCase(charAt2) || Character.toLowerCase(charAt) == Character.toLowerCase(charAt2))) {
                        return false;
                    }
                }
                i11 = i15;
                i13 = i14;
                i12 = i16;
            }
        } else {
            return ((String) charSequence).regionMatches(z11, i11, (String) charSequence2, i12, i13);
        }
    }

    public static CharSequence subSequence(CharSequence charSequence, int i11) {
        if (charSequence == null) {
            return null;
        }
        return charSequence.subSequence(i11, charSequence.length());
    }

    public static char[] toCharArray(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).toCharArray();
        }
        int length = charSequence.length();
        char[] cArr = new char[charSequence.length()];
        for (int i11 = 0; i11 < length; i11++) {
            cArr[i11] = charSequence.charAt(i11);
        }
        return cArr;
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i11) {
        return charSequence.toString().indexOf(charSequence2.toString(), i11);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i11) {
        return charSequence.toString().lastIndexOf(charSequence2.toString(), i11);
    }
}
