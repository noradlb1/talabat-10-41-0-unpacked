package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

public final class zzwo implements zzxt {
    private final byte[] zza = new byte[4096];

    public final /* synthetic */ int zze(zzdg zzdg, int i11, boolean z11) {
        return zzxr.zza(this, zzdg, i11, true);
    }

    public final int zzf(zzdg zzdg, int i11, boolean z11, int i12) throws IOException {
        int zzg = zzdg.zzg(this.zza, 0, Math.min(4096, i11));
        if (zzg != -1) {
            return zzg;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    public final void zzk(zzab zzab) {
    }

    public final /* synthetic */ void zzq(zzfd zzfd, int i11) {
        zzxr.zzb(this, zzfd, i11);
    }

    public final void zzr(zzfd zzfd, int i11, int i12) {
        zzfd.zzG(i11);
    }

    public final void zzs(long j11, int i11, int i12, int i13, @Nullable zzxs zzxs) {
    }
}
