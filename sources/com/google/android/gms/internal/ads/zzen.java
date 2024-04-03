package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.Nonnull;

final class zzen<T> {
    @Nonnull
    public final T zza;
    private zzu zzb = new zzu();
    private boolean zzc;
    private boolean zzd;

    public zzen(@Nonnull T t11) {
        this.zza = t11;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzen.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzen) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(int i11, zzel<T> zzel) {
        if (!this.zzd) {
            if (i11 != -1) {
                this.zzb.zza(i11);
            }
            this.zzc = true;
            zzel.zza(this.zza);
        }
    }

    public final void zzb(zzem<T> zzem) {
        if (!this.zzd && this.zzc) {
            zzw zzb2 = this.zzb.zzb();
            this.zzb = new zzu();
            this.zzc = false;
            zzem.zza(this.zza, zzb2);
        }
    }

    public final void zzc(zzem<T> zzem) {
        this.zzd = true;
        if (this.zzc) {
            zzem.zza(this.zza, this.zzb.zzb());
        }
    }
}
