package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final /* synthetic */ class zzepj implements zzdeu {
    public final /* synthetic */ zzeox zza;
    public final /* synthetic */ zzbui zzb;

    public /* synthetic */ zzepj(zzeox zzeox, zzbui zzbui) {
        this.zza = zzeox;
        this.zzb = zzbui;
    }

    public final void zza(zzbew zzbew) {
        zzeox zzeox = this.zza;
        zzbui zzbui = this.zzb;
        zzeox.zza(zzbew);
        if (zzbui != null) {
            try {
                zzbui.zzf(zzbew);
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
        if (zzbui != null) {
            try {
                zzbui.zze(zzbew.zza);
            } catch (RemoteException e12) {
                zzciz.zzl("#007 Could not call remote method.", e12);
            }
        }
    }
}
