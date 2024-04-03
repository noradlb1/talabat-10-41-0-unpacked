package com.google.android.gms.internal.measurement;

import android.content.Context;
import javax.annotation.Nullable;

final class zzhc extends zzhz {
    private final Context zza;
    private final zzim zzb;

    public zzhc(Context context, @Nullable zzim zzim) {
        this.zza = context;
        this.zzb = zzim;
    }

    public final boolean equals(Object obj) {
        zzim zzim;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhz) {
            zzhz zzhz = (zzhz) obj;
            if (!this.zza.equals(zzhz.zza()) || ((zzim = this.zzb) != null ? !zzim.equals(zzhz.zzb()) : zzhz.zzb() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int hashCode = this.zza.hashCode() ^ 1000003;
        zzim zzim = this.zzb;
        if (zzim == null) {
            i11 = 0;
        } else {
            i11 = zzim.hashCode();
        }
        return (hashCode * 1000003) ^ i11;
    }

    public final String toString() {
        String obj = this.zza.toString();
        String valueOf = String.valueOf(this.zzb);
        return "FlagsContext{context=" + obj + ", hermeticFileOverrides=" + valueOf + "}";
    }

    public final Context zza() {
        return this.zza;
    }

    @Nullable
    public final zzim zzb() {
        return this.zzb;
    }
}
