package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzfjz {
    private boolean zza;

    public final void zza(Context context) {
        zzfli.zzb(context, "Application Context cannot be null");
        if (!this.zza) {
            this.zza = true;
            zzfkw.zzb().zzc(context);
            zzfkr.zza().zzc(context);
            zzflg.zzf(context);
            zzfkt.zzb().zzc(context);
        }
    }

    public final boolean zzb() {
        return this.zza;
    }
}
