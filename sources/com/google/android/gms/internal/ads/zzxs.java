package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzxs {
    public final int zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzxs(int i11, byte[] bArr, int i12, int i13) {
        this.zza = i11;
        this.zzb = bArr;
        this.zzc = i12;
        this.zzd = i13;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzxs.class == obj.getClass()) {
            zzxs zzxs = (zzxs) obj;
            if (this.zza == zzxs.zza && this.zzc == zzxs.zzc && this.zzd == zzxs.zzd && Arrays.equals(this.zzb, zzxs.zzb)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.zza * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }
}
