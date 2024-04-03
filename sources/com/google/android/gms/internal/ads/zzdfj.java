package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzdfj extends zzdkb<zzdfl> {
    private boolean zzb = false;

    public zzdfj(Set<zzdlw<zzdfl>> set) {
        super(set);
    }

    public final synchronized void zza() {
        if (!this.zzb) {
            zzo(zzdfi.zza);
            this.zzb = true;
        }
    }
}
