package com.google.android.gms.internal.icing;

import android.content.Context;
import javax.annotation.Nullable;

final class zzbd extends zzbh {
    private final Context zza;
    private final zzbm zzb;

    public zzbd(Context context, @Nullable zzbm zzbm) {
        if (context != null) {
            this.zza = context;
            this.zzb = zzbm;
            return;
        }
        throw new NullPointerException("Null context");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbh) {
            zzbh zzbh = (zzbh) obj;
            if (!this.zza.equals(zzbh.zza()) || !this.zzb.equals(zzbh.zzb())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 46 + valueOf2.length());
        sb2.append("FlagsContext{context=");
        sb2.append(valueOf);
        sb2.append(", hermeticFileOverrides=");
        sb2.append(valueOf2);
        sb2.append("}");
        return sb2.toString();
    }

    public final Context zza() {
        return this.zza;
    }

    @Nullable
    public final zzbm zzb() {
        return this.zzb;
    }
}
