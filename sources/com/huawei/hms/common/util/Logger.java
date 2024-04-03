package com.huawei.hms.common.util;

import android.annotation.SuppressLint;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Locale;
import net.bytebuddy.pool.TypePool;
import org.json.JSONException;

public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f48220a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final String f48221b = "Logger";

    /* renamed from: c  reason: collision with root package name */
    private static final String f48222c = "|";

    /* renamed from: d  reason: collision with root package name */
    private static final int f48223d = 8;

    /* renamed from: e  reason: collision with root package name */
    private static final int f48224e = 20;

    /* renamed from: f  reason: collision with root package name */
    private static final String f48225f = "dynamic-api_";

    public static class b extends Throwable {

        /* renamed from: a  reason: collision with root package name */
        private static final long f48226a = 7129050843360571879L;

        /* renamed from: b  reason: collision with root package name */
        private String f48227b;

        /* renamed from: c  reason: collision with root package name */
        private Throwable f48228c;

        /* renamed from: d  reason: collision with root package name */
        private Throwable f48229d;

        private b(Throwable th2) {
            this.f48229d = th2;
        }

        /* access modifiers changed from: private */
        public void a(Throwable th2) {
            this.f48228c = th2;
        }

        public void a(String str) {
            this.f48227b = str;
        }

        public Throwable getCause() {
            Throwable th2 = this.f48228c;
            if (th2 == this) {
                return null;
            }
            return th2;
        }

        public String getMessage() {
            return this.f48227b;
        }

        public String toString() {
            Throwable th2 = this.f48229d;
            if (th2 == null) {
                return "";
            }
            String name2 = th2.getClass().getName();
            if (this.f48227b == null) {
                return name2;
            }
            String str = name2 + ": ";
            if (this.f48227b.startsWith(str)) {
                return this.f48227b;
            }
            return str + this.f48227b;
        }
    }

    private static int a(int i11, String str, String str2) {
        return Log.println(i11, a(str), a(str2, 7));
    }

    private static String a(int i11) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i11) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i11];
        return Process.myPid() + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + Process.myTid() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getClassName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber();
    }

    private static String a(String str) {
        return f48225f + str;
    }

    private static String a(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return a(i11);
        }
        return a(i11) + "|" + str;
    }

    private static Throwable a(Throwable th2) {
        if (isLoggable(3)) {
            return th2;
        }
        if (th2 == null) {
            return null;
        }
        int i11 = ((th2 instanceof IOException) || (th2 instanceof JSONException)) ? 8 : 20;
        b bVar = new b(th2);
        StackTraceElement[] stackTrace = bVar.getStackTrace();
        if (stackTrace.length > i11) {
            bVar.setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i11));
        } else {
            bVar.setStackTrace(stackTrace);
        }
        bVar.a(anonymizeMessage(th2.getMessage()));
        Throwable cause = th2.getCause();
        b bVar2 = bVar;
        while (cause != null) {
            b bVar3 = new b(cause);
            bVar3.a(anonymizeMessage(cause.getMessage()));
            bVar2.a((Throwable) bVar3);
            cause = cause.getCause();
            bVar2 = bVar3;
        }
        return bVar;
    }

    public static String anonymizeMessage(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i11 = 0; i11 < charArray.length; i11++) {
            if (i11 % 2 == 1) {
                charArray[i11] = TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH;
            }
        }
        return new String(charArray);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, Object obj) {
        println(3, str, obj);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void e(String str, Object obj) {
        println(6, str, obj);
    }

    public static void e(String str, String str2, Throwable th2) {
        Log.e(a(str), a(str2, 5), a(th2));
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    public static String format(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, Object obj) {
        println(4, str, obj);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static boolean isLoggable(int i11) {
        return Log.isLoggable(f48225f, i11);
    }

    public static void println(int i11, String str, Object obj) {
        if (i11 >= 3 && isLoggable(i11)) {
            a(i11, str, obj == null ? "null" : obj.toString());
        }
    }

    public static void println(int i11, String str, String str2, Object... objArr) {
        if (i11 >= 3) {
            if (str2 == null) {
                Log.w(f48221b, "format is null, not log");
                return;
            }
            try {
                if (isLoggable(i11)) {
                    a(i11, str, format(str2, objArr));
                }
            } catch (IllegalFormatException e11) {
                w(f48221b, "log format error" + str2, (Throwable) e11);
            }
        }
    }

    public static void v(String str, Object obj) {
        println(2, str, obj);
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void w(String str, Object obj) {
        println(5, str, obj);
    }

    public static void w(String str, String str2, Throwable th2) {
        Log.w(a(str), a(str2, 5), a(th2));
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }
}
