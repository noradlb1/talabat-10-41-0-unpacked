package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum HashType implements Internal.EnumLite {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    SHA224(5),
    UNRECOGNIZED(-1);
    
    public static final int SHA1_VALUE = 1;
    public static final int SHA224_VALUE = 5;
    public static final int SHA256_VALUE = 3;
    public static final int SHA384_VALUE = 2;
    public static final int SHA512_VALUE = 4;
    public static final int UNKNOWN_HASH_VALUE = 0;
    private static final Internal.EnumLiteMap<HashType> internalValueMap = null;
    private final int value;

    public static final class HashTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new HashTypeVerifier();
        }

        private HashTypeVerifier() {
        }

        public boolean isInRange(int i11) {
            return HashType.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<HashType>() {
            public HashType findValueByNumber(int i11) {
                return HashType.forNumber(i11);
            }
        };
    }

    private HashType(int i11) {
        this.value = i11;
    }

    public static HashType forNumber(int i11) {
        if (i11 == 0) {
            return UNKNOWN_HASH;
        }
        if (i11 == 1) {
            return SHA1;
        }
        if (i11 == 2) {
            return SHA384;
        }
        if (i11 == 3) {
            return SHA256;
        }
        if (i11 == 4) {
            return SHA512;
        }
        if (i11 != 5) {
            return null;
        }
        return SHA224;
    }

    public static Internal.EnumLiteMap<HashType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HashTypeVerifier.INSTANCE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static HashType valueOf(int i11) {
        return forNumber(i11);
    }
}
