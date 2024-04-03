package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

public final class zzcfs extends zzcff {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzcft zzb;

    public zzcfs(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzcft zzcft) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzcft;
    }

    public final void zze(int i11) {
    }

    public final void zzf(zzbew zzbew) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zzbew.zzb());
        }
    }

    public final void zzg() {
        zzcft zzcft;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null && (zzcft = this.zzb) != null) {
            rewardedInterstitialAdLoadCallback.onAdLoaded(zzcft);
        }
    }
}
