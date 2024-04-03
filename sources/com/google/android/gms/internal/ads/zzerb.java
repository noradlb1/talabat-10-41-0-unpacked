package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

public final class zzerb implements zzevn<zzevm<Bundle>> {
    private final Executor zza;
    private final zzcik zzb;

    public zzerb(Executor executor, zzcik zzcik) {
        this.zza = executor;
        this.zzb = zzcik;
    }

    public final zzfxa<zzevm<Bundle>> zzb() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbT)).booleanValue()) {
            return zzfwq.zzi(null);
        }
        return zzfwq.zzm(this.zzb.zzj(), zzera.zza, this.zza);
    }
}
