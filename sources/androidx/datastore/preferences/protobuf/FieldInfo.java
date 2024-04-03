package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.lang.reflect.Field;

final class FieldInfo implements Comparable<FieldInfo> {
    private final Field cachedSizeField;
    private final boolean enforceUtf8;
    private final Internal.EnumVerifier enumVerifier;
    private final Field field;
    private final int fieldNumber;
    private final Object mapDefaultEntry;
    private final Class<?> messageClass;
    private final OneofInfo oneof;
    private final Class<?> oneofStoredType;
    private final Field presenceField;
    private final int presenceMask;
    private final boolean required;
    private final FieldType type;

    /* renamed from: androidx.datastore.preferences.protobuf.FieldInfo$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35774a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.datastore.preferences.protobuf.FieldType[] r0 = androidx.datastore.preferences.protobuf.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f35774a = r0
                androidx.datastore.preferences.protobuf.FieldType r1 = androidx.datastore.preferences.protobuf.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35774a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.FieldType r1 = androidx.datastore.preferences.protobuf.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f35774a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.FieldType r1 = androidx.datastore.preferences.protobuf.FieldType.MESSAGE_LIST     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f35774a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.FieldType r1 = androidx.datastore.preferences.protobuf.FieldType.GROUP_LIST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.FieldInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder {
        private Field cachedSizeField;
        private boolean enforceUtf8;
        private Internal.EnumVerifier enumVerifier;
        private Field field;
        private int fieldNumber;
        private Object mapDefaultEntry;
        private OneofInfo oneof;
        private Class<?> oneofStoredType;
        private Field presenceField;
        private int presenceMask;
        private boolean required;
        private FieldType type;

        private Builder() {
        }

        public /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public FieldInfo build() {
            OneofInfo oneofInfo = this.oneof;
            if (oneofInfo != null) {
                return FieldInfo.forOneofMemberField(this.fieldNumber, this.type, oneofInfo, this.oneofStoredType, this.enforceUtf8, this.enumVerifier);
            }
            Object obj = this.mapDefaultEntry;
            if (obj != null) {
                return FieldInfo.forMapField(this.field, this.fieldNumber, obj, this.enumVerifier);
            }
            Field field2 = this.presenceField;
            if (field2 == null) {
                Internal.EnumVerifier enumVerifier2 = this.enumVerifier;
                if (enumVerifier2 != null) {
                    Field field3 = this.cachedSizeField;
                    if (field3 == null) {
                        return FieldInfo.forFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, enumVerifier2);
                    }
                    return FieldInfo.forPackedFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, enumVerifier2, field3);
                }
                Field field4 = this.cachedSizeField;
                if (field4 == null) {
                    return FieldInfo.forField(this.field, this.fieldNumber, this.type, this.enforceUtf8);
                }
                return FieldInfo.forPackedField(this.field, this.fieldNumber, this.type, field4);
            } else if (this.required) {
                return FieldInfo.forProto2RequiredField(this.field, this.fieldNumber, this.type, field2, this.presenceMask, this.enforceUtf8, this.enumVerifier);
            } else {
                return FieldInfo.forProto2OptionalField(this.field, this.fieldNumber, this.type, field2, this.presenceMask, this.enforceUtf8, this.enumVerifier);
            }
        }

        public Builder withCachedSizeField(Field field2) {
            this.cachedSizeField = field2;
            return this;
        }

        public Builder withEnforceUtf8(boolean z11) {
            this.enforceUtf8 = z11;
            return this;
        }

        public Builder withEnumVerifier(Internal.EnumVerifier enumVerifier2) {
            this.enumVerifier = enumVerifier2;
            return this;
        }

        public Builder withField(Field field2) {
            if (this.oneof == null) {
                this.field = field2;
                return this;
            }
            throw new IllegalStateException("Cannot set field when building a oneof.");
        }

        public Builder withFieldNumber(int i11) {
            this.fieldNumber = i11;
            return this;
        }

        public Builder withMapDefaultEntry(Object obj) {
            this.mapDefaultEntry = obj;
            return this;
        }

        public Builder withOneof(OneofInfo oneofInfo, Class<?> cls) {
            if (this.field == null && this.presenceField == null) {
                this.oneof = oneofInfo;
                this.oneofStoredType = cls;
                return this;
            }
            throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
        }

        public Builder withPresence(Field field2, int i11) {
            this.presenceField = (Field) Internal.b(field2, "presenceField");
            this.presenceMask = i11;
            return this;
        }

        public Builder withRequired(boolean z11) {
            this.required = z11;
            return this;
        }

        public Builder withType(FieldType fieldType) {
            this.type = fieldType;
            return this;
        }
    }

    private FieldInfo(Field field2, int i11, FieldType fieldType, Class<?> cls, Field field3, int i12, boolean z11, boolean z12, OneofInfo oneofInfo, Class<?> cls2, Object obj, Internal.EnumVerifier enumVerifier2, Field field4) {
        this.field = field2;
        this.type = fieldType;
        this.messageClass = cls;
        this.fieldNumber = i11;
        this.presenceField = field3;
        this.presenceMask = i12;
        this.required = z11;
        this.enforceUtf8 = z12;
        this.oneof = oneofInfo;
        this.oneofStoredType = cls2;
        this.mapDefaultEntry = obj;
        this.enumVerifier = enumVerifier2;
        this.cachedSizeField = field4;
    }

    private static void checkFieldNumber(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i11);
        }
    }

    public static FieldInfo forField(Field field2, int i11, FieldType fieldType, boolean z11) {
        FieldType fieldType2 = fieldType;
        checkFieldNumber(i11);
        Field field3 = field2;
        Internal.b(field2, "field");
        Internal.b(fieldType2, "fieldType");
        if (fieldType2 != FieldType.MESSAGE_LIST && fieldType2 != FieldType.GROUP_LIST) {
            return new FieldInfo(field2, i11, fieldType, (Class<?>) null, (Field) null, 0, false, z11, (OneofInfo) null, (Class<?>) null, (Object) null, (Internal.EnumVerifier) null, (Field) null);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo forFieldWithEnumVerifier(Field field2, int i11, FieldType fieldType, Internal.EnumVerifier enumVerifier2) {
        checkFieldNumber(i11);
        Internal.b(field2, "field");
        return new FieldInfo(field2, i11, fieldType, (Class<?>) null, (Field) null, 0, false, false, (OneofInfo) null, (Class<?>) null, (Object) null, enumVerifier2, (Field) null);
    }

    public static FieldInfo forMapField(Field field2, int i11, Object obj, Internal.EnumVerifier enumVerifier2) {
        Object obj2 = obj;
        Internal.b(obj2, "mapDefaultEntry");
        checkFieldNumber(i11);
        Internal.b(field2, "field");
        return new FieldInfo(field2, i11, FieldType.MAP, (Class<?>) null, (Field) null, 0, false, true, (OneofInfo) null, (Class<?>) null, obj2, enumVerifier2, (Field) null);
    }

    public static FieldInfo forOneofMemberField(int i11, FieldType fieldType, OneofInfo oneofInfo, Class<?> cls, boolean z11, Internal.EnumVerifier enumVerifier2) {
        FieldType fieldType2 = fieldType;
        checkFieldNumber(i11);
        Internal.b(fieldType2, "fieldType");
        Internal.b(oneofInfo, "oneof");
        Internal.b(cls, "oneofStoredType");
        if (fieldType.isScalar()) {
            return new FieldInfo((Field) null, i11, fieldType, (Class<?>) null, (Field) null, 0, false, z11, oneofInfo, cls, (Object) null, enumVerifier2, (Field) null);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Oneof is only supported for scalar fields. Field ");
        int i12 = i11;
        sb2.append(i11);
        sb2.append(" is of type ");
        sb2.append(fieldType2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static FieldInfo forPackedField(Field field2, int i11, FieldType fieldType, Field field3) {
        FieldType fieldType2 = fieldType;
        checkFieldNumber(i11);
        Field field4 = field2;
        Internal.b(field2, "field");
        Internal.b(fieldType2, "fieldType");
        if (fieldType2 != FieldType.MESSAGE_LIST && fieldType2 != FieldType.GROUP_LIST) {
            return new FieldInfo(field2, i11, fieldType, (Class<?>) null, (Field) null, 0, false, false, (OneofInfo) null, (Class<?>) null, (Object) null, (Internal.EnumVerifier) null, field3);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo forPackedFieldWithEnumVerifier(Field field2, int i11, FieldType fieldType, Internal.EnumVerifier enumVerifier2, Field field3) {
        checkFieldNumber(i11);
        Internal.b(field2, "field");
        return new FieldInfo(field2, i11, fieldType, (Class<?>) null, (Field) null, 0, false, false, (OneofInfo) null, (Class<?>) null, (Object) null, enumVerifier2, field3);
    }

    public static FieldInfo forProto2OptionalField(Field field2, int i11, FieldType fieldType, Field field3, int i12, boolean z11, Internal.EnumVerifier enumVerifier2) {
        Field field4 = field3;
        checkFieldNumber(i11);
        Field field5 = field2;
        Internal.b(field2, "field");
        Internal.b(fieldType, "fieldType");
        Internal.b(field4, "presenceField");
        if (field4 == null || isExactlyOneBitSet(i12)) {
            int i13 = i12;
            return new FieldInfo(field2, i11, fieldType, (Class<?>) null, field3, i12, false, z11, (OneofInfo) null, (Class<?>) null, (Object) null, enumVerifier2, (Field) null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i12);
    }

    public static FieldInfo forProto2RequiredField(Field field2, int i11, FieldType fieldType, Field field3, int i12, boolean z11, Internal.EnumVerifier enumVerifier2) {
        Field field4 = field3;
        checkFieldNumber(i11);
        Field field5 = field2;
        Internal.b(field2, "field");
        Internal.b(fieldType, "fieldType");
        Internal.b(field4, "presenceField");
        if (field4 == null || isExactlyOneBitSet(i12)) {
            int i13 = i12;
            return new FieldInfo(field2, i11, fieldType, (Class<?>) null, field3, i12, true, z11, (OneofInfo) null, (Class<?>) null, (Object) null, enumVerifier2, (Field) null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i12);
    }

    public static FieldInfo forRepeatedMessageField(Field field2, int i11, FieldType fieldType, Class<?> cls) {
        checkFieldNumber(i11);
        Internal.b(field2, "field");
        FieldType fieldType2 = fieldType;
        Internal.b(fieldType2, "fieldType");
        Class<?> cls2 = cls;
        Internal.b(cls2, "messageClass");
        return new FieldInfo(field2, i11, fieldType2, cls2, (Field) null, 0, false, false, (OneofInfo) null, (Class<?>) null, (Object) null, (Internal.EnumVerifier) null, (Field) null);
    }

    private static boolean isExactlyOneBitSet(int i11) {
        return i11 != 0 && (i11 & (i11 + -1)) == 0;
    }

    public static Builder newBuilder() {
        return new Builder((AnonymousClass1) null);
    }

    public Field getCachedSizeField() {
        return this.cachedSizeField;
    }

    public Internal.EnumVerifier getEnumVerifier() {
        return this.enumVerifier;
    }

    public Field getField() {
        return this.field;
    }

    public int getFieldNumber() {
        return this.fieldNumber;
    }

    public Class<?> getListElementType() {
        return this.messageClass;
    }

    public Object getMapDefaultEntry() {
        return this.mapDefaultEntry;
    }

    public Class<?> getMessageFieldClass() {
        int i11 = AnonymousClass1.f35774a[this.type.ordinal()];
        if (i11 == 1 || i11 == 2) {
            Field field2 = this.field;
            if (field2 != null) {
                return field2.getType();
            }
            return this.oneofStoredType;
        } else if (i11 == 3 || i11 == 4) {
            return this.messageClass;
        } else {
            return null;
        }
    }

    public OneofInfo getOneof() {
        return this.oneof;
    }

    public Class<?> getOneofStoredType() {
        return this.oneofStoredType;
    }

    public Field getPresenceField() {
        return this.presenceField;
    }

    public int getPresenceMask() {
        return this.presenceMask;
    }

    public FieldType getType() {
        return this.type;
    }

    public boolean isEnforceUtf8() {
        return this.enforceUtf8;
    }

    public boolean isRequired() {
        return this.required;
    }

    public int compareTo(FieldInfo fieldInfo) {
        return this.fieldNumber - fieldInfo.fieldNumber;
    }
}
