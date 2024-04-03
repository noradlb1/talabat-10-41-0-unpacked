package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzcjm;
import com.google.android.gms.internal.ads.zzedb;
import com.google.android.gms.internal.ads.zzedc;
import com.google.android.gms.internal.ads.zzfxb;
import com.google.android.gms.internal.ads.zzgpr;
import com.google.android.gms.internal.ads.zzgpz;
import com.google.android.gms.internal.ads.zzgqe;
import java.util.concurrent.Executor;

public final class zzag implements zzgpr<zzaf> {
    private final zzgqe<Executor> zza;
    private final zzgqe<zzedb> zzb;

    public zzag(zzgqe<Executor> zzgqe, zzgqe<zzedb> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    /* renamed from: zza */
    public final zzaf zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzaf(zzfxb, ((zzedc) this.zzb).zzb());
    }
}
