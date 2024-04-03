package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzqm implements zzrn {
    private final zzrn zza;
    private final long zzb;

    public zzqm(zzrn zzrn, long j11) {
        this.zza = zzrn;
        this.zzb = j11;
    }

    public final int zza(zzhr zzhr, zzda zzda, int i11) {
        int zza2 = this.zza.zza(zzhr, zzda, i11);
        if (zza2 != -4) {
            return zza2;
        }
        zzda.zzd = Math.max(0, zzda.zzd + this.zzb);
        return -4;
    }

    public final int zzb(long j11) {
        return this.zza.zzb(j11 - this.zzb);
    }

    public final zzrn zzc() {
        return this.zza;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return this.zza.zze();
    }
}
