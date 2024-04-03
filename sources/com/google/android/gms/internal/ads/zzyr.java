package com.google.android.gms.internal.ads;

final class zzyr extends zzxe {
    private final long zza;

    public zzyr(zzwq zzwq, long j11) {
        super(zzwq);
        boolean z11;
        if (zzwq.zze() >= j11) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzd(z11);
        this.zza = j11;
    }

    public final long zzc() {
        return super.zzc() - this.zza;
    }

    public final long zzd() {
        return super.zzd() - this.zza;
    }

    public final long zze() {
        return super.zze() - this.zza;
    }
}
