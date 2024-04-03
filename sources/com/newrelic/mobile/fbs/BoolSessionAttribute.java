package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class BoolSessionAttribute extends Table {
    public static BoolSessionAttribute __lookup_by_key(BoolSessionAttribute boolSessionAttribute, int i11, String str, ByteBuffer byteBuffer) {
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
                if (boolSessionAttribute == null) {
                    boolSessionAttribute = new BoolSessionAttribute();
                }
                return boolSessionAttribute.__assign(__indirect, byteBuffer);
            }
        }
        return null;
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(0, i11, 0);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, boolean z11) {
        flatBufferBuilder.addBoolean(1, z11, false);
    }

    public static int createBoolSessionAttribute(FlatBufferBuilder flatBufferBuilder, int i11, boolean z11) {
        flatBufferBuilder.startObject(2);
        addName(flatBufferBuilder, i11);
        addValue(flatBufferBuilder, z11);
        return endBoolSessionAttribute(flatBufferBuilder);
    }

    public static int endBoolSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        int endObject = flatBufferBuilder.endObject();
        flatBufferBuilder.required(endObject, 4);
        return endObject;
    }

    public static BoolSessionAttribute getRootAsBoolSessionAttribute(ByteBuffer byteBuffer) {
        return getRootAsBoolSessionAttribute(byteBuffer, new BoolSessionAttribute());
    }

    public static void startBoolSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(2);
    }

    public BoolSessionAttribute __assign(int i11, ByteBuffer byteBuffer) {
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

    public boolean mutateValue(boolean z11) {
        int __offset = __offset(6);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.put(__offset + this.bb_pos, z11 ? (byte) 1 : 0);
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

    public boolean value() {
        int __offset = __offset(6);
        return (__offset == 0 || this.f52789bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public static BoolSessionAttribute getRootAsBoolSessionAttribute(ByteBuffer byteBuffer, BoolSessionAttribute boolSessionAttribute) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return boolSessionAttribute.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
