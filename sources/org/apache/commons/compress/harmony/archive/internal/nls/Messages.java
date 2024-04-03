package org.apache.commons.compress.harmony.archive.internal.nls;

import java.security.AccessController;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import t20.a;

public class Messages {
    private static ResourceBundle bundle;

    static {
        try {
            bundle = setLocale(Locale.getDefault(), "org.apache.commons.compress.harmony.archive.internal.nls.messages");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String format(String str, Object[] objArr) {
        int i11;
        StringBuilder sb2 = new StringBuilder(str.length() + (objArr.length * 20));
        int length = objArr.length;
        String[] strArr = new String[length];
        int i12 = 0;
        for (int i13 = 0; i13 < objArr.length; i13++) {
            Object obj = objArr[i13];
            if (obj == null) {
                strArr[i13] = "<null>";
            } else {
                strArr[i13] = obj.toString();
            }
        }
        while (true) {
            int indexOf = str.indexOf(123, i12);
            if (indexOf < 0) {
                break;
            }
            if (indexOf != 0) {
                int i14 = indexOf - 1;
                if (str.charAt(i14) == '\\') {
                    if (indexOf != 1) {
                        sb2.append(str.substring(i12, i14));
                    }
                    sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
                    i11 = indexOf + 1;
                    i12 = i11;
                }
            }
            if (indexOf > str.length() - 3) {
                sb2.append(str.substring(i12));
                i12 = str.length();
            } else {
                int i15 = indexOf + 1;
                byte digit = (byte) Character.digit(str.charAt(i15), 10);
                if (digit < 0 || str.charAt(indexOf + 2) != '}') {
                    sb2.append(str.substring(i12, i15));
                    i12 = i15;
                } else {
                    sb2.append(str.substring(i12, indexOf));
                    if (digit >= length) {
                        sb2.append("<missing argument>");
                    } else {
                        sb2.append(strArr[digit]);
                    }
                    i11 = indexOf + 3;
                    i12 = i11;
                }
            }
        }
        if (i12 < str.length()) {
            sb2.append(str.substring(i12));
        }
        return sb2.toString();
    }

    public static String getString(String str) {
        ResourceBundle resourceBundle = bundle;
        if (resourceBundle == null) {
            return str;
        }
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return "Missing message: " + str;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$setLocale$0(String str, Locale locale, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return ResourceBundle.getBundle(str, locale, classLoader);
    }

    public static ResourceBundle setLocale(Locale locale, String str) {
        try {
            return (ResourceBundle) AccessController.doPrivileged(new a(str, locale, (ClassLoader) null));
        } catch (MissingResourceException unused) {
            return null;
        }
    }

    public static String getString(String str, Object obj) {
        return getString(str, new Object[]{obj});
    }

    public static String getString(String str, int i11) {
        return getString(str, new Object[]{Integer.toString(i11)});
    }

    public static String getString(String str, char c11) {
        return getString(str, new Object[]{String.valueOf(c11)});
    }

    public static String getString(String str, Object obj, Object obj2) {
        return getString(str, new Object[]{obj, obj2});
    }

    public static String getString(String str, Object[] objArr) {
        ResourceBundle resourceBundle = bundle;
        if (resourceBundle != null) {
            try {
                str = resourceBundle.getString(str);
            } catch (MissingResourceException unused) {
            }
        }
        return format(str, objArr);
    }
}
