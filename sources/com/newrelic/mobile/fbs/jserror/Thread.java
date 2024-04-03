package com.newrelic.mobile.fbs.jserror;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Thread extends Table {
    public static void addFrames(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(0, i11, 0);
    }

    public static int createFramesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createThread(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startObject(1);
        addFrames(flatBufferBuilder, i11);
        return endThread(flatBufferBuilder);
    }

    public static int endThread(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static Thread getRootAsThread(ByteBuffer byteBuffer) {
        return getRootAsThread(byteBuffer, new Thread());
    }

    public static void startFramesVector(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startVector(4, i11, 4);
    }

    public static void startThread(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(1);
    }

    public Thread __assign(int i11, ByteBuffer byteBuffer) {
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

    public Frame frames(int i11) {
        return frames(new Frame(), i11);
    }

    public int framesLength() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public static Thread getRootAsThread(ByteBuffer byteBuffer, Thread thread) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return thread.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public Frame frames(Frame frame, int i11) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return frame.__assign(__indirect(__vector(__offset) + (i11 * 4)), this.f52789bb);
        }
        return null;
    }
}
