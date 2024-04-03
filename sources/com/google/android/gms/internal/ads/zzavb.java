package com.google.android.gms.internal.ads;

public final class zzavb extends zzapr {
    private static final Object zzb = new Object();
    private final long zzc;
    private final long zzd;

    public zzavb(long j11, boolean z11) {
        this.zzc = j11;
        this.zzd = j11;
    }

    public final int zza(Object obj) {
        return zzb.equals(obj) ? 0 : -1;
    }

    public final int zzb() {
        return 1;
    }

    public final int zzc() {
        return 1;
    }

    public final zzapp zzd(int i11, zzapp zzapp, boolean z11) {
        zzawm.zza(i11, 0, 1);
        Object obj = z11 ? zzb : null;
        long j11 = this.zzc;
        zzapp.zza = obj;
        zzapp.zzb = obj;
        zzapp.zzc = j11;
        return zzapp;
    }

    public final zzapq zze(int i11, zzapq zzapq, boolean z11, long j11) {
        zzawm.zza(i11, 0, 1);
        zzapq.zza = this.zzd;
        return zzapq;
    }
}
