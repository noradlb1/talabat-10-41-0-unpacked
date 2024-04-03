package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbxy implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationNativeAdCallback {
    private final zzbxn zza;

    public zzbxy(zzbxn zzbxn) {
        this.zza = zzbxn;
    }

    public final void onAdClosed() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdFailedToShow(@NonNull AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdFailedToShow.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 87 + String.valueOf(domain).length());
        sb2.append("Mediation ad failed to show: Error Code = ");
        sb2.append(code);
        sb2.append(". Error Message = ");
        sb2.append(message);
        sb2.append(" Error Domain = ");
        sb2.append(domain);
        zzciz.zzj(sb2.toString());
        try {
            this.zza.zzk(adError.zza());
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdLeftApplication() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzn();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdOpened() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onVideoComplete() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onVideoComplete.");
        try {
            this.zza.zzu();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onVideoPause.");
        try {
            this.zza.zzw();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onVideoPlay() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onVideoPlay.");
        try {
            this.zza.zzx();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onVideoUnmute() {
    }

    public final void reportAdClicked() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called reportAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void reportAdImpression() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called reportAdImpression.");
        try {
            this.zza.zzm();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdFailedToShow(String str) {
        String str2;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdFailedToShow.");
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Mediation ad failed to show: ".concat(valueOf);
        } else {
            str2 = new String("Mediation ad failed to show: ");
        }
        zzciz.zzj(str2);
        try {
            this.zza.zzl(str);
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}
