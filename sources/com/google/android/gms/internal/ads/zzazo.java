package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.appopen.AppOpenAd;

public final class zzazo extends zzazv {
    @Nullable
    private final AppOpenAd.AppOpenAdLoadCallback zza;
    private final String zzb;

    public zzazo(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback, String str) {
        this.zza = appOpenAdLoadCallback;
        this.zzb = str;
    }

    public final void zzb(int i11) {
    }

    public final void zzc(zzbew zzbew) {
        if (this.zza != null) {
            this.zza.onAdFailedToLoad(zzbew.zzb());
        }
    }

    public final void zzd(zzazt zzazt) {
        if (this.zza != null) {
            this.zza.onAdLoaded(new zzazp(zzazt, this.zzb));
        }
    }
}
