package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcyq extends zzazs {
    private final zzcyp zza;
    private final zzbhk zzb;
    private final zzezj zzc;
    private boolean zzd = false;

    public zzcyq(zzcyp zzcyp, zzbhk zzbhk, zzezj zzezj) {
        this.zza = zzcyp;
        this.zzb = zzbhk;
        this.zzc = zzezj;
    }

    public final zzbhk zze() {
        return this.zzb;
    }

    public final zzbiw zzf() {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfi)).booleanValue()) {
            return null;
        }
        return this.zza.zzl();
    }

    public final void zzg(boolean z11) {
        this.zzd = z11;
    }

    public final void zzh(zzbit zzbit) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        zzezj zzezj = this.zzc;
        if (zzezj != null) {
            zzezj.zzp(zzbit);
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzbaa zzbaa) {
        try {
            this.zzc.zzs(zzbaa);
            this.zza.zzd((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzbaa, this.zzd);
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zzj(zzazx zzazx) {
    }
}
