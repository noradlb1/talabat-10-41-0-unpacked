package com.newrelic.mobile.fbs.models;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class InteractionTrace extends Table {
    public static void addContent(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(5, i11, 0);
    }

    public static void addDuration(FlatBufferBuilder flatBufferBuilder, float f11) {
        flatBufferBuilder.addFloat(3, f11, 0.0d);
    }

    public static void addEnd(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(1, j11, 0);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(2, i11, 0);
    }

    public static void addProtocolVersion(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(4, i11, 0);
    }

    public static void addStart(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(0, j11, 0);
    }

    public static int createInteractionTrace(FlatBufferBuilder flatBufferBuilder, long j11, long j12, int i11, float f11, int i12, int i13) {
        flatBufferBuilder.startObject(6);
        addEnd(flatBufferBuilder, j12);
        addStart(flatBufferBuilder, j11);
        addContent(flatBufferBuilder, i13);
        addProtocolVersion(flatBufferBuilder, i12);
        addDuration(flatBufferBuilder, f11);
        addName(flatBufferBuilder, i11);
        return endInteractionTrace(flatBufferBuilder);
    }

    public static int endInteractionTrace(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static InteractionTrace getRootAsInteractionTrace(ByteBuffer byteBuffer) {
        return getRootAsInteractionTrace(byteBuffer, new InteractionTrace());
    }

    public static void startInteractionTrace(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(6);
    }

    public InteractionTrace __assign(int i11, ByteBuffer byteBuffer) {
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

    public String content() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer contentAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer contentInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public float duration() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return this.f52789bb.getFloat(__offset + this.bb_pos);
        }
        return 0.0f;
    }

    public long end() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public boolean mutateDuration(float f11) {
        int __offset = __offset(10);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putFloat(__offset + this.bb_pos, f11);
        return true;
    }

    public boolean mutateEnd(long j11) {
        int __offset = __offset(6);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public boolean mutateStart(long j11) {
        int __offset = __offset(4);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public String name() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public String protocolVersion() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer protocolVersionAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer protocolVersionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public long start() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public static InteractionTrace getRootAsInteractionTrace(ByteBuffer byteBuffer, InteractionTrace interactionTrace) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return interactionTrace.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
