package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzahe;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VolleyLog {
    private static final String CLASS_NAME = VolleyLog.class.getName();
    public static boolean DEBUG = Log.isLoggable(zzahe.zza, 2);
    public static String TAG = "Volley";

    public static class MarkerLog {
        public static final boolean ENABLED = VolleyLog.DEBUG;
        private static final long MIN_DURATION_FOR_LOGGING_MS = 0;
        private boolean mFinished = false;
        private final List<Marker> mMarkers = new ArrayList();

        public static class Marker {

            /* renamed from: name  reason: collision with root package name */
            public final String f40728name;
            public final long thread;
            public final long time;

            public Marker(String str, long j11, long j12) {
                this.f40728name = str;
                this.thread = j11;
                this.time = j12;
            }
        }

        private long getTotalDuration() {
            if (this.mMarkers.size() == 0) {
                return 0;
            }
            long j11 = this.mMarkers.get(0).time;
            List<Marker> list = this.mMarkers;
            return list.get(list.size() - 1).time - j11;
        }

        public synchronized void add(String str, long j11) {
            if (!this.mFinished) {
                this.mMarkers.add(new Marker(str, j11, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public void finalize() throws Throwable {
            if (!this.mFinished) {
                finish("Request on the loose");
                VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        public synchronized void finish(String str) {
            this.mFinished = true;
            long totalDuration = getTotalDuration();
            if (totalDuration > 0) {
                long j11 = this.mMarkers.get(0).time;
                VolleyLog.d("(%-4d ms) %s", Long.valueOf(totalDuration), str);
                for (Marker next : this.mMarkers) {
                    long j12 = next.time;
                    VolleyLog.d("(+%-4d) [%2d] %s", Long.valueOf(j12 - j11), Long.valueOf(next.thread), next.f40728name);
                    j11 = j12;
                }
            }
        }
    }

    private static String buildMessage(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i11 = 2;
        while (true) {
            if (i11 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i11].getClassName().equals(CLASS_NAME)) {
                String className = stackTrace[i11].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + stackTrace[i11].getMethodName();
                break;
            } else {
                i11++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }

    public static void d(String str, Object... objArr) {
        buildMessage(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        Log.e(TAG, buildMessage(str, objArr));
    }

    public static void setTag(String str) {
        d("Changing log tag to %s", str);
        TAG = str;
        DEBUG = Log.isLoggable(str, 2);
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            buildMessage(str, objArr);
        }
    }

    public static void wtf(String str, Object... objArr) {
        Log.wtf(TAG, buildMessage(str, objArr));
    }

    public static void e(Throwable th2, String str, Object... objArr) {
        Log.e(TAG, buildMessage(str, objArr), th2);
    }

    public static void wtf(Throwable th2, String str, Object... objArr) {
        Log.wtf(TAG, buildMessage(str, objArr), th2);
    }
}
