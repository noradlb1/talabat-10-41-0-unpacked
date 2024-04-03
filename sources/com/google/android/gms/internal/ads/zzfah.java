package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdav;
import com.google.android.gms.internal.ads.zzdea;
import java.util.concurrent.Executor;

final class zzfah<U extends zzdea<A>, A extends zzdav> implements zzfgi<U, A> {
    public final zzfbb<U> zza;
    public final zzfbd zzb;
    public final zzbfd zzc;
    public final String zzd;
    public final Executor zze;
    public final zzbfo zzf;
    public final zzffx zzg;

    public zzfah(zzfbb<U> zzfbb, zzfbd zzfbd, zzbfd zzbfd, String str, Executor executor, zzbfo zzbfo, zzffx zzffx) {
        this.zza = zzfbb;
        this.zzb = zzfbd;
        this.zzc = zzbfd;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzbfo;
        this.zzg = zzffx;
    }

    public final zzffx zza() {
        return this.zzg;
    }

    public final Executor zzb() {
        return this.zze;
    }
}
