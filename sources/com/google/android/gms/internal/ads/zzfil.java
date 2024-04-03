package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzfil {
    private final Executor zza;
    private final zzcje zzb;

    public zzfil(Executor executor, zzcje zzcje) {
        this.zza = executor;
        this.zzb = zzcje;
    }

    public final /* synthetic */ void zza(String str) {
        this.zzb.zza(str);
    }

    public final void zzb(String str) {
        this.zza.execute(new zzfik(this, str));
    }
}
