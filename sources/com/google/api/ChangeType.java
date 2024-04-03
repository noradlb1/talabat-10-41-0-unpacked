package com.google.api;

import com.google.protobuf.Internal;

public enum ChangeType implements Internal.EnumLite {
    CHANGE_TYPE_UNSPECIFIED(0),
    ADDED(1),
    REMOVED(2),
    MODIFIED(3),
    UNRECOGNIZED(-1);
    
    public static final int ADDED_VALUE = 1;
    public static final int CHANGE_TYPE_UNSPECIFIED_VALUE = 0;
    public static final int MODIFIED_VALUE = 3;
    public static final int REMOVED_VALUE = 2;
    private static final Internal.EnumLiteMap<ChangeType> internalValueMap = null;
    private final int value;

    public static final class ChangeTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new ChangeTypeVerifier();
        }

        private ChangeTypeVerifier() {
        }

        public boolean isInRange(int i11) {
            return ChangeType.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<ChangeType>() {
            public ChangeType findValueByNumber(int i11) {
                return ChangeType.forNumber(i11);
            }
        };
    }

    private ChangeType(int i11) {
        this.value = i11;
    }

    public static ChangeType forNumber(int i11) {
        if (i11 == 0) {
            return CHANGE_TYPE_UNSPECIFIED;
        }
        if (i11 == 1) {
            return ADDED;
        }
        if (i11 == 2) {
            return REMOVED;
        }
        if (i11 != 3) {
            return null;
        }
        return MODIFIED;
    }

    public static Internal.EnumLiteMap<ChangeType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ChangeTypeVerifier.INSTANCE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static ChangeType valueOf(int i11) {
        return forNumber(i11);
    }
}
