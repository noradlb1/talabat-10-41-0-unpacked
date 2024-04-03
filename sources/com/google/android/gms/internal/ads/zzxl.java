package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public final class zzxl {
    public static List<byte[]> zza(byte[] bArr) {
        byte b11 = bArr[11];
        byte b12 = bArr[10];
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(zzc(zzb((long) (((b11 & 255) << 8) | (b12 & 255)))));
        arrayList.add(zzc(zzb(3840)));
        return arrayList;
    }

    private static long zzb(long j11) {
        return (j11 * C.NANOS_PER_SECOND) / 48000;
    }

    private static byte[] zzc(long j11) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j11).array();
    }
}
