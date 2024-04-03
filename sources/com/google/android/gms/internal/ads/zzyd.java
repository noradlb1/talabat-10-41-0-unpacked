package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzyd implements zzwf {
    private final zzxd zza;
    private final int zzb;
    private final zzwx zzc = new zzwx();

    public /* synthetic */ zzyd(zzxd zzxd, int i11, zzyc zzyc) {
        this.zza = zzxd;
        this.zzb = i11;
    }

    private final long zzc(zzwq zzwq) throws IOException {
        while (zzwq.zzd() < zzwq.zzc() - 6) {
            zzxd zzxd = this.zza;
            int i11 = this.zzb;
            zzwx zzwx = this.zzc;
            long zzd = zzwq.zzd();
            byte[] bArr = new byte[2];
            zzwk zzwk = (zzwk) zzwq;
            zzwk.zzm(bArr, 0, 2, false);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i11) {
                zzwq.zzj();
                zzwk.zzl((int) (zzd - zzwq.zze()), false);
            } else {
                zzfd zzfd = new zzfd(16);
                System.arraycopy(bArr, 0, zzfd.zzH(), 0, 2);
                zzfd.zzE(zzwt.zza(zzwq, zzfd.zzH(), 2, 14));
                zzwq.zzj();
                zzwk.zzl((int) (zzd - zzwq.zze()), false);
                if (zzwy.zzc(zzfd, zzxd, i11, zzwx)) {
                    break;
                }
            }
            zzwk.zzl(1, false);
        }
        if (zzwq.zzd() < zzwq.zzc() - 6) {
            return this.zzc.zza;
        }
        ((zzwk) zzwq).zzl((int) (zzwq.zzc() - zzwq.zzd()), false);
        return this.zza.zzj;
    }

    public final zzwe zza(zzwq zzwq, long j11) throws IOException {
        long zze = zzwq.zze();
        long zzc2 = zzc(zzwq);
        long zzd = zzwq.zzd();
        ((zzwk) zzwq).zzl(Math.max(6, this.zza.zzc), false);
        long zzc3 = zzc(zzwq);
        long zzd2 = zzwq.zzd();
        if (zzc2 <= j11 && zzc3 > j11) {
            return zzwe.zze(zzd);
        }
        if (zzc3 <= j11) {
            return zzwe.zzf(zzc3, zzd2);
        }
        return zzwe.zzd(zzc2, zze);
    }

    public final /* synthetic */ void zzb() {
    }
}
