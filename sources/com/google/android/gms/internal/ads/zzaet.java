package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;

final class zzaet implements zzwf {
    private final zzfk zza;
    private final zzfd zzb = new zzfd();
    private final int zzc;

    public zzaet(int i11, zzfk zzfk, int i12) {
        this.zzc = i11;
        this.zza = zzfk;
    }

    public final zzwe zza(zzwq zzwq, long j11) throws IOException {
        int zza2;
        int i11;
        long j12;
        long zze = zzwq.zze();
        int min = (int) Math.min(112800, zzwq.zzc() - zze);
        this.zzb.zzC(min);
        ((zzwk) zzwq).zzm(this.zzb.zzH(), 0, min, false);
        zzfd zzfd = this.zzb;
        int zzd = zzfd.zzd();
        long j13 = -1;
        long j14 = -1;
        long j15 = -9223372036854775807L;
        while (zzfd.zza() >= 188 && (i11 = zza2 + 188) <= zzd) {
            long zzb2 = zzaff.zzb(zzfd, (zza2 = zzaff.zza(zzfd.zzH(), zzfd.zzc(), zzd)), this.zzc);
            if (zzb2 != C.TIME_UNSET) {
                long zzb3 = this.zza.zzb(zzb2);
                if (zzb3 > j11) {
                    if (j15 == C.TIME_UNSET) {
                        return zzwe.zzd(zzb3, zze);
                    }
                    j12 = zze + j14;
                } else if (100000 + zzb3 > j11) {
                    j12 = zze + ((long) zza2);
                } else {
                    j14 = (long) zza2;
                    j15 = zzb3;
                }
                return zzwe.zze(j12);
            }
            zzfd.zzF(i11);
            j13 = (long) i11;
        }
        if (j15 != C.TIME_UNSET) {
            return zzwe.zzf(j15, zze + j13);
        }
        return zzwe.zza;
    }

    public final void zzb() {
        zzfd zzfd = this.zzb;
        byte[] bArr = zzfn.zzf;
        int length = bArr.length;
        zzfd.zzD(bArr, 0);
    }
}
