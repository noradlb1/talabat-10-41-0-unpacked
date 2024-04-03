package androidx.emoji2.text.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class FlatBufferBuilder {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f35916a;

    /* renamed from: b  reason: collision with root package name */
    public int f35917b;

    /* renamed from: c  reason: collision with root package name */
    public int f35918c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f35919d;

    /* renamed from: e  reason: collision with root package name */
    public int f35920e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35921f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35922g;

    /* renamed from: h  reason: collision with root package name */
    public int f35923h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f35924i;

    /* renamed from: j  reason: collision with root package name */
    public int f35925j;

    /* renamed from: k  reason: collision with root package name */
    public int f35926k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f35927l;

    /* renamed from: m  reason: collision with root package name */
    public ByteBufferFactory f35928m;

    /* renamed from: n  reason: collision with root package name */
    public final Utf8 f35929n;

    public static class ByteBufferBackedInputStream extends InputStream {

        /* renamed from: b  reason: collision with root package name */
        public ByteBuffer f35930b;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.f35930b = byteBuffer;
        }

        public int read() throws IOException {
            try {
                return this.f35930b.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int i11);

        public void releaseByteBuffer(ByteBuffer byteBuffer) {
        }
    }

    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = new HeapByteBufferFactory();

        public ByteBuffer newByteBuffer(int i11) {
            return ByteBuffer.allocate(i11).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder(int i11, ByteBufferFactory byteBufferFactory) {
        this(i11, byteBufferFactory, (ByteBuffer) null, Utf8.getDefault());
    }

    public static ByteBuffer c(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        int i11;
        int capacity = byteBuffer.capacity();
        if ((-1073741824 & capacity) == 0) {
            if (capacity == 0) {
                i11 = 1;
            } else {
                i11 = capacity << 1;
            }
            byteBuffer.position(0);
            ByteBuffer newByteBuffer = byteBufferFactory.newByteBuffer(i11);
            newByteBuffer.position(newByteBuffer.clear().capacity() - capacity);
            newByteBuffer.put(byteBuffer);
            return newByteBuffer;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.f35917b;
    }

    public static boolean isFieldPresent(Table table, int i11) {
        return table.c(i11) != 0;
    }

    public void Nested(int i11) {
        if (i11 != offset()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void a(int i11, String str, boolean z11) {
        int i12;
        int i13 = this.f35918c;
        if (z11) {
            i12 = 4;
        } else {
            i12 = 0;
        }
        prep(i13, i12 + 8);
        if (str.length() == 4) {
            for (int i14 = 3; i14 >= 0; i14--) {
                addByte((byte) str.charAt(i14));
            }
            b(i11, z11);
            return;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public void addBoolean(boolean z11) {
        prep(1, 0);
        putBoolean(z11);
    }

    public void addByte(byte b11) {
        prep(1, 0);
        putByte(b11);
    }

    public void addDouble(double d11) {
        prep(8, 0);
        putDouble(d11);
    }

    public void addFloat(float f11) {
        prep(4, 0);
        putFloat(f11);
    }

    public void addInt(int i11) {
        prep(4, 0);
        putInt(i11);
    }

    public void addLong(long j11) {
        prep(8, 0);
        putLong(j11);
    }

    public void addOffset(int i11) {
        prep(4, 0);
        putInt((offset() - i11) + 4);
    }

    public void addShort(short s11) {
        prep(2, 0);
        putShort(s11);
    }

    public void addStruct(int i11, int i12, int i13) {
        if (i12 != i13) {
            Nested(i12);
            slot(i11);
        }
    }

    public void b(int i11, boolean z11) {
        int i12;
        int i13 = this.f35918c;
        if (z11) {
            i12 = 4;
        } else {
            i12 = 0;
        }
        prep(i13, i12 + 4);
        addOffset(i11);
        if (z11) {
            addInt(this.f35916a.capacity() - this.f35917b);
        }
        this.f35916a.position(this.f35917b);
        this.f35922g = true;
    }

    public void clear() {
        this.f35917b = this.f35916a.capacity();
        this.f35916a.clear();
        this.f35918c = 1;
        while (true) {
            int i11 = this.f35920e;
            if (i11 > 0) {
                int[] iArr = this.f35919d;
                int i12 = i11 - 1;
                this.f35920e = i12;
                iArr[i12] = 0;
            } else {
                this.f35920e = 0;
                this.f35921f = false;
                this.f35922g = false;
                this.f35923h = 0;
                this.f35925j = 0;
                this.f35926k = 0;
                return;
            }
        }
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.f35916a;
        int i11 = this.f35917b - length;
        this.f35917b = i11;
        byteBuffer.position(i11);
        this.f35916a.put(bArr);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T t11, int[] iArr) {
        t11.m(iArr, this.f35916a);
        return createVectorOfTables(iArr);
    }

    public int createString(CharSequence charSequence) {
        int encodedLength = this.f35929n.encodedLength(charSequence);
        addByte((byte) 0);
        startVector(1, encodedLength, 1);
        ByteBuffer byteBuffer = this.f35916a;
        int i11 = this.f35917b - encodedLength;
        this.f35917b = i11;
        byteBuffer.position(i11);
        this.f35929n.encodeUtf8(charSequence, this.f35916a);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int i11, int i12, int i13) {
        int i14 = i11 * i12;
        startVector(i11, i12, i13);
        ByteBuffer byteBuffer = this.f35916a;
        int i15 = this.f35917b - i14;
        this.f35917b = i15;
        byteBuffer.position(i15);
        ByteBuffer order = this.f35916a.slice().order(ByteOrder.LITTLE_ENDIAN);
        order.limit(i14);
        return order;
    }

    public int createVectorOfTables(int[] iArr) {
        notNested();
        startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            addOffset(iArr[length]);
        }
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.f35916a;
    }

    public int endTable() {
        int i11;
        int i12;
        if (this.f35919d == null || !this.f35921f) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        addInt(0);
        int offset = offset();
        int i13 = this.f35920e - 1;
        while (i13 >= 0 && this.f35919d[i13] == 0) {
            i13--;
        }
        int i14 = i13 + 1;
        while (i13 >= 0) {
            int i15 = this.f35919d[i13];
            if (i15 != 0) {
                i12 = offset - i15;
            } else {
                i12 = 0;
            }
            addShort((short) i12);
            i13--;
        }
        addShort((short) (offset - this.f35923h));
        addShort((short) ((i14 + 2) * 2));
        int i16 = 0;
        loop2:
        while (true) {
            if (i16 >= this.f35925j) {
                i11 = 0;
                break;
            }
            int capacity = this.f35916a.capacity() - this.f35924i[i16];
            int i17 = this.f35917b;
            short s11 = this.f35916a.getShort(capacity);
            if (s11 == this.f35916a.getShort(i17)) {
                int i18 = 2;
                while (i18 < s11) {
                    if (this.f35916a.getShort(capacity + i18) == this.f35916a.getShort(i17 + i18)) {
                        i18 += 2;
                    }
                }
                i11 = this.f35924i[i16];
                break loop2;
            }
            i16++;
        }
        if (i11 != 0) {
            int capacity2 = this.f35916a.capacity() - offset;
            this.f35917b = capacity2;
            this.f35916a.putInt(capacity2, i11 - offset);
        } else {
            int i19 = this.f35925j;
            int[] iArr = this.f35924i;
            if (i19 == iArr.length) {
                this.f35924i = Arrays.copyOf(iArr, i19 * 2);
            }
            int[] iArr2 = this.f35924i;
            int i21 = this.f35925j;
            this.f35925j = i21 + 1;
            iArr2[i21] = offset();
            ByteBuffer byteBuffer = this.f35916a;
            byteBuffer.putInt(byteBuffer.capacity() - offset, offset() - offset);
        }
        this.f35921f = false;
        return offset;
    }

    public int endVector() {
        if (this.f35921f) {
            this.f35921f = false;
            putInt(this.f35926k);
            return offset();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public void finish(int i11) {
        b(i11, false);
    }

    public void finishSizePrefixed(int i11) {
        b(i11, true);
    }

    public void finished() {
        if (!this.f35922g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public FlatBufferBuilder forceDefaults(boolean z11) {
        this.f35927l = z11;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.f35928m = byteBufferFactory;
        this.f35916a = byteBuffer;
        byteBuffer.clear();
        this.f35916a.order(ByteOrder.LITTLE_ENDIAN);
        this.f35918c = 1;
        this.f35917b = this.f35916a.capacity();
        this.f35920e = 0;
        this.f35921f = false;
        this.f35922g = false;
        this.f35923h = 0;
        this.f35925j = 0;
        this.f35926k = 0;
        return this;
    }

    public void notNested() {
        if (this.f35921f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int offset() {
        return this.f35916a.capacity() - this.f35917b;
    }

    public void pad(int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            ByteBuffer byteBuffer = this.f35916a;
            int i13 = this.f35917b - 1;
            this.f35917b = i13;
            byteBuffer.put(i13, (byte) 0);
        }
    }

    public void prep(int i11, int i12) {
        if (i11 > this.f35918c) {
            this.f35918c = i11;
        }
        int i13 = ((~((this.f35916a.capacity() - this.f35917b) + i12)) + 1) & (i11 - 1);
        while (this.f35917b < i13 + i11 + i12) {
            int capacity = this.f35916a.capacity();
            ByteBuffer byteBuffer = this.f35916a;
            ByteBuffer c11 = c(byteBuffer, this.f35928m);
            this.f35916a = c11;
            if (byteBuffer != c11) {
                this.f35928m.releaseByteBuffer(byteBuffer);
            }
            this.f35917b += this.f35916a.capacity() - capacity;
        }
        pad(i13);
    }

    public void putBoolean(boolean z11) {
        ByteBuffer byteBuffer = this.f35916a;
        int i11 = this.f35917b - 1;
        this.f35917b = i11;
        byteBuffer.put(i11, z11 ? (byte) 1 : 0);
    }

    public void putByte(byte b11) {
        ByteBuffer byteBuffer = this.f35916a;
        int i11 = this.f35917b - 1;
        this.f35917b = i11;
        byteBuffer.put(i11, b11);
    }

    public void putDouble(double d11) {
        ByteBuffer byteBuffer = this.f35916a;
        int i11 = this.f35917b - 8;
        this.f35917b = i11;
        byteBuffer.putDouble(i11, d11);
    }

    public void putFloat(float f11) {
        ByteBuffer byteBuffer = this.f35916a;
        int i11 = this.f35917b - 4;
        this.f35917b = i11;
        byteBuffer.putFloat(i11, f11);
    }

    public void putInt(int i11) {
        ByteBuffer byteBuffer = this.f35916a;
        int i12 = this.f35917b - 4;
        this.f35917b = i12;
        byteBuffer.putInt(i12, i11);
    }

    public void putLong(long j11) {
        ByteBuffer byteBuffer = this.f35916a;
        int i11 = this.f35917b - 8;
        this.f35917b = i11;
        byteBuffer.putLong(i11, j11);
    }

    public void putShort(short s11) {
        ByteBuffer byteBuffer = this.f35916a;
        int i11 = this.f35917b - 2;
        this.f35917b = i11;
        byteBuffer.putShort(i11, s11);
    }

    public void required(int i11, int i12) {
        boolean z11;
        int capacity = this.f35916a.capacity() - i11;
        if (this.f35916a.getShort((capacity - this.f35916a.getInt(capacity)) + i12) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new AssertionError("FlatBuffers: field " + i12 + " must be set");
        }
    }

    public byte[] sizedByteArray(int i11, int i12) {
        finished();
        byte[] bArr = new byte[i12];
        this.f35916a.position(i11);
        this.f35916a.get(bArr);
        return bArr;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer duplicate = this.f35916a.duplicate();
        duplicate.position(this.f35917b);
        duplicate.limit(this.f35916a.capacity());
        return new ByteBufferBackedInputStream(duplicate);
    }

    public void slot(int i11) {
        this.f35919d[i11] = offset();
    }

    public void startTable(int i11) {
        notNested();
        int[] iArr = this.f35919d;
        if (iArr == null || iArr.length < i11) {
            this.f35919d = new int[i11];
        }
        this.f35920e = i11;
        Arrays.fill(this.f35919d, 0, i11, 0);
        this.f35921f = true;
        this.f35923h = offset();
    }

    public void startVector(int i11, int i12, int i13) {
        notNested();
        this.f35926k = i12;
        int i14 = i11 * i12;
        prep(4, i14);
        prep(i13, i14);
        this.f35921f = true;
    }

    public FlatBufferBuilder(int i11, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        this.f35918c = 1;
        this.f35919d = null;
        this.f35920e = 0;
        this.f35921f = false;
        this.f35922g = false;
        this.f35924i = new int[16];
        this.f35925j = 0;
        this.f35926k = 0;
        this.f35927l = false;
        i11 = i11 <= 0 ? 1 : i11;
        this.f35928m = byteBufferFactory;
        if (byteBuffer != null) {
            this.f35916a = byteBuffer;
            byteBuffer.clear();
            this.f35916a.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f35916a = byteBufferFactory.newByteBuffer(i11);
        }
        this.f35929n = utf8;
        this.f35917b = this.f35916a.capacity();
    }

    public void addBoolean(int i11, boolean z11, boolean z12) {
        if (this.f35927l || z11 != z12) {
            addBoolean(z11);
            slot(i11);
        }
    }

    public void addByte(int i11, byte b11, int i12) {
        if (this.f35927l || b11 != i12) {
            addByte(b11);
            slot(i11);
        }
    }

    public void addDouble(int i11, double d11, double d12) {
        if (this.f35927l || d11 != d12) {
            addDouble(d11);
            slot(i11);
        }
    }

    public void addFloat(int i11, float f11, double d11) {
        if (this.f35927l || ((double) f11) != d11) {
            addFloat(f11);
            slot(i11);
        }
    }

    public void addInt(int i11, int i12, int i13) {
        if (this.f35927l || i12 != i13) {
            addInt(i12);
            slot(i11);
        }
    }

    public void addLong(int i11, long j11, long j12) {
        if (this.f35927l || j11 != j12) {
            addLong(j11);
            slot(i11);
        }
    }

    public void addShort(int i11, short s11, int i12) {
        if (this.f35927l || s11 != i12) {
            addShort(s11);
            slot(i11);
        }
    }

    public void finish(int i11, String str) {
        a(i11, str, false);
    }

    public void finishSizePrefixed(int i11, String str) {
        a(i11, str, true);
    }

    public void addOffset(int i11, int i12, int i13) {
        if (this.f35927l || i12 != i13) {
            addOffset(i12);
            slot(i11);
        }
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.f35917b, this.f35916a.capacity() - this.f35917b);
    }

    public int createByteVector(byte[] bArr, int i11, int i12) {
        startVector(1, i12, 1);
        ByteBuffer byteBuffer = this.f35916a;
        int i13 = this.f35917b - i12;
        this.f35917b = i13;
        byteBuffer.position(i13);
        this.f35916a.put(bArr, i11, i12);
        return endVector();
    }

    public int createString(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f35916a;
        int i11 = this.f35917b - remaining;
        this.f35917b = i11;
        byteBuffer2.position(i11);
        this.f35916a.put(byteBuffer);
        return endVector();
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f35916a;
        int i11 = this.f35917b - remaining;
        this.f35917b = i11;
        byteBuffer2.position(i11);
        this.f35916a.put(byteBuffer);
        return endVector();
    }

    public FlatBufferBuilder(int i11) {
        this(i11, HeapByteBufferFactory.INSTANCE, (ByteBuffer) null, Utf8.getDefault());
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.getDefault());
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, (ByteBufferFactory) new HeapByteBufferFactory());
    }
}
