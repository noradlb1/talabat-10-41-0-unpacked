package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

public final class zzcgp extends zzchi {
    private final Clock zzb;
    private final zzcgp zzc = this;
    private final zzgqe<Context> zzd;
    private final zzgqe<zzg> zze;
    private final zzgqe<zzchh> zzf;
    private final zzgqe<zzcgg> zzg;
    private final zzgqe<Clock> zzh;
    private final zzgqe<zzcgi> zzi;
    private final zzgqe<zzcgk> zzj;
    private final zzgqe<zzchm> zzk;

    public /* synthetic */ zzcgp(Context context, Clock clock, zzg zzg2, zzchh zzchh, zzcgo zzcgo) {
        this.zzb = clock;
        zzgpr zza = zzgps.zza(context);
        this.zzd = zza;
        zzgpr zza2 = zzgps.zza(zzg2);
        this.zze = zza2;
        zzgpr zza3 = zzgps.zza(zzchh);
        this.zzf = zza3;
        this.zzg = zzgpq.zzc(new zzcgh(zza, zza2, zza3));
        zzgpr zza4 = zzgps.zza(clock);
        this.zzh = zza4;
        zzgqe<zzcgi> zzc2 = zzgpq.zzc(new zzcgj(zza4, zza2, zza3));
        this.zzi = zzc2;
        zzcgl zzcgl = new zzcgl(zza4, zzc2);
        this.zzj = zzcgl;
        this.zzk = zzgpq.zzc(new zzchn(zza, zzcgl));
    }

    public final zzcgg zza() {
        return this.zzg.zzb();
    }

    public final zzcgk zzb() {
        return new zzcgk(this.zzb, this.zzi.zzb());
    }

    public final zzchm zzc() {
        return this.zzk.zzb();
    }
}
