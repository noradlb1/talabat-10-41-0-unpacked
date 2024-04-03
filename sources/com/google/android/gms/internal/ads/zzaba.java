package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzaba {
    private static final long[] zza = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] zzb = new byte[8];
    private int zzc;
    private int zzd;

    public static int zzb(int i11) {
        int i12 = 0;
        while (i12 < 8) {
            int i13 = ((zza[i12] & ((long) i11)) > 0 ? 1 : ((zza[i12] & ((long) i11)) == 0 ? 0 : -1));
            i12++;
            if (i13 != 0) {
                return i12;
            }
        }
        return -1;
    }

    public static long zzc(byte[] bArr, int i11, boolean z11) {
        long j11 = ((long) bArr[0]) & 255;
        if (z11) {
            j11 &= ~zza[i11 - 1];
        }
        for (int i12 = 1; i12 < i11; i12++) {
            j11 = (j11 << 8) | (((long) bArr[i12]) & 255);
        }
        return j11;
    }

    public final int zza() {
        return this.zzd;
    }

    public final long zzd(zzwq zzwq, boolean z11, boolean z12, int i11) throws IOException {
        if (this.zzc == 0) {
            if (!zzwq.zzn(this.zzb, 0, 1, z11)) {
                return -1;
            }
            int zzb2 = zzb(this.zzb[0] & 255);
            this.zzd = zzb2;
            if (zzb2 != -1) {
                this.zzc = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i12 = this.zzd;
        if (i12 > i11) {
            this.zzc = 0;
            return -2;
        }
        if (i12 != 1) {
            ((zzwk) zzwq).zzn(this.zzb, 1, i12 - 1, false);
        }
        this.zzc = 0;
        return zzc(this.zzb, this.zzd, z12);
    }

    public final void zze() {
        this.zzc = 0;
        this.zzd = 0;
    }
}
