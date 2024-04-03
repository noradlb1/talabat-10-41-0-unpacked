package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;

public final class zzdql {
    zzbpj zza;
    zzbpg zzb;
    zzbpw zzc;
    zzbpt zzd;
    zzbui zze;
    final SimpleArrayMap<String, zzbpp> zzf = new SimpleArrayMap<>();
    final SimpleArrayMap<String, zzbpm> zzg = new SimpleArrayMap<>();

    public final zzdql zza(zzbpg zzbpg) {
        this.zzb = zzbpg;
        return this;
    }

    public final zzdql zzb(zzbpj zzbpj) {
        this.zza = zzbpj;
        return this;
    }

    public final zzdql zzc(String str, zzbpp zzbpp, @Nullable zzbpm zzbpm) {
        this.zzf.put(str, zzbpp);
        if (zzbpm != null) {
            this.zzg.put(str, zzbpm);
        }
        return this;
    }

    public final zzdql zzd(zzbui zzbui) {
        this.zze = zzbui;
        return this;
    }

    public final zzdql zze(zzbpt zzbpt) {
        this.zzd = zzbpt;
        return this;
    }

    public final zzdql zzf(zzbpw zzbpw) {
        this.zzc = zzbpw;
        return this;
    }

    public final zzdqn zzg() {
        return new zzdqn(this);
    }
}
