package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.UShort;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class FlexBuffers {
    /* access modifiers changed from: private */
    public static final ReadBuf EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    public static class Blob extends Sized {

        /* renamed from: e  reason: collision with root package name */
        public static final Blob f35931e = new Blob(FlexBuffers.EMPTY_BB, 1, 1);

        public Blob(ReadBuf readBuf, int i11, int i12) {
            super(readBuf, i11, i12);
        }

        public static Blob empty() {
            return f35931e;
        }

        public ByteBuffer data() {
            ByteBuffer wrap = ByteBuffer.wrap(this.f35932a.data());
            wrap.position(this.f35933b);
            wrap.limit(this.f35933b + size());
            return wrap.asReadOnlyBuffer().slice();
        }

        public byte get(int i11) {
            return this.f35932a.get(this.f35933b + i11);
        }

        public byte[] getBytes() {
            int size = size();
            byte[] bArr = new byte[size];
            for (int i11 = 0; i11 < size; i11++) {
                bArr[i11] = this.f35932a.get(this.f35933b + i11);
            }
            return bArr;
        }

        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        public String toString() {
            return this.f35932a.getString(this.f35933b, size());
        }

        public StringBuilder toString(StringBuilder sb2) {
            sb2.append('\"');
            sb2.append(this.f35932a.getString(this.f35933b, size()));
            sb2.append('\"');
            return sb2;
        }
    }

    public static class FlexBufferException extends RuntimeException {
        public FlexBufferException(String str) {
            super(str);
        }
    }

    public static class Key extends Object {
        /* access modifiers changed from: private */
        public static final Key EMPTY = new Key(FlexBuffers.EMPTY_BB, 0, 0);

        public Key(ReadBuf readBuf, int i11, int i12) {
            super(readBuf, i11, i12);
        }

        public static Key empty() {
            return EMPTY;
        }

        public int b(byte[] bArr) {
            byte b11;
            byte b12;
            int i11 = this.f35933b;
            int i12 = 0;
            do {
                b11 = this.f35932a.get(i11);
                b12 = bArr[i12];
                if (b11 == 0) {
                    return b11 - b12;
                }
                i11++;
                i12++;
                if (i12 == bArr.length) {
                    return b11 - b12;
                }
            } while (b11 == b12);
            return b11 - b12;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (key.f35933b == this.f35933b && key.f35934c == this.f35934c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f35933b ^ this.f35934c;
        }

        public StringBuilder toString(StringBuilder sb2) {
            sb2.append(toString());
            return sb2;
        }

        public String toString() {
            int i11 = this.f35933b;
            while (this.f35932a.get(i11) != 0) {
                i11++;
            }
            int i12 = this.f35933b;
            return this.f35932a.getString(i12, i11 - i12);
        }
    }

    public static class KeyVector {
        private final TypedVector vec;

        public KeyVector(TypedVector typedVector) {
            this.vec = typedVector;
        }

        public Key get(int i11) {
            if (i11 >= size()) {
                return Key.EMPTY;
            }
            TypedVector typedVector = this.vec;
            TypedVector typedVector2 = this.vec;
            ReadBuf readBuf = typedVector2.f35932a;
            return new Key(readBuf, FlexBuffers.indirect(readBuf, typedVector.f35933b + (i11 * typedVector.f35934c), typedVector2.f35934c), 1);
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (int i11 = 0; i11 < this.vec.size(); i11++) {
                this.vec.get(i11).b(sb2);
                if (i11 != this.vec.size() - 1) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    public static class Map extends Vector {
        private static final Map EMPTY_MAP = new Map(FlexBuffers.EMPTY_BB, 1, 1);

        public Map(ReadBuf readBuf, int i11, int i12) {
            super(readBuf, i11, i12);
        }

        private int binarySearch(KeyVector keyVector, byte[] bArr) {
            int size = keyVector.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) >>> 1;
                int b11 = keyVector.get(i12).b(bArr);
                if (b11 < 0) {
                    i11 = i12 + 1;
                } else if (b11 <= 0) {
                    return i12;
                } else {
                    size = i12 - 1;
                }
            }
            return -(i11 + 1);
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(String str) {
            return get(str.getBytes(StandardCharsets.UTF_8));
        }

        public KeyVector keys() {
            int i11 = this.f35933b - (this.f35934c * 3);
            ReadBuf readBuf = this.f35932a;
            int c11 = FlexBuffers.indirect(readBuf, i11, this.f35934c);
            ReadBuf readBuf2 = this.f35932a;
            int i12 = this.f35934c;
            return new KeyVector(new TypedVector(readBuf, c11, FlexBuffers.readInt(readBuf2, i11 + i12, i12), 4));
        }

        public StringBuilder toString(StringBuilder sb2) {
            sb2.append("{ ");
            KeyVector keys = keys();
            int size = size();
            Vector values = values();
            for (int i11 = 0; i11 < size; i11++) {
                sb2.append('\"');
                sb2.append(keys.get(i11).toString());
                sb2.append("\" : ");
                sb2.append(values.get(i11).toString());
                if (i11 != size - 1) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
            }
            sb2.append(" }");
            return sb2;
        }

        public Vector values() {
            return new Vector(this.f35932a, this.f35933b, this.f35934c);
        }

        public Reference get(byte[] bArr) {
            KeyVector keys = keys();
            int size = keys.size();
            int binarySearch = binarySearch(keys, bArr);
            if (binarySearch < 0 || binarySearch >= size) {
                return Reference.NULL_REFERENCE;
            }
            return get(binarySearch);
        }
    }

    public static abstract class Object {

        /* renamed from: a  reason: collision with root package name */
        public ReadBuf f35932a;

        /* renamed from: b  reason: collision with root package name */
        public int f35933b;

        /* renamed from: c  reason: collision with root package name */
        public int f35934c;

        public Object(ReadBuf readBuf, int i11, int i12) {
            this.f35932a = readBuf;
            this.f35933b = i11;
            this.f35934c = i12;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder sb2);
    }

    public static class Reference {
        /* access modifiers changed from: private */
        public static final Reference NULL_REFERENCE = new Reference(FlexBuffers.EMPTY_BB, 0, 1, 0);

        /* renamed from: bb  reason: collision with root package name */
        private ReadBuf f35935bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        public Reference(ReadBuf readBuf, int i11, int i12, int i13) {
            this(readBuf, i11, i12, 1 << (i13 & 3), i13 >> 2);
        }

        public Blob asBlob() {
            if (!isBlob() && !isString()) {
                return Blob.empty();
            }
            ReadBuf readBuf = this.f35935bb;
            return new Blob(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public boolean asBoolean() {
            if (isBoolean()) {
                if (this.f35935bb.get(this.end) != 0) {
                    return true;
                }
                return false;
            } else if (asUInt() != 0) {
                return true;
            } else {
                return false;
            }
        }

        public double asFloat() {
            int i11 = this.type;
            if (i11 == 3) {
                return FlexBuffers.readDouble(this.f35935bb, this.end, this.parentWidth);
            }
            if (i11 == 1) {
                return (double) FlexBuffers.readInt(this.f35935bb, this.end, this.parentWidth);
            }
            if (i11 != 2) {
                if (i11 == 5) {
                    return Double.parseDouble(asString());
                }
                if (i11 == 6) {
                    ReadBuf readBuf = this.f35935bb;
                    return (double) FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
                } else if (i11 == 7) {
                    ReadBuf readBuf2 = this.f35935bb;
                    return (double) FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
                } else if (i11 == 8) {
                    ReadBuf readBuf3 = this.f35935bb;
                    return FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
                } else if (i11 == 10) {
                    return (double) asVector().size();
                } else {
                    if (i11 != 26) {
                        return 0.0d;
                    }
                }
            }
            return (double) FlexBuffers.readUInt(this.f35935bb, this.end, this.parentWidth);
        }

        public int asInt() {
            int i11 = this.type;
            if (i11 == 1) {
                return FlexBuffers.readInt(this.f35935bb, this.end, this.parentWidth);
            }
            if (i11 == 2) {
                return (int) FlexBuffers.readUInt(this.f35935bb, this.end, this.parentWidth);
            }
            if (i11 == 3) {
                return (int) FlexBuffers.readDouble(this.f35935bb, this.end, this.parentWidth);
            }
            if (i11 == 5) {
                return Integer.parseInt(asString());
            }
            if (i11 == 6) {
                ReadBuf readBuf = this.f35935bb;
                return FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            } else if (i11 == 7) {
                ReadBuf readBuf2 = this.f35935bb;
                return (int) FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            } else if (i11 == 8) {
                ReadBuf readBuf3 = this.f35935bb;
                return (int) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            } else if (i11 == 10) {
                return asVector().size();
            } else {
                if (i11 != 26) {
                    return 0;
                }
                return FlexBuffers.readInt(this.f35935bb, this.end, this.parentWidth);
            }
        }

        public Key asKey() {
            if (!isKey()) {
                return Key.empty();
            }
            ReadBuf readBuf = this.f35935bb;
            return new Key(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public long asLong() {
            int i11 = this.type;
            if (i11 == 1) {
                return FlexBuffers.readLong(this.f35935bb, this.end, this.parentWidth);
            }
            if (i11 == 2) {
                return FlexBuffers.readUInt(this.f35935bb, this.end, this.parentWidth);
            }
            if (i11 == 3) {
                return (long) FlexBuffers.readDouble(this.f35935bb, this.end, this.parentWidth);
            }
            if (i11 == 5) {
                try {
                    return Long.parseLong(asString());
                } catch (NumberFormatException unused) {
                    return 0;
                }
            } else if (i11 == 6) {
                ReadBuf readBuf = this.f35935bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            } else if (i11 == 7) {
                ReadBuf readBuf2 = this.f35935bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            } else if (i11 == 8) {
                ReadBuf readBuf3 = this.f35935bb;
                return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            } else if (i11 == 10) {
                return (long) asVector().size();
            } else {
                if (i11 != 26) {
                    return 0;
                }
                return (long) FlexBuffers.readInt(this.f35935bb, this.end, this.parentWidth);
            }
        }

        public Map asMap() {
            if (!isMap()) {
                return Map.empty();
            }
            ReadBuf readBuf = this.f35935bb;
            return new Map(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public String asString() {
            if (isString()) {
                int c11 = FlexBuffers.indirect(this.f35935bb, this.end, this.parentWidth);
                ReadBuf readBuf = this.f35935bb;
                int i11 = this.byteWidth;
                return this.f35935bb.getString(c11, (int) FlexBuffers.readUInt(readBuf, c11 - i11, i11));
            } else if (!isKey()) {
                return "";
            } else {
                int c12 = FlexBuffers.indirect(this.f35935bb, this.end, this.byteWidth);
                int i12 = c12;
                while (this.f35935bb.get(i12) != 0) {
                    i12++;
                }
                return this.f35935bb.getString(c12, i12 - c12);
            }
        }

        public long asUInt() {
            int i11 = this.type;
            if (i11 == 2) {
                return FlexBuffers.readUInt(this.f35935bb, this.end, this.parentWidth);
            }
            if (i11 == 1) {
                return FlexBuffers.readLong(this.f35935bb, this.end, this.parentWidth);
            }
            if (i11 == 3) {
                return (long) FlexBuffers.readDouble(this.f35935bb, this.end, this.parentWidth);
            }
            if (i11 == 10) {
                return (long) asVector().size();
            }
            if (i11 == 26) {
                return (long) FlexBuffers.readInt(this.f35935bb, this.end, this.parentWidth);
            }
            if (i11 == 5) {
                return Long.parseLong(asString());
            }
            if (i11 == 6) {
                ReadBuf readBuf = this.f35935bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            } else if (i11 == 7) {
                ReadBuf readBuf2 = this.f35935bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
            } else if (i11 != 8) {
                return 0;
            } else {
                ReadBuf readBuf3 = this.f35935bb;
                return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.parentWidth);
            }
        }

        public Vector asVector() {
            if (isVector()) {
                ReadBuf readBuf = this.f35935bb;
                return new Vector(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            int i11 = this.type;
            if (i11 == 15) {
                ReadBuf readBuf2 = this.f35935bb;
                return new TypedVector(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth, 4);
            } else if (!FlexBuffers.h(i11)) {
                return Vector.empty();
            } else {
                ReadBuf readBuf3 = this.f35935bb;
                return new TypedVector(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth, FlexBuffers.k(this.type));
            }
        }

        public StringBuilder b(StringBuilder sb2) {
            int i11 = this.type;
            if (i11 != 36) {
                switch (i11) {
                    case 0:
                        sb2.append("null");
                        return sb2;
                    case 1:
                    case 6:
                        sb2.append(asLong());
                        return sb2;
                    case 2:
                    case 7:
                        sb2.append(asUInt());
                        return sb2;
                    case 3:
                    case 8:
                        sb2.append(asFloat());
                        return sb2;
                    case 4:
                        Key asKey = asKey();
                        sb2.append('\"');
                        StringBuilder key = asKey.toString(sb2);
                        key.append('\"');
                        return key;
                    case 5:
                        sb2.append('\"');
                        sb2.append(asString());
                        sb2.append('\"');
                        return sb2;
                    case 9:
                        return asMap().toString(sb2);
                    case 10:
                        return asVector().toString(sb2);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.type);
                    case 25:
                        return asBlob().toString(sb2);
                    case 26:
                        sb2.append(asBoolean());
                        return sb2;
                    default:
                        return sb2;
                }
            }
            sb2.append(asVector());
            return sb2;
        }

        public int getType() {
            return this.type;
        }

        public boolean isBlob() {
            return this.type == 25;
        }

        public boolean isBoolean() {
            return this.type == 26;
        }

        public boolean isFloat() {
            int i11 = this.type;
            return i11 == 3 || i11 == 8;
        }

        public boolean isInt() {
            int i11 = this.type;
            return i11 == 1 || i11 == 6;
        }

        public boolean isIntOrUInt() {
            return isInt() || isUInt();
        }

        public boolean isKey() {
            return this.type == 4;
        }

        public boolean isMap() {
            return this.type == 9;
        }

        public boolean isNull() {
            return this.type == 0;
        }

        public boolean isNumeric() {
            return isIntOrUInt() || isFloat();
        }

        public boolean isString() {
            return this.type == 5;
        }

        public boolean isTypedVector() {
            return FlexBuffers.h(this.type);
        }

        public boolean isUInt() {
            int i11 = this.type;
            return i11 == 2 || i11 == 7;
        }

        public boolean isVector() {
            int i11 = this.type;
            return i11 == 10 || i11 == 9;
        }

        public String toString() {
            return b(new StringBuilder(128)).toString();
        }

        public Reference(ReadBuf readBuf, int i11, int i12, int i13, int i14) {
            this.f35935bb = readBuf;
            this.end = i11;
            this.parentWidth = i12;
            this.byteWidth = i13;
            this.type = i14;
        }
    }

    public static abstract class Sized extends Object {

        /* renamed from: d  reason: collision with root package name */
        public final int f35936d;

        public Sized(ReadBuf readBuf, int i11, int i12) {
            super(readBuf, i11, i12);
            this.f35936d = FlexBuffers.readInt(this.f35932a, i11 - i12, i12);
        }

        public int size() {
            return this.f35936d;
        }
    }

    public static class TypedVector extends Vector {
        private static final TypedVector EMPTY_VECTOR = new TypedVector(FlexBuffers.EMPTY_BB, 1, 1, 1);
        private final int elemType;

        public TypedVector(ReadBuf readBuf, int i11, int i12, int i13) {
            super(readBuf, i11, i12);
            this.elemType = i13;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int i11) {
            if (i11 >= size()) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.f35932a, this.f35933b + (i11 * this.f35934c), this.f35934c, 1, this.elemType);
        }

        public int getElemType() {
            return this.elemType;
        }

        public boolean isEmptyVector() {
            return this == EMPTY_VECTOR;
        }
    }

    public static class Unsigned {
        public static int a(byte b11) {
            return b11 & 255;
        }

        public static long b(int i11) {
            return ((long) i11) & 4294967295L;
        }

        public static int c(short s11) {
            return s11 & UShort.MAX_VALUE;
        }
    }

    public static class Vector extends Sized {
        private static final Vector EMPTY_VECTOR = new Vector(FlexBuffers.EMPTY_BB, 1, 1);

        public Vector(ReadBuf readBuf, int i11, int i12) {
            super(readBuf, i11, i12);
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int i11) {
            long size = (long) size();
            long j11 = (long) i11;
            if (j11 >= size) {
                return Reference.NULL_REFERENCE;
            }
            int a11 = Unsigned.a(this.f35932a.get((int) (((long) this.f35933b) + (size * ((long) this.f35934c)) + j11)));
            return new Reference(this.f35932a, this.f35933b + (i11 * this.f35934c), this.f35934c, a11);
        }

        public boolean isEmpty() {
            return this == EMPTY_VECTOR;
        }

        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        public StringBuilder toString(StringBuilder sb2) {
            sb2.append("[ ");
            int size = size();
            for (int i11 = 0; i11 < size; i11++) {
                get(i11).b(sb2);
                if (i11 != size - 1) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
            }
            sb2.append(" ]");
            return sb2;
        }
    }

    public static boolean g(int i11) {
        return i11 <= 3 || i11 == 26;
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer byteBuffer) {
        return getRoot(byteBuffer.hasArray() ? new ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new ByteBufferReadWriteBuf(byteBuffer));
    }

    public static boolean h(int i11) {
        return (i11 >= 11 && i11 <= 15) || i11 == 36;
    }

    public static boolean i(int i11) {
        return (i11 >= 1 && i11 <= 4) || i11 == 26;
    }

    /* access modifiers changed from: private */
    public static int indirect(ReadBuf readBuf, int i11, int i12) {
        return (int) (((long) i11) - readUInt(readBuf, i11, i12));
    }

    public static int j(int i11, int i12) {
        if (i12 == 0) {
            return (i11 - 1) + 11;
        }
        if (i12 == 2) {
            return (i11 - 1) + 16;
        }
        if (i12 == 3) {
            return (i11 - 1) + 19;
        }
        if (i12 != 4) {
            return 0;
        }
        return (i11 - 1) + 22;
    }

    public static int k(int i11) {
        return (i11 - 11) + 1;
    }

    /* access modifiers changed from: private */
    public static double readDouble(ReadBuf readBuf, int i11, int i12) {
        if (i12 == 4) {
            return (double) readBuf.getFloat(i11);
        }
        if (i12 != 8) {
            return -1.0d;
        }
        return readBuf.getDouble(i11);
    }

    /* access modifiers changed from: private */
    public static int readInt(ReadBuf readBuf, int i11, int i12) {
        return (int) readLong(readBuf, i11, i12);
    }

    /* access modifiers changed from: private */
    public static long readLong(ReadBuf readBuf, int i11, int i12) {
        int i13;
        if (i12 == 1) {
            i13 = readBuf.get(i11);
        } else if (i12 == 2) {
            i13 = readBuf.getShort(i11);
        } else if (i12 == 4) {
            i13 = readBuf.getInt(i11);
        } else if (i12 != 8) {
            return -1;
        } else {
            return readBuf.getLong(i11);
        }
        return (long) i13;
    }

    /* access modifiers changed from: private */
    public static long readUInt(ReadBuf readBuf, int i11, int i12) {
        if (i12 == 1) {
            return (long) Unsigned.a(readBuf.get(i11));
        }
        if (i12 == 2) {
            return (long) Unsigned.c(readBuf.getShort(i11));
        }
        if (i12 == 4) {
            return Unsigned.b(readBuf.getInt(i11));
        }
        if (i12 != 8) {
            return -1;
        }
        return readBuf.getLong(i11);
    }

    public static Reference getRoot(ReadBuf readBuf) {
        int limit = readBuf.limit() - 1;
        byte b11 = readBuf.get(limit);
        int i11 = limit - 1;
        return new Reference(readBuf, i11 - b11, b11, Unsigned.a(readBuf.get(i11)));
    }
}
