package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzecl implements Callable {
    public final /* synthetic */ zzalt zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzecl(zzalt zzalt, Context context) {
        this.zza = zzalt;
        this.zzb = context;
    }

    public final Object call() {
        zzalt zzalt = this.zza;
        return zzalt.zzc().zzg(this.zzb);
    }
}
