package com.newrelic.mobile.fbs.ios;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Library extends Table {
    public static void addAddress(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(2, j11, 0);
    }

    public static void addArch(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addByte(4, (byte) i11, 0);
    }

    public static void addPath(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(6, i11, 0);
    }

    public static void addSize(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(5, j11, 0);
    }

    public static void addUserLibrary(FlatBufferBuilder flatBufferBuilder, boolean z11) {
        flatBufferBuilder.addBoolean(3, z11, false);
    }

    public static void addUuidHigh(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(1, j11, 0);
    }

    public static void addUuidLow(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(0, j11, 0);
    }

    public static int createLibrary(FlatBufferBuilder flatBufferBuilder, long j11, long j12, long j13, boolean z11, int i11, long j14, int i12) {
        flatBufferBuilder.startObject(7);
        addSize(flatBufferBuilder, j14);
        addAddress(flatBufferBuilder, j13);
        addUuidHigh(flatBufferBuilder, j12);
        addUuidLow(flatBufferBuilder, j11);
        addPath(flatBufferBuilder, i12);
        addArch(flatBufferBuilder, i11);
        addUserLibrary(flatBufferBuilder, z11);
        return endLibrary(flatBufferBuilder);
    }

    public static int endLibrary(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static void finishLibraryBuffer(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.finish(i11);
    }

    public static void finishSizePrefixedLibraryBuffer(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.finishSizePrefixed(i11);
    }

    public static Library getRootAsLibrary(ByteBuffer byteBuffer) {
        return getRootAsLibrary(byteBuffer, new Library());
    }

    public static void startLibrary(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(7);
    }

    public Library __assign(int i11, ByteBuffer byteBuffer) {
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
        int __offset = __offset(8);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public int arch() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return this.f52789bb.get(__offset + this.bb_pos) & 255;
        }
        return 0;
    }

    public boolean mutateAddress(long j11) {
        int __offset = __offset(8);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public boolean mutateArch(int i11) {
        int __offset = __offset(12);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.put(__offset + this.bb_pos, (byte) i11);
        return true;
    }

    public boolean mutateSize(long j11) {
        int __offset = __offset(14);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public boolean mutateUserLibrary(boolean z11) {
        int __offset = __offset(10);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.put(__offset + this.bb_pos, z11 ? (byte) 1 : 0);
        return true;
    }

    public boolean mutateUuidHigh(long j11) {
        int __offset = __offset(6);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public boolean mutateUuidLow(long j11) {
        int __offset = __offset(4);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public String path() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer pathAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public ByteBuffer pathInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public long size() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public boolean userLibrary() {
        int __offset = __offset(10);
        return (__offset == 0 || this.f52789bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public long uuidHigh() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public long uuidLow() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public static Library getRootAsLibrary(ByteBuffer byteBuffer, Library library2) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return library2.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
