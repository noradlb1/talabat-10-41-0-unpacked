package com.google.android.gms.internal.ads;

public final class zzgcq extends zzgkh<zzgcr, zzgcq> implements zzglw {
    private zzgcq() {
        super(zzgcr.zzb);
    }

    public final zzgcq zza(zzgjf zzgjf) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgcr) this.zza).zzg = zzgjf;
        return this;
    }

    public final zzgcq zzb(zzgcx zzgcx) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzgcr.zzi((zzgcr) this.zza, zzgcx);
        return this;
    }

    public final zzgcq zzc(int i11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgcr) this.zza).zze = 0;
        return this;
    }

    public /* synthetic */ zzgcq(zzgcp zzgcp) {
        super(zzgcr.zzb);
    }
}
