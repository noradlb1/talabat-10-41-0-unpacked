package com.google.android.gms.internal.ads;

final class zzfxn extends zzfwz<zzfxa> {
    final /* synthetic */ zzfxp zza;
    private final zzfvw zzb;

    public zzfxn(zzfxp zzfxp, zzfvw zzfvw) {
        this.zza = zzfxp;
        zzfvw.getClass();
        this.zzb = zzfvw;
    }

    public final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzfxa zza2 = this.zzb.zza();
        zzfqg.zzd(zza2, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzb);
        return zza2;
    }

    public final String zzb() {
        return this.zzb.toString();
    }

    public final void zzd(Throwable th2) {
        this.zza.zzt(th2);
    }

    public final /* synthetic */ void zze(Object obj) {
        this.zza.zzu((zzfxa) obj);
    }

    public final boolean zzg() {
        return this.zza.isDone();
    }
}
