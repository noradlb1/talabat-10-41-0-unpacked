package com.google.ads.mediation.customevent;

import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzciz;

@VisibleForTesting
final class zza implements CustomEventBannerListener {
    private final CustomEventAdapter zza;
    private final MediationBannerListener zzb;

    public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
        this.zza = customEventAdapter;
        this.zzb = mediationBannerListener;
    }

    public final void onClick() {
        zzciz.zze("Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onClick(this.zza);
    }

    public final void onDismissScreen() {
        zzciz.zze("Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onDismissScreen(this.zza);
    }

    public final void onFailedToReceiveAd() {
        zzciz.zze("Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onFailedToReceiveAd(this.zza, AdRequest.ErrorCode.NO_FILL);
    }

    public final void onLeaveApplication() {
        zzciz.zze("Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onLeaveApplication(this.zza);
    }

    public final void onPresentScreen() {
        zzciz.zze("Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onPresentScreen(this.zza);
    }

    public final void onReceivedAd(View view) {
        zzciz.zze("Custom event adapter called onReceivedAd.");
        this.zza.zzc = view;
        this.zzb.onReceivedAd(this.zza);
    }
}
