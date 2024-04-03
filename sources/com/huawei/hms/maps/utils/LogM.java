package com.huawei.hms.maps.utils;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import net.bytebuddy.utility.JavaConstant;

public class LogM {

    /* renamed from: a  reason: collision with root package name */
    private static StringBuffer f49614a = new StringBuffer();

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f49615b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f49616c = (Log.isLoggable("HmsMapSite", 2));

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f49617d = (Log.isLoggable("HmsMapSite", 3));

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f49618e = (Log.isLoggable("HmsMapSite", 4));

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f49619f = (Log.isLoggable("HmsMapSite", 5));

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f49620g;

    static {
        boolean z11 = false;
        if (Log.isLoggable("HmsMapSite", 6)) {
            z11 = true;
        }
        f49620g = z11;
    }

    private LogM() {
    }

    private static String a(long j11) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SSS").format(new Date(j11));
    }

    private static String a(String str) {
        if (str == null) {
            return "HmsMapKit";
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int lineNumber = stackTrace.length > 5 ? stackTrace[5].getLineNumber() : 0;
        return "HmsMapKit_" + str + JavaConstant.Dynamic.DEFAULT_NAME + lineNumber;
    }

    private static String a(String str, boolean z11) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z11) {
                str = maf.a(str);
            }
            sb2.append(str);
        }
        return sb2.toString();
    }

    private static void a(String str, String str2) {
        StringBuffer stringBuffer;
        if (TextUtils.isEmpty(str)) {
            str = "HmsMapKit";
        }
        if (f49614a.length() == 0) {
            stringBuffer = f49614a;
        } else {
            stringBuffer = f49614a;
            stringBuffer.append(System.lineSeparator());
        }
        stringBuffer.append(a(System.currentTimeMillis()));
        stringBuffer.append(" ");
        stringBuffer.append(str);
        stringBuffer.append(CertificateUtil.DELIMITER);
        stringBuffer.append(str2);
        if (f49614a.length() > 3072) {
            f49614a.setLength(0);
        }
    }

    public static void d(String str, String str2) {
        if (f49617d) {
            d(str, str2, (Throwable) null, false);
        }
    }

    public static void d(String str, String str2, String str3) {
        if (f49617d) {
            d(str, str2, str3, (Throwable) null);
        }
    }

    public static void d(String str, String str2, String str3, Throwable th2) {
        if (f49617d) {
            String a11 = a(str);
            if (th2 == null) {
                maf.a(a11, str2, str3);
            } else {
                maf.a(a11, str2, str3, th2);
            }
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        if (f49617d) {
            d(str, str2, th2, false);
        }
    }

    public static void d(String str, String str2, Throwable th2, boolean z11) {
        if (f49617d) {
            String a11 = a(str);
            if (th2 == null) {
                maf.a(a11, str2, z11);
            } else {
                maf.a(a11, str2, th2, z11);
            }
        }
    }

    public static void d(String str, String str2, boolean z11) {
        if (f49617d) {
            d(str, str2, (Throwable) null, z11);
        }
    }

    public static void e(String str, String str2) {
        if (f49620g) {
            e(str, str2, (Throwable) null, false);
        }
    }

    public static void e(String str, String str2, String str3) {
        if (f49620g) {
            e(str, str2, str3, (Throwable) null);
        }
    }

    public static void e(String str, String str2, String str3, Throwable th2) {
        String str4;
        if (f49620g) {
            String a11 = a(str);
            if (th2 == null) {
                maf.d(a11, str2, str3);
                str4 = getLogMsg(str2, str3);
            } else {
                maf.d(a11, str2, str3, th2);
                str4 = getLogMsg(str2, str3) + System.lineSeparator() + Log.getStackTraceString(maf.a(th2));
            }
            a(str, str4);
        }
    }

    public static void e(String str, String str2, Throwable th2, boolean z11) {
        String str3;
        if (f49620g) {
            String a11 = a(str);
            if (th2 == null) {
                maf.d(a11, str2, z11);
                str3 = a(str2, z11);
            } else {
                maf.d(a11, str2, th2, z11);
                str3 = a(str2, z11) + System.lineSeparator() + Log.getStackTraceString(maf.a(th2));
            }
            a(str, str3);
        }
    }

    public static void e(String str, String str2, boolean z11) {
        if (f49620g) {
            e(str, str2, (Throwable) null, z11);
        }
    }

    public static String getErrLog() {
        if (f49614a.length() <= 0) {
            return "";
        }
        String stringBuffer = f49614a.toString();
        f49614a.setLength(0);
        return stringBuffer;
    }

    public static String getLogMsg(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(maf.a(str2));
        }
        return sb2.toString();
    }

    public static void i(String str, String str2) {
        if (f49618e) {
            i(str, str2, (Throwable) null, false);
        }
    }

    public static void i(String str, String str2, String str3) {
        if (f49618e) {
            i(str, str2, str3, (Throwable) null);
        }
    }

    public static void i(String str, String str2, String str3, Throwable th2) {
        if (f49618e) {
            String a11 = a(str);
            if (th2 == null) {
                maf.b(a11, str2, str3);
            } else {
                maf.b(a11, str2, str3, th2);
            }
        }
    }

    public static void i(String str, String str2, Throwable th2) {
        if (f49618e) {
            i(str, str2, th2, false);
        }
    }

    public static void i(String str, String str2, Throwable th2, boolean z11) {
        if (f49618e) {
            String a11 = a(str);
            if (th2 == null) {
                maf.b(a11, str2, z11);
            } else {
                maf.b(a11, str2, th2, z11);
            }
        }
    }

    public static void i(String str, String str2, boolean z11) {
        if (f49618e) {
            i(str, str2, (Throwable) null, z11);
        }
    }

    public static void v(String str, String str2) {
        if (f49616c) {
            maf.a(a(str), str2);
        }
    }

    public static void w(String str, String str2) {
        if (f49619f) {
            w(str, str2, (Throwable) null, false);
        }
    }

    public static void w(String str, String str2, String str3) {
        if (f49619f) {
            w(str, str2, str3, (Throwable) null);
        }
    }

    public static void w(String str, String str2, String str3, Throwable th2) {
        String str4;
        if (f49619f) {
            String a11 = a(str);
            if (th2 == null) {
                maf.c(a11, str2, str3);
                str4 = getLogMsg(str2, str3);
            } else {
                maf.c(a11, str2, str3, th2);
                str4 = getLogMsg(str2, str3) + System.lineSeparator() + Log.getStackTraceString(maf.a(th2));
            }
            a(str, str4);
        }
    }

    public static void w(String str, String str2, Throwable th2) {
        if (f49619f) {
            w(str, str2, th2, false);
        }
    }

    public static void w(String str, String str2, Throwable th2, boolean z11) {
        String str3;
        if (f49619f) {
            String a11 = a(str);
            if (th2 == null) {
                maf.c(a11, str2, z11);
                str3 = a(str2, z11);
            } else {
                maf.c(a11, str2, th2, z11);
                str3 = a(str2, z11) + System.lineSeparator() + Log.getStackTraceString(maf.a(th2));
            }
            a(str, str3);
        }
    }

    public static void w(String str, String str2, boolean z11) {
        if (f49619f) {
            w(str, str2, (Throwable) null, z11);
        }
    }
}
