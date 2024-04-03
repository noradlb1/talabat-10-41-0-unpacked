package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import com.google.android.gms.ads.nonagon.signalgeneration.zzx;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzeuu implements zzevn<zzeuv> {
    private final String zza;
    private final zzfxb zzb;
    private final ScheduledExecutorService zzc;
    private final Context zzd;
    private final zzfef zze;
    private final zzcqm zzf;

    public zzeuu(zzfxb zzfxb, ScheduledExecutorService scheduledExecutorService, String str, Context context, zzfef zzfef, zzcqm zzcqm) {
        this.zzb = zzfxb;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = context;
        this.zze = zzfef;
        this.zzf = zzcqm;
    }

    public static /* synthetic */ zzfxa zza(zzeuu zzeuu) {
        String str = zzeuu.zza;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfu)).booleanValue()) {
            str = AdFormat.UNKNOWN.name();
        }
        zzf zzq = zzeuu.zzf.zzq();
        zzdeb zzdeb = new zzdeb();
        zzdeb.zzc(zzeuu.zzd);
        zzfed zzfed = new zzfed();
        zzfed.zzs("adUnitId");
        zzfed.zzD(zzeuu.zze.zzd);
        zzfed.zzr(new zzbfi());
        zzdeb.zzf(zzfed.zzF());
        zzq.zza(zzdeb.zzg());
        zzx zzx = new zzx();
        zzx.zza(str);
        zzq.zzb(zzx.zzb());
        new zzdkc();
        return zzfwq.zzf(zzfwq.zzm((zzfwh) zzfwq.zzo(zzfwh.zzw(zzq.zzc().zza()), ((Long) zzbgq.zzc().zzb(zzblj.zzfv)).longValue(), TimeUnit.MILLISECONDS, zzeuu.zzc), zzeuq.zza, zzeuu.zzb), Exception.class, zzeur.zza, zzeuu.zzb);
    }

    public final zzfxa<zzeuv> zzb() {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzft)).booleanValue() || "adUnitId".equals(this.zze.zzf)) {
            return this.zzb.zzb(zzeut.zza);
        }
        return zzfwq.zzl(new zzeus(this), this.zzb);
    }
}
