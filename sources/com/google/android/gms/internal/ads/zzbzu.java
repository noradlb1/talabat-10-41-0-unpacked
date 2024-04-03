package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;

final class zzbzu implements MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> {
    final /* synthetic */ zzbzc zza;
    final /* synthetic */ zzbxn zzb;

    public zzbzu(zzbzz zzbzz, zzbzc zzbzc, zzbxn zzbxn) {
        this.zza = zzbzc;
        this.zzb = zzbxn;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzf(adError.zza());
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        MediationInterscrollerAd mediationInterscrollerAd = (MediationInterscrollerAd) obj;
        if (mediationInterscrollerAd == null) {
            zzciz.zzj("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zza.zze("Adapter returned null.");
                return null;
            } catch (RemoteException e11) {
                zzciz.zzh("", e11);
                return null;
            }
        } else {
            try {
                this.zza.zzh(new zzbyh(mediationInterscrollerAd));
            } catch (RemoteException e12) {
                zzciz.zzh("", e12);
            }
            return new zzcaa(this.zzb);
        }
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, AdError.UNDEFINED_DOMAIN));
    }
}
