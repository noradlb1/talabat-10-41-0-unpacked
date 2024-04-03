package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

final class zzoq {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzoq(String str, boolean z11, boolean z12) {
        this.zza = str;
        this.zzb = z11;
        this.zzc = z12;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzoq.class) {
            zzoq zzoq = (zzoq) obj;
            if (TextUtils.equals(this.zza, zzoq.zza) && this.zzb == zzoq.zzb && this.zzc == zzoq.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i11 = 1237;
        int hashCode = (((this.zza.hashCode() + 31) * 31) + (true != this.zzb ? 1237 : 1231)) * 31;
        if (true == this.zzc) {
            i11 = 1231;
        }
        return hashCode + i11;
    }
}
