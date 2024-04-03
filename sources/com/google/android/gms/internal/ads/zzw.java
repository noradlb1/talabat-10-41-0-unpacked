package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;

public final class zzw {
    private final SparseBooleanArray zza;

    public /* synthetic */ zzw(SparseBooleanArray sparseBooleanArray, zzv zzv) {
        this.zza = sparseBooleanArray;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzw)) {
            return false;
        }
        zzw zzw = (zzw) obj;
        if (zzfn.zza >= 24) {
            return this.zza.equals(zzw.zza);
        }
        if (this.zza.size() != zzw.zza.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.zza.size(); i11++) {
            if (zza(i11) != zzw.zza(i11)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        if (zzfn.zza >= 24) {
            return this.zza.hashCode();
        }
        int size = this.zza.size();
        for (int i11 = 0; i11 < this.zza.size(); i11++) {
            size = (size * 31) + zza(i11);
        }
        return size;
    }

    public final int zza(int i11) {
        zzdy.zza(i11, 0, this.zza.size());
        return this.zza.keyAt(i11);
    }

    public final int zzb() {
        return this.zza.size();
    }
}
