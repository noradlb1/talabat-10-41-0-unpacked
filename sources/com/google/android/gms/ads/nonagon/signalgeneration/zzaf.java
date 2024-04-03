package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzcdq;
import com.google.android.gms.internal.ads.zzedb;
import com.google.android.gms.internal.ads.zzfvx;
import com.google.android.gms.internal.ads.zzfwq;
import com.google.android.gms.internal.ads.zzfxa;
import java.util.concurrent.Executor;

public final class zzaf implements zzfvx<zzcdq, zzah> {
    private final Executor zza;
    private final zzedb zzb;

    public zzaf(Executor executor, zzedb zzedb) {
        this.zza = executor;
        this.zzb = zzedb;
    }

    public final /* bridge */ /* synthetic */ zzfxa zza(Object obj) throws Exception {
        zzcdq zzcdq = (zzcdq) obj;
        return zzfwq.zzn(this.zzb.zzb(zzcdq), new zzae(zzcdq), this.zza);
    }
}
