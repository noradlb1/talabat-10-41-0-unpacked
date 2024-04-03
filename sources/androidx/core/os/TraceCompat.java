package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

@Deprecated
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    @RequiresApi(18)
    public static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static void a(String str) {
            Trace.beginSection(str);
        }

        @DoNotInline
        public static void b() {
            Trace.endSection();
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void a(String str, int i11) {
            Trace.beginAsyncSection(str, i11);
        }

        @DoNotInline
        public static void b(String str, int i11) {
            Trace.endAsyncSection(str, i11);
        }

        @DoNotInline
        public static boolean c() {
            return Trace.isEnabled();
        }

        @DoNotInline
        public static void d(String str, long j11) {
            Trace.setCounter(str, j11);
        }
    }

    static {
        Class<String> cls = String.class;
        Class<Trace> cls2 = Trace.class;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                sTraceTagApp = cls2.getField("TRACE_TAG_APP").getLong((Object) null);
                Class cls3 = Long.TYPE;
                sIsTagEnabledMethod = cls2.getMethod("isTagEnabled", new Class[]{cls3});
                Class cls4 = Integer.TYPE;
                sAsyncTraceBeginMethod = cls2.getMethod("asyncTraceBegin", new Class[]{cls3, cls, cls4});
                sAsyncTraceEndMethod = cls2.getMethod("asyncTraceEnd", new Class[]{cls3, cls, cls4});
                sTraceCounterMethod = cls2.getMethod("traceCounter", new Class[]{cls3, cls, cls4});
            } catch (Exception e11) {
                Log.i(TAG, "Unable to initialize via reflection.", e11);
            }
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String str, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.a(str, i11);
            return;
        }
        try {
            sAsyncTraceBeginMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i11)});
        } catch (Exception unused) {
        }
    }

    public static void beginSection(@NonNull String str) {
        Api18Impl.a(str);
    }

    public static void endAsyncSection(@NonNull String str, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.b(str, i11);
            return;
        }
        try {
            sAsyncTraceEndMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i11)});
        } catch (Exception unused) {
        }
    }

    public static void endSection() {
        Api18Impl.b();
    }

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.c();
        }
        try {
            return ((Boolean) sIsTagEnabledMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void setCounter(@NonNull String str, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.d(str, (long) i11);
            return;
        }
        try {
            sTraceCounterMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i11)});
        } catch (Exception unused) {
        }
    }
}
