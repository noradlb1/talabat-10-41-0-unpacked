package com.newrelic.mobile.fbs.hex;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import com.newrelic.mobile.fbs.ios.Library;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class HandledException extends Table {
    public static void addAppUuidHigh(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(1, j11, 0);
    }

    public static void addAppUuidLow(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(0, j11, 0);
    }

    public static void addCause(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(6, i11, 0);
    }

    public static void addLibraries(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(8, i11, 0);
    }

    public static void addMessage(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(5, i11, 0);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(4, i11, 0);
    }

    public static void addSessionId(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(2, i11, 0);
    }

    public static void addThreads(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(7, i11, 0);
    }

    public static void addTimestampMs(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(3, j11, 0);
    }

    public static int createHandledException(FlatBufferBuilder flatBufferBuilder, long j11, long j12, int i11, long j13, int i12, int i13, int i14, int i15, int i16) {
        flatBufferBuilder.startObject(9);
        addTimestampMs(flatBufferBuilder, j13);
        addAppUuidHigh(flatBufferBuilder, j12);
        addAppUuidLow(flatBufferBuilder, j11);
        addLibraries(flatBufferBuilder, i16);
        addThreads(flatBufferBuilder, i15);
        addCause(flatBufferBuilder, i14);
        addMessage(flatBufferBuilder, i13);
        addName(flatBufferBuilder, i12);
        addSessionId(flatBufferBuilder, i11);
        return endHandledException(flatBufferBuilder);
    }

    public static int createLibrariesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createThreadsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int endHandledException(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static void finishHandledExceptionBuffer(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.finish(i11);
    }

    public static void finishSizePrefixedHandledExceptionBuffer(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.finishSizePrefixed(i11);
    }

    public static HandledException getRootAsHandledException(ByteBuffer byteBuffer) {
        return getRootAsHandledException(byteBuffer, new HandledException());
    }

    public static void startHandledException(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(9);
    }

    public static void startLibrariesVector(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startVector(4, i11, 4);
    }

    public static void startThreadsVector(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startVector(4, i11, 4);
    }

    public HandledException __assign(int i11, ByteBuffer byteBuffer) {
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

    public long appUuidHigh() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public long appUuidLow() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public String cause() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer causeAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public ByteBuffer causeInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public Library libraries(int i11) {
        return libraries(new Library(), i11);
    }

    public int librariesLength() {
        int __offset = __offset(20);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public String message() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer messageAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer messageInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public boolean mutateAppUuidHigh(long j11) {
        int __offset = __offset(6);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public boolean mutateAppUuidLow(long j11) {
        int __offset = __offset(4);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public boolean mutateTimestampMs(long j11) {
        int __offset = __offset(10);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public String name() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public String sessionId() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer sessionIdAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer sessionIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public Thread threads(int i11) {
        return threads(new Thread(), i11);
    }

    public int threadsLength() {
        int __offset = __offset(18);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public long timestampMs() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public static HandledException getRootAsHandledException(ByteBuffer byteBuffer, HandledException handledException) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return handledException.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public Library libraries(Library library2, int i11) {
        int __offset = __offset(20);
        if (__offset != 0) {
            return library2.__assign(__indirect(__vector(__offset) + (i11 * 4)), this.f52789bb);
        }
        return null;
    }

    public Thread threads(Thread thread, int i11) {
        int __offset = __offset(18);
        if (__offset != 0) {
            return thread.__assign(__indirect(__vector(__offset) + (i11 * 4)), this.f52789bb);
        }
        return null;
    }
}
