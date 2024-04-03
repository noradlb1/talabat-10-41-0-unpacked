package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;

final class zzbjh extends zzbgp {
    final /* synthetic */ zzbji zza;

    public zzbjh(zzbji zzbji) {
        this.zza = zzbji;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zza.zze.zzb(this.zza.zzi());
        super.onAdFailedToLoad(loadAdError);
    }

    public final void onAdLoaded() {
        this.zza.zze.zzb(this.zza.zzi());
        super.onAdLoaded();
    }
}
