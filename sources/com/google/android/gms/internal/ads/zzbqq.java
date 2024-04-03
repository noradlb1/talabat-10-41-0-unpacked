package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

public final class zzbqq extends zzbpv {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zza;

    public zzbqq(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zza = onUnifiedNativeAdLoadedListener;
    }

    public final void zze(zzbqf zzbqf) {
        this.zza.onUnifiedNativeAdLoaded(new zzbqg(zzbqf));
    }
}
