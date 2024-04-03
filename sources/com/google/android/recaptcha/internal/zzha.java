package com.google.android.recaptcha.internal;

public class zzha extends zzgz implements zziq {
    public zzha(zzhb zzhb) {
        super(zzhb);
    }

    /* renamed from: zzd */
    public final zzhb zzk() {
        if (!((zzhb) this.zza).zzF()) {
            return (zzhb) this.zza;
        }
        ((zzhb) this.zza).zzb.zzg();
        return (zzhb) super.zzk();
    }

    public final void zzn() {
        super.zzn();
        if (((zzhb) this.zza).zzb != zzgv.zzd()) {
            zzhb zzhb = (zzhb) this.zza;
            zzhb.zzb = zzhb.zzb.clone();
        }
    }
}
