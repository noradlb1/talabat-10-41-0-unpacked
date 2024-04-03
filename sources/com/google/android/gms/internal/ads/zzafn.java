package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzafn {
    public final int zza;
    public final long zzb;

    private zzafn(int i11, long j11) {
        this.zza = i11;
        this.zzb = j11;
    }

    public static zzafn zza(zzwq zzwq, zzfd zzfd) throws IOException {
        ((zzwk) zzwq).zzm(zzfd.zzH(), 0, 8, false);
        zzfd.zzF(0);
        return new zzafn(zzfd.zze(), zzfd.zzq());
    }
}
