package com.newrelic.com.google.flatbuffers;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

public class Table {
    public static final ThreadLocal<Charset> UTF8_CHARSET = new ThreadLocal<Charset>() {
        public Charset initialValue() {
            return Charset.forName("UTF-8");
        }
    };

    /* renamed from: bb  reason: collision with root package name */
    protected ByteBuffer f52789bb;
    protected int bb_pos;
    Utf8 utf8 = Utf8.getDefault();
    protected int vtable_size;
    protected int vtable_start;

    public static boolean __has_identifier(ByteBuffer byteBuffer, String str) {
        if (str.length() == 4) {
            for (int i11 = 0; i11 < 4; i11++) {
                if (str.charAt(i11) != ((char) byteBuffer.get(byteBuffer.position() + 4 + i11))) {
                    return false;
                }
            }
            return true;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public static int compareStrings(int i11, int i12, ByteBuffer byteBuffer) {
        int i13 = i11 + byteBuffer.getInt(i11);
        int i14 = i12 + byteBuffer.getInt(i12);
        int i15 = byteBuffer.getInt(i13);
        int i16 = byteBuffer.getInt(i14);
        int i17 = i13 + 4;
        int i18 = i14 + 4;
        int min = Math.min(i15, i16);
        for (int i19 = 0; i19 < min; i19++) {
            int i21 = i19 + i17;
            int i22 = i19 + i18;
            if (byteBuffer.get(i21) != byteBuffer.get(i22)) {
                return byteBuffer.get(i21) - byteBuffer.get(i22);
            }
        }
        return i15 - i16;
    }

    public int __indirect(int i11) {
        return i11 + this.f52789bb.getInt(i11);
    }

    public int __offset(int i11) {
        if (i11 < this.vtable_size) {
            return this.f52789bb.getShort(this.vtable_start + i11);
        }
        return 0;
    }

    public void __reset() {
        this.f52789bb = null;
        this.bb_pos = 0;
        this.vtable_start = 0;
        this.vtable_size = 0;
    }

    public String __string(int i11) {
        int i12 = i11 + this.f52789bb.getInt(i11);
        return this.utf8.decodeUtf8(this.f52789bb, i12 + 4, this.f52789bb.getInt(i12));
    }

    public Table __union(Table table, int i11) {
        int i12 = i11 + this.bb_pos;
        int i13 = i12 + this.f52789bb.getInt(i12);
        table.bb_pos = i13;
        table.f52789bb = this.f52789bb;
        int i14 = i13 - this.f52789bb.getInt(i13);
        table.vtable_start = i14;
        table.vtable_size = this.f52789bb.getShort(i14);
        return table;
    }

    public int __vector(int i11) {
        int i12 = i11 + this.bb_pos;
        return i12 + this.f52789bb.getInt(i12) + 4;
    }

    public ByteBuffer __vector_as_bytebuffer(int i11, int i12) {
        int __offset = __offset(i11);
        if (__offset == 0) {
            return null;
        }
        ByteBuffer order = this.f52789bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int __vector = __vector(__offset);
        order.position(__vector);
        order.limit(__vector + (__vector_len(__offset) * i12));
        return order;
    }

    public ByteBuffer __vector_in_bytebuffer(ByteBuffer byteBuffer, int i11, int i12) {
        int __offset = __offset(i11);
        if (__offset == 0) {
            return null;
        }
        int __vector = __vector(__offset);
        byteBuffer.rewind();
        byteBuffer.limit((__vector_len(__offset) * i12) + __vector);
        byteBuffer.position(__vector);
        return byteBuffer;
    }

    public int __vector_len(int i11) {
        int i12 = i11 + this.bb_pos;
        return this.f52789bb.getInt(i12 + this.f52789bb.getInt(i12));
    }

    public ByteBuffer getByteBuffer() {
        return this.f52789bb;
    }

    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }

    public void sortTables(int[] iArr, final ByteBuffer byteBuffer) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            numArr[i11] = Integer.valueOf(iArr[i11]);
        }
        Arrays.sort(numArr, new Comparator<Integer>() {
            public int compare(Integer num, Integer num2) {
                return Table.this.keysCompare(num, num2, byteBuffer);
            }
        });
        for (int i12 = 0; i12 < iArr.length; i12++) {
            iArr[i12] = numArr[i12].intValue();
        }
    }

    public static int __indirect(int i11, ByteBuffer byteBuffer) {
        return i11 + byteBuffer.getInt(i11);
    }

    public static int __offset(int i11, int i12, ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity() - i12;
        return byteBuffer.getShort((i11 + capacity) - byteBuffer.getInt(capacity)) + capacity;
    }

    public static int compareStrings(int i11, byte[] bArr, ByteBuffer byteBuffer) {
        int i12 = i11 + byteBuffer.getInt(i11);
        int i13 = byteBuffer.getInt(i12);
        int length = bArr.length;
        int i14 = i12 + 4;
        int min = Math.min(i13, length);
        for (int i15 = 0; i15 < min; i15++) {
            int i16 = i15 + i14;
            if (byteBuffer.get(i16) != bArr[i15]) {
                return byteBuffer.get(i16) - bArr[i15];
            }
        }
        return i13 - length;
    }
}
