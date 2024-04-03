package com.newrelic.mobile.fbs.jserror;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Frame extends Table {
    public static void addColumn(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addInt(3, i11, 0);
    }

    public static void addFileName(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(1, i11, 0);
    }

    public static void addLineNumber(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addInt(2, i11, 0);
    }

    public static void addMethod(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(0, i11, 0);
    }

    public static int createFrame(FlatBufferBuilder flatBufferBuilder, int i11, int i12, int i13, int i14) {
        flatBufferBuilder.startObject(4);
        addColumn(flatBufferBuilder, i14);
        addLineNumber(flatBufferBuilder, i13);
        addFileName(flatBufferBuilder, i12);
        addMethod(flatBufferBuilder, i11);
        return endFrame(flatBufferBuilder);
    }

    public static int endFrame(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static Frame getRootAsFrame(ByteBuffer byteBuffer) {
        return getRootAsFrame(byteBuffer, new Frame());
    }

    public static void startFrame(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(4);
    }

    public Frame __assign(int i11, ByteBuffer byteBuffer) {
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

    public int column() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return this.f52789bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public String fileName() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer fileNameAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer fileNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public int lineNumber() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return this.f52789bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public String method() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer methodAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer methodInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public boolean mutateColumn(int i11) {
        int __offset = __offset(10);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putInt(__offset + this.bb_pos, i11);
        return true;
    }

    public boolean mutateLineNumber(int i11) {
        int __offset = __offset(8);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putInt(__offset + this.bb_pos, i11);
        return true;
    }

    public static Frame getRootAsFrame(ByteBuffer byteBuffer, Frame frame) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return frame.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
