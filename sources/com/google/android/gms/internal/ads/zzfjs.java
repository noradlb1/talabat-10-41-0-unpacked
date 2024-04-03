package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;

public final class zzfjs {
    private final Executor zza;
    private final zzcje zzb;

    public zzfjs(Executor executor, zzcje zzcje) {
        this.zza = executor;
        this.zzb = zzcje;
    }

    public final /* synthetic */ void zza(String str) {
        this.zzb.zza(str);
    }

    public final void zzb(String str) {
        this.zza.execute(new zzfjr(this, str));
    }

    public final void zzc(List<String> list) {
        for (String zzb2 : list) {
            zzb(zzb2);
        }
    }
}
