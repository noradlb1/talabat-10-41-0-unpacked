package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;

public enum NullValue implements Internal.EnumLite {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);
    
    public static final int NULL_VALUE_VALUE = 0;
    private static final Internal.EnumLiteMap<NullValue> internalValueMap = null;
    private final int value;

    public static final class NullValueVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        public static final Internal.EnumVerifier f35811a = null;

        static {
            f35811a = new NullValueVerifier();
        }

        private NullValueVerifier() {
        }

        public boolean isInRange(int i11) {
            return NullValue.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<NullValue>() {
            public NullValue findValueByNumber(int i11) {
                return NullValue.forNumber(i11);
            }
        };
    }

    private NullValue(int i11) {
        this.value = i11;
    }

    public static NullValue forNumber(int i11) {
        if (i11 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return NullValueVerifier.f35811a;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static NullValue valueOf(int i11) {
        return forNumber(i11);
    }
}
