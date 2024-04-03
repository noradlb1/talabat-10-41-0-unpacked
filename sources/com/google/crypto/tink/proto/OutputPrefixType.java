package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum OutputPrefixType implements Internal.EnumLite {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);
    
    public static final int CRUNCHY_VALUE = 4;
    public static final int LEGACY_VALUE = 2;
    public static final int RAW_VALUE = 3;
    public static final int TINK_VALUE = 1;
    public static final int UNKNOWN_PREFIX_VALUE = 0;
    private static final Internal.EnumLiteMap<OutputPrefixType> internalValueMap = null;
    private final int value;

    public static final class OutputPrefixTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new OutputPrefixTypeVerifier();
        }

        private OutputPrefixTypeVerifier() {
        }

        public boolean isInRange(int i11) {
            return OutputPrefixType.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<OutputPrefixType>() {
            public OutputPrefixType findValueByNumber(int i11) {
                return OutputPrefixType.forNumber(i11);
            }
        };
    }

    private OutputPrefixType(int i11) {
        this.value = i11;
    }

    public static OutputPrefixType forNumber(int i11) {
        if (i11 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i11 == 1) {
            return TINK;
        }
        if (i11 == 2) {
            return LEGACY;
        }
        if (i11 == 3) {
            return RAW;
        }
        if (i11 != 4) {
            return null;
        }
        return CRUNCHY;
    }

    public static Internal.EnumLiteMap<OutputPrefixType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return OutputPrefixTypeVerifier.INSTANCE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static OutputPrefixType valueOf(int i11) {
        return forNumber(i11);
    }
}
