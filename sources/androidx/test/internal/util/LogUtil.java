package androidx.test.internal.util;

import android.util.Log;
import androidx.test.internal.util.ProcSummary;

public final class LogUtil {
    private static volatile String myProcName;

    public interface Supplier<T> {
        T get();
    }

    public static final /* synthetic */ String a(String str) {
        return str;
    }

    public static final /* synthetic */ String b(String str) {
        String procName = procName();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(procName).length());
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(procName);
        return sb2.toString();
    }

    private static boolean isLoggable(String str, int i11) {
        if (str.length() > 23) {
            str = str.substring(0, 22);
        }
        return Log.isLoggable(str, i11);
    }

    public static void logDebug(String str, String str2, Object... objArr) {
        logDebug(str, (Supplier<String>) new LogUtil$$Lambda$0(str2), objArr);
    }

    public static void logDebugWithProcess(String str, String str2, Object... objArr) {
        logDebug(str, (Supplier<String>) new LogUtil$$Lambda$1(str2), objArr);
    }

    private static final String procName() {
        String str;
        String str2 = myProcName;
        if (str2 != null) {
            return str2;
        }
        try {
            str = ProcSummary.summarize("self").cmdline;
        } catch (ProcSummary.SummaryException unused) {
            str = "unknown";
        }
        if (str.length() <= 64 || !str.contains("-classpath")) {
            return str;
        }
        return "robolectric";
    }

    private static void logDebug(String str, Supplier<String> supplier, Object... objArr) {
        if (isLoggable(str, 3)) {
            String.format(supplier.get(), objArr);
        }
    }
}
