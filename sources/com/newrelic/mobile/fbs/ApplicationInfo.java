package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ApplicationInfo extends Table {
    public static void addAppVersion(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(2, i11, 0);
    }

    public static void addAppVersionId(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(3, j11, 0);
    }

    public static void addApplicationLicense(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(0, i11, 0);
    }

    public static void addFramework(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addByte(4, (byte) i11, 0);
    }

    public static void addPlatform(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addByte(1, (byte) i11, 0);
    }

    public static int createApplicationInfo(FlatBufferBuilder flatBufferBuilder, int i11, int i12, int i13, long j11, int i14) {
        flatBufferBuilder.startObject(5);
        addAppVersionId(flatBufferBuilder, j11);
        addAppVersion(flatBufferBuilder, i13);
        addApplicationLicense(flatBufferBuilder, i11);
        addFramework(flatBufferBuilder, i14);
        addPlatform(flatBufferBuilder, i12);
        return endApplicationInfo(flatBufferBuilder);
    }

    public static int endApplicationInfo(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static ApplicationInfo getRootAsApplicationInfo(ByteBuffer byteBuffer) {
        return getRootAsApplicationInfo(byteBuffer, new ApplicationInfo());
    }

    public static void startApplicationInfo(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(5);
    }

    public ApplicationInfo __assign(int i11, ByteBuffer byteBuffer) {
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

    public String appVersion() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer appVersionAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public long appVersionId() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public ByteBuffer appVersionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public ApplicationLicense applicationLicense() {
        return applicationLicense(new ApplicationLicense());
    }

    public int framework() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return this.f52789bb.get(__offset + this.bb_pos) & 255;
        }
        return 0;
    }

    public boolean mutateAppVersionId(long j11) {
        int __offset = __offset(10);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public boolean mutateFramework(int i11) {
        int __offset = __offset(12);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.put(__offset + this.bb_pos, (byte) i11);
        return true;
    }

    public boolean mutatePlatform(int i11) {
        int __offset = __offset(6);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.put(__offset + this.bb_pos, (byte) i11);
        return true;
    }

    public int platform() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.f52789bb.get(__offset + this.bb_pos) & 255;
        }
        return 0;
    }

    public static ApplicationInfo getRootAsApplicationInfo(ByteBuffer byteBuffer, ApplicationInfo applicationInfo) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return applicationInfo.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public ApplicationLicense applicationLicense(ApplicationLicense applicationLicense) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return applicationLicense.__assign(__indirect(__offset + this.bb_pos), this.f52789bb);
        }
        return null;
    }
}
