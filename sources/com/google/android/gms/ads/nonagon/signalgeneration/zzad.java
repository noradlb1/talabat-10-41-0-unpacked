package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzddy;
import com.google.android.gms.internal.ads.zzfhy;
import com.google.android.gms.internal.ads.zzfie;
import com.google.android.gms.internal.ads.zzfxa;
import com.google.android.gms.internal.ads.zzgpr;
import com.google.android.gms.internal.ads.zzgqe;
import java.util.concurrent.TimeUnit;

public final class zzad implements zzgpr<zzfxa<zzah>> {
    private final zzgqe<zzfie> zza;
    private final zzgqe<zzaf> zzb;
    private final zzgqe<zzddx> zzc;

    public zzad(zzgqe<zzfie> zzgqe, zzgqe<zzaf> zzgqe2, zzgqe<zzddx> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return this.zza.zzb().zzb(zzfhy.GENERATE_SIGNALS, ((zzddy) this.zzc).zzb().zzc()).zzf(((zzag) this.zzb).zzb()).zzi((long) ((Integer) zzbgq.zzc().zzb(zzblj.zzdW)).intValue(), TimeUnit.SECONDS).zza();
    }
}
