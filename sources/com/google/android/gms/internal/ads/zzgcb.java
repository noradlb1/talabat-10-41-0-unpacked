package com.google.android.gms.internal.ads;

public final class zzgcb extends zzgkh<zzgcc, zzgcb> implements zzglw {
    private zzgcb() {
        super(zzgcc.zzb);
    }

    public final zzgcb zza(zzgci zzgci) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzgcc.zzi((zzgcc) this.zza, zzgci);
        return this;
    }

    public final zzgcb zzb(zzgew zzgew) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzgcc.zzj((zzgcc) this.zza, zzgew);
        return this;
    }

    public final zzgcb zzc(int i11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgcc) this.zza).zze = i11;
        return this;
    }

    public /* synthetic */ zzgcb(zzgca zzgca) {
        super(zzgcc.zzb);
    }
}
