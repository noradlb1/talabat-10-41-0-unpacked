package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.OpusUtil;

public final class zzawn {
    private static final byte[] zza = {0, 0, 0, 1};
    private static final int[] zzb = {96000, 88200, 64000, OpusUtil.SAMPLE_RATE, 44100, 32000, 24000, 22050, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> zza(byte[] bArr) {
        boolean z11;
        zzawt zzawt = new zzawt(bArr, bArr.length);
        int zzc2 = zzc(zzawt);
        int zzd = zzd(zzawt);
        int zza2 = zzawt.zza(4);
        if (zzc2 == 5 || zzc2 == 29) {
            zzd = zzd(zzawt);
            if (zzc(zzawt) == 22) {
                zza2 = zzawt.zza(4);
            }
        }
        int i11 = zzc[zza2];
        if (i11 != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzawm.zzc(z11);
        return Pair.create(Integer.valueOf(zzd), Integer.valueOf(i11));
    }

    public static byte[] zzb(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[(i12 + 4)];
        System.arraycopy(zza, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i11, bArr2, 4, i12);
        return bArr2;
    }

    private static int zzc(zzawt zzawt) {
        int zza2 = zzawt.zza(5);
        if (zza2 == 31) {
            return zzawt.zza(6) + 32;
        }
        return zza2;
    }

    private static int zzd(zzawt zzawt) {
        boolean z11;
        int zza2 = zzawt.zza(4);
        if (zza2 == 15) {
            return zzawt.zza(24);
        }
        if (zza2 < 13) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzawm.zzc(z11);
        return zzb[zza2];
    }
}
