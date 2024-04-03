package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzepb implements zzbes, zzdmd {
    @GuardedBy("this")
    private zzbgu zza;

    public final synchronized void onAdClicked() {
        zzbgu zzbgu = this.zza;
        if (zzbgu != null) {
            try {
                zzbgu.zzb();
            } catch (RemoteException e11) {
                zzciz.zzk("Remote Exception at onAdClicked.", e11);
            }
        }
    }

    public final synchronized void zza(zzbgu zzbgu) {
        this.zza = zzbgu;
    }

    public final synchronized void zzq() {
        zzbgu zzbgu = this.zza;
        if (zzbgu != null) {
            try {
                zzbgu.zzb();
            } catch (RemoteException e11) {
                zzciz.zzk("Remote Exception at onPhysicalClick.", e11);
            }
        }
    }
}
