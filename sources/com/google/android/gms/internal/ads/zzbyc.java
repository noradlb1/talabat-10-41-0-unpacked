package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;

final class zzbyc implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    final /* synthetic */ zzbxn zza;
    final /* synthetic */ zzbyg zzb;

    public zzbyc(zzbyg zzbyg, zzbxn zzbxn) {
        this.zzb = zzbyg;
        this.zza = zzbxn;
    }

    public final void onFailure(AdError adError) {
        try {
            String canonicalName = this.zzb.zza.getClass().getCanonicalName();
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 87 + String.valueOf(message).length() + String.valueOf(domain).length());
            sb2.append(canonicalName);
            sb2.append("failed to loaded mediation ad: ErrorCode = ");
            sb2.append(code);
            sb2.append(". ErrorMessage = ");
            sb2.append(message);
            sb2.append(". ErrorDomain = ");
            sb2.append(domain);
            zzciz.zze(sb2.toString());
            this.zza.zzh(adError.zza());
            this.zza.zzi(adError.getCode(), adError.getMessage());
            this.zza.zzg(adError.getCode());
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        try {
            this.zzb.zze = ((MediationBannerAd) obj).getView();
            this.zza.zzo();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
        return new zzbxy(this.zza);
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, AdError.UNDEFINED_DOMAIN));
    }
}
