package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

public final class zzu {
    private final SparseBooleanArray zza = new SparseBooleanArray();
    private boolean zzb;

    public final zzu zza(int i11) {
        zzdy.zzf(!this.zzb);
        this.zza.append(i11, true);
        return this;
    }

    public final zzw zzb() {
        zzdy.zzf(!this.zzb);
        this.zzb = true;
        return new zzw(this.zza, (zzv) null);
    }
}
