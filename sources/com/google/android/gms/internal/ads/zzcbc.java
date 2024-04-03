package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

public final class zzcbc extends zzbpv {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzcbc(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    public final void zze(zzbqf zzbqf) {
        this.zza.onNativeAdLoaded(new zzcav(zzbqf));
    }
}
