package com.huawei.hms.maps.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;
import net.bytebuddy.pool.TypePool;

public class maf {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f49629a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    public static class maa extends Throwable {

        /* renamed from: a  reason: collision with root package name */
        private String f49630a;

        /* renamed from: b  reason: collision with root package name */
        private Throwable f49631b;

        /* renamed from: c  reason: collision with root package name */
        private Throwable f49632c;

        public maa(Throwable th2) {
            this.f49632c = th2;
        }

        public void a(String str) {
            this.f49630a = str;
        }

        public void a(Throwable th2) {
            this.f49631b = th2;
        }

        public synchronized Throwable getCause() {
            Throwable th2;
            th2 = this.f49631b;
            if (th2 == this) {
                th2 = null;
            }
            return th2;
        }

        public String getMessage() {
            return this.f49630a;
        }

        public String toString() {
            Throwable th2 = this.f49632c;
            if (th2 == null) {
                return "";
            }
            String name2 = th2.getClass().getName();
            if (this.f49630a == null) {
                return name2;
            }
            String str = name2 + ": ";
            if (this.f49630a.startsWith(str)) {
                return this.f49630a;
            }
            return str + this.f49630a;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i11 = 1;
        if (1 == length) {
            return String.valueOf(TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
        }
        StringBuilder sb2 = new StringBuilder(length);
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (f49629a.matcher(String.valueOf(charAt)).matches()) {
                if (i11 % 2 == 0) {
                    charAt = '*';
                }
                i11++;
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    private static String a(String str, boolean z11) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z11) {
                str = a(str);
            }
            sb2.append(str);
        }
        return sb2.toString();
    }

    public static Throwable a(Throwable th2) {
        if (th2 == null) {
            return null;
        }
        maa maa2 = new maa(th2);
        maa2.setStackTrace(th2.getStackTrace());
        maa2.a(b(th2.getMessage()));
        Throwable cause = th2.getCause();
        maa maa3 = maa2;
        while (cause != null) {
            maa maa4 = new maa(cause);
            maa4.setStackTrace(cause.getStackTrace());
            maa4.a(b(cause.getMessage()));
            maa3.a((Throwable) maa4);
            cause = cause.getCause();
            maa3 = maa4;
        }
        return maa2;
    }

    public static void a(String str, String str2) {
        TextUtils.isEmpty(str2);
    }

    public static void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            b(str2, str3);
        }
    }

    public static void a(String str, String str2, String str3, Throwable th2) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            b(str2, str3);
            a(th2);
        }
    }

    public static void a(String str, String str2, Throwable th2, boolean z11) {
        if (!TextUtils.isEmpty(str2)) {
            a(str2, z11);
            a(th2);
        }
    }

    public static void a(String str, String str2, boolean z11) {
        if (!TextUtils.isEmpty(str2)) {
            a(str2, z11);
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i11 = 0; i11 < charArray.length; i11++) {
            if (i11 % 2 == 0) {
                charArray[i11] = TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH;
            }
        }
        return new String(charArray);
    }

    private static String b(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(a(str2));
        }
        return sb2.toString();
    }

    public static void b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.i(str, b(str2, str3));
        }
    }

    public static void b(String str, String str2, String str3, Throwable th2) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.i(str, b(str2, str3), a(th2));
        }
    }

    public static void b(String str, String str2, Throwable th2, boolean z11) {
        if (!TextUtils.isEmpty(str2) || th2 != null) {
            Log.i(str, a(str2, z11), a(th2));
        }
    }

    public static void b(String str, String str2, boolean z11) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(str, a(str2, z11));
        }
    }

    public static void c(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.w(str, b(str2, str3));
        }
    }

    public static void c(String str, String str2, String str3, Throwable th2) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.w(str, b(str2, str3), a(th2));
        }
    }

    public static void c(String str, String str2, Throwable th2, boolean z11) {
        if (!TextUtils.isEmpty(str2) || th2 != null) {
            Log.w(str, a(str2, z11), a(th2));
        }
    }

    public static void c(String str, String str2, boolean z11) {
        if (!TextUtils.isEmpty(str2)) {
            Log.w(str, a(str2, z11));
        }
    }

    public static void d(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.e(str, b(str2, str3));
        }
    }

    public static void d(String str, String str2, String str3, Throwable th2) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.e(str, b(str2, str3), a(th2));
        }
    }

    public static void d(String str, String str2, Throwable th2, boolean z11) {
        if (!TextUtils.isEmpty(str2) || th2 != null) {
            Log.e(str, a(str2, z11), a(th2));
        }
    }

    public static void d(String str, String str2, boolean z11) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, a(str2, z11));
        }
    }
}
