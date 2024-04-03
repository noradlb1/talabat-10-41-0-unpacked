package com.google.android.gms.internal.ads;

public final class zzgch extends zzgkh<zzgci, zzgch> implements zzglw {
    private zzgch() {
        super(zzgci.zzb);
    }

    public final zzgch zza(zzgjf zzgjf) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgci) this.zza).zzg = zzgjf;
        return this;
    }

    public final zzgch zzb(zzgco zzgco) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzgci.zzj((zzgci) this.zza, zzgco);
        return this;
    }

    public final zzgch zzc(int i11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgci) this.zza).zze = 0;
        return this;
    }

    public /* synthetic */ zzgch(zzgcg zzgcg) {
        super(zzgci.zzb);
    }
}
