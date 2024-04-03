package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzejl implements Callable {
    public final /* synthetic */ zzejn zza;
    public final /* synthetic */ zzfdz zzb;
    public final /* synthetic */ zzfdn zzc;

    public /* synthetic */ zzejl(zzejn zzejn, zzfdz zzfdz, zzfdn zzfdn) {
        this.zza = zzejn;
        this.zzb = zzfdz;
        this.zzc = zzfdn;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc);
    }
}
