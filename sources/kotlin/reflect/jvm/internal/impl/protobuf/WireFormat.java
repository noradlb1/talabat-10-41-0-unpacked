package kotlin.reflect.jvm.internal.impl.protobuf;

public final class WireFormat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f24777a = b(1, 3);

    /* renamed from: b  reason: collision with root package name */
    public static final int f24778b = b(1, 4);

    /* renamed from: c  reason: collision with root package name */
    public static final int f24779c = b(2, 0);

    /* renamed from: d  reason: collision with root package name */
    public static final int f24780d = b(3, 2);

    public enum FieldType {
        DOUBLE(JavaType.DOUBLE, 1),
        FLOAT(JavaType.FLOAT, 5),
        INT64(r5, 0),
        UINT64(r5, 0),
        INT32(r11, 0),
        FIXED64(r5, 1),
        FIXED32(r11, 5),
        BOOL(JavaType.BOOLEAN, 0),
        STRING(JavaType.STRING, 2) {
            public boolean isPackable() {
                return false;
            }
        },
        GROUP(r13, 3) {
            public boolean isPackable() {
                return false;
            }
        },
        MESSAGE(r13, 2) {
            public boolean isPackable() {
                return false;
            }
        },
        BYTES(JavaType.BYTE_STRING, 2) {
            public boolean isPackable() {
                return false;
            }
        },
        UINT32(r11, 0),
        ENUM(JavaType.ENUM, 0),
        SFIXED32(r11, 5),
        SFIXED64(r5, 1),
        SINT32(r11, 0),
        SINT64(r5, 0);
        
        private final JavaType javaType;
        private final int wireType;

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }

        private FieldType(JavaType javaType2, int i11) {
            this.javaType = javaType2;
            this.wireType = i11;
        }
    }

    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.EMPTY),
        ENUM((String) null),
        MESSAGE((String) null);
        
        private final Object defaultDefault;

        private JavaType(Object obj) {
            this.defaultDefault = obj;
        }
    }

    public static int a(int i11) {
        return i11 & 7;
    }

    public static int b(int i11, int i12) {
        return (i11 << 3) | i12;
    }

    public static int getTagFieldNumber(int i11) {
        return i11 >>> 3;
    }
}
