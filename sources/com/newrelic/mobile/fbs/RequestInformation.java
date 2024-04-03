package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class RequestInformation extends Table {
    public static void addRequestAddress(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addInt(1, (int) j11, 0);
    }

    public static void addRequestTimestampMs(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(0, j11, 0);
    }

    public static int createRequestInformation(FlatBufferBuilder flatBufferBuilder, long j11, long j12) {
        flatBufferBuilder.startObject(2);
        addRequestTimestampMs(flatBufferBuilder, j11);
        addRequestAddress(flatBufferBuilder, j12);
        return endRequestInformation(flatBufferBuilder);
    }

    public static int endRequestInformation(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static RequestInformation getRootAsRequestInformation(ByteBuffer byteBuffer) {
        return getRootAsRequestInformation(byteBuffer, new RequestInformation());
    }

    public static void startRequestInformation(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(2);
    }

    public RequestInformation __assign(int i11, ByteBuffer byteBuffer) {
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

    public boolean mutateRequestAddress(long j11) {
        int __offset = __offset(6);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putInt(__offset + this.bb_pos, (int) j11);
        return true;
    }

    public boolean mutateRequestTimestampMs(long j11) {
        int __offset = __offset(4);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public long requestAddress() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return ((long) this.f52789bb.getInt(__offset + this.bb_pos)) & 4294967295L;
        }
        return 0;
    }

    public long requestTimestampMs() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public static RequestInformation getRootAsRequestInformation(ByteBuffer byteBuffer, RequestInformation requestInformation) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return requestInformation.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
