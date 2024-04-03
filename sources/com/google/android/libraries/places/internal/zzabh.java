package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzabh {
    static final zzabh zza = new zzabh(true);
    private static volatile boolean zzb = false;
    private static volatile zzabh zzc;
    private final Map zzd;

    public zzabh() {
        this.zzd = new HashMap();
    }

    public static zzabh zza() {
        zzabh zzabh = zzc;
        if (zzabh == null) {
            synchronized (zzabh.class) {
                zzabh = zzc;
                if (zzabh == null) {
                    zzabh = zza;
                    zzc = zzabh;
                }
            }
        }
        return zzabh;
    }

    public zzabh(boolean z11) {
        this.zzd = Collections.emptyMap();
    }
}
