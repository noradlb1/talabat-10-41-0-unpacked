package com.google.android.gms.internal.ads;

public final class zzgfh extends zzgkh<zzgfi, zzgfh> implements zzglw {
    private zzgfh() {
        super(zzgfi.zzb);
    }

    public final zzgfh zza(String str) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzgfi.zzg((zzgfi) this.zza, str);
        return this;
    }

    public final zzgfh zzb(zzgjf zzgjf) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgfi) this.zza).zzf = zzgjf;
        return this;
    }

    public final zzgfh zzc(int i11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgfi) this.zza).zzg = zzggj.zza(i11);
        return this;
    }

    public /* synthetic */ zzgfh(zzgfg zzgfg) {
        super(zzgfi.zzb);
    }
}
