package com.google.android.gms.internal.ads;

import android.content.Context;

public final /* synthetic */ class zzeln implements zzdob {
    public final /* synthetic */ zzehw zza;

    public /* synthetic */ zzeln(zzehw zzehw) {
        this.zza = zzehw;
    }

    public final void zza(boolean z11, Context context, zzdfe zzdfe) {
        zzehw zzehw = this.zza;
        try {
            ((zzfev) zzehw.zzb).zzu(z11);
            ((zzfev) zzehw.zzb).zzx(context);
        } catch (zzfek e11) {
            throw new zzdoa(e11.getCause());
        }
    }
}
