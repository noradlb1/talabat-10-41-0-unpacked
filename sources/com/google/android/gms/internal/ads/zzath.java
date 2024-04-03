package com.google.android.gms.internal.ads;

import android.text.TextUtils;

final class zzath {
    public final String zza;
    public final boolean zzb;

    public zzath(String str, boolean z11) {
        this.zza = str;
        this.zzb = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzath.class) {
            zzath zzath = (zzath) obj;
            if (!TextUtils.equals(this.zza, zzath.zza) || this.zzb != zzath.zzb) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (true != this.zzb ? 1237 : 1231);
    }
}
