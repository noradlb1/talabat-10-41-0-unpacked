package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzt;
import java.io.InputStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzedb {
    private final ScheduledExecutorService zza;
    private final zzfxb zzb;
    private final zzedt zzc;
    private final zzgpl<zzefh> zzd;

    public zzedb(ScheduledExecutorService scheduledExecutorService, zzfxb zzfxb, zzedt zzedt, zzgpl<zzefh> zzgpl) {
        this.zza = scheduledExecutorService;
        this.zzb = zzfxb;
        this.zzc = zzedt;
        this.zzd = zzgpl;
    }

    public final /* synthetic */ zzfxa zza(zzcdq zzcdq, int i11, Throwable th2) throws Exception {
        return this.zzd.zzb().zzd(zzcdq, i11);
    }

    public final zzfxa<InputStream> zzb(zzcdq zzcdq) {
        zzfxa zzfxa;
        String str = zzcdq.zzd;
        zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzG(str)) {
            zzfxa = zzfwq.zzh(new zzeeg(1));
        } else {
            zzedt zzedt = this.zzc;
            synchronized (zzedt.zzb) {
                if (zzedt.zzc) {
                    zzfxa = zzedt.zza;
                } else {
                    zzedt.zzc = true;
                    zzedt.zze = zzcdq;
                    zzedt.zzf.checkAvailabilityAndConnect();
                    zzedt.zza.zzc(new zzeds(zzedt), zzcjm.zzf);
                    zzfxa = zzedt.zza;
                }
            }
        }
        int callingUid = Binder.getCallingUid();
        zzfwh zzw = zzfwh.zzw(zzfxa);
        long intValue = (long) ((Integer) zzbgq.zzc().zzb(zzblj.zzdW)).intValue();
        return zzfwq.zzg((zzfwh) zzfwq.zzo(zzw, intValue, TimeUnit.SECONDS, this.zza), Throwable.class, new zzeda(this, zzcdq, callingUid), this.zzb);
    }
}
