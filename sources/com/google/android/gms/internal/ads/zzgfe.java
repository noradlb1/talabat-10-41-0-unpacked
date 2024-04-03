package com.google.android.gms.internal.ads;

public final class zzgfe extends zzgkh<zzgff, zzgfe> implements zzglw {
    private zzgfe() {
        super(zzgff.zzb);
    }

    public final zzgfe zza(String str) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgff) this.zza).zze = str;
        return this;
    }

    public final zzgfe zzb(zzgjf zzgjf) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgff) this.zza).zzf = zzgjf;
        return this;
    }

    public final zzgfe zzc(int i11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgff) this.zza).zzg = i11 - 2;
        return this;
    }

    public /* synthetic */ zzgfe(zzgfd zzgfd) {
        super(zzgff.zzb);
    }
}
