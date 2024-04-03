package com.google.android.libraries.places.internal;

public final class zzje {
    public static <T> T zza(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str.concat(" must not be null"));
    }

    public static String zzb(String str) {
        String str2;
        String str3;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("identifier must not be empty");
        } else if (!zzc(str.charAt(0))) {
            if (str.length() != 0) {
                str3 = "identifier must start with an ASCII letter: ".concat(str);
            } else {
                str3 = new String("identifier must start with an ASCII letter: ");
            }
            throw new IllegalArgumentException(str3);
        } else {
            int i11 = 1;
            while (i11 < str.length()) {
                char charAt = str.charAt(i11);
                if (zzc(charAt) || ((charAt >= '0' && charAt <= '9') || charAt == '_')) {
                    i11++;
                } else {
                    if (str.length() != 0) {
                        str2 = "identifier must contain only ASCII letters, digits or underscore: ".concat(str);
                    } else {
                        str2 = new String("identifier must contain only ASCII letters, digits or underscore: ");
                    }
                    throw new IllegalArgumentException(str2);
                }
            }
            return str;
        }
    }

    private static boolean zzc(char c11) {
        if (c11 >= 'a' && c11 <= 'z') {
            return true;
        }
        if (c11 >= 'A') {
            return c11 <= 'Z';
        }
        return false;
    }
}
