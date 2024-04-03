package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzboc implements NativeCustomTemplateAd.DisplayOpenMeasurement {
    private final zzbpc zza;

    public zzboc(zzbpc zzbpc) {
        this.zza = zzbpc;
        try {
            zzbpc.zzl();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final void setView(View view) {
        try {
            this.zza.zzo(ObjectWrapper.wrap(view));
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final boolean start() {
        try {
            return this.zza.zzr();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
            return false;
        }
    }
}
