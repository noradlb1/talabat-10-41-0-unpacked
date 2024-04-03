package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbnn {
    static final AtomicBoolean zza = new AtomicBoolean();
    private static final AtomicReference<zzbnl> zzb = new AtomicReference<>();
    private static final AtomicReference<zzbnm> zzc = new AtomicReference<>();

    public static zzbnl zza() {
        return zzb.get();
    }

    public static zzbnm zzb() {
        return zzc.get();
    }

    public static void zzc(zzbnl zzbnl) {
        zzb.set(zzbnl);
    }
}
