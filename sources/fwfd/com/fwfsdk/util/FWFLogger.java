package fwfd.com.fwfsdk.util;

public class FWFLogger {
    private static boolean isUnitTest = false;
    public static FWFLogLevel logLevel = FWFLogLevel.verbose;
    private static String stringLog = "";

    public enum FWFLogLevel {
        verbose(0),
        debug(1),
        info(2),
        warning(3),
        error(4),
        none(5);
        
        private int value;

        private FWFLogLevel(int i11) {
            this.value = i11;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static String getStringLog() {
        return stringLog;
    }

    private static void log(String str, String str2) {
        if (isUnitTest) {
            stringLog = str;
            System.out.println(str);
        }
    }

    public static void logDebug(String str) {
        if (logLevel.getValue() <= FWFLogLevel.debug.getValue()) {
            log(str, "d");
        }
    }

    public static void logError(String str) {
        if (logLevel.getValue() <= FWFLogLevel.error.getValue()) {
            log(str, "e");
        }
    }

    public static void logInfo(String str) {
        if (logLevel.getValue() <= FWFLogLevel.info.getValue()) {
            log(str, "i");
        }
    }

    public static void logVerbose(String str) {
        if (logLevel.getValue() <= FWFLogLevel.verbose.getValue()) {
            log(str, "v");
        }
    }

    public static void logWarning(String str) {
        if (logLevel.getValue() <= FWFLogLevel.warning.getValue()) {
            log(str, "w");
        }
    }

    public static void setIsUnitTest(boolean z11) {
        isUnitTest = z11;
    }
}
