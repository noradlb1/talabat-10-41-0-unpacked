package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzt;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class zzech {
    private final zzfxb zza;
    private final zzfxb zzb;
    private final zzedp zzc;
    private final zzgpl<zzefh> zzd;

    public zzech(zzfxb zzfxb, zzfxb zzfxb2, zzedp zzedp, zzgpl<zzefh> zzgpl) {
        this.zza = zzfxb;
        this.zzb = zzfxb2;
        this.zzc = zzedp;
        this.zzd = zzgpl;
    }

    public final /* synthetic */ zzfxa zza(zzcdq zzcdq, int i11, zzeeg zzeeg) throws Exception {
        return this.zzd.zzb().zzc(zzcdq, i11);
    }

    public final zzfxa<InputStream> zzb(zzcdq zzcdq) {
        zzfxa<V> zzfxa;
        String str = zzcdq.zzd;
        zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzG(str)) {
            zzfxa = zzfwq.zzh(new zzeeg(1));
        } else {
            zzfxa = zzfwq.zzg(this.zza.zzb(new zzecg(this, zzcdq)), ExecutionException.class, zzecf.zza, this.zzb);
        }
        return zzfwq.zzg(zzfxa, zzeeg.class, new zzece(this, zzcdq, Binder.getCallingUid()), this.zzb);
    }

    public final /* synthetic */ InputStream zzc(zzcdq zzcdq) throws Exception {
        zzcjr<InputStream> zzcjr;
        zzedp zzedp = this.zzc;
        synchronized (zzedp.zzb) {
            if (zzedp.zzc) {
                zzcjr = zzedp.zza;
            } else {
                zzedp.zzc = true;
                zzedp.zze = zzcdq;
                zzedp.zzf.checkAvailabilityAndConnect();
                zzedp.zza.zzc(new zzedo(zzedp), zzcjm.zzf);
                zzcjr = zzedp.zza;
            }
        }
        return (InputStream) zzcjr.get((long) ((Integer) zzbgq.zzc().zzb(zzblj.zzdW)).intValue(), TimeUnit.SECONDS);
    }
}
