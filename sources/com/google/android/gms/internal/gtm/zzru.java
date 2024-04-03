package com.google.android.gms.internal.gtm;

import java.util.List;

abstract class zzru {
    private static final zzru zzbch = new zzrw();
    private static final zzru zzbci = new zzrx();

    private zzru() {
    }

    public static zzru zzqc() {
        return zzbch;
    }

    public static zzru zzqd() {
        return zzbci;
    }

    public abstract <L> List<L> zza(Object obj, long j11);

    public abstract <L> void zza(Object obj, Object obj2, long j11);

    public abstract void zzb(Object obj, long j11);
}
