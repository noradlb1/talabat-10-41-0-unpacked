package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class StringSessionAttribute extends Table {
    public static StringSessionAttribute __lookup_by_key(StringSessionAttribute stringSessionAttribute, int i11, String str, ByteBuffer byteBuffer) {
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
                if (stringSessionAttribute == null) {
                    stringSessionAttribute = new StringSessionAttribute();
                }
                return stringSessionAttribute.__assign(__indirect, byteBuffer);
            }
        }
        return null;
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(0, i11, 0);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(1, i11, 0);
    }

    public static int createStringSessionAttribute(FlatBufferBuilder flatBufferBuilder, int i11, int i12) {
        flatBufferBuilder.startObject(2);
        addValue(flatBufferBuilder, i12);
        addName(flatBufferBuilder, i11);
        return endStringSessionAttribute(flatBufferBuilder);
    }

    public static int endStringSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        int endObject = flatBufferBuilder.endObject();
        flatBufferBuilder.required(endObject, 4);
        return endObject;
    }

    public static StringSessionAttribute getRootAsStringSessionAttribute(ByteBuffer byteBuffer) {
        return getRootAsStringSessionAttribute(byteBuffer, new StringSessionAttribute());
    }

    public static void startStringSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(2);
    }

    public StringSessionAttribute __assign(int i11, ByteBuffer byteBuffer) {
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

    public String value() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer valueAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer valueInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public static StringSessionAttribute getRootAsStringSessionAttribute(ByteBuffer byteBuffer, StringSessionAttribute stringSessionAttribute) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return stringSessionAttribute.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
