package com.google.android.gms.internal.ads;

public final class zzgfs extends zzgkh<zzgfv, zzgfs> implements zzglw {
    private zzgfs() {
        super(zzgfv.zzb);
    }

    public final zzgfs zza(zzgfu zzgfu) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zzgfv.zze((zzgfv) this.zza, zzgfu);
        return this;
    }

    public final zzgfs zzb(int i11) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        ((zzgfv) this.zza).zze = i11;
        return this;
    }

    public /* synthetic */ zzgfs(zzgfr zzgfr) {
        super(zzgfv.zzb);
    }
}
