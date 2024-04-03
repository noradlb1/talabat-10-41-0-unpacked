package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzfhv<O> {
    final /* synthetic */ zzfhw zza;
    private final Object zzb;
    @Nullable
    private final String zzc;
    private final zzfxa<?> zzd;
    private final List<zzfxa<?>> zze;
    private final zzfxa<O> zzf;

    private zzfhv(zzfhw zzfhw, zzfhw zzfhw2, String str, zzfxa zzfxa, List<zzfxa> list, zzfxa<O> zzfxa2) {
        this.zza = zzfhw;
        this.zzb = zzfhw2;
        this.zzc = str;
        this.zzd = zzfxa;
        this.zze = list;
        this.zzf = zzfxa2;
    }

    public /* synthetic */ zzfhv(zzfhw zzfhw, Object obj, String str, zzfxa zzfxa, List list, zzfxa zzfxa2, zzfhu zzfhu) {
        this(zzfhw, obj, (String) null, zzfxa, list, zzfxa2);
    }

    public final zzfhj zza() {
        Object obj = this.zzb;
        String str = this.zzc;
        if (str == null) {
            str = this.zza.zzf(obj);
        }
        zzfhj zzfhj = new zzfhj(obj, str, this.zzf);
        this.zza.zzd.zza(zzfhj);
        zzfxa<?> zzfxa = this.zzd;
        zzfhs zzfhs = new zzfhs(this, zzfhj);
        zzfxb zzfxb = zzcjm.zzf;
        zzfxa.zzc(zzfhs, zzfxb);
        zzfwq.zzr(zzfhj, new zzfht(this, zzfhj), zzfxb);
        return zzfhj;
    }

    public final zzfhv<O> zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final <T extends Throwable> zzfhv<O> zzc(Class<T> cls, zzfvx<T, O> zzfvx) {
        zzfhw zzfhw = this.zza;
        return new zzfhv(zzfhw, this.zzb, this.zzc, this.zzd, this.zze, zzfwq.zzg(this.zzf, cls, zzfvx, zzfhw.zzb));
    }

    public final <O2> zzfhv<O2> zzd(zzfxa<O2> zzfxa) {
        return zzg(new zzfhr(zzfxa), zzcjm.zzf);
    }

    public final <O2> zzfhv<O2> zze(zzfhh<O, O2> zzfhh) {
        return zzf(new zzfhp(zzfhh));
    }

    public final <O2> zzfhv<O2> zzf(zzfvx<O, O2> zzfvx) {
        return zzg(zzfvx, this.zza.zzb);
    }

    public final <O2> zzfhv<O2> zzg(zzfvx<O, O2> zzfvx, Executor executor) {
        return new zzfhv(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzfwq.zzn(this.zzf, zzfvx, executor));
    }

    public final zzfhv<O> zzh(String str) {
        return new zzfhv(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfhv<O> zzi(long j11, TimeUnit timeUnit) {
        zzfhw zzfhw = this.zza;
        return new zzfhv(zzfhw, this.zzb, this.zzc, this.zzd, this.zze, zzfwq.zzo(this.zzf, j11, timeUnit, zzfhw.zzc));
    }
}
