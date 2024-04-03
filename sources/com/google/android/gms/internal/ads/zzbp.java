package com.google.android.gms.internal.ads;

public final class zzbp {
    private final zzu zza = new zzu();

    public final zzbp zza(int i11) {
        this.zza.zza(i11);
        return this;
    }

    public final zzbp zzb(zzbr zzbr) {
        zzu zzu = this.zza;
        zzw zza2 = zzbr.zzc;
        for (int i11 = 0; i11 < zza2.zzb(); i11++) {
            zzu.zza(zza2.zza(i11));
        }
        return this;
    }

    public final zzbp zzc(int... iArr) {
        zzu zzu = this.zza;
        for (int zza2 : iArr) {
            zzu.zza(zza2);
        }
        return this;
    }

    public final zzbp zzd(int i11, boolean z11) {
        zzu zzu = this.zza;
        if (z11) {
            zzu.zza(i11);
        }
        return this;
    }

    public final zzbr zze() {
        return new zzbr(this.zza.zzb(), (zzbq) null);
    }
}
