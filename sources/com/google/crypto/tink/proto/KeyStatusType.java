package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum KeyStatusType implements Internal.EnumLite {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    
    public static final int DESTROYED_VALUE = 3;
    public static final int DISABLED_VALUE = 2;
    public static final int ENABLED_VALUE = 1;
    public static final int UNKNOWN_STATUS_VALUE = 0;
    private static final Internal.EnumLiteMap<KeyStatusType> internalValueMap = null;
    private final int value;

    public static final class KeyStatusTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new KeyStatusTypeVerifier();
        }

        private KeyStatusTypeVerifier() {
        }

        public boolean isInRange(int i11) {
            return KeyStatusType.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<KeyStatusType>() {
            public KeyStatusType findValueByNumber(int i11) {
                return KeyStatusType.forNumber(i11);
            }
        };
    }

    private KeyStatusType(int i11) {
        this.value = i11;
    }

    public static KeyStatusType forNumber(int i11) {
        if (i11 == 0) {
            return UNKNOWN_STATUS;
        }
        if (i11 == 1) {
            return ENABLED;
        }
        if (i11 == 2) {
            return DISABLED;
        }
        if (i11 != 3) {
            return null;
        }
        return DESTROYED;
    }

    public static Internal.EnumLiteMap<KeyStatusType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return KeyStatusTypeVerifier.INSTANCE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static KeyStatusType valueOf(int i11) {
        return forNumber(i11);
    }
}
