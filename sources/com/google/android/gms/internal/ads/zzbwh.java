package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbwh {
    @VisibleForTesting
    static final zzbf<zzbuo> zza = new zzbwf();
    @VisibleForTesting
    static final zzbf<zzbuo> zzb = new zzbwg();
    private final zzbvt zzc;

    public zzbwh(Context context, zzcjf zzcjf, String str) {
        this.zzc = new zzbvt(context, zzcjf, str, zza, zzb);
    }

    public final <I, O> zzbvx<I, O> zza(String str, zzbwa<I> zzbwa, zzbvz<O> zzbvz) {
        return new zzbwl(this.zzc, str, zzbwa, zzbvz);
    }

    public final zzbwq zzb() {
        return new zzbwq(this.zzc);
    }
}
