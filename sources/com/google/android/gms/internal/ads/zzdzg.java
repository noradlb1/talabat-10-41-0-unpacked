package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class zzdzg {
    protected final String zza = zzbms.zzb.zze();
    protected final Map<String, String> zzb = new HashMap();
    protected final Executor zzc;
    protected final zzcje zzd;
    protected final boolean zze;
    private final zzfiz zzf;

    public zzdzg(Executor executor, zzcje zzcje, zzfiz zzfiz) {
        boolean z11;
        this.zzc = executor;
        this.zzd = zzcje;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue()) {
            this.zze = ((Boolean) zzbgq.zzc().zzb(zzblj.zzbv)).booleanValue();
        } else {
            if (((double) zzbgo.zze().nextFloat()) <= zzbms.zza.zze().doubleValue()) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.zze = z11;
        }
        this.zzf = zzfiz;
    }

    public final String zzb(Map<String, String> map) {
        return this.zzf.zza(map);
    }

    public final void zzc(Map<String, String> map) {
        String zza2 = this.zzf.zza(map);
        if (this.zze) {
            this.zzc.execute(new zzdzf(this, zza2));
        }
        zze.zza(zza2);
    }
}
