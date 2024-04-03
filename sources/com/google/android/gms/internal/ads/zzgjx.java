package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzgjx {
    static final zzgjx zza = new zzgjx(true);
    private static volatile boolean zzb = false;
    private static volatile zzgjx zzc;
    private static volatile zzgjx zzd;
    private final Map<zzgjw, zzgkj<?, ?>> zze;

    public zzgjx() {
        this.zze = new HashMap();
    }

    public static zzgjx zza() {
        zzgjx zzgjx = zzc;
        if (zzgjx == null) {
            synchronized (zzgjx.class) {
                zzgjx = zzc;
                if (zzgjx == null) {
                    zzgjx = zza;
                    zzc = zzgjx;
                }
            }
        }
        return zzgjx;
    }

    public static zzgjx zzb() {
        zzgjx zzgjx = zzd;
        if (zzgjx != null) {
            return zzgjx;
        }
        synchronized (zzgjx.class) {
            zzgjx zzgjx2 = zzd;
            if (zzgjx2 != null) {
                return zzgjx2;
            }
            zzgjx zzb2 = zzgkf.zzb(zzgjx.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final <ContainingType extends zzglv> zzgkj<ContainingType, ?> zzc(ContainingType containingtype, int i11) {
        return this.zze.get(new zzgjw(containingtype, i11));
    }

    public zzgjx(boolean z11) {
        this.zze = Collections.emptyMap();
    }
}
