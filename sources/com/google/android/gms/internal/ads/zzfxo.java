package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final class zzfxo extends zzfwz {
    final /* synthetic */ zzfxp zza;
    private final Callable zzb;

    public zzfxo(zzfxp zzfxp, Callable callable) {
        this.zza = zzfxp;
        callable.getClass();
        this.zzb = callable;
    }

    public final Object zza() throws Exception {
        return this.zzb.call();
    }

    public final String zzb() {
        return this.zzb.toString();
    }

    public final void zzd(Throwable th2) {
        this.zza.zzt(th2);
    }

    public final void zze(Object obj) {
        this.zza.zzs(obj);
    }

    public final boolean zzg() {
        return this.zza.isDone();
    }
}
