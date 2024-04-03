package com.google.android.gms.internal.ads;

public final class zzgct extends zzgkh<zzgcu, zzgct> implements zzglw {
    private zzgct() {
        super(zzgcu.zzb);
    }

    public final zzgct zza(int i11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgcu) this.zza).zzf = i11;
        return this;
    }

    public final zzgct zzb(zzgcx zzgcx) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzgcu.zzg((zzgcu) this.zza, zzgcx);
        return this;
    }

    public /* synthetic */ zzgct(zzgcs zzgcs) {
        super(zzgcu.zzb);
    }
}
