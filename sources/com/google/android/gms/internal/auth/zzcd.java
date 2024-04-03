package com.google.android.gms.internal.auth;

import android.content.Context;
import javax.annotation.Nullable;

final class zzcd extends zzda {
    private final Context zza;
    private final zzdj zzb;

    public zzcd(Context context, @Nullable zzdj zzdj) {
        if (context != null) {
            this.zza = context;
            this.zzb = zzdj;
            return;
        }
        throw new NullPointerException("Null context");
    }

    public final boolean equals(Object obj) {
        zzdj zzdj;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzda) {
            zzda zzda = (zzda) obj;
            if (!this.zza.equals(zzda.zza()) || ((zzdj = this.zzb) != null ? !zzdj.equals(zzda.zzb()) : zzda.zzb() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzdj zzdj = this.zzb;
        if (zzdj == null) {
            i11 = 0;
        } else {
            i11 = zzdj.hashCode();
        }
        return hashCode ^ i11;
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
    public final zzdj zzb() {
        return this.zzb;
    }
}
