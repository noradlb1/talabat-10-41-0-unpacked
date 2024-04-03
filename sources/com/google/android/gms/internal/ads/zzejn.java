package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzejn implements zzeht<zzcyw> {
    /* access modifiers changed from: private */
    public final zzczt zza;
    private final zzeiu zzb;
    private final zzfxb zzc;
    /* access modifiers changed from: private */
    public final zzdet zzd;
    private final ScheduledExecutorService zze;

    public zzejn(zzczt zzczt, zzeiu zzeiu, zzdet zzdet, ScheduledExecutorService scheduledExecutorService, zzfxb zzfxb) {
        this.zza = zzczt;
        this.zzb = zzeiu;
        this.zzd = zzdet;
        this.zze = scheduledExecutorService;
        this.zzc = zzfxb;
    }

    public final zzfxa<zzcyw> zza(zzfdz zzfdz, zzfdn zzfdn) {
        return this.zzc.zzb(new zzejl(this, zzfdz, zzfdn));
    }

    public final boolean zzb(zzfdz zzfdz, zzfdn zzfdn) {
        if (zzfdz.zza.zza.zza() == null || !this.zzb.zzb(zzfdz, zzfdn)) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ zzcyw zzc(zzfdz zzfdz, zzfdn zzfdn) throws Exception {
        return this.zza.zzb(new zzdbk(zzfdz, zzfdn, (String) null), new zzdag(zzfdz.zza.zza.zza(), new zzejk(this, zzfdz, zzfdn))).zza();
    }

    public final /* synthetic */ void zzf(zzfdz zzfdz, zzfdn zzfdn) {
        zzfwq.zzr(zzfwq.zzo(this.zzb.zza(zzfdz, zzfdn), (long) zzfdn.zzO, TimeUnit.SECONDS, this.zze), new zzejm(this), this.zzc);
    }
}
