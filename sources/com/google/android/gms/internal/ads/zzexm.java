package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.List;

public final class zzexm {
    private final zzcdq zza;
    private final int zzb;

    public zzexm(zzcdq zzcdq, int i11) {
        this.zza = zzcdq;
        this.zzb = i11;
    }

    public final int zza() {
        return this.zzb;
    }

    @Nullable
    public final PackageInfo zzb() {
        return this.zza.zzf;
    }

    public final String zzc() {
        return this.zza.zzd;
    }

    public final String zzd() {
        return this.zza.zza.getString("ms");
    }

    public final String zze() {
        return this.zza.zzh;
    }

    public final List<String> zzf() {
        return this.zza.zze;
    }

    public final boolean zzg() {
        return this.zza.zza.getBoolean("is_gbid");
    }
}
