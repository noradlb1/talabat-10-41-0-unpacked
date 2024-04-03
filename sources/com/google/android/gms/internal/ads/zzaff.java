package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

public final class zzaff {
    public static int zza(byte[] bArr, int i11, int i12) {
        while (i11 < i12 && bArr[i11] != 71) {
            i11++;
        }
        return i11;
    }

    public static long zzb(zzfd zzfd, int i11, int i12) {
        zzfd.zzF(i11);
        if (zzfd.zza() < 5) {
            return C.TIME_UNSET;
        }
        int zze = zzfd.zze();
        if ((8388608 & zze) != 0 || ((zze >> 8) & 8191) != i12 || (zze & 32) == 0 || zzfd.zzk() < 7 || zzfd.zza() < 7 || (zzfd.zzk() & 16) != 16) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[6];
        zzfd.zzB(bArr, 0, 6);
        byte b11 = bArr[0];
        byte b12 = bArr[1];
        byte b13 = bArr[2];
        long j11 = ((long) bArr[3]) & 255;
        return ((((long) b12) & 255) << 17) | ((((long) b11) & 255) << 25) | ((((long) b13) & 255) << 9) | (j11 + j11) | ((((long) bArr[4]) & 255) >> 7);
    }
}
