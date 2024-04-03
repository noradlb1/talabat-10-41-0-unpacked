package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

final class zzcgn {
    private Context zza;
    private Clock zzb;
    private zzg zzc;
    private zzchh zzd;

    private zzcgn() {
    }

    public /* synthetic */ zzcgn(zzcgm zzcgm) {
    }

    public final zzcgn zza(zzg zzg) {
        this.zzc = zzg;
        return this;
    }

    public final zzcgn zzb(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    public final zzcgn zzc(Clock clock) {
        clock.getClass();
        this.zzb = clock;
        return this;
    }

    public final zzcgn zzd(zzchh zzchh) {
        this.zzd = zzchh;
        return this;
    }

    public final zzchi zze() {
        zzgpz.zzc(this.zza, Context.class);
        zzgpz.zzc(this.zzb, Clock.class);
        zzgpz.zzc(this.zzc, zzg.class);
        zzgpz.zzc(this.zzd, zzchh.class);
        return new zzcgp(this.zza, this.zzb, this.zzc, this.zzd, (zzcgo) null);
    }
}
