package com.google.firebase.perf.v1;

import com.google.protobuf.Internal;

public enum ApplicationProcessState implements Internal.EnumLite {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);
    
    public static final int APPLICATION_PROCESS_STATE_UNKNOWN_VALUE = 0;
    public static final int BACKGROUND_VALUE = 2;
    public static final int FOREGROUND_BACKGROUND_VALUE = 3;
    public static final int FOREGROUND_VALUE = 1;
    private static final Internal.EnumLiteMap<ApplicationProcessState> internalValueMap = null;
    private final int value;

    public static final class ApplicationProcessStateVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new ApplicationProcessStateVerifier();
        }

        private ApplicationProcessStateVerifier() {
        }

        public boolean isInRange(int i11) {
            return ApplicationProcessState.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<ApplicationProcessState>() {
            public ApplicationProcessState findValueByNumber(int i11) {
                return ApplicationProcessState.forNumber(i11);
            }
        };
    }

    private ApplicationProcessState(int i11) {
        this.value = i11;
    }

    public static ApplicationProcessState forNumber(int i11) {
        if (i11 == 0) {
            return APPLICATION_PROCESS_STATE_UNKNOWN;
        }
        if (i11 == 1) {
            return FOREGROUND;
        }
        if (i11 == 2) {
            return BACKGROUND;
        }
        if (i11 != 3) {
            return null;
        }
        return FOREGROUND_BACKGROUND;
    }

    public static Internal.EnumLiteMap<ApplicationProcessState> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ApplicationProcessStateVerifier.INSTANCE;
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static ApplicationProcessState valueOf(int i11) {
        return forNumber(i11);
    }
}
