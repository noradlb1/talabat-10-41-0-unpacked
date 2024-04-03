package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbew;
import com.google.android.gms.internal.ads.zzbim;

final class zzax extends zzbim {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzba zzb;

    public zzax(zzba zzba, Context context) {
        this.zzb = zzba;
        this.zza = context;
    }

    public final void zze(@Nullable zzbew zzbew) {
        if (zzbew != null) {
            this.zzb.zzi(this.zza, zzbew.zzb, true, true);
        }
    }
}
