package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;

final class zzbya implements MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> {
    final /* synthetic */ zzbxn zza;
    final /* synthetic */ Adapter zzb;
    final /* synthetic */ zzbyg zzc;

    public zzbya(zzbyg zzbyg, zzbxn zzbxn, Adapter adapter) {
        this.zzc = zzbyg;
        this.zza = zzbxn;
        this.zzb = adapter;
    }

    public final void onFailure(@NonNull AdError adError) {
        try {
            String canonicalName = this.zzb.getClass().getCanonicalName();
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 85 + String.valueOf(message).length() + String.valueOf(domain).length());
            sb2.append(canonicalName);
            sb2.append("failed to load mediation ad: ErrorCode = ");
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
            this.zzc.zzi = (MediationInterscrollerAd) obj;
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
