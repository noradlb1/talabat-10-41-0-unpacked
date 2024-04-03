package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzcgv implements Callable {
    public final /* synthetic */ zzchh zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzcgv(zzchh zzchh, Context context) {
        this.zza = zzchh;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zzg(this.zzb);
    }
}
