package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

public final class zzwe {
    public static final zzwe zza = new zzwe(-3, C.TIME_UNSET, -1);
    /* access modifiers changed from: private */
    public final int zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final long zzd;

    private zzwe(int i11, long j11, long j12) {
        this.zzb = i11;
        this.zzc = j11;
        this.zzd = j12;
    }

    public static zzwe zzd(long j11, long j12) {
        return new zzwe(-1, j11, j12);
    }

    public static zzwe zze(long j11) {
        return new zzwe(0, C.TIME_UNSET, j11);
    }

    public static zzwe zzf(long j11, long j12) {
        return new zzwe(-2, j11, j12);
    }
}
