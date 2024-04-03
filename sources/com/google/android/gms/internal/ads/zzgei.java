package com.google.android.gms.internal.ads;

public final class zzgei extends zzgkh<zzgej, zzgei> implements zzglw {
    private zzgei() {
        super(zzgej.zzb);
    }

    public final zzgei zza(zzgjf zzgjf) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgej) this.zza).zzg = zzgjf;
        return this;
    }

    public final zzgei zzb(zzgem zzgem) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzgej.zzi((zzgej) this.zza, zzgem);
        return this;
    }

    public final zzgei zzc(int i11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgej) this.zza).zze = 0;
        return this;
    }

    public /* synthetic */ zzgei(zzgeh zzgeh) {
        super(zzgej.zzb);
    }
}
