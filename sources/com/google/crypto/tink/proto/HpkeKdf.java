package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum HpkeKdf implements Internal.EnumLite {
    KDF_UNKNOWN(0),
    HKDF_SHA256(1),
    HKDF_SHA384(2),
    HKDF_SHA512(3),
    UNRECOGNIZED(-1);
    
    public static final int HKDF_SHA256_VALUE = 1;
    public static final int HKDF_SHA384_VALUE = 2;
    public static final int HKDF_SHA512_VALUE = 3;
    public static final int KDF_UNKNOWN_VALUE = 0;
    private static final Internal.EnumLiteMap<HpkeKdf> internalValueMap = null;
    private final int value;

    public static final class HpkeKdfVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new HpkeKdfVerifier();
        }

        private HpkeKdfVerifier() {
        }

        public boolean isInRange(int i11) {
            return HpkeKdf.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<HpkeKdf>() {
            public HpkeKdf findValueByNumber(int i11) {
                return HpkeKdf.forNumber(i11);
            }
        };
    }

    private HpkeKdf(int i11) {
        this.value = i11;
    }

    public static HpkeKdf forNumber(int i11) {
        if (i11 == 0) {
            return KDF_UNKNOWN;
        }
        if (i11 == 1) {
            return HKDF_SHA256;
        }
        if (i11 == 2) {
            return HKDF_SHA384;
        }
        if (i11 != 3) {
            return null;
        }
        return HKDF_SHA512;
    }

    public static Internal.EnumLiteMap<HpkeKdf> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HpkeKdfVerifier.INSTANCE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static HpkeKdf valueOf(int i11) {
        return forNumber(i11);
    }
}
