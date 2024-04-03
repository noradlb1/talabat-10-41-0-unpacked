package com.google.android.gms.internal.ads;

final class zzask implements zzasi {
    private final int zza;
    private final int zzb;
    private final zzawu zzc;

    public zzask(zzasf zzasf) {
        zzawu zzawu = zzasf.zza;
        this.zzc = zzawu;
        zzawu.zzv(12);
        this.zza = zzawu.zzi();
        this.zzb = zzawu.zzi();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        int i11 = this.zza;
        return i11 == 0 ? this.zzc.zzi() : i11;
    }

    public final boolean zzc() {
        return this.zza != 0;
    }
}
