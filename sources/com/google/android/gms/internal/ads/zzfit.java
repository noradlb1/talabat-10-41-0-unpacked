package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class zzfit {
    @NonNull
    public final String zza;
    @NonNull
    public final String zzb;

    public zzfit(@NonNull String str, @NonNull String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfit)) {
            return false;
        }
        zzfit zzfit = (zzfit) obj;
        if (!this.zza.equals(zzfit.zza) || !this.zzb.equals(zzfit.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        return (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).hashCode();
    }
}
