package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public enum FieldType {
    DOUBLE(0, r13, r14),
    FLOAT(1, r11, r1),
    INT64(2, r11, r12),
    UINT64(3, r11, r12),
    INT32(4, r11, r21),
    FIXED64(5, r11, r3),
    FIXED32(6, r11, r21),
    BOOL(7, r11, r25),
    STRING(8, r11, r27),
    MESSAGE(9, r11, r29),
    BYTES(10, r11, r31),
    UINT32(11, r11, r21),
    ENUM(12, r11, r34),
    SFIXED32(13, r11, r21),
    SFIXED64(14, r11, r3),
    SINT32(15, r11, r21),
    SINT64(16, r11, r3),
    GROUP(17, r11, r29),
    DOUBLE_LIST(18, r40, r12),
    FLOAT_LIST(19, r19, r1),
    INT64_LIST(20, r19, r20),
    UINT64_LIST(21, r19, r20),
    INT32_LIST(22, r19, r21),
    FIXED64_LIST(23, r19, r3),
    FIXED32_LIST(24, r19, r21),
    BOOL_LIST(25, r19, r25),
    STRING_LIST(26, r19, r27),
    MESSAGE_LIST(27, r19, r29),
    BYTES_LIST(28, r19, r31),
    UINT32_LIST(29, r19, r21),
    ENUM_LIST(30, r19, r34),
    SFIXED32_LIST(31, r19, r21),
    SFIXED64_LIST(32, r19, r3),
    SINT32_LIST(33, r19, r21),
    SINT64_LIST(34, r19, r3),
    DOUBLE_LIST_PACKED(35, r56, r12),
    FLOAT_LIST_PACKED(36, r19, r1),
    INT64_LIST_PACKED(37, r19, r20),
    UINT64_LIST_PACKED(38, r19, r20),
    INT32_LIST_PACKED(39, r19, r21),
    FIXED64_LIST_PACKED(40, r19, r3),
    FIXED32_LIST_PACKED(41, r19, r21),
    BOOL_LIST_PACKED(42, r19, r25),
    UINT32_LIST_PACKED(43, r19, r21),
    ENUM_LIST_PACKED(44, r19, r34),
    SFIXED32_LIST_PACKED(45, r19, r21),
    SFIXED64_LIST_PACKED(46, r19, r3),
    SINT32_LIST_PACKED(47, r19, r21),
    SINT64_LIST_PACKED(48, r19, r3),
    GROUP_LIST(49, r40, r29),
    MAP(50, Collection.MAP, JavaType.VOID);
    
    private static final Type[] EMPTY_TYPES = null;
    private static final FieldType[] VALUES = null;
    private final Collection collection;
    private final Class<?> elementType;

    /* renamed from: id  reason: collision with root package name */
    private final int f47303id;
    private final JavaType javaType;
    private final boolean primitiveScalar;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.FieldType$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$FieldType$Collection = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.google.crypto.tink.shaded.protobuf.JavaType[] r0 = com.google.crypto.tink.shaded.protobuf.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$JavaType = r0
                r1 = 1
                com.google.crypto.tink.shaded.protobuf.JavaType r2 = com.google.crypto.tink.shaded.protobuf.JavaType.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$google$protobuf$JavaType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.JavaType r3 = com.google.crypto.tink.shaded.protobuf.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$google$protobuf$JavaType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.JavaType r4 = com.google.crypto.tink.shaded.protobuf.JavaType.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.google.crypto.tink.shaded.protobuf.FieldType$Collection[] r3 = com.google.crypto.tink.shaded.protobuf.FieldType.Collection.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$google$protobuf$FieldType$Collection = r3
                com.google.crypto.tink.shaded.protobuf.FieldType$Collection r4 = com.google.crypto.tink.shaded.protobuf.FieldType.Collection.MAP     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$com$google$protobuf$FieldType$Collection     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.google.crypto.tink.shaded.protobuf.FieldType$Collection r3 = com.google.crypto.tink.shaded.protobuf.FieldType.Collection.VECTOR     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$google$protobuf$FieldType$Collection     // Catch:{ NoSuchFieldError -> 0x004d }
                com.google.crypto.tink.shaded.protobuf.FieldType$Collection r1 = com.google.crypto.tink.shaded.protobuf.FieldType.Collection.SCALAR     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.FieldType.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Collection {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);
        
        private final boolean isList;

        private Collection(boolean z11) {
            this.isList = z11;
        }

        public boolean isList() {
            return this.isList;
        }
    }

    /* access modifiers changed from: public */
    static {
        int i11;
        EMPTY_TYPES = new Type[0];
        FieldType[] values = values();
        VALUES = new FieldType[values.length];
        for (FieldType fieldType : values) {
            VALUES[fieldType.f47303id] = fieldType;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r1 = com.google.crypto.tink.shaded.protobuf.FieldType.AnonymousClass1.$SwitchMap$com$google$protobuf$JavaType[r5.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private FieldType(int r3, com.google.crypto.tink.shaded.protobuf.FieldType.Collection r4, com.google.crypto.tink.shaded.protobuf.JavaType r5) {
        /*
            r0 = this;
            r0.<init>(r1, r2)
            r0.f47303id = r3
            r0.collection = r4
            r0.javaType = r5
            int[] r1 = com.google.crypto.tink.shaded.protobuf.FieldType.AnonymousClass1.$SwitchMap$com$google$protobuf$FieldType$Collection
            int r2 = r4.ordinal()
            r1 = r1[r2]
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L_0x0022
            if (r1 == r2) goto L_0x001b
            r1 = 0
            r0.elementType = r1
            goto L_0x0028
        L_0x001b:
            java.lang.Class r1 = r5.getBoxedType()
            r0.elementType = r1
            goto L_0x0028
        L_0x0022:
            java.lang.Class r1 = r5.getBoxedType()
            r0.elementType = r1
        L_0x0028:
            com.google.crypto.tink.shaded.protobuf.FieldType$Collection r1 = com.google.crypto.tink.shaded.protobuf.FieldType.Collection.SCALAR
            if (r4 != r1) goto L_0x003c
            int[] r1 = com.google.crypto.tink.shaded.protobuf.FieldType.AnonymousClass1.$SwitchMap$com$google$protobuf$JavaType
            int r4 = r5.ordinal()
            r1 = r1[r4]
            if (r1 == r3) goto L_0x003c
            if (r1 == r2) goto L_0x003c
            r2 = 3
            if (r1 == r2) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r3 = 0
        L_0x003d:
            r0.primitiveScalar = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.FieldType.<init>(java.lang.String, int, int, com.google.crypto.tink.shaded.protobuf.FieldType$Collection, com.google.crypto.tink.shaded.protobuf.JavaType):void");
    }

    public static FieldType forId(int i11) {
        if (i11 < 0) {
            return null;
        }
        FieldType[] fieldTypeArr = VALUES;
        if (i11 >= fieldTypeArr.length) {
            return null;
        }
        return fieldTypeArr[i11];
    }

    private static Type getGenericSuperList(Class<?> cls) {
        Type[] genericInterfaces = cls.getGenericInterfaces();
        int length = genericInterfaces.length;
        int i11 = 0;
        while (true) {
            Class<List> cls2 = List.class;
            if (i11 < length) {
                Type type = genericInterfaces[i11];
                if ((type instanceof ParameterizedType) && cls2.isAssignableFrom((Class) ((ParameterizedType) type).getRawType())) {
                    return type;
                }
                i11++;
            } else {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (!(genericSuperclass instanceof ParameterizedType) || !cls2.isAssignableFrom((Class) ((ParameterizedType) genericSuperclass).getRawType())) {
                    return null;
                }
                return genericSuperclass;
            }
        }
    }

    private static Type getListParameter(Class<?> cls, Type[] typeArr) {
        Class<? super Object> cls2;
        boolean z11;
        while (true) {
            Class<List> cls3 = List.class;
            int i11 = 0;
            Class<? super Object> cls4 = cls;
            if (cls4 != cls3) {
                Type genericSuperList = getGenericSuperList(cls4);
                if (!(genericSuperList instanceof ParameterizedType)) {
                    typeArr = EMPTY_TYPES;
                    Class<? super Object>[] interfaces = cls4.getInterfaces();
                    int length = interfaces.length;
                    while (true) {
                        if (i11 >= length) {
                            cls2 = cls4.getSuperclass();
                            break;
                        }
                        Class<? super Object> cls5 = interfaces[i11];
                        if (cls3.isAssignableFrom(cls5)) {
                            cls2 = cls5;
                            break;
                        }
                        i11++;
                    }
                } else {
                    ParameterizedType parameterizedType = (ParameterizedType) genericSuperList;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i12 = 0; i12 < actualTypeArguments.length; i12++) {
                        Type type = actualTypeArguments[i12];
                        if (type instanceof TypeVariable) {
                            TypeVariable[] typeParameters = cls4.getTypeParameters();
                            if (typeArr.length == typeParameters.length) {
                                int i13 = 0;
                                while (true) {
                                    if (i13 >= typeParameters.length) {
                                        z11 = false;
                                        break;
                                    } else if (type == typeParameters[i13]) {
                                        actualTypeArguments[i12] = typeArr[i13];
                                        z11 = true;
                                        break;
                                    } else {
                                        i13++;
                                    }
                                }
                                if (!z11) {
                                    throw new RuntimeException("Unable to find replacement for " + type);
                                }
                            } else {
                                throw new RuntimeException("Type array mismatch");
                            }
                        }
                    }
                    typeArr = actualTypeArguments;
                    cls2 = (Class) parameterizedType.getRawType();
                }
                cls4 = cls2;
            } else if (typeArr.length == 1) {
                return typeArr[0];
            } else {
                throw new RuntimeException("Unable to identify parameter type for List<T>");
            }
        }
    }

    private boolean isValidForList(Field field) {
        Class<?> type = field.getType();
        if (!this.javaType.getType().isAssignableFrom(type)) {
            return false;
        }
        Type[] typeArr = EMPTY_TYPES;
        if (field.getGenericType() instanceof ParameterizedType) {
            typeArr = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
        }
        Type listParameter = getListParameter(type, typeArr);
        if (!(listParameter instanceof Class)) {
            return true;
        }
        return this.elementType.isAssignableFrom((Class) listParameter);
    }

    public JavaType getJavaType() {
        return this.javaType;
    }

    public int id() {
        return this.f47303id;
    }

    public boolean isList() {
        return this.collection.isList();
    }

    public boolean isMap() {
        return this.collection == Collection.MAP;
    }

    public boolean isPacked() {
        return Collection.PACKED_VECTOR.equals(this.collection);
    }

    public boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }

    public boolean isScalar() {
        return this.collection == Collection.SCALAR;
    }

    public boolean isValidForField(Field field) {
        if (Collection.VECTOR.equals(this.collection)) {
            return isValidForList(field);
        }
        return this.javaType.getType().isAssignableFrom(field.getType());
    }
}
