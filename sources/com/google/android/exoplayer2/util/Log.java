package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.UnknownHostException;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.dataflow.qual.Pure;

public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 2;
    private static final Object lock = new Object();
    @GuardedBy("lock")
    private static int logLevel = 0;
    @GuardedBy("lock")
    private static boolean logStackTraces = true;
    @GuardedBy("lock")
    private static Logger logger = Logger.DEFAULT;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            public void d(String str, String str2) {
            }

            public void e(String str, String str2) {
                android.util.Log.e(str, str2);
            }

            public void i(String str, String str2) {
                android.util.Log.i(str, str2);
            }

            public void w(String str, String str2) {
                android.util.Log.w(str, str2);
            }
        };

        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    private Log() {
    }

    @Pure
    private static String appendThrowableString(String str, @Nullable Throwable th2) {
        String throwableString = getThrowableString(th2);
        if (TextUtils.isEmpty(throwableString)) {
            return str;
        }
        return str + "\n  " + throwableString.replace(StringUtils.LF, "\n  ") + 10;
    }

    @Pure
    public static void d(@Size(max = 23) String str, String str2) {
        synchronized (lock) {
            if (logLevel == 0) {
                logger.d(str, str2);
            }
        }
    }

    @Pure
    public static void e(@Size(max = 23) String str, String str2) {
        synchronized (lock) {
            if (logLevel <= 3) {
                logger.e(str, str2);
            }
        }
    }

    @Pure
    public static int getLogLevel() {
        int i11;
        synchronized (lock) {
            i11 = logLevel;
        }
        return i11;
    }

    @Nullable
    @Pure
    public static String getThrowableString(@Nullable Throwable th2) {
        synchronized (lock) {
            if (th2 == null) {
                return null;
            }
            if (isCausedByUnknownHostException(th2)) {
                return "UnknownHostException (no network)";
            }
            if (!logStackTraces) {
                String message = th2.getMessage();
                return message;
            }
            String replace = android.util.Log.getStackTraceString(th2).trim().replace("\t", "    ");
            return replace;
        }
    }

    @Pure
    public static void i(@Size(max = 23) String str, String str2) {
        synchronized (lock) {
            if (logLevel <= 1) {
                logger.i(str, str2);
            }
        }
    }

    @Pure
    private static boolean isCausedByUnknownHostException(@Nullable Throwable th2) {
        while (th2 != null) {
            if (th2 instanceof UnknownHostException) {
                return true;
            }
            th2 = th2.getCause();
        }
        return false;
    }

    public static void setLogLevel(int i11) {
        synchronized (lock) {
            logLevel = i11;
        }
    }

    public static void setLogStackTraces(boolean z11) {
        synchronized (lock) {
            logStackTraces = z11;
        }
    }

    public static void setLogger(Logger logger2) {
        synchronized (lock) {
            logger = logger2;
        }
    }

    @Pure
    public static void w(@Size(max = 23) String str, String str2) {
        synchronized (lock) {
            if (logLevel <= 2) {
                logger.w(str, str2);
            }
        }
    }

    @Pure
    public static void d(@Size(max = 23) String str, String str2, @Nullable Throwable th2) {
        d(str, appendThrowableString(str2, th2));
    }

    @Pure
    public static void e(@Size(max = 23) String str, String str2, @Nullable Throwable th2) {
        e(str, appendThrowableString(str2, th2));
    }

    @Pure
    public static void i(@Size(max = 23) String str, String str2, @Nullable Throwable th2) {
        i(str, appendThrowableString(str2, th2));
    }

    @Pure
    public static void w(@Size(max = 23) String str, String str2, @Nullable Throwable th2) {
        w(str, appendThrowableString(str2, th2));
    }
}
