package com.google.logging.type;

import com.google.protobuf.Internal;

public enum LogSeverity implements Internal.EnumLite {
    DEFAULT(0),
    DEBUG(100),
    INFO(200),
    NOTICE(300),
    WARNING(400),
    ERROR(500),
    CRITICAL(600),
    ALERT(700),
    EMERGENCY(800),
    UNRECOGNIZED(-1);
    
    public static final int ALERT_VALUE = 700;
    public static final int CRITICAL_VALUE = 600;
    public static final int DEBUG_VALUE = 100;
    public static final int DEFAULT_VALUE = 0;
    public static final int EMERGENCY_VALUE = 800;
    public static final int ERROR_VALUE = 500;
    public static final int INFO_VALUE = 200;
    public static final int NOTICE_VALUE = 300;
    public static final int WARNING_VALUE = 400;
    private static final Internal.EnumLiteMap<LogSeverity> internalValueMap = null;
    private final int value;

    public static final class LogSeverityVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new LogSeverityVerifier();
        }

        private LogSeverityVerifier() {
        }

        public boolean isInRange(int i11) {
            return LogSeverity.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<LogSeverity>() {
            public LogSeverity findValueByNumber(int i11) {
                return LogSeverity.forNumber(i11);
            }
        };
    }

    private LogSeverity(int i11) {
        this.value = i11;
    }

    public static LogSeverity forNumber(int i11) {
        if (i11 == 0) {
            return DEFAULT;
        }
        if (i11 == 100) {
            return DEBUG;
        }
        if (i11 == 200) {
            return INFO;
        }
        if (i11 == 300) {
            return NOTICE;
        }
        if (i11 == 400) {
            return WARNING;
        }
        if (i11 == 500) {
            return ERROR;
        }
        if (i11 == 600) {
            return CRITICAL;
        }
        if (i11 == 700) {
            return ALERT;
        }
        if (i11 != 800) {
            return null;
        }
        return EMERGENCY;
    }

    public static Internal.EnumLiteMap<LogSeverity> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return LogSeverityVerifier.INSTANCE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static LogSeverity valueOf(int i11) {
        return forNumber(i11);
    }
}
