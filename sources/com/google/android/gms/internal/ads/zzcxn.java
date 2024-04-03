package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcxn implements zzgpr<Set<zzdlw<zzo>>> {
    private final zzgqe<zzcxf> zza;
    private final zzgqe<Executor> zzb;
    private final zzgqe<JSONObject> zzc;

    public zzcxn(zzgqe<zzcxf> zzgqe, zzgqe<Executor> zzgqe2, zzgqe<JSONObject> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzcxf zzb2 = this.zza.zzb();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        if (this.zzc.zzb() == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzdlw(zzb2, zzfxb));
        }
        zzgpz.zzb(set);
        return set;
    }
}
