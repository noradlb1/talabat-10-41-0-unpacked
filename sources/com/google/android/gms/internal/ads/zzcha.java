package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

public final /* synthetic */ class zzcha implements zzchg {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzcha(Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    public final void zza(zzcqg zzcqg) {
        Context context = this.zza;
        zzcqg.zzs(ObjectWrapper.wrap(context), this.zzb, context.getPackageName());
    }
}
