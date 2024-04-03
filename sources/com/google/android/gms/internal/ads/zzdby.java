package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzdby<T> {
    private final zzedm zza;
    private final zzfef zzb;
    private final zzfie zzc;
    private final zzcvp zzd;
    private final zzell<T> zze;
    /* access modifiers changed from: private */
    public final zzdjw zzf;
    @Nullable
    private zzfdz zzg;
    private final zzeeq zzh;
    private final zzddx zzi;
    private final Executor zzj;
    private final zzeed zzk;
    private final zzehy zzl;

    public zzdby(zzedm zzedm, zzfef zzfef, zzfie zzfie, zzcvp zzcvp, zzell<T> zzell, zzdjw zzdjw, @Nullable zzfdz zzfdz, zzeeq zzeeq, zzddx zzddx, Executor executor, zzeed zzeed, zzehy zzehy) {
        this.zza = zzedm;
        this.zzb = zzfef;
        this.zzc = zzfie;
        this.zzd = zzcvp;
        this.zze = zzell;
        this.zzf = zzdjw;
        this.zzg = zzfdz;
        this.zzh = zzeeq;
        this.zzi = zzddx;
        this.zzj = executor;
        this.zzk = zzeed;
        this.zzl = zzehy;
    }

    public final zzbew zza(Throwable th2) {
        return zzfey.zzb(th2, this.zzl);
    }

    public final zzdjw zzc() {
        return this.zzf;
    }

    public final /* synthetic */ zzfdz zzd(zzfdz zzfdz) throws Exception {
        this.zzd.zza(zzfdz);
        return zzfdz;
    }

    public final zzfxa<zzcdq> zze(zzffu zzffu) {
        zzfhj zza2 = this.zzc.zzb(zzfhy.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzdbu(this, zzffu)).zza();
        zzfwq.zzr(zza2, new zzdbw(this), this.zzj);
        return zza2;
    }

    public final /* synthetic */ zzfxa zzf(zzffu zzffu, zzcdq zzcdq) throws Exception {
        zzcdq.zzi = zzffu;
        return this.zzh.zza(zzcdq);
    }

    public final zzfxa<Void> zzg(zzcdq zzcdq) {
        zzfhj zza2 = this.zzc.zzb(zzfhy.NOTIFY_CACHE_HIT, this.zzh.zzf(zzcdq)).zza();
        zzfwq.zzr(zza2, new zzdbx(this), this.zzj);
        return zza2;
    }

    public final zzfxa<T> zzh(zzfxa<zzfdz> zzfxa) {
        zzfhv<O2> zzf2 = this.zzc.zzb(zzfhy.RENDERER, zzfxa).zze(new zzdbt(this)).zzf(this.zze);
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzdV)).booleanValue()) {
            zzf2 = zzf2.zzi((long) ((Integer) zzbgq.zzc().zzb(zzblj.zzdW)).intValue(), TimeUnit.SECONDS);
        }
        return zzf2.zza();
    }

    public final zzfxa<zzfdz> zzi() {
        zzbfd zzbfd = this.zzb.zzd;
        if (zzbfd.zzx == null && zzbfd.zzs == null) {
            return zzj(this.zzi.zzc());
        }
        zzfie zzfie = this.zzc;
        return zzfho.zzc(this.zza.zzc(), zzfhy.SERVER_TRANSACTION, zzfie).zza();
    }

    public final zzfxa<zzfdz> zzj(zzfxa<zzcdq> zzfxa) {
        zzfdz zzfdz = this.zzg;
        if (zzfdz != null) {
            zzfie zzfie = this.zzc;
            return zzfho.zzc(zzfwq.zzi(zzfdz), zzfhy.SERVER_TRANSACTION, zzfie).zza();
        }
        zzt.zzc().zzj();
        return this.zzc.zzb(zzfhy.SERVER_TRANSACTION, zzfxa).zzf(new zzdbv(this.zzk)).zza();
    }

    public final void zzk(zzfdz zzfdz) {
        this.zzg = zzfdz;
    }
}
