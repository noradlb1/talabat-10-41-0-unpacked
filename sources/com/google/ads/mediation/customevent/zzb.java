package com.google.ads.mediation.customevent;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzciz;

@VisibleForTesting
final class zzb implements CustomEventInterstitialListener {
    final /* synthetic */ CustomEventAdapter zza;
    private final CustomEventAdapter zzb;
    private final MediationInterstitialListener zzc;

    public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
        this.zza = customEventAdapter;
        this.zzb = customEventAdapter2;
        this.zzc = mediationInterstitialListener;
    }

    public final void onDismissScreen() {
        zzciz.zze("Custom event adapter called onDismissScreen.");
        this.zzc.onDismissScreen(this.zzb);
    }

    public final void onFailedToReceiveAd() {
        zzciz.zze("Custom event adapter called onFailedToReceiveAd.");
        this.zzc.onFailedToReceiveAd(this.zzb, AdRequest.ErrorCode.NO_FILL);
    }

    public final void onLeaveApplication() {
        zzciz.zze("Custom event adapter called onLeaveApplication.");
        this.zzc.onLeaveApplication(this.zzb);
    }

    public final void onPresentScreen() {
        zzciz.zze("Custom event adapter called onPresentScreen.");
        this.zzc.onPresentScreen(this.zzb);
    }

    public final void onReceivedAd() {
        zzciz.zze("Custom event adapter called onReceivedAd.");
        this.zzc.onReceivedAd(this.zza);
    }
}
