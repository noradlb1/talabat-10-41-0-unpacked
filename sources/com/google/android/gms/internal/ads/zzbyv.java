package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

final class zzbyv implements Runnable {
    final /* synthetic */ AdRequest.ErrorCode zza;
    final /* synthetic */ zzbyx zzb;

    public zzbyv(zzbyx zzbyx, AdRequest.ErrorCode errorCode) {
        this.zzb = zzbyx;
        this.zza = errorCode;
    }

    public final void run() {
        try {
            this.zzb.zza.zzg(zzbyy.zza(this.zza));
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}
