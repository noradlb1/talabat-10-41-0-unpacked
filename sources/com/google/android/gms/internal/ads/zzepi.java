package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzepi {
    private final zzepn<zzdav> zza;
    private final String zzb;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzbiw zzc;

    public zzepi(zzepn<zzdav> zzepn, String str) {
        this.zza = zzepn;
        this.zzb = str;
    }

    public final synchronized String zza() {
        String str;
        str = null;
        try {
            zzbiw zzbiw = this.zzc;
            if (zzbiw != null) {
                str = zzbiw.zze();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            return null;
        }
        return str;
    }

    public final synchronized String zzb() {
        String str;
        str = null;
        try {
            zzbiw zzbiw = this.zzc;
            if (zzbiw != null) {
                str = zzbiw.zze();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            return null;
        }
        return str;
    }

    public final synchronized void zzd(zzbfd zzbfd, int i11) throws RemoteException {
        this.zzc = null;
        this.zza.zzb(zzbfd, this.zzb, new zzepo(i11), new zzeph(this));
    }

    public final synchronized boolean zze() throws RemoteException {
        return this.zza.zza();
    }
}
