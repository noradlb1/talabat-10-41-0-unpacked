package com.google.android.gms.internal.ads;

public final class zzdvv implements zzgpr<zzbbg> {
    private final zzgqe<zzfef> zza;

    public zzdvv(zzgqe<zzfef> zzgqe) {
        this.zza = zzgqe;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbbg zzbbg;
        if (((zzdei) this.zza).zza().zzo.zza == 3) {
            zzbbg = zzbbg.REWARDED_INTERSTITIAL;
        } else {
            zzbbg = zzbbg.REWARD_BASED_VIDEO_AD;
        }
        zzgpz.zzb(zzbbg);
        return zzbbg;
    }
}
