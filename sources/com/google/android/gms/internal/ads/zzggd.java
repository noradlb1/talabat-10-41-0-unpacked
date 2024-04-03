package com.google.android.gms.internal.ads;

public final class zzggd extends zzgkh<zzgge, zzggd> implements zzglw {
    private zzggd() {
        super(zzgge.zzb);
    }

    public final zzggd zza(zzggh zzggh) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzgge.zzh((zzgge) this.zza, zzggh);
        return this;
    }

    public final zzggd zzb(int i11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgge) this.zza).zze = 0;
        return this;
    }

    public /* synthetic */ zzggd(zzggc zzggc) {
        super(zzgge.zzb);
    }
}
