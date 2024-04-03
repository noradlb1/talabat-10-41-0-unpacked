package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class HexAgentDataBundle extends Table {
    public static void addHexAgentData(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(0, i11, 0);
    }

    public static int createHexAgentDataBundle(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startObject(1);
        addHexAgentData(flatBufferBuilder, i11);
        return endHexAgentDataBundle(flatBufferBuilder);
    }

    public static int createHexAgentDataVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int endHexAgentDataBundle(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static void finishHexAgentDataBundleBuffer(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.finish(i11);
    }

    public static void finishSizePrefixedHexAgentDataBundleBuffer(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.finishSizePrefixed(i11);
    }

    public static HexAgentDataBundle getRootAsHexAgentDataBundle(ByteBuffer byteBuffer) {
        return getRootAsHexAgentDataBundle(byteBuffer, new HexAgentDataBundle());
    }

    public static void startHexAgentDataBundle(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(1);
    }

    public static void startHexAgentDataVector(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startVector(4, i11, 4);
    }

    public HexAgentDataBundle __assign(int i11, ByteBuffer byteBuffer) {
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

    public HexAgentData hexAgentData(int i11) {
        return hexAgentData(new HexAgentData(), i11);
    }

    public int hexAgentDataLength() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public static HexAgentDataBundle getRootAsHexAgentDataBundle(ByteBuffer byteBuffer, HexAgentDataBundle hexAgentDataBundle) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return hexAgentDataBundle.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public HexAgentData hexAgentData(HexAgentData hexAgentData, int i11) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return hexAgentData.__assign(__indirect(__vector(__offset) + (i11 * 4)), this.f52789bb);
        }
        return null;
    }
}
