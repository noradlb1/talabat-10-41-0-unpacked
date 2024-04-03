package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;

public final class zzcqp {
    private final zzcjf zza;
    private final Context zzb;
    private final WeakReference<Context> zzc;

    public /* synthetic */ zzcqp(zzcqn zzcqn, zzcqo zzcqo) {
        this.zza = zzcqn.zza;
        this.zzb = zzcqn.zzb;
        this.zzc = zzcqn.zzc;
    }

    public final Context zza() {
        return this.zzb;
    }

    public final zzalt zzb() {
        return new zzalt(new zzi(this.zzb, this.zza));
    }

    public final zzbnp zzc() {
        return new zzbnp(this.zzb);
    }

    public final zzcjf zzd() {
        return this.zza;
    }

    public final String zze() {
        return zzt.zzp().zzd(this.zzb, this.zza.zza);
    }

    public final WeakReference<Context> zzf() {
        return this.zzc;
    }
}
