package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzfiv implements zzfio {
    private final zzfiz zza;
    private final zzfix zzb;
    private final zzfil zzc;

    public zzfiv(zzfil zzfil, zzfiz zzfiz, zzfix zzfix, byte[] bArr) {
        this.zzc = zzfil;
        this.zza = zzfiz;
        this.zzb = zzfix;
    }

    public final String zza(zzfin zzfin) {
        zzfiz zzfiz = this.zza;
        Map<String, String> zzj = zzfin.zzj();
        this.zzb.zza(zzj);
        return zzfiz.zza(zzj);
    }

    public final void zzb(zzfin zzfin) {
        this.zzc.zzb(zza(zzfin));
    }
}
