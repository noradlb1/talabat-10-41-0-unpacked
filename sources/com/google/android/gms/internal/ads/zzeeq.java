package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzt;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public final class zzeeq {
    private final zzfxb zza;
    private final zzedx zzb;
    private final zzgpl<zzefh> zzc;

    public zzeeq(zzfxb zzfxb, zzedx zzedx, zzgpl<zzefh> zzgpl) {
        this.zza = zzfxb;
        this.zzb = zzedx;
        this.zzc = zzgpl;
    }

    private final <RetT> zzfxa<RetT> zzg(zzcdq zzcdq, zzeep<InputStream> zzeep, zzeep<InputStream> zzeep2, zzfvx<InputStream, RetT> zzfvx) {
        zzfxa<V> zzfxa;
        String str = zzcdq.zzd;
        zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzG(str)) {
            zzfxa = zzfwq.zzh(new zzeeg(1));
        } else {
            zzfxa = zzfwq.zzg(zzeep.zza(zzcdq), ExecutionException.class, zzeeo.zza, this.zza);
        }
        return zzfwq.zzg(zzfwq.zzn(zzfwh.zzw(zzfxa), zzfvx, this.zza), zzeeg.class, new zzeem(this, zzeep2, zzcdq, zzfvx), this.zza);
    }

    public final zzfxa<zzcdq> zza(zzcdq zzcdq) {
        return zzg(zzcdq, new zzeeh(this.zzb), new zzeei(this), new zzeel(zzcdq));
    }

    public final /* synthetic */ zzfxa zzb(zzeep zzeep, zzcdq zzcdq, zzfvx zzfvx, zzeeg zzeeg) throws Exception {
        return zzfwq.zzn(zzeep.zza(zzcdq), zzfvx, this.zza);
    }

    public final /* synthetic */ zzfxa zzc(zzcdq zzcdq) {
        return this.zzc.zzb().zzb(zzcdq, Binder.getCallingUid());
    }

    public final /* synthetic */ zzfxa zzd(zzcdq zzcdq) {
        String str;
        zzedx zzedx = this.zzb;
        if (zzbnc.zzd.zze().booleanValue()) {
            str = zzcdq.zzh;
        } else {
            str = zzcdq.zzj;
        }
        return zzedx.zzc(str);
    }

    public final /* synthetic */ zzfxa zze(zzcdq zzcdq) {
        String str;
        zzefh zzb2 = this.zzc.zzb();
        if (zzbnc.zzd.zze().booleanValue()) {
            str = zzcdq.zzh;
        } else {
            str = zzcdq.zzj;
        }
        return zzb2.zzi(str);
    }

    public final zzfxa<Void> zzf(zzcdq zzcdq) {
        if (zzamv.zzg(zzcdq.zzj)) {
            return zzfwq.zzh(new zzecd(2, "Pool key missing from removeUrl call."));
        }
        return zzg(zzcdq, new zzeej(this), new zzeek(this), zzeen.zza);
    }
}
