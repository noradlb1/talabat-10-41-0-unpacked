package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzciz;

@VisibleForTesting
final class zzc implements CustomEventNativeListener {
    private final CustomEventAdapter zza;
    private final MediationNativeListener zzb;

    public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
        this.zza = customEventAdapter;
        this.zzb = mediationNativeListener;
    }

    public final void onAdClicked() {
        zzciz.zze("Custom event adapter called onAdClicked.");
        this.zzb.onAdClicked(this.zza);
    }

    public final void onAdClosed() {
        zzciz.zze("Custom event adapter called onAdClosed.");
        this.zzb.onAdClosed(this.zza);
    }

    public final void onAdFailedToLoad(int i11) {
        zzciz.zze("Custom event adapter called onAdFailedToLoad.");
        this.zzb.onAdFailedToLoad((MediationNativeAdapter) this.zza, i11);
    }

    public final void onAdImpression() {
        zzciz.zze("Custom event adapter called onAdImpression.");
        this.zzb.onAdImpression(this.zza);
    }

    public final void onAdLeftApplication() {
        zzciz.zze("Custom event adapter called onAdLeftApplication.");
        this.zzb.onAdLeftApplication(this.zza);
    }

    public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        zzciz.zze("Custom event adapter called onAdLoaded.");
        this.zzb.onAdLoaded(this.zza, unifiedNativeAdMapper);
    }

    public final void onAdOpened() {
        zzciz.zze("Custom event adapter called onAdOpened.");
        this.zzb.onAdOpened(this.zza);
    }

    public final void onAdFailedToLoad(AdError adError) {
        zzciz.zze("Custom event adapter called onAdFailedToLoad.");
        this.zzb.onAdFailedToLoad((MediationNativeAdapter) this.zza, adError);
    }
}
