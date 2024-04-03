package com.google.android.gms.internal.icing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzcp {
    static final zzcp zza = new zzcp(true);
    private static volatile boolean zzb = false;
    private static volatile zzcp zzc;
    private final Map zzd;

    public zzcp() {
        this.zzd = new HashMap();
    }

    public static zzcp zza() {
        zzcp zzcp = zzc;
        if (zzcp == null) {
            synchronized (zzcp.class) {
                zzcp = zzc;
                if (zzcp == null) {
                    zzcp = zza;
                    zzc = zzcp;
                }
            }
        }
        return zzcp;
    }

    public zzcp(boolean z11) {
        this.zzd = Collections.emptyMap();
    }
}
