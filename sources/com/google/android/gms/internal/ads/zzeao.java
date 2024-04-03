package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzeao implements zzdzy {
    /* access modifiers changed from: private */
    public final long zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public final zzead zzc;
    private final zzfde zzd;

    public zzeao(long j11, Context context, zzead zzead, zzcqm zzcqm, String str) {
        this.zza = j11;
        this.zzb = str;
        this.zzc = zzead;
        zzfdg zzx = zzcqm.zzx();
        zzx.zzb(context);
        zzx.zza(str);
        this.zzd = zzx.zzc().zza();
    }

    public final void zza() {
    }

    public final void zzb(zzbfd zzbfd) {
        try {
            this.zzd.zzf(zzbfd, new zzeam(this));
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zzc() {
        try {
            this.zzd.zzk(new zzean(this));
            this.zzd.zzm(ObjectWrapper.wrap(null));
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}
