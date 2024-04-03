package com.google.android.gms.internal.ads;

public final class zzbeq extends zzgkh<zzber, zzbeq> implements zzglw {
    private zzbeq() {
        super(zzber.zzb);
    }

    public final zzbeq zza(boolean z11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzber.zzd((zzber) this.zza, z11);
        return this;
    }

    public final zzbeq zzb(int i11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzber.zze((zzber) this.zza, i11);
        return this;
    }

    public final boolean zzc() {
        return ((zzber) this.zza).zzf();
    }

    public /* synthetic */ zzbeq(zzbbd zzbbd) {
        super(zzber.zzb);
    }
}
