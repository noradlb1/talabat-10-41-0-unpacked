package com.google.api;

import com.google.protobuf.Internal;

public enum LaunchStage implements Internal.EnumLite {
    LAUNCH_STAGE_UNSPECIFIED(0),
    EARLY_ACCESS(1),
    ALPHA(2),
    BETA(3),
    GA(4),
    DEPRECATED(5),
    UNRECOGNIZED(-1);
    
    public static final int ALPHA_VALUE = 2;
    public static final int BETA_VALUE = 3;
    public static final int DEPRECATED_VALUE = 5;
    public static final int EARLY_ACCESS_VALUE = 1;
    public static final int GA_VALUE = 4;
    public static final int LAUNCH_STAGE_UNSPECIFIED_VALUE = 0;
    private static final Internal.EnumLiteMap<LaunchStage> internalValueMap = null;
    private final int value;

    public static final class LaunchStageVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new LaunchStageVerifier();
        }

        private LaunchStageVerifier() {
        }

        public boolean isInRange(int i11) {
            return LaunchStage.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<LaunchStage>() {
            public LaunchStage findValueByNumber(int i11) {
                return LaunchStage.forNumber(i11);
            }
        };
    }

    private LaunchStage(int i11) {
        this.value = i11;
    }

    public static LaunchStage forNumber(int i11) {
        if (i11 == 0) {
            return LAUNCH_STAGE_UNSPECIFIED;
        }
        if (i11 == 1) {
            return EARLY_ACCESS;
        }
        if (i11 == 2) {
            return ALPHA;
        }
        if (i11 == 3) {
            return BETA;
        }
        if (i11 == 4) {
            return GA;
        }
        if (i11 != 5) {
            return null;
        }
        return DEPRECATED;
    }

    public static Internal.EnumLiteMap<LaunchStage> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return LaunchStageVerifier.INSTANCE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static LaunchStage valueOf(int i11) {
        return forNumber(i11);
    }
}
