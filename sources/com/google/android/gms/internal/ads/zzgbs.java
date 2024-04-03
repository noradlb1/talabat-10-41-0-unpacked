package com.google.android.gms.internal.ads;

public final class zzgbs extends zzgkh<zzgbt, zzgbs> implements zzglw {
    private zzgbs() {
        super(zzgbt.zzb);
    }

    public final zzgbs zza(zzgjf zzgjf) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgbt) this.zza).zzf = zzgjf;
        return this;
    }

    public final zzgbs zzb(zzgbz zzgbz) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzgbt.zzj((zzgbt) this.zza, zzgbz);
        return this;
    }

    public final zzgbs zzc(int i11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgbt) this.zza).zze = 0;
        return this;
    }

    public /* synthetic */ zzgbs(zzgbr zzgbr) {
        super(zzgbt.zzb);
    }
}
