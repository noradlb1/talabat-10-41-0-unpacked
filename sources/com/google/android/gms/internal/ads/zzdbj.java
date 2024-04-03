package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzdbj {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzfxa<zzdbc> zzc;
    private volatile boolean zzd = true;

    public zzdbj(Executor executor, ScheduledExecutorService scheduledExecutorService, zzfxa<zzdbc> zzfxa) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzfxa;
    }

    public static /* bridge */ /* synthetic */ void zzb(zzdbj zzdbj, List list, zzfwm zzfwm) {
        if (list == null || list.isEmpty()) {
            zzdbj.zza.execute(new zzdbg(zzfwm));
            return;
        }
        zzfxa<O> zzi = zzfwq.zzi(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzi = zzfwq.zzn(zzfwq.zzg(zzi, Throwable.class, new zzdbe(zzfwm), zzdbj.zza), new zzdbd(zzdbj, zzfwm, (zzfxa) it.next()), zzdbj.zza);
        }
        zzfwq.zzr(zzi, new zzdbi(zzdbj, zzfwm), zzdbj.zza);
    }

    public final /* synthetic */ zzfxa zza(zzfwm zzfwm, zzfxa zzfxa, zzdav zzdav) throws Exception {
        if (zzdav != null) {
            zzfwm.zzb(zzdav);
        }
        return zzfwq.zzo(zzfxa, zzbni.zzb.zze().longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    public final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final void zze(zzfwm<zzdav> zzfwm) {
        zzfwq.zzr(this.zzc, new zzdbh(this, zzfwm), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
