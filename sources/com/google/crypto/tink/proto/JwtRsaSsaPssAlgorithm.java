package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum JwtRsaSsaPssAlgorithm implements Internal.EnumLite {
    PS_UNKNOWN(0),
    PS256(1),
    PS384(2),
    PS512(3),
    UNRECOGNIZED(-1);
    
    public static final int PS256_VALUE = 1;
    public static final int PS384_VALUE = 2;
    public static final int PS512_VALUE = 3;
    public static final int PS_UNKNOWN_VALUE = 0;
    private static final Internal.EnumLiteMap<JwtRsaSsaPssAlgorithm> internalValueMap = null;
    private final int value;

    public static final class JwtRsaSsaPssAlgorithmVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new JwtRsaSsaPssAlgorithmVerifier();
        }

        private JwtRsaSsaPssAlgorithmVerifier() {
        }

        public boolean isInRange(int i11) {
            return JwtRsaSsaPssAlgorithm.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<JwtRsaSsaPssAlgorithm>() {
            public JwtRsaSsaPssAlgorithm findValueByNumber(int i11) {
                return JwtRsaSsaPssAlgorithm.forNumber(i11);
            }
        };
    }

    private JwtRsaSsaPssAlgorithm(int i11) {
        this.value = i11;
    }

    public static JwtRsaSsaPssAlgorithm forNumber(int i11) {
        if (i11 == 0) {
            return PS_UNKNOWN;
        }
        if (i11 == 1) {
            return PS256;
        }
        if (i11 == 2) {
            return PS384;
        }
        if (i11 != 3) {
            return null;
        }
        return PS512;
    }

    public static Internal.EnumLiteMap<JwtRsaSsaPssAlgorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return JwtRsaSsaPssAlgorithmVerifier.INSTANCE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static JwtRsaSsaPssAlgorithm valueOf(int i11) {
        return forNumber(i11);
    }
}
