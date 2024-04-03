package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

public final class zzaeh implements zzaeq {
    private zzab zza;
    private zzfk zzb;
    private zzxt zzc;

    public zzaeh(String str) {
        zzz zzz = new zzz();
        zzz.zzS(str);
        this.zza = zzz.zzY();
    }

    public final void zza(zzfd zzfd) {
        zzdy.zzb(this.zzb);
        int i11 = zzfn.zza;
        long zzd = this.zzb.zzd();
        long zze = this.zzb.zze();
        if (zzd != C.TIME_UNSET && zze != C.TIME_UNSET) {
            zzab zzab = this.zza;
            if (zze != zzab.zzq) {
                zzz zzb2 = zzab.zzb();
                zzb2.zzW(zze);
                zzab zzY = zzb2.zzY();
                this.zza = zzY;
                this.zzc.zzk(zzY);
            }
            int zza2 = zzfd.zza();
            zzxr.zzb(this.zzc, zzfd, zza2);
            this.zzc.zzs(zzd, 1, zza2, 0, (zzxs) null);
        }
    }

    public final void zzb(zzfk zzfk, zzws zzws, zzafd zzafd) {
        this.zzb = zzfk;
        zzafd.zzc();
        zzxt zzv = zzws.zzv(zzafd.zza(), 5);
        this.zzc = zzv;
        zzv.zzk(this.zza);
    }
}
