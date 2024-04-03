package com.newrelic.mobile.fbs.hex;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Frame extends Table {
    public static void addAddress(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(5, j11, 0);
    }

    public static void addClassName(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(1, i11, 0);
    }

    public static void addFileName(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(3, i11, 0);
    }

    public static void addLineNumber(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(4, j11, 0);
    }

    public static void addMethodName(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(2, i11, 0);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(0, i11, 0);
    }

    public static int createFrame(FlatBufferBuilder flatBufferBuilder, int i11, int i12, int i13, int i14, long j11, long j12) {
        flatBufferBuilder.startObject(6);
        addAddress(flatBufferBuilder, j12);
        addLineNumber(flatBufferBuilder, j11);
        addFileName(flatBufferBuilder, i14);
        addMethodName(flatBufferBuilder, i13);
        addClassName(flatBufferBuilder, i12);
        addValue(flatBufferBuilder, i11);
        return endFrame(flatBufferBuilder);
    }

    public static int endFrame(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static Frame getRootAsFrame(ByteBuffer byteBuffer) {
        return getRootAsFrame(byteBuffer, new Frame());
    }

    public static void startFrame(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(6);
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

    public long address() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public String className() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer classNameAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer classNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public String fileName() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer fileNameAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer fileNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public long lineNumber() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public String methodName() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer methodNameAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer methodNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public boolean mutateAddress(long j11) {
        int __offset = __offset(14);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public boolean mutateLineNumber(long j11) {
        int __offset = __offset(12);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public String value() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer valueAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer valueInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public static Frame getRootAsFrame(ByteBuffer byteBuffer, Frame frame) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return frame.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
