package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzqw implements zzrn {
    final /* synthetic */ zzqz zza;
    /* access modifiers changed from: private */
    public final int zzb;

    public zzqw(zzqz zzqz, int i11) {
        this.zza = zzqz;
        this.zzb = i11;
    }

    public final int zza(zzhr zzhr, zzda zzda, int i11) {
        return this.zza.zzg(this.zzb, zzhr, zzda, i11);
    }

    public final int zzb(long j11) {
        return this.zza.zzi(this.zzb, j11);
    }

    public final void zzd() throws IOException {
        this.zza.zzF(this.zzb);
    }

    public final boolean zze() {
        return this.zza.zzM(this.zzb);
    }
}
