package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

final class zzbzx implements SignalCallbacks {
    final /* synthetic */ zzbzr zza;

    public zzbzx(zzbzz zzbzz, zzbzr zzbzr) {
        this.zza = zzbzr;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzg(adError.zza());
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final void onSuccess(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zza.zzf(str);
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }
}
