package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public final class zzcfm extends zzcff {
    private final RewardedAdLoadCallback zza;
    private final RewardedAd zzb;

    public zzcfm(RewardedAdLoadCallback rewardedAdLoadCallback, RewardedAd rewardedAd) {
        this.zza = rewardedAdLoadCallback;
        this.zzb = rewardedAd;
    }

    public final void zze(int i11) {
    }

    public final void zzf(zzbew zzbew) {
        if (this.zza != null) {
            this.zza.onAdFailedToLoad(zzbew.zzb());
        }
    }

    public final void zzg() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zza;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onAdLoaded(this.zzb);
        }
    }
}
