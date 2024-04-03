package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzdmh {
    private final List<String> zza;
    private final zzfjs zzb;
    private boolean zzc;

    public zzdmh(zzfdn zzfdn, zzfjs zzfjs) {
        this.zza = zzfdn.zzq;
        this.zzb = zzfjs;
    }

    public final void zza() {
        if (!this.zzc) {
            this.zzb.zzc(this.zza);
            this.zzc = true;
        }
    }
}
