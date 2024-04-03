package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;

public final class zzcr {
    public static final zzcr zza = new zzcr(zzfss.zzo());
    public static final zzj<zzcr> zzb = zzco.zza;
    private final zzfss<zzcq> zzc;

    public zzcr(List<zzcq> list) {
        this.zzc = zzfss.zzm(list);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzcr.class != obj.getClass()) {
            return false;
        }
        return this.zzc.equals(((zzcr) obj).zzc);
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }
}
