package com.google.android.gms.internal.ads;

public final class zzgfx extends zzgkh<zzgfy, zzgfx> implements zzglw {
    private zzgfx() {
        super(zzgfy.zzb);
    }

    public final zzgfx zza(zzggb zzggb) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzgfy.zzh((zzgfy) this.zza, zzggb);
        return this;
    }

    public final zzgfx zzb(int i11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgfy) this.zza).zze = 0;
        return this;
    }

    public /* synthetic */ zzgfx(zzgfw zzgfw) {
        super(zzgfy.zzb);
    }
}
