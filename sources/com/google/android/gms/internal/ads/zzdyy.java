package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class zzdyy {
    final /* synthetic */ zzdyz zza;
    private final Map<String, String> zzb = new ConcurrentHashMap();

    @VisibleForTesting
    public zzdyy(zzdyz zzdyz) {
        this.zza = zzdyz;
    }

    public final zzdyy zzb(String str, String str2) {
        this.zzb.put(str, str2);
        return this;
    }

    public final zzdyy zzc(zzfdn zzfdn) {
        this.zzb.put("aai", zzfdn.zzx);
        return this;
    }

    public final zzdyy zzd(zzfdq zzfdq) {
        this.zzb.put("gqi", zzfdq.zzb);
        return this;
    }

    public final String zze() {
        return this.zza.zza.zzb(this.zzb);
    }

    public final void zzf() {
        this.zza.zzb.execute(new zzdyx(this));
    }

    public final /* synthetic */ void zzg() {
        this.zza.zza.zzc(this.zzb);
    }
}
