package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzexw implements zzevn<zzexx> {
    private final zzcik zza;
    private final boolean zzb;
    private final ScheduledExecutorService zzc;
    private final zzfxb zzd;
    private final String zze;
    private final zzcia zzf;

    public zzexw(zzcik zzcik, boolean z11, zzcia zzcia, zzfxb zzfxb, String str, ScheduledExecutorService scheduledExecutorService, byte[] bArr) {
        this.zza = zzcik;
        this.zzb = z11;
        this.zzf = zzcia;
        this.zzd = zzfxb;
        this.zze = str;
        this.zzc = scheduledExecutorService;
    }

    public final /* synthetic */ zzexx zza(Exception exc) {
        this.zza.zzs(exc, "TrustlessTokenSignal");
        return null;
    }

    public final zzfxa<zzexx> zzb() {
        if (!zzbnj.zza.zze().booleanValue() && !this.zzb) {
            return zzfwq.zzi(null);
        }
        return zzfwq.zzf(zzfwq.zzo(zzfwq.zzm(zzfwq.zzi(null), zzexv.zza, this.zzd), zzbnj.zzc.zze().longValue(), TimeUnit.MILLISECONDS, this.zzc), Exception.class, new zzexu(this), this.zzd);
    }
}
