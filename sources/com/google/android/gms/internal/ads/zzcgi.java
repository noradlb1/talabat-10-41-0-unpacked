package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

final class zzcgi {
    private final Clock zza;
    private final zzg zzb;
    private final zzchh zzc;

    public zzcgi(Clock clock, zzg zzg, zzchh zzchh) {
        this.zza = clock;
        this.zzb = zzg;
        this.zzc = zzchh;
    }

    public final void zza() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzal)).booleanValue()) {
            this.zzc.zzt();
        }
    }

    public final void zzb(int i11, long j11) {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzak)).booleanValue()) {
            if (j11 - this.zzb.zze() < 0) {
                zze.zza("Receiving npa decision in the past, ignoring.");
                return;
            }
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzal)).booleanValue()) {
                this.zzb.zzG(-1);
                this.zzb.zzH(j11);
            } else {
                this.zzb.zzG(i11);
                this.zzb.zzH(j11);
            }
            zza();
        }
    }
}
