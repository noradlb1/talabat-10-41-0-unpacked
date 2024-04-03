package com.apptimize;

import android.util.Log;
import com.apptimize.Apptimize;
import com.apptimize.ApptimizeOptions;
import java.util.concurrent.atomic.AtomicReference;

public class bo {

    /* renamed from: a  reason: collision with root package name */
    private static ApptimizeOptions.LogLevel f41394a = ApptimizeOptions.LogLevel.VERBOSE;

    /* renamed from: b  reason: collision with root package name */
    private static AtomicReference<Apptimize.LogMonitor> f41395b = new AtomicReference<>((Object) null);

    /* renamed from: c  reason: collision with root package name */
    private static boolean f41396c = false;

    /* renamed from: d  reason: collision with root package name */
    private static int f41397d = 0;

    /* renamed from: com.apptimize.bo$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41398a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.apptimize.ApptimizeOptions$LogLevel[] r0 = com.apptimize.ApptimizeOptions.LogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f41398a = r0
                com.apptimize.ApptimizeOptions$LogLevel r1 = com.apptimize.ApptimizeOptions.LogLevel.VERBOSE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f41398a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.apptimize.ApptimizeOptions$LogLevel r1 = com.apptimize.ApptimizeOptions.LogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f41398a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.apptimize.ApptimizeOptions$LogLevel r1 = com.apptimize.ApptimizeOptions.LogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f41398a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.apptimize.ApptimizeOptions$LogLevel r1 = com.apptimize.ApptimizeOptions.LogLevel.WARNING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f41398a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.apptimize.ApptimizeOptions$LogLevel r1 = com.apptimize.ApptimizeOptions.LogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.bo.AnonymousClass1.<clinit>():void");
        }
    }

    public static void a(ApptimizeOptions.LogLevel logLevel) {
        if (logLevel != null) {
            f41394a = logLevel;
        }
    }

    private static Throwable b(Throwable th2) {
        if (th2 == null) {
            return null;
        }
        Throwable th3 = new Throwable(th2.getMessage(), b(th2.getCause()));
        if (th2.getStackTrace().length == 0) {
            th3.setStackTrace(new StackTraceElement[0]);
        } else {
            th3.setStackTrace(new StackTraceElement[]{th2.getStackTrace()[0]});
        }
        return th3;
    }

    public static void c(String str, String str2) {
        a(ApptimizeOptions.LogLevel.INFO, false, false, str, str2);
    }

    public static void d(String str, String str2) {
        a(ApptimizeOptions.LogLevel.VERBOSE, false, false, str, str2);
    }

    public static void e(String str, String str2) {
        a(ApptimizeOptions.LogLevel.WARNING, false, false, str, str2);
    }

    public static void f(String str, String str2) {
        a(ApptimizeOptions.LogLevel.DEBUG, true, false, str, str2);
    }

    public static void g(String str, String str2) {
        a(ApptimizeOptions.LogLevel.ERROR, true, false, str, str2);
    }

    public static void h(String str, String str2) {
        a(ApptimizeOptions.LogLevel.INFO, true, false, str, str2);
    }

    public static void i(String str, String str2) {
        a(ApptimizeOptions.LogLevel.VERBOSE, true, false, str, str2);
    }

    public static void j(String str, String str2) {
        a(ApptimizeOptions.LogLevel.WARNING, true, false, str, str2);
    }

    public static void k(String str, String str2) {
        a(ApptimizeOptions.LogLevel.DEBUG, false, true, str, str2);
    }

    public static void l(String str, String str2) {
        a(ApptimizeOptions.LogLevel.ERROR, false, true, str, str2);
    }

    public static void m(String str, String str2) {
        a(ApptimizeOptions.LogLevel.INFO, false, true, str, str2);
    }

    public static void n(String str, String str2) {
        a(ApptimizeOptions.LogLevel.WARNING, false, true, str, str2);
    }

    public static void o(String str, String str2) {
        a(ApptimizeOptions.LogLevel.DEBUG, true, true, str, str2);
    }

    public static void p(String str, String str2) {
        a(ApptimizeOptions.LogLevel.ERROR, true, true, str, str2);
    }

    public static void q(String str, String str2) {
        a(ApptimizeOptions.LogLevel.INFO, true, true, str, str2);
    }

    public static void r(String str, String str2) {
        a(ApptimizeOptions.LogLevel.VERBOSE, true, true, str, str2);
    }

    public static void s(String str, String str2) {
        a(ApptimizeOptions.LogLevel.WARNING, true, true, str, str2);
    }

    public static void a(Apptimize.LogMonitor logMonitor, boolean z11) {
        f41395b.set(logMonitor);
        f41396c = z11 && logMonitor != null;
    }

    public static void c(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.INFO, false, false, str, str2, th2);
    }

    public static void d(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.WARNING, false, false, str, str2, th2);
    }

    public static void e(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.ERROR, true, false, str, str2, th2);
    }

    public static void f(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.INFO, true, false, str, str2, th2);
    }

    public static void g(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.WARNING, true, false, str, str2, th2);
    }

    public static void h(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.DEBUG, false, true, str, str2, th2);
    }

    public static void i(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.ERROR, false, true, str, str2, th2);
    }

    public static void j(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.INFO, false, true, str, str2, th2);
    }

    public static void k(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.WARNING, false, true, str, str2, th2);
    }

    public static void l(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.ERROR, true, true, str, str2, th2);
    }

    public static void m(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.WARNING, true, true, str, str2, th2);
    }

    public static String a(Throwable th2) {
        return Log.getStackTraceString(th2);
    }

    public static void a(String str, String str2) {
        a(ApptimizeOptions.LogLevel.DEBUG, false, false, str, str2);
    }

    public static void a(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.DEBUG, false, false, str, str2, th2);
    }

    public static void b(String str, String str2) {
        a(ApptimizeOptions.LogLevel.ERROR, false, false, str, str2);
    }

    private static boolean a(ApptimizeOptions.LogLevel logLevel, String str, String str2, Throwable th2) {
        Apptimize.LogMonitor logMonitor = f41395b.get();
        if (logMonitor == null) {
            return false;
        }
        logMonitor.log(logLevel, str, str2, th2);
        return f41396c;
    }

    public static void b(String str, String str2, Throwable th2) {
        a(ApptimizeOptions.LogLevel.ERROR, false, false, str, str2, th2);
    }

    private static void a(ApptimizeOptions.LogLevel logLevel, boolean z11, boolean z12, String str, String str2) {
        if (!av.f41239b) {
            if (z11) {
                str = "Apptimize";
            } else {
                return;
            }
        }
        if (!z12) {
            bp.a(logLevel.getTag(), str, str2, (Throwable) null);
        }
        if ((av.f41239b || f41394a.ordinal() <= logLevel.ordinal()) && !a(logLevel, str, str2, (Throwable) null)) {
            int i11 = AnonymousClass1.f41398a[logLevel.ordinal()];
            if (i11 == 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Apptimize: ");
                sb2.append(str2);
            } else if (i11 == 2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Apptimize: ");
                sb3.append(str2);
            } else if (i11 == 3) {
                Log.i(str, "Apptimize: " + str2);
            } else if (i11 == 4) {
                Log.w(str, "Apptimize: " + str2);
            } else if (i11 == 5) {
                Log.e(str, "Apptimize: " + str2);
            }
        }
    }

    private static void a(ApptimizeOptions.LogLevel logLevel, boolean z11, boolean z12, String str, String str2, Throwable th2) {
        f41397d++;
        if (!av.f41239b) {
            if (z11) {
                str = "Apptimize";
            } else {
                return;
            }
        }
        if (gn.h() && !av.f41239b) {
            th2 = b(th2);
        }
        if (!z12) {
            bp.a(logLevel.getTag(), str, str2, th2);
        }
        if ((av.f41239b || f41394a.ordinal() <= logLevel.ordinal()) && !a(logLevel, str, str2, th2)) {
            int i11 = AnonymousClass1.f41398a[logLevel.ordinal()];
            if (i11 == 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Apptimize: ");
                sb2.append(str2);
            } else if (i11 == 2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Apptimize: ");
                sb3.append(str2);
            } else if (i11 == 3) {
                Log.i(str, "Apptimize: " + str2, th2);
            } else if (i11 == 4) {
                Log.w(str, "Apptimize: " + str2, th2);
            } else if (i11 == 5) {
                Log.e(str, "Apptimize: " + str2, th2);
            }
        }
    }
}
