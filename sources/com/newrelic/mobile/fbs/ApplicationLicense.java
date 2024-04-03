package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ApplicationLicense extends Table {
    public static ApplicationLicense __lookup_by_key(ApplicationLicense applicationLicense, int i11, String str, ByteBuffer byteBuffer) {
        byte[] bytes = str.getBytes(Table.UTF8_CHARSET.get());
        int i12 = byteBuffer.getInt(i11 - 4);
        int i13 = 0;
        while (i12 != 0) {
            int i14 = i12 / 2;
            int __indirect = Table.__indirect(((i13 + i14) * 4) + i11, byteBuffer);
            int compareStrings = Table.compareStrings(Table.__offset(4, byteBuffer.capacity() - __indirect, byteBuffer), bytes, byteBuffer);
            if (compareStrings > 0) {
                i12 = i14;
            } else if (compareStrings < 0) {
                int i15 = i14 + 1;
                i13 += i15;
                i12 -= i15;
            } else {
                if (applicationLicense == null) {
                    applicationLicense = new ApplicationLicense();
                }
                return applicationLicense.__assign(__indirect, byteBuffer);
            }
        }
        return null;
    }

    public static void addAccountId(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(1, j11, 0);
    }

    public static void addClusterAgentId(FlatBufferBuilder flatBufferBuilder, long j11) {
        flatBufferBuilder.addLong(2, j11, 0);
    }

    public static void addLicenseKey(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(0, i11, 0);
    }

    public static int createApplicationLicense(FlatBufferBuilder flatBufferBuilder, int i11, long j11, long j12) {
        flatBufferBuilder.startObject(3);
        addClusterAgentId(flatBufferBuilder, j12);
        addAccountId(flatBufferBuilder, j11);
        addLicenseKey(flatBufferBuilder, i11);
        return endApplicationLicense(flatBufferBuilder);
    }

    public static int endApplicationLicense(FlatBufferBuilder flatBufferBuilder) {
        int endObject = flatBufferBuilder.endObject();
        flatBufferBuilder.required(endObject, 4);
        return endObject;
    }

    public static ApplicationLicense getRootAsApplicationLicense(ByteBuffer byteBuffer) {
        return getRootAsApplicationLicense(byteBuffer, new ApplicationLicense());
    }

    public static void startApplicationLicense(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(3);
    }

    public ApplicationLicense __assign(int i11, ByteBuffer byteBuffer) {
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

    public long accountId() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public long clusterAgentId() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return this.f52789bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return Table.compareStrings(Table.__offset(4, num.intValue(), byteBuffer), Table.__offset(4, num2.intValue(), byteBuffer), byteBuffer);
    }

    public String licenseKey() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer licenseKeyAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer licenseKeyInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public boolean mutateAccountId(long j11) {
        int __offset = __offset(6);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public boolean mutateClusterAgentId(long j11) {
        int __offset = __offset(8);
        if (__offset == 0) {
            return false;
        }
        this.f52789bb.putLong(__offset + this.bb_pos, j11);
        return true;
    }

    public static ApplicationLicense getRootAsApplicationLicense(ByteBuffer byteBuffer, ApplicationLicense applicationLicense) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return applicationLicense.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
