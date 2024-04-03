package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

public final class zzbkj extends zzbis {
    @Nullable
    private final OnPaidEventListener zza;

    public zzbkj(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zza = onPaidEventListener;
    }

    public final void zze(zzbfk zzbfk) {
        if (this.zza != null) {
            this.zza.onPaidEvent(AdValue.zza(zzbfk.zzb, zzbfk.zzc, zzbfk.zzd));
        }
    }
}
