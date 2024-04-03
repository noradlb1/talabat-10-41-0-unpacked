package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzafk implements zzafj {
    private final zzws zza;
    private final zzxt zzb;
    private final zzafm zzc;
    private final zzab zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzafk(zzws zzws, zzxt zzxt, zzafm zzafm, String str, int i11) throws zzbj {
        this.zza = zzws;
        this.zzb = zzxt;
        this.zzc = zzafm;
        int i12 = (zzafm.zzb * zzafm.zze) / 8;
        int i13 = zzafm.zzd;
        if (i13 == i12) {
            int i14 = zzafm.zzc * i12;
            int i15 = i14 * 8;
            int max = Math.max(i12, i14 / 10);
            this.zze = max;
            zzz zzz = new zzz();
            zzz.zzS(str);
            zzz.zzv(i15);
            zzz.zzO(i15);
            zzz.zzL(max);
            zzz.zzw(zzafm.zzb);
            zzz.zzT(zzafm.zzc);
            zzz.zzN(i11);
            this.zzd = zzz.zzY();
            return;
        }
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("Expected block size: ");
        sb2.append(i12);
        sb2.append("; got: ");
        sb2.append(i13);
        throw zzbj.zza(sb2.toString(), (Throwable) null);
    }

    public final void zza(int i11, long j11) {
        this.zza.zzL(new zzafp(this.zzc, 1, (long) i11, j11));
        this.zzb.zzk(this.zzd);
    }

    public final void zzb(long j11) {
        this.zzf = j11;
        this.zzg = 0;
        this.zzh = 0;
    }

    public final boolean zzc(zzwq zzwq, long j11) throws IOException {
        int i11;
        int i12;
        int i13;
        long j12 = j11;
        while (true) {
            i11 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
            if (i11 <= 0 || (i12 = this.zzg) >= (i13 = this.zze)) {
                zzafm zzafm = this.zzc;
                int i14 = zzafm.zzd;
                int i15 = this.zzg / i14;
            } else {
                int zza2 = zzxr.zza(this.zzb, zzwq, (int) Math.min((long) (i13 - i12), j12), true);
                if (zza2 == -1) {
                    j12 = 0;
                } else {
                    this.zzg += zza2;
                    j12 -= (long) zza2;
                }
            }
        }
        zzafm zzafm2 = this.zzc;
        int i142 = zzafm2.zzd;
        int i152 = this.zzg / i142;
        if (i152 > 0) {
            long j13 = this.zzf;
            long zzt = zzfn.zzt(this.zzh, 1000000, (long) zzafm2.zzc);
            int i16 = i152 * i142;
            int i17 = this.zzg - i16;
            this.zzb.zzs(j13 + zzt, 1, i16, i17, (zzxs) null);
            this.zzh += (long) i152;
            this.zzg = i17;
        }
        if (i11 <= 0) {
            return true;
        }
        return false;
    }
}
