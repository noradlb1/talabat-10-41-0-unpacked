package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzpf implements zzrn {
    public final zzrn zza;
    final /* synthetic */ zzpg zzb;
    private boolean zzc;

    public zzpf(zzpg zzpg, zzrn zzrn) {
        this.zzb = zzpg;
        this.zza = zzrn;
    }

    public final int zza(zzhr zzhr, zzda zzda, int i11) {
        if (this.zzb.zzp()) {
            return -3;
        }
        if (this.zzc) {
            zzda.zzc(4);
            return -4;
        }
        int zza2 = this.zza.zza(zzhr, zzda, i11);
        if (zza2 == -5) {
            zzab zzab = zzhr.zza;
            zzab.getClass();
            int i12 = zzab.zzC;
            int i13 = 0;
            if (i12 == 0) {
                if (zzab.zzD != 0) {
                    i12 = 0;
                }
                return -5;
            }
            if (this.zzb.zzb == Long.MIN_VALUE) {
                i13 = zzab.zzD;
            }
            zzz zzb2 = zzab.zzb();
            zzb2.zzC(i12);
            zzb2.zzD(i13);
            zzhr.zza = zzb2.zzY();
            return -5;
        }
        zzpg zzpg = this.zzb;
        long j11 = zzpg.zzb;
        if (j11 == Long.MIN_VALUE || ((zza2 != -4 || zzda.zzd < j11) && (zza2 != -3 || zzpg.zzb() != Long.MIN_VALUE || zzda.zzc))) {
            return zza2;
        }
        zzda.zzb();
        zzda.zzc(4);
        this.zzc = true;
        return -4;
    }

    public final int zzb(long j11) {
        if (this.zzb.zzp()) {
            return -3;
        }
        return this.zza.zzb(j11);
    }

    public final void zzc() {
        this.zzc = false;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return !this.zzb.zzp() && this.zza.zze();
    }
}
