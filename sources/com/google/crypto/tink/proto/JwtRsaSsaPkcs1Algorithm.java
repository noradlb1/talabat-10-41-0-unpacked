package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum JwtRsaSsaPkcs1Algorithm implements Internal.EnumLite {
    RS_UNKNOWN(0),
    RS256(1),
    RS384(2),
    RS512(3),
    UNRECOGNIZED(-1);
    
    public static final int RS256_VALUE = 1;
    public static final int RS384_VALUE = 2;
    public static final int RS512_VALUE = 3;
    public static final int RS_UNKNOWN_VALUE = 0;
    private static final Internal.EnumLiteMap<JwtRsaSsaPkcs1Algorithm> internalValueMap = null;
    private final int value;

    public static final class JwtRsaSsaPkcs1AlgorithmVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new JwtRsaSsaPkcs1AlgorithmVerifier();
        }

        private JwtRsaSsaPkcs1AlgorithmVerifier() {
        }

        public boolean isInRange(int i11) {
            return JwtRsaSsaPkcs1Algorithm.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<JwtRsaSsaPkcs1Algorithm>() {
            public JwtRsaSsaPkcs1Algorithm findValueByNumber(int i11) {
                return JwtRsaSsaPkcs1Algorithm.forNumber(i11);
            }
        };
    }

    private JwtRsaSsaPkcs1Algorithm(int i11) {
        this.value = i11;
    }

    public static JwtRsaSsaPkcs1Algorithm forNumber(int i11) {
        if (i11 == 0) {
            return RS_UNKNOWN;
        }
        if (i11 == 1) {
            return RS256;
        }
        if (i11 == 2) {
            return RS384;
        }
        if (i11 != 3) {
            return null;
        }
        return RS512;
    }

    public static Internal.EnumLiteMap<JwtRsaSsaPkcs1Algorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return JwtRsaSsaPkcs1AlgorithmVerifier.INSTANCE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static JwtRsaSsaPkcs1Algorithm valueOf(int i11) {
        return forNumber(i11);
    }
}
