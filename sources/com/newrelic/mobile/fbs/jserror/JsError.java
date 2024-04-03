package com.newrelic.mobile.fbs.jserror;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class JsError extends Table {
    public static void addBuildId(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(4, i11, 0);
    }

    public static void addBundleId(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(5, i11, 0);
    }

    public static void addFatal(FlatBufferBuilder flatBufferBuilder, boolean z11) {
        flatBufferBuilder.addBoolean(2, z11, false);
    }

    public static void addMessage(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(1, i11, 0);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(0, i11, 0);
    }

    public static void addThread(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(3, i11, 0);
    }

    public static int createJsError(FlatBufferBuilder flatBufferBuilder, int i11, int i12, boolean z11, int i13, int i14, int i15) {
        flatBufferBuilder.startObject(6);
        addBundleId(flatBufferBuilder, i15);
        addBuildId(flatBufferBuilder, i14);
        addThread(flatBufferBuilder, i13);
        addMessage(flatBufferBuilder, i12);
        addName(flatBufferBuilder, i11);
        addFatal(flatBufferBuilder, z11);
        return endJsError(flatBufferBuilder);
    }

    public static int endJsError(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static void finishJsErrorBuffer(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.finish(i11);
    }

    public static void finishSizePrefixedJsErrorBuffer(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.finishSizePrefixed(i11);
    }

    public static JsError getRootAsJsError(ByteBuffer byteBuffer) {
        return getRootAsJsError(byteBuffer, new JsError());
    }

    public static void startJsError(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(6);
    }

    public JsError __assign(int i11, ByteBuffer byteBuffer) {
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

    public String buildId() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer buildIdAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer buildIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public String bundleId() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer bundleIdAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer bundleIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public boolean fatal() {
        int __offset = __offset(8);
        return (__offset == 0 || this.f52789bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public String message() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer messageAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer messageInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public boolean mutateFatal(boolean z11) {
        int __offset = __offset(8);
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

    public Thread thread() {
        return thread(new Thread());
    }

    public static JsError getRootAsJsError(ByteBuffer byteBuffer, JsError jsError) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return jsError.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public Thread thread(Thread thread) {
        int __offset = __offset(10);
        if (__offset != 0) {
            return thread.__assign(__indirect(__offset + this.bb_pos), this.f52789bb);
        }
        return null;
    }
}
