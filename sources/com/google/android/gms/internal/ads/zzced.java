package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

public final class zzced extends zzcef {
    private final String zza;
    private final int zzb;

    public zzced(String str, int i11) {
        this.zza = str;
        this.zzb = i11;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzced)) {
            zzced zzced = (zzced) obj;
            if (!Objects.equal(this.zza, zzced.zza) || !Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzced.zzb))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
