package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

final class zzamm implements zzfog {
    private final zzfmj zza;
    private final zzfna zzb;
    private final zzamz zzc;
    private final zzaml zzd;
    private final zzalw zze;

    public zzamm(@NonNull zzfmj zzfmj, @NonNull zzfna zzfna, @NonNull zzamz zzamz, @NonNull zzaml zzaml, @Nullable zzalw zzalw) {
        this.zza = zzfmj;
        this.zzb = zzfna;
        this.zzc = zzamz;
        this.zzd = zzaml;
        this.zze = zzalw;
    }

    private final Map<String, Object> zze() {
        HashMap hashMap = new HashMap();
        zzajp zzb2 = this.zzb.zzb();
        hashMap.put("v", this.zza.zzb());
        hashMap.put("gms", Boolean.valueOf(this.zza.zzc()));
        hashMap.put("int", zzb2.zzh());
        hashMap.put("up", Boolean.valueOf(this.zzd.zza()));
        hashMap.put("t", new Throwable());
        return hashMap;
    }

    public final Map<String, Object> zza() {
        Map<String, Object> zze2 = zze();
        zze2.put("lts", Long.valueOf(this.zzc.zza()));
        return zze2;
    }

    public final Map<String, Object> zzb() {
        Map<String, Object> zze2 = zze();
        zzajp zza2 = this.zzb.zza();
        zze2.put("gai", Boolean.valueOf(this.zza.zzd()));
        zze2.put("did", zza2.zzg());
        zze2.put("dst", Integer.valueOf(zza2.zzag() - 1));
        zze2.put("doo", Boolean.valueOf(zza2.zzad()));
        zzalw zzalw = this.zze;
        if (zzalw != null) {
            zze2.put("nt", Long.valueOf(zzalw.zza()));
        }
        return zze2;
    }

    public final Map<String, Object> zzc() {
        return zze();
    }

    public final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
