package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;

final class zzasl implements zzasi {
    private final zzawu zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzasl(zzasf zzasf) {
        zzawu zzawu = zzasf.zza;
        this.zza = zzawu;
        zzawu.zzv(12);
        this.zzc = zzawu.zzi() & 255;
        this.zzb = zzawu.zzi();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        int i11 = this.zzc;
        if (i11 == 8) {
            return this.zza.zzg();
        }
        if (i11 == 16) {
            return this.zza.zzj();
        }
        int i12 = this.zzd;
        this.zzd = i12 + 1;
        if (i12 % 2 != 0) {
            return this.zze & 15;
        }
        int zzg = this.zza.zzg();
        this.zze = zzg;
        return (zzg & PsExtractor.VIDEO_STREAM_MASK) >> 4;
    }

    public final boolean zzc() {
        return false;
    }
}
