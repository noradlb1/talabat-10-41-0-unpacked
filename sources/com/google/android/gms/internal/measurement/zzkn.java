package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzkn {
    static final zzkn zza = new zzkn(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzkn zzd;
    private final Map zze;

    public zzkn() {
        this.zze = new HashMap();
    }

    public static zzkn zza() {
        zzkn zzkn = zzd;
        if (zzkn != null) {
            return zzkn;
        }
        synchronized (zzkn.class) {
            zzkn zzkn2 = zzd;
            if (zzkn2 != null) {
                return zzkn2;
            }
            zzkn zzb2 = zzkv.zzb(zzkn.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzkz zzb(zzmi zzmi, int i11) {
        return (zzkz) this.zze.get(new zzkm(zzmi, i11));
    }

    public zzkn(boolean z11) {
        this.zze = Collections.emptyMap();
    }
}
