package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.FlexBuffers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FlexBuffersBuilder {
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;
    /* access modifiers changed from: private */

    /* renamed from: bb  reason: collision with root package name */
    public final ReadWriteBuf f35937bb;
    private boolean finished;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack;
    private final HashMap<String, Integer> stringPool;

    public static class Value {

        /* renamed from: a  reason: collision with root package name */
        public final int f35939a;

        /* renamed from: b  reason: collision with root package name */
        public final int f35940b;

        /* renamed from: c  reason: collision with root package name */
        public final double f35941c;

        /* renamed from: d  reason: collision with root package name */
        public long f35942d;

        /* renamed from: e  reason: collision with root package name */
        public int f35943e;

        public Value(int i11, int i12, int i13, long j11) {
            this.f35943e = i11;
            this.f35939a = i12;
            this.f35940b = i13;
            this.f35942d = j11;
            this.f35941c = Double.MIN_VALUE;
        }

        /* access modifiers changed from: private */
        public int elemWidth(int i11, int i12) {
            return elemWidth(this.f35939a, this.f35940b, this.f35942d, i11, i12);
        }

        public static Value f(int i11, int i12, int i13, int i14) {
            return new Value(i11, i13, i14, (long) i12);
        }

        public static Value g(int i11, boolean z11) {
            return new Value(i11, 26, 0, z11 ? 1 : 0);
        }

        public static Value h(int i11, float f11) {
            return new Value(i11, 3, 2, (double) f11);
        }

        public static Value i(int i11, double d11) {
            return new Value(i11, 3, 3, d11);
        }

        public static Value j(int i11, int i12) {
            return new Value(i11, 1, 1, (long) i12);
        }

        public static Value k(int i11, int i12) {
            return new Value(i11, 1, 2, (long) i12);
        }

        public static Value l(int i11, long j11) {
            return new Value(i11, 1, 3, j11);
        }

        public static Value m(int i11, int i12) {
            return new Value(i11, 1, 0, (long) i12);
        }

        public static Value n(int i11, int i12) {
            return new Value(i11, 2, 1, (long) i12);
        }

        public static Value o(int i11, int i12) {
            return new Value(i11, 2, 2, (long) i12);
        }

        public static Value p(int i11, long j11) {
            return new Value(i11, 2, 3, j11);
        }

        private static byte packedType(int i11, int i12) {
            return (byte) (i11 | (i12 << 2));
        }

        /* access modifiers changed from: private */
        public static int paddingBytes(int i11, int i12) {
            return ((~i11) + 1) & (i12 - 1);
        }

        public static Value q(int i11, int i12) {
            return new Value(i11, 2, 0, (long) i12);
        }

        /* access modifiers changed from: private */
        public byte storedPackedType() {
            return storedPackedType(0);
        }

        private int storedWidth(int i11) {
            if (FlexBuffers.g(this.f35939a)) {
                return Math.max(this.f35940b, i11);
            }
            return this.f35940b;
        }

        /* access modifiers changed from: private */
        public static int elemWidth(int i11, int i12, long j11, int i13, int i14) {
            if (FlexBuffers.g(i11)) {
                return i12;
            }
            for (int i15 = 1; i15 <= 32; i15 *= 2) {
                int b11 = FlexBuffersBuilder.b((long) ((int) (((long) ((paddingBytes(i13, i15) + i13) + (i14 * i15))) - j11)));
                if ((1 << b11) == ((long) i15)) {
                    return b11;
                }
            }
            return 3;
        }

        /* access modifiers changed from: private */
        public byte storedPackedType(int i11) {
            return packedType(storedWidth(i11), this.f35939a);
        }

        public Value(int i11, int i12, int i13, double d11) {
            this.f35943e = i11;
            this.f35939a = i12;
            this.f35940b = i13;
            this.f35941c = d11;
            this.f35942d = Long.MIN_VALUE;
        }
    }

    public FlexBuffersBuilder(int i11) {
        this((ReadWriteBuf) new ArrayReadWriteBuf(i11), 1);
    }

    private int align(int i11) {
        int i12 = 1 << i11;
        int a11 = Value.paddingBytes(this.f35937bb.writePosition(), i12);
        while (true) {
            int i13 = a11 - 1;
            if (a11 == 0) {
                return i12;
            }
            this.f35937bb.put((byte) 0);
            a11 = i13;
        }
    }

    public static int b(long j11) {
        if (j11 <= ((long) FlexBuffers.Unsigned.a((byte) -1))) {
            return 0;
        }
        if (j11 <= ((long) FlexBuffers.Unsigned.c(-1))) {
            return 1;
        }
        if (j11 <= FlexBuffers.Unsigned.b(-1)) {
            return 2;
        }
        return 3;
    }

    private Value createKeyVector(int i11, int i12) {
        long j11 = (long) i12;
        int max = Math.max(0, b(j11));
        int i13 = i11;
        while (i13 < this.stack.size()) {
            i13++;
            max = Math.max(max, Value.elemWidth(4, 0, (long) this.stack.get(i13).f35943e, this.f35937bb.writePosition(), i13));
        }
        int align = align(max);
        writeInt(j11, align);
        int writePosition = this.f35937bb.writePosition();
        while (i11 < this.stack.size()) {
            int i14 = this.stack.get(i11).f35943e;
            writeOffset((long) this.stack.get(i11).f35943e, align);
            i11++;
        }
        return new Value(-1, FlexBuffers.j(4, 0), max, (long) writePosition);
    }

    private Value createVector(int i11, int i12, int i13, boolean z11, boolean z12, Value value) {
        int i14;
        int i15;
        Value value2 = value;
        int i16 = i13;
        long j11 = (long) i16;
        int max = Math.max(0, b(j11));
        if (value2 != null) {
            max = Math.max(max, value2.elemWidth(this.f35937bb.writePosition(), 0));
            i14 = 3;
        } else {
            i14 = 1;
        }
        int i17 = 4;
        int i18 = max;
        for (int i19 = i12; i19 < this.stack.size(); i19++) {
            i18 = Math.max(i18, this.stack.get(i19).elemWidth(this.f35937bb.writePosition(), i19 + i14));
            int i21 = i12;
            if (z11 && i19 == i21) {
                i17 = this.stack.get(i19).f35939a;
                if (!FlexBuffers.i(i17)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i22 = i12;
        int align = align(i18);
        if (value2 != null) {
            writeOffset(value2.f35942d, align);
            writeInt(1 << value2.f35940b, align);
        }
        if (!z12) {
            writeInt(j11, align);
        }
        int writePosition = this.f35937bb.writePosition();
        for (int i23 = i22; i23 < this.stack.size(); i23++) {
            writeAny(this.stack.get(i23), align);
        }
        if (!z11) {
            while (i22 < this.stack.size()) {
                this.f35937bb.put(this.stack.get(i22).storedPackedType(i18));
                i22++;
            }
        }
        if (value2 != null) {
            i15 = 9;
        } else if (z11) {
            if (!z12) {
                i16 = 0;
            }
            i15 = FlexBuffers.j(i17, i16);
        } else {
            i15 = 10;
        }
        return new Value(i11, i15, i18, (long) writePosition);
    }

    private int putKey(String str) {
        if (str == null) {
            return -1;
        }
        int writePosition = this.f35937bb.writePosition();
        if ((this.flags & 1) != 0) {
            Integer num = this.keyPool.get(str);
            if (num != null) {
                return num.intValue();
            }
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.f35937bb.put(bytes, 0, bytes.length);
            this.f35937bb.put((byte) 0);
            this.keyPool.put(str, Integer.valueOf(writePosition));
            return writePosition;
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.f35937bb.put(bytes2, 0, bytes2.length);
        this.f35937bb.put((byte) 0);
        this.keyPool.put(str, Integer.valueOf(writePosition));
        return writePosition;
    }

    private void writeAny(Value value, int i11) {
        int i12 = value.f35939a;
        if (!(i12 == 0 || i12 == 1 || i12 == 2)) {
            if (i12 == 3) {
                writeDouble(value.f35941c, i11);
                return;
            } else if (i12 != 26) {
                writeOffset(value.f35942d, i11);
                return;
            }
        }
        writeInt(value.f35942d, i11);
    }

    private Value writeBlob(int i11, byte[] bArr, int i12, boolean z11) {
        int b11 = b((long) bArr.length);
        writeInt((long) bArr.length, align(b11));
        int writePosition = this.f35937bb.writePosition();
        this.f35937bb.put(bArr, 0, bArr.length);
        if (z11) {
            this.f35937bb.put((byte) 0);
        }
        return Value.f(i11, writePosition, i12, b11);
    }

    private void writeDouble(double d11, int i11) {
        if (i11 == 4) {
            this.f35937bb.putFloat((float) d11);
        } else if (i11 == 8) {
            this.f35937bb.putDouble(d11);
        }
    }

    private void writeInt(long j11, int i11) {
        if (i11 == 1) {
            this.f35937bb.put((byte) ((int) j11));
        } else if (i11 == 2) {
            this.f35937bb.putShort((short) ((int) j11));
        } else if (i11 == 4) {
            this.f35937bb.putInt((int) j11);
        } else if (i11 == 8) {
            this.f35937bb.putLong(j11);
        }
    }

    private void writeOffset(long j11, int i11) {
        writeInt((long) ((int) (((long) this.f35937bb.writePosition()) - j11)), i11);
    }

    private Value writeString(int i11, String str) {
        return writeBlob(i11, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String str, int i11) {
        int putKey = putKey(str);
        ArrayList<Value> arrayList = this.stack;
        Collections.sort(arrayList.subList(i11, arrayList.size()), this.keyComparator);
        int i12 = i11;
        Value createVector = createVector(putKey, i12, this.stack.size() - i11, false, false, createKeyVector(i11, this.stack.size() - i11));
        while (this.stack.size() > i11) {
            ArrayList<Value> arrayList2 = this.stack;
            arrayList2.remove(arrayList2.size() - 1);
        }
        this.stack.add(createVector);
        return (int) createVector.f35942d;
    }

    public int endVector(String str, int i11, boolean z11, boolean z12) {
        Value createVector = createVector(putKey(str), i11, this.stack.size() - i11, z11, z12, (Value) null);
        while (this.stack.size() > i11) {
            ArrayList<Value> arrayList = this.stack;
            arrayList.remove(arrayList.size() - 1);
        }
        this.stack.add(createVector);
        return (int) createVector.f35942d;
    }

    public ByteBuffer finish() {
        int align = align(this.stack.get(0).elemWidth(this.f35937bb.writePosition(), 0));
        writeAny(this.stack.get(0), align);
        this.f35937bb.put(this.stack.get(0).storedPackedType());
        this.f35937bb.put((byte) align);
        this.finished = true;
        return ByteBuffer.wrap(this.f35937bb.data(), 0, this.f35937bb.writePosition());
    }

    public ReadWriteBuf getBuffer() {
        return this.f35937bb;
    }

    public int putBlob(byte[] bArr) {
        return putBlob((String) null, bArr);
    }

    public void putBoolean(boolean z11) {
        putBoolean((String) null, z11);
    }

    public void putFloat(float f11) {
        putFloat((String) null, f11);
    }

    public void putInt(int i11) {
        putInt((String) null, i11);
    }

    public int putString(String str) {
        return putString((String) null, str);
    }

    public void putUInt(int i11) {
        putUInt((String) null, (long) i11);
    }

    public void putUInt64(BigInteger bigInteger) {
        putUInt64((String) null, bigInteger.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    private void putUInt64(String str, long j11) {
        this.stack.add(Value.p(putKey(str), j11));
    }

    public int putBlob(String str, byte[] bArr) {
        Value writeBlob = writeBlob(putKey(str), bArr, 25, false);
        this.stack.add(writeBlob);
        return (int) writeBlob.f35942d;
    }

    public void putBoolean(String str, boolean z11) {
        this.stack.add(Value.g(putKey(str), z11));
    }

    public void putFloat(String str, float f11) {
        this.stack.add(Value.h(putKey(str), f11));
    }

    public void putInt(String str, int i11) {
        putInt(str, (long) i11);
    }

    public int putString(String str, String str2) {
        int putKey = putKey(str);
        if ((this.flags & 2) != 0) {
            Integer num = this.stringPool.get(str2);
            if (num == null) {
                Value writeString = writeString(putKey, str2);
                this.stringPool.put(str2, Integer.valueOf((int) writeString.f35942d));
                this.stack.add(writeString);
                return (int) writeString.f35942d;
            }
            this.stack.add(Value.f(putKey, num.intValue(), 5, b((long) str2.length())));
            return num.intValue();
        }
        Value writeString2 = writeString(putKey, str2);
        this.stack.add(writeString2);
        return (int) writeString2.f35942d;
    }

    public void putUInt(long j11) {
        putUInt((String) null, j11);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i11) {
        this((ReadWriteBuf) new ArrayReadWriteBuf(byteBuffer.array()), i11);
    }

    private void putUInt(String str, long j11) {
        Value value;
        int putKey = putKey(str);
        int b11 = b(j11);
        if (b11 == 0) {
            value = Value.q(putKey, (int) j11);
        } else if (b11 == 1) {
            value = Value.n(putKey, (int) j11);
        } else if (b11 == 2) {
            value = Value.o(putKey, (int) j11);
        } else {
            value = Value.p(putKey, j11);
        }
        this.stack.add(value);
    }

    public void putFloat(double d11) {
        putFloat((String) null, d11);
    }

    public void putInt(String str, long j11) {
        int putKey = putKey(str);
        if (-128 <= j11 && j11 <= 127) {
            this.stack.add(Value.m(putKey, (int) j11));
        } else if (-32768 <= j11 && j11 <= 32767) {
            this.stack.add(Value.j(putKey, (int) j11));
        } else if (-2147483648L > j11 || j11 > 2147483647L) {
            this.stack.add(Value.l(putKey, j11));
        } else {
            this.stack.add(Value.k(putKey, (int) j11));
        }
    }

    public FlexBuffersBuilder(ReadWriteBuf readWriteBuf, int i11) {
        this.stack = new ArrayList<>();
        this.keyPool = new HashMap<>();
        this.stringPool = new HashMap<>();
        this.finished = false;
        this.keyComparator = new Comparator<Value>() {
            public int compare(Value value, Value value2) {
                byte b11;
                byte b12;
                int i11 = value.f35943e;
                int i12 = value2.f35943e;
                do {
                    b11 = FlexBuffersBuilder.this.f35937bb.get(i11);
                    b12 = FlexBuffersBuilder.this.f35937bb.get(i12);
                    if (b11 == 0) {
                        return b11 - b12;
                    }
                    i11++;
                    i12++;
                } while (b11 == b12);
                return b11 - b12;
            }
        };
        this.f35937bb = readWriteBuf;
        this.flags = i11;
    }

    public void putFloat(String str, double d11) {
        this.stack.add(Value.i(putKey(str), d11));
    }

    public void putInt(long j11) {
        putInt((String) null, j11);
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }
}
