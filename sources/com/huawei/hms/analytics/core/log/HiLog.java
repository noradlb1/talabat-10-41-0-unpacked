package com.huawei.hms.analytics.core.log;

import java.util.Locale;

public class HiLog {

    /* renamed from: a  reason: collision with root package name */
    private static LogAdapter f47909a;

    public interface ErrorCode {
        public static final String CE001 = "CE-001";
        public static final String IE001 = "IE-001";
        public static final String IE002 = "IE-002";
        public static final String IE003 = "IE-003";
        public static final String IE004 = "IE-004";
        public static final String IE005 = "IE-005";
        public static final String IE006 = "IE-006";
        public static final String NE001 = "NE-001";
        public static final String NE002 = "NE-002";
        public static final String NE003 = "NE-003";
        public static final String NE004 = "NE-004";
        public static final String NE005 = "NE-005";
        public static final String NE006 = "NE-006";
        public static final String PE001 = "PE-001";
        public static final String PE002 = "PE-002";
        public static final String PE003 = "PE-003";
        public static final String PE004 = "PE-004";
        public static final String PE005 = "PE-005";
        public static final String PE006 = "PE-006";
        public static final String SE001 = "SE-001";
        public static final String SE002 = "SE-002";
        public static final String SE003 = "SE-003";
    }

    private static boolean a() {
        LogAdapter logAdapter = f47909a;
        if (logAdapter != null) {
            return logAdapter.isLoggable(3);
        }
        return false;
    }

    private static boolean b() {
        LogAdapter logAdapter = f47909a;
        if (logAdapter != null) {
            return logAdapter.isLoggable(4);
        }
        return false;
    }

    private static boolean c() {
        LogAdapter logAdapter = f47909a;
        if (logAdapter != null) {
            return logAdapter.isLoggable(5);
        }
        return false;
    }

    public static void d(String str, String str2) {
        if (a() && str != null && str2 != null) {
            f47909a.println(3, str, str2);
        }
    }

    public static void d(String str, String str2, String str3) {
        if (a()) {
            f47909a.println(3, str, str2, str3);
        }
    }

    private static boolean d() {
        LogAdapter logAdapter = f47909a;
        if (logAdapter != null) {
            return logAdapter.isLoggable(6);
        }
        return false;
    }

    public static void e(String str, String str2) {
        if (d() && str != null && str2 != null) {
            f47909a.println(6, str, str2);
        }
    }

    public static void e(String str, String str2, String str3) {
        if (d()) {
            f47909a.println(6, str, str2, str3);
        }
    }

    public static void i(String str, String str2) {
        if (b() && str != null && str2 != null) {
            f47909a.println(4, str, str2);
        }
    }

    public static void i(String str, String str2, String str3) {
        if (b()) {
            f47909a.println(4, str, str2, str3);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (b() && str != null && str2 != null) {
            f47909a.println(4, str, String.format(Locale.ROOT, str2, objArr));
        }
    }

    public static synchronized void init(int i11, String str) {
        synchronized (HiLog.class) {
            if (f47909a == null) {
                f47909a = new a();
            }
            f47909a.init(i11, str);
        }
    }

    public static void w(String str, String str2) {
        if (c() && str != null && str2 != null) {
            f47909a.println(5, str, str2);
        }
    }

    public static void w(String str, String str2, String str3) {
        if (c()) {
            f47909a.println(5, str, str2, str3);
        }
    }
}
