package com.google.android.gms.internal.ads;

import android.content.Context;

public final /* synthetic */ class zzemg implements zzdob {
    public final /* synthetic */ zzehw zza;

    public /* synthetic */ zzemg(zzehw zzehw) {
        this.zza = zzehw;
    }

    public final void zza(boolean z11, Context context, zzdfe zzdfe) {
        zzehw zzehw = this.zza;
        try {
            ((zzfev) zzehw.zzb).zzu(z11);
            ((zzfev) zzehw.zzb).zzy();
        } catch (zzfek e11) {
            zzciz.zzk("Cannot show rewarded video.", e11);
            throw new zzdoa(e11.getCause());
        }
    }
}
