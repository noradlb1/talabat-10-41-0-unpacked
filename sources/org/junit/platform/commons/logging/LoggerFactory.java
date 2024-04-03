package org.junit.platform.commons.logging;

import j$.lang.Iterable;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Supplier;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;

@API(since = "1.0", status = API.Status.INTERNAL)
public final class LoggerFactory {
    /* access modifiers changed from: private */
    public static final Set<LogRecordListener> listeners = ConcurrentHashMap.newKeySet();

    public static final class DelegatingLogger implements Logger {
        private static final String FQCN = "org.junit.platform.commons.logging.LoggerFactory$DelegatingLogger";
        private final Logger julLogger;

        /* renamed from: name  reason: collision with root package name */
        private final String f27998name;

        public DelegatingLogger(String str) {
            this.f27998name = str;
            this.julLogger = Logger.getLogger(str);
        }

        private LogRecord createLogRecord(Level level, Throwable th2, String str) {
            String str2;
            String str3;
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int length = stackTrace.length;
            int i11 = 0;
            boolean z11 = false;
            while (true) {
                if (i11 >= length) {
                    str2 = null;
                    str3 = null;
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i11];
                str2 = stackTraceElement.getClassName();
                if (FQCN.equals(str2)) {
                    z11 = true;
                } else if (z11) {
                    str3 = stackTraceElement.getMethodName();
                    break;
                }
                i11++;
            }
            LogRecord logRecord = new LogRecord(level, str);
            logRecord.setLoggerName(this.f27998name);
            logRecord.setThrown(th2);
            logRecord.setSourceClassName(str2);
            logRecord.setSourceMethodName(str3);
            logRecord.setResourceBundleName(this.julLogger.getResourceBundleName());
            logRecord.setResourceBundle(this.julLogger.getResourceBundle());
            return logRecord;
        }

        private void log(Level level, Throwable th2, Supplier<String> supplier) {
            boolean isLoggable = this.julLogger.isLoggable(level);
            if (isLoggable || !LoggerFactory.listeners.isEmpty()) {
                LogRecord createLogRecord = createLogRecord(level, th2, nullSafeGet(supplier));
                if (isLoggable) {
                    this.julLogger.log(createLogRecord);
                }
                Iterable.EL.forEach(LoggerFactory.listeners, new a(createLogRecord));
            }
        }

        private static String nullSafeGet(Supplier<String> supplier) {
            if (supplier != null) {
                return supplier.get();
            }
            return null;
        }

        public void config(Supplier<String> supplier) {
            log(Level.CONFIG, (Throwable) null, supplier);
        }

        public void debug(Supplier<String> supplier) {
            log(Level.FINE, (Throwable) null, supplier);
        }

        public void error(Supplier<String> supplier) {
            log(Level.SEVERE, (Throwable) null, supplier);
        }

        public void info(Supplier<String> supplier) {
            log(Level.INFO, (Throwable) null, supplier);
        }

        public void trace(Supplier<String> supplier) {
            log(Level.FINER, (Throwable) null, supplier);
        }

        public void warn(Supplier<String> supplier) {
            log(Level.WARNING, (Throwable) null, supplier);
        }

        public void config(Throwable th2, Supplier<String> supplier) {
            log(Level.CONFIG, th2, supplier);
        }

        public void debug(Throwable th2, Supplier<String> supplier) {
            log(Level.FINE, th2, supplier);
        }

        public void error(Throwable th2, Supplier<String> supplier) {
            log(Level.SEVERE, th2, supplier);
        }

        public void info(Throwable th2, Supplier<String> supplier) {
            log(Level.INFO, th2, supplier);
        }

        public void trace(Throwable th2, Supplier<String> supplier) {
            log(Level.FINER, th2, supplier);
        }

        public void warn(Throwable th2, Supplier<String> supplier) {
            log(Level.WARNING, th2, supplier);
        }
    }

    private LoggerFactory() {
    }

    public static void addListener(LogRecordListener logRecordListener) {
        listeners.add(logRecordListener);
    }

    public static Logger getLogger(Class<?> cls) {
        if (cls != null) {
            return new DelegatingLogger(cls.getName());
        }
        throw new JUnitException("Class must not be null");
    }

    public static void removeListener(LogRecordListener logRecordListener) {
        listeners.remove(logRecordListener);
    }
}
