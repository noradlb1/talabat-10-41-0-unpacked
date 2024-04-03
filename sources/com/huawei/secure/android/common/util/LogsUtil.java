package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

public class LogsUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f33986a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: b  reason: collision with root package name */
    private static final char f33987b = '*';

    /* renamed from: c  reason: collision with root package name */
    private static final int f33988c = 2;

    public static class a extends Throwable {

        /* renamed from: d  reason: collision with root package name */
        private static final long f33989d = 7129050843360571879L;

        /* renamed from: a  reason: collision with root package name */
        private String f33990a;

        /* renamed from: b  reason: collision with root package name */
        private Throwable f33991b;

        /* renamed from: c  reason: collision with root package name */
        private Throwable f33992c;

        public a(Throwable th2) {
            this.f33992c = th2;
        }

        public void a(Throwable th2) {
            this.f33991b = th2;
        }

        public synchronized Throwable getCause() {
            Throwable th2;
            th2 = this.f33991b;
            if (th2 == this) {
                th2 = null;
            }
            return th2;
        }

        public String getMessage() {
            return this.f33990a;
        }

        public String toString() {
            Throwable th2 = this.f33992c;
            if (th2 == null) {
                return "";
            }
            String name2 = th2.getClass().getName();
            if (this.f33990a == null) {
                return name2;
            }
            String str = name2 + ": ";
            if (this.f33990a.startsWith(str)) {
                return this.f33990a;
            }
            return str + this.f33990a;
        }

        public void a(String str) {
            this.f33990a = str;
        }
    }

    private static String a(String str, boolean z11) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z11) {
                sb2.append(a(str));
            } else {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i11 = 0; i11 < charArray.length; i11++) {
            if (i11 % 2 == 0) {
                charArray[i11] = '*';
            }
        }
        return new String(charArray);
    }

    public static void d(String str, String str2, boolean z11) {
        if (!TextUtils.isEmpty(str2)) {
            a(str2, z11);
        }
    }

    public static void e(String str, String str2, boolean z11) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, a(str2, z11));
        }
    }

    public static Throwable getNewThrowable(Throwable th2) {
        if (th2 == null) {
            return null;
        }
        a aVar = new a(th2);
        aVar.setStackTrace(th2.getStackTrace());
        aVar.a(b(th2.getMessage()));
        Throwable cause = th2.getCause();
        a aVar2 = aVar;
        while (cause != null) {
            a aVar3 = new a(cause);
            aVar3.setStackTrace(cause.getStackTrace());
            aVar3.a(b(cause.getMessage()));
            aVar2.a((Throwable) aVar3);
            cause = cause.getCause();
            aVar2 = aVar3;
        }
        return aVar;
    }

    public static void i(String str, String str2, boolean z11) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(str, a(str2, z11));
        }
    }

    public static void w(String str, String str2, boolean z11) {
        if (!TextUtils.isEmpty(str2)) {
            Log.w(str, a(str2, z11));
        }
    }

    public static void d(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            a(str2, str3);
        }
    }

    public static void e(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.e(str, a(str2, str3));
        }
    }

    public static void i(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.i(str, a(str2, str3));
        }
    }

    public static void w(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.w(str, a(str2, str3));
        }
    }

    public static void d(String str, String str2, String str3, Throwable th2) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            a(str2, str3);
            getNewThrowable(th2);
        }
    }

    public static void e(String str, String str2, String str3, Throwable th2) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.e(str, a(str2, str3), getNewThrowable(th2));
        }
    }

    public static void i(String str, String str2, String str3, Throwable th2) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.i(str, a(str2, str3), getNewThrowable(th2));
        }
    }

    public static void w(String str, String str2, String str3, Throwable th2) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.w(str, a(str2, str3), getNewThrowable(th2));
        }
    }

    private static String a(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(a(str2));
        }
        return sb2.toString();
    }

    public static void d(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            a(str2, false);
        }
    }

    public static void e(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, a(str2, false));
        }
    }

    public static void i(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(str, a(str2, false));
        }
    }

    public static void w(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.w(str, a(str2, false));
        }
    }

    public static void d(String str, String str2, Throwable th2, boolean z11) {
        if (!TextUtils.isEmpty(str2)) {
            a(str2, z11);
            getNewThrowable(th2);
        }
    }

    public static void e(String str, String str2, Throwable th2, boolean z11) {
        if (!TextUtils.isEmpty(str2) || th2 != null) {
            Log.e(str, a(str2, z11), getNewThrowable(th2));
        }
    }

    public static void i(String str, String str2, Throwable th2, boolean z11) {
        if (!TextUtils.isEmpty(str2) || th2 != null) {
            Log.i(str, a(str2, z11), getNewThrowable(th2));
        }
    }

    public static void w(String str, String str2, Throwable th2, boolean z11) {
        if (!TextUtils.isEmpty(str2) || th2 != null) {
            Log.w(str, a(str2, z11), getNewThrowable(th2));
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        if (!TextUtils.isEmpty(str2) || th2 != null) {
            a(str2, false);
            getNewThrowable(th2);
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        if (!TextUtils.isEmpty(str2) || th2 != null) {
            Log.e(str, a(str2, false), getNewThrowable(th2));
        }
    }

    public static void i(String str, String str2, Throwable th2) {
        if (!TextUtils.isEmpty(str2) || th2 != null) {
            Log.i(str, a(str2, false), getNewThrowable(th2));
        }
    }

    public static void w(String str, String str2, Throwable th2) {
        if (!TextUtils.isEmpty(str2) || th2 != null) {
            Log.w(str, a(str2, false), getNewThrowable(th2));
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i11 = 1;
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder sb2 = new StringBuilder(length);
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (f33986a.matcher(String.valueOf(charAt)).matches()) {
                if (i11 % 2 == 0) {
                    charAt = '*';
                }
                i11++;
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }
}
