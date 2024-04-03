package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

public final class zzer {
    public static void zza(MediaFormat mediaFormat, String str, int i11) {
        if (i11 != -1) {
            mediaFormat.setInteger(str, i11);
        }
    }

    public static void zzb(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            StringBuilder sb2 = new StringBuilder(15);
            sb2.append("csd-");
            sb2.append(i11);
            mediaFormat.setByteBuffer(sb2.toString(), ByteBuffer.wrap(list.get(i11)));
        }
    }
}
