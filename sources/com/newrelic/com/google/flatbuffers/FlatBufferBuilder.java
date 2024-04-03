package com.newrelic.com.google.flatbuffers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: bb  reason: collision with root package name */
    ByteBuffer f52787bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    public static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        public int read() throws IOException {
            try {
                return this.buf.get() & 255;
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

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    public static ByteBuffer growByteBuffer(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
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
            newByteBuffer.position(i11 - capacity);
            newByteBuffer.put(byteBuffer);
            return newByteBuffer;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    public void Nested(int i11) {
        if (i11 != offset()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
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

    public void clear() {
        this.space = this.f52787bb.capacity();
        this.f52787bb.clear();
        this.minalign = 1;
        while (true) {
            int i11 = this.vtable_in_use;
            if (i11 > 0) {
                int[] iArr = this.vtable;
                int i12 = i11 - 1;
                this.vtable_in_use = i12;
                iArr[i12] = 0;
            } else {
                this.vtable_in_use = 0;
                this.nested = false;
                this.finished = false;
                this.object_start = 0;
                this.num_vtables = 0;
                this.vector_num_elems = 0;
                return;
            }
        }
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.f52787bb;
        int i11 = this.space - length;
        this.space = i11;
        byteBuffer.position(i11);
        this.f52787bb.put(bArr);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T t11, int[] iArr) {
        t11.sortTables(iArr, this.f52787bb);
        return createVectorOfTables(iArr);
    }

    public int createString(CharSequence charSequence) {
        int encodedLength = this.utf8.encodedLength(charSequence);
        addByte((byte) 0);
        startVector(1, encodedLength, 1);
        ByteBuffer byteBuffer = this.f52787bb;
        int i11 = this.space - encodedLength;
        this.space = i11;
        byteBuffer.position(i11);
        this.utf8.encodeUtf8(charSequence, this.f52787bb);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int i11, int i12, int i13) {
        int i14 = i11 * i12;
        startVector(i11, i12, i13);
        ByteBuffer byteBuffer = this.f52787bb;
        int i15 = this.space - i14;
        this.space = i15;
        byteBuffer.position(i15);
        ByteBuffer order = this.f52787bb.slice().order(ByteOrder.LITTLE_ENDIAN);
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
        return this.f52787bb;
    }

    public int endObject() {
        int i11;
        int i12;
        if (this.vtable == null || !this.nested) {
            throw new AssertionError("FlatBuffers: endObject called without startObject");
        }
        addInt(0);
        int offset = offset();
        int i13 = this.vtable_in_use - 1;
        while (i13 >= 0 && this.vtable[i13] == 0) {
            i13--;
        }
        int i14 = i13 + 1;
        while (i13 >= 0) {
            int i15 = this.vtable[i13];
            if (i15 != 0) {
                i12 = offset - i15;
            } else {
                i12 = 0;
            }
            addShort((short) i12);
            i13--;
        }
        addShort((short) (offset - this.object_start));
        addShort((short) ((i14 + 2) * 2));
        int i16 = 0;
        loop2:
        while (true) {
            if (i16 >= this.num_vtables) {
                i11 = 0;
                break;
            }
            int capacity = this.f52787bb.capacity() - this.vtables[i16];
            int i17 = this.space;
            short s11 = this.f52787bb.getShort(capacity);
            if (s11 == this.f52787bb.getShort(i17)) {
                int i18 = 2;
                while (i18 < s11) {
                    if (this.f52787bb.getShort(capacity + i18) == this.f52787bb.getShort(i17 + i18)) {
                        i18 += 2;
                    }
                }
                i11 = this.vtables[i16];
                break loop2;
            }
            i16++;
        }
        if (i11 != 0) {
            int capacity2 = this.f52787bb.capacity() - offset;
            this.space = capacity2;
            this.f52787bb.putInt(capacity2, i11 - offset);
        } else {
            int i19 = this.num_vtables;
            int[] iArr = this.vtables;
            if (i19 == iArr.length) {
                this.vtables = Arrays.copyOf(iArr, i19 * 2);
            }
            int[] iArr2 = this.vtables;
            int i21 = this.num_vtables;
            this.num_vtables = i21 + 1;
            iArr2[i21] = offset();
            ByteBuffer byteBuffer = this.f52787bb;
            byteBuffer.putInt(byteBuffer.capacity() - offset, offset() - offset);
        }
        this.nested = false;
        return offset;
    }

    public int endVector() {
        if (this.nested) {
            this.nested = false;
            putInt(this.vector_num_elems);
            return offset();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public void finish(int i11, boolean z11) {
        prep(this.minalign, (z11 ? 4 : 0) + 4);
        addOffset(i11);
        if (z11) {
            addInt(this.f52787bb.capacity() - this.space);
        }
        this.f52787bb.position(this.space);
        this.finished = true;
    }

    public void finishSizePrefixed(int i11) {
        finish(i11, true);
    }

    public void finished() {
        if (!this.finished) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public FlatBufferBuilder forceDefaults(boolean z11) {
        this.force_defaults = z11;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.bb_factory = byteBufferFactory;
        this.f52787bb = byteBuffer;
        byteBuffer.clear();
        this.f52787bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.f52787bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public void notNested() {
        if (this.nested) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int offset() {
        return this.f52787bb.capacity() - this.space;
    }

    public void pad(int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            ByteBuffer byteBuffer = this.f52787bb;
            int i13 = this.space - 1;
            this.space = i13;
            byteBuffer.put(i13, (byte) 0);
        }
    }

    public void prep(int i11, int i12) {
        if (i11 > this.minalign) {
            this.minalign = i11;
        }
        int i13 = ((~((this.f52787bb.capacity() - this.space) + i12)) + 1) & (i11 - 1);
        while (this.space < i13 + i11 + i12) {
            int capacity = this.f52787bb.capacity();
            ByteBuffer byteBuffer = this.f52787bb;
            ByteBuffer growByteBuffer = growByteBuffer(byteBuffer, this.bb_factory);
            this.f52787bb = growByteBuffer;
            if (byteBuffer != growByteBuffer) {
                this.bb_factory.releaseByteBuffer(byteBuffer);
            }
            this.space += this.f52787bb.capacity() - capacity;
        }
        pad(i13);
    }

    public void putBoolean(boolean z11) {
        ByteBuffer byteBuffer = this.f52787bb;
        int i11 = this.space - 1;
        this.space = i11;
        byteBuffer.put(i11, z11 ? (byte) 1 : 0);
    }

    public void putByte(byte b11) {
        ByteBuffer byteBuffer = this.f52787bb;
        int i11 = this.space - 1;
        this.space = i11;
        byteBuffer.put(i11, b11);
    }

    public void putDouble(double d11) {
        ByteBuffer byteBuffer = this.f52787bb;
        int i11 = this.space - 8;
        this.space = i11;
        byteBuffer.putDouble(i11, d11);
    }

    public void putFloat(float f11) {
        ByteBuffer byteBuffer = this.f52787bb;
        int i11 = this.space - 4;
        this.space = i11;
        byteBuffer.putFloat(i11, f11);
    }

    public void putInt(int i11) {
        ByteBuffer byteBuffer = this.f52787bb;
        int i12 = this.space - 4;
        this.space = i12;
        byteBuffer.putInt(i12, i11);
    }

    public void putLong(long j11) {
        ByteBuffer byteBuffer = this.f52787bb;
        int i11 = this.space - 8;
        this.space = i11;
        byteBuffer.putLong(i11, j11);
    }

    public void putShort(short s11) {
        ByteBuffer byteBuffer = this.f52787bb;
        int i11 = this.space - 2;
        this.space = i11;
        byteBuffer.putShort(i11, s11);
    }

    public void required(int i11, int i12) {
        boolean z11;
        int capacity = this.f52787bb.capacity() - i11;
        if (this.f52787bb.getShort((capacity - this.f52787bb.getInt(capacity)) + i12) != 0) {
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
        this.f52787bb.position(i11);
        this.f52787bb.get(bArr);
        return bArr;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer duplicate = this.f52787bb.duplicate();
        duplicate.position(this.space);
        duplicate.limit(this.f52787bb.capacity());
        return new ByteBufferBackedInputStream(duplicate);
    }

    public void slot(int i11) {
        this.vtable[i11] = offset();
    }

    public void startObject(int i11) {
        notNested();
        int[] iArr = this.vtable;
        if (iArr == null || iArr.length < i11) {
            this.vtable = new int[i11];
        }
        this.vtable_in_use = i11;
        Arrays.fill(this.vtable, 0, i11, 0);
        this.nested = true;
        this.object_start = offset();
    }

    public void startVector(int i11, int i12, int i13) {
        notNested();
        this.vector_num_elems = i12;
        int i14 = i11 * i12;
        prep(4, i14);
        prep(i13, i14);
        this.nested = true;
    }

    public FlatBufferBuilder(int i11, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf82) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        i11 = i11 <= 0 ? 1 : i11;
        this.space = i11;
        this.bb_factory = byteBufferFactory;
        if (byteBuffer != null) {
            this.f52787bb = byteBuffer;
            byteBuffer.clear();
            this.f52787bb.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f52787bb = byteBufferFactory.newByteBuffer(i11);
        }
        this.utf8 = utf82;
    }

    public void addBoolean(int i11, boolean z11, boolean z12) {
        if (this.force_defaults || z11 != z12) {
            addBoolean(z11);
            slot(i11);
        }
    }

    public void addByte(int i11, byte b11, int i12) {
        if (this.force_defaults || b11 != i12) {
            addByte(b11);
            slot(i11);
        }
    }

    public void addDouble(int i11, double d11, double d12) {
        if (this.force_defaults || d11 != d12) {
            addDouble(d11);
            slot(i11);
        }
    }

    public void addFloat(int i11, float f11, double d11) {
        if (this.force_defaults || ((double) f11) != d11) {
            addFloat(f11);
            slot(i11);
        }
    }

    public void addInt(int i11, int i12, int i13) {
        if (this.force_defaults || i12 != i13) {
            addInt(i12);
            slot(i11);
        }
    }

    public void addLong(int i11, long j11, long j12) {
        if (this.force_defaults || j11 != j12) {
            addLong(j11);
            slot(i11);
        }
    }

    public void addShort(int i11, short s11, int i12) {
        if (this.force_defaults || s11 != i12) {
            addShort(s11);
            slot(i11);
        }
    }

    public void finishSizePrefixed(int i11, String str) {
        finish(i11, str, true);
    }

    public void addOffset(int i11, int i12, int i13) {
        if (this.force_defaults || i12 != i13) {
            addOffset(i12);
            slot(i11);
        }
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.f52787bb.capacity() - this.space);
    }

    public void finish(int i11) {
        finish(i11, false);
    }

    public int createString(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f52787bb;
        int i11 = this.space - remaining;
        this.space = i11;
        byteBuffer2.position(i11);
        this.f52787bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i11, String str, boolean z11) {
        prep(this.minalign, (z11 ? 4 : 0) + 8);
        if (str.length() == 4) {
            for (int i12 = 3; i12 >= 0; i12--) {
                addByte((byte) str.charAt(i12));
            }
            finish(i11, z11);
            return;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public void finish(int i11, String str) {
        finish(i11, str, false);
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
