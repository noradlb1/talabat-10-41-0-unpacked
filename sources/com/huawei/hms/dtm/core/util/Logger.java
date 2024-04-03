package com.huawei.hms.dtm.core.util;

import android.util.Log;

public final class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static j f48614a = new SimpleLogger();

    public static class SimpleLogger implements j {
        private SimpleLogger() {
        }

        public void debug(String str, String str2) {
        }

        public void error(String str, String str2) {
            Log.e(str, str2);
        }

        public void info(String str, String str2) {
            Log.i(str, str2);
        }

        public void verbose(String str, String str2) {
        }

        public void warn(String str, String str2) {
            Log.w(str, str2);
        }
    }

    private Logger() {
        throw new UnsupportedOperationException("Util");
    }

    public static void debug(String str) {
        if (Log.isLoggable("HMS-DTM", 3)) {
            f48614a.debug("HMS-DTM", str);
        }
    }

    public static void debug(String str, String str2) {
        if (Log.isLoggable(str, 3)) {
            f48614a.debug(str, str2);
        }
    }

    public static void error(String str) {
        if (Log.isLoggable("HMS-DTM", 6)) {
            f48614a.error("HMS-DTM", str);
        }
    }

    public static void error(String str, String str2) {
        if (Log.isLoggable(str, 6)) {
            f48614a.error(str, str2);
        }
    }

    public static void info(String str) {
        if (Log.isLoggable("HMS-DTM", 4)) {
            f48614a.info("HMS-DTM", str);
        }
    }

    public static void info(String str, String str2) {
        if (Log.isLoggable(str, 4)) {
            f48614a.info(str, str2);
        }
    }

    public static void test(String str) {
    }

    public static void verbose(String str) {
        if (Log.isLoggable("HMS-DTM", 2)) {
            f48614a.verbose("HMS-DTM", str);
        }
    }

    public static void verbose(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            f48614a.verbose(str, str2);
        }
    }

    public static void warn(String str) {
        if (Log.isLoggable("HMS-DTM", 5)) {
            f48614a.warn("HMS-DTM", str);
        }
    }

    public static void warn(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            f48614a.warn(str, str2);
        }
    }
}
