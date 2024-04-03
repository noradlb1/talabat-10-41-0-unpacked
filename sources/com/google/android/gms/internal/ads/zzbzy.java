package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

final class zzbzy implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    final /* synthetic */ zzbzl zza;
    final /* synthetic */ zzbxn zzb;
    final /* synthetic */ zzbzz zzc;

    public zzbzy(zzbzz zzbzz, zzbzl zzbzl, zzbxn zzbxn) {
        this.zzc = zzbzz;
        this.zza = zzbzl;
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
        MediationRewardedAd mediationRewardedAd = (MediationRewardedAd) obj;
        if (mediationRewardedAd == null) {
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
                this.zzc.zzc = mediationRewardedAd;
                this.zza.zzg();
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
