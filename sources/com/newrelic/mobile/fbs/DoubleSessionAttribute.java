package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class DoubleSessionAttribute extends Table {
    public static DoubleSessionAttribute __lookup_by_key(DoubleSessionAttribute doubleSessionAttribute, int i11, String str, ByteBuffer byteBuffer) {
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
                if (doubleSessionAttribute == null) {
                    doubleSessionAttribute = new DoubleSessionAttribute();
                }
                return doubleSessionAttribute.__assign(__indirect, byteBuffer);
            }
        }
        return null;
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(0, i11, 0);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, double d11) {
        flatBufferBuilder.addDouble(1, d11, 0.0d);
    }

    public static int createDoubleSessionAttribute(FlatBufferBuilder flatBufferBuilder, int i11, double d11) {
        flatBufferBuilder.startObject(2);
        addValue(flatBufferBuilder, d11);
        addName(flatBufferBuilder, i11);
        return endDoubleSessionAttribute(flatBufferBuilder);
    }

    public static int endDoubleSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        int endObject = flatBufferBuilder.endObject();
        flatBufferBuilder.required(endObject, 4);
        return endObject;
    }

    public static DoubleSessionAttribute getRootAsDoubleSessionAttribute(ByteBuffer byteBuffer) {
        return getRootAsDoubleSessionAttribute(byteBuffer, new DoubleSessionAttribute());
    }

    public static void startDoubleSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(2);
    }

    public DoubleSessionAttribute __assign(int i11, ByteBuffer byteBuffer) {
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

    public boolean mutateValue(double d11) {
        int __offset = __offset(6);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putDouble(__offset + this.bb_pos, d11);
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

    public double value() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.f52789bb.getDouble(__offset + this.bb_pos);
        }
        return 0.0d;
    }

    public static DoubleSessionAttribute getRootAsDoubleSessionAttribute(ByteBuffer byteBuffer, DoubleSessionAttribute doubleSessionAttribute) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return doubleSessionAttribute.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
