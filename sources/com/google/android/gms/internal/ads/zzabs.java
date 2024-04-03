package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;

final class zzabs implements zzabp {
    private final zzfd zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzabs(zzabm zzabm) {
        zzfd zzfd = zzabm.zza;
        this.zza = zzfd;
        zzfd.zzF(12);
        this.zzc = zzfd.zzn() & 255;
        this.zzb = zzfd.zzn();
    }

    public final int zza() {
        return -1;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i11 = this.zzc;
        if (i11 == 8) {
            return this.zza.zzk();
        }
        if (i11 == 16) {
            return this.zza.zzo();
        }
        int i12 = this.zzd;
        this.zzd = i12 + 1;
        if (i12 % 2 != 0) {
            return this.zze & 15;
        }
        int zzk = this.zza.zzk();
        this.zze = zzk;
        return (zzk & PsExtractor.VIDEO_STREAM_MASK) >> 4;
    }
}
