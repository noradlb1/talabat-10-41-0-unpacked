package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

public final class zzdvi extends VideoController.VideoLifecycleCallbacks {
    private final zzdqc zza;

    public zzdvi(zzdqc zzdqc) {
        this.zza = zzdqc;
    }

    private static zzbjc zza(zzdqc zzdqc) {
        zzbiz zzj = zzdqc.zzj();
        if (zzj == null) {
            return null;
        }
        try {
            return zzj.zzi();
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void onVideoEnd() {
        zzbjc zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zze();
            } catch (RemoteException e11) {
                zzciz.zzk("Unable to call onVideoEnd()", e11);
            }
        }
    }

    public final void onVideoPause() {
        zzbjc zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zzg();
            } catch (RemoteException e11) {
                zzciz.zzk("Unable to call onVideoEnd()", e11);
            }
        }
    }

    public final void onVideoStart() {
        zzbjc zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zzi();
            } catch (RemoteException e11) {
                zzciz.zzk("Unable to call onVideoEnd()", e11);
            }
        }
    }
}
