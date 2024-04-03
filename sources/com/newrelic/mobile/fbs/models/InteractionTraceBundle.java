package com.newrelic.mobile.fbs.models;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class InteractionTraceBundle extends Table {
    public static void addAccountId(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addInt(0, i11, 0);
    }

    public static void addAppId(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(1, j11, 0);
    }

    public static void addAppVersionId(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addInt(2, i11, 0);
    }

    public static void addCountryCode(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(3, i11, 0);
    }

    public static void addDevice(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(4, i11, 0);
    }

    public static void addDispatcher(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(7, i11, 0);
    }

    public static void addEntityGuid(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(6, i11, 0);
    }

    public static void addInteractionTraces(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(8, i11, 0);
    }

    public static void addOs(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(5, i11, 0);
    }

    public static int createInteractionTraceBundle(FlatBufferBuilder flatBufferBuilder, int i11, long j11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        flatBufferBuilder.startObject(9);
        addAppId(flatBufferBuilder, j11);
        addInteractionTraces(flatBufferBuilder, i18);
        addDispatcher(flatBufferBuilder, i17);
        addEntityGuid(flatBufferBuilder, i16);
        addOs(flatBufferBuilder, i15);
        addDevice(flatBufferBuilder, i14);
        addCountryCode(flatBufferBuilder, i13);
        addAppVersionId(flatBufferBuilder, i12);
        addAccountId(flatBufferBuilder, i11);
        return endInteractionTraceBundle(flatBufferBuilder);
    }

    public static int createInteractionTracesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int endInteractionTraceBundle(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static void finishInteractionTraceBundleBuffer(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.finish(i11);
    }

    public static void finishSizePrefixedInteractionTraceBundleBuffer(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.finishSizePrefixed(i11);
    }

    public static InteractionTraceBundle getRootAsInteractionTraceBundle(ByteBuffer byteBuffer) {
        return getRootAsInteractionTraceBundle(byteBuffer, new InteractionTraceBundle());
    }

    public static void startInteractionTraceBundle(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(9);
    }

    public static void startInteractionTracesVector(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startVector(4, i11, 4);
    }

    public InteractionTraceBundle __assign(int i11, ByteBuffer byteBuffer) {
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

    public int accountId() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.f52789bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public long appId() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public int appVersionId() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return this.f52789bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public String countryCode() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer countryCodeAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer countryCodeInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public String device() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer deviceAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer deviceInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public String dispatcher() {
        int __offset = __offset(18);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer dispatcherAsByteBuffer() {
        return __vector_as_bytebuffer(18, 1);
    }

    public ByteBuffer dispatcherInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 18, 1);
    }

    public String entityGuid() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer entityGuidAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public ByteBuffer entityGuidInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public InteractionTrace interactionTraces(int i11) {
        return interactionTraces(new InteractionTrace(), i11);
    }

    public int interactionTracesLength() {
        int __offset = __offset(20);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public boolean mutateAccountId(int i11) {
        int __offset = __offset(4);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putInt(__offset + this.bb_pos, i11);
        return true;
    }

    public boolean mutateAppId(long j11) {
        int __offset = __offset(6);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public boolean mutateAppVersionId(int i11) {
        int __offset = __offset(8);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putInt(__offset + this.bb_pos, i11);
        return true;
    }

    public String os() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer osAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer osInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public static InteractionTraceBundle getRootAsInteractionTraceBundle(ByteBuffer byteBuffer, InteractionTraceBundle interactionTraceBundle) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return interactionTraceBundle.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public InteractionTrace interactionTraces(InteractionTrace interactionTrace, int i11) {
        int __offset = __offset(20);
        if (__offset != 0) {
            return interactionTrace.__assign(__indirect(__vector(__offset) + (i11 * 4)), this.f52789bb);
        }
        return null;
    }
}
