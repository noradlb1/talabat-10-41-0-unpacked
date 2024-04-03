package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class LongSessionAttribute extends Table {
    public static LongSessionAttribute __lookup_by_key(LongSessionAttribute longSessionAttribute, int i11, String str, ByteBuffer byteBuffer) {
        byte[] bytes = str.getBytes(Table.UTF8_CHARSET.get());
        int i12 = byteBuffer.getInt(i11 - 4);
        int i13 = 0;
        while (i12 != 0) {
            int i14 = i12 / 2;
            int __indirect = Table.__indirect(((i13 + i14) * 4) + i11, byteBuffer);
            int compareStrings = Table.compareStrings(Table.__offset(4, byteBuffer.capacity() - __indirect, byteBuffer), bytes, byteBuffer);
            if (compareStrings > 0) {
                i12 = i14;
            } else if (compareStrings < 0) {
                int i15 = i14 + 1;
                i13 += i15;
                i12 -= i15;
            } else {
                if (longSessionAttribute == null) {
                    longSessionAttribute = new LongSessionAttribute();
                }
                return longSessionAttribute.__assign(__indirect, byteBuffer);
            }
        }
        return null;
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(0, i11, 0);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(1, j11, 0);
    }

    public static int createLongSessionAttribute(FlatBufferBuilder flatBufferBuilder, int i11, long j11) {
        flatBufferBuilder.startObject(2);
        addValue(flatBufferBuilder, j11);
        addName(flatBufferBuilder, i11);
        return endLongSessionAttribute(flatBufferBuilder);
    }

    public static int endLongSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        int endObject = flatBufferBuilder.endObject();
        flatBufferBuilder.required(endObject, 4);
        return endObject;
    }

    public static LongSessionAttribute getRootAsLongSessionAttribute(ByteBuffer byteBuffer) {
        return getRootAsLongSessionAttribute(byteBuffer, new LongSessionAttribute());
    }

    public static void startLongSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(2);
    }

    public LongSessionAttribute __assign(int i11, ByteBuffer byteBuffer) {
        __init(i11, byteBuffer);
        return this;
    }

    public void __init(int i11, ByteBuffer byteBuffer) {
        this.bb_pos = i11;
        this.f52789bb = byteBuffer;
        int i12 = i11 - byteBuffer.getInt(i11);
        this.vtable_start = i12;
        this.vtable_size = this.f52789bb.getShort(i12);
    }

    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return Table.compareStrings(Table.__offset(4, num.intValue(), byteBuffer), Table.__offset(4, num2.intValue(), byteBuffer), byteBuffer);
    }

    public boolean mutateValue(long j11) {
        int __offset = __offset(6);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public String name() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public long value() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public static LongSessionAttribute getRootAsLongSessionAttribute(ByteBuffer byteBuffer, LongSessionAttribute longSessionAttribute) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return longSessionAttribute.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
