package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbuj<AdT> extends AdManagerInterstitialAd {
    private final Context zza;
    private final zzbfh zzb = zzbfh.zza;
    private final zzbhk zzc;
    private final String zzd;
    private final zzbxe zze;
    @Nullable
    private AppEventListener zzf;
    @Nullable
    private FullScreenContentCallback zzg;
    @Nullable
    private OnPaidEventListener zzh;

    public zzbuj(Context context, String str) {
        zzbxe zzbxe = new zzbxe();
        this.zze = zzbxe;
        this.zza = context;
        this.zzd = str;
        this.zzc = zzbgo.zza().zze(context, new zzbfi(), str, zzbxe);
    }

    public final String getAdUnitId() {
        return this.zzd;
    }

    @Nullable
    public final AppEventListener getAppEventListener() {
        return this.zzf;
    }

    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzg;
    }

    @Nullable
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzh;
    }

    @NonNull
    public final ResponseInfo getResponseInfo() {
        zzbiw zzbiw = null;
        try {
            zzbhk zzbhk = this.zzc;
            if (zzbhk != null) {
                zzbiw = zzbhk.zzk();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
        return ResponseInfo.zzb(zzbiw);
    }

    public final void setAppEventListener(@Nullable AppEventListener appEventListener) {
        zzayo zzayo;
        try {
            this.zzf = appEventListener;
            zzbhk zzbhk = this.zzc;
            if (zzbhk != null) {
                if (appEventListener != null) {
                    zzayo = new zzayo(appEventListener);
                } else {
                    zzayo = null;
                }
                zzbhk.zzG(zzayo);
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzg = fullScreenContentCallback;
            zzbhk zzbhk = this.zzc;
            if (zzbhk != null) {
                zzbhk.zzJ(new zzbgr(fullScreenContentCallback));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void setImmersiveMode(boolean z11) {
        try {
            zzbhk zzbhk = this.zzc;
            if (zzbhk != null) {
                zzbhk.zzL(z11);
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzh = onPaidEventListener;
            zzbhk zzbhk = this.zzc;
            if (zzbhk != null) {
                zzbhk.zzP(new zzbkj(onPaidEventListener));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void show(@NonNull Activity activity) {
        if (activity == null) {
            zzciz.zzj("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            zzbhk zzbhk = this.zzc;
            if (zzbhk != null) {
                zzbhk.zzW(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zza(zzbjg zzbjg, AdLoadCallback<AdT> adLoadCallback) {
        try {
            if (this.zzc != null) {
                this.zze.zzd(zzbjg.zzr());
                this.zzc.zzy(this.zzb.zza(this.zza, zzbjg), new zzbez(adLoadCallback, this));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            adLoadCallback.onAdFailedToLoad(new LoadAdError(0, "Internal Error.", MobileAds.ERROR_DOMAIN, (AdError) null, (ResponseInfo) null));
        }
    }
}
