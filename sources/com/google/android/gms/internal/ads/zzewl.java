package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

public final class zzewl implements zzevn<zzewm> {
    private final Context zza;
    private final String zzb;
    private final zzfxb zzc;

    public zzewl(@Nullable zzcds zzcds, Context context, String str, zzfxb zzfxb) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzfxb;
    }

    public final zzfxa<zzewm> zzb() {
        return this.zzc.zzb(new zzewk(this));
    }
}
